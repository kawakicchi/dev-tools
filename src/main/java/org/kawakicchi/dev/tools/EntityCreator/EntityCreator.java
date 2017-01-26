package org.kawakicchi.dev.tools.EntityCreator;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.kawakicchi.dev.tools.sample.domain.UnsupportedColumnTypeException;
import org.kawakicchi.dev.tools.sample.entity.ColumnEntity;
import org.kawakicchi.dev.tools.sample.entity.TableEntity;
import org.kawakicchi.dev.tools.util.DevToolsUtil;

public class EntityCreator {

	private VelocityEngine engine;

	public EntityCreator(VelocityEngine engine) {
		this.engine = engine;
	}

	public String generateEntity(final TableEntity table) {
		final Set<String> imports = new HashSet<String>();
		final Map<String, Object> classMap = new HashMap<String, Object>();
		final String className = tableNameToClassName(table.getName());
		classMap.put("package", "jp.xxxx");
		classMap.put("name", className);
		classMap.put("label", table.getName());
		classMap.put("comment", table.getComment());
		final List<Map<String, Object>> fields = new ArrayList<Map<String, Object>>();
		for (ColumnEntity column : table.getColumns()) {
			final Map<String, Object> field = new HashMap<String, Object>();
			final String fieldName = columnNameToFieldName(column.getName());
			final String fieldType = toType(column.getType(), imports);
			field.put("name", fieldName);
			field.put("label", column.getName());
			field.put("comment", column.getComment());
			field.put("type", fieldType);
			field.put("setterMethodName", toSetterMethodName(fieldName, fieldType));
			field.put("getterMethodName", toGetterMethodName(fieldName, fieldType));
			fields.add(field);
		}
		classMap.put("fields", fields);
		classMap.put("imports", new ArrayList<String>(imports));

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("class", classMap);

		StringWriter stringWriter = new StringWriter();
		engine.mergeTemplate("TableEntityClass.vm", "UTF-8", velocityContext, stringWriter);

		return stringWriter.toString();
	}

	public String generateDoma(final TableEntity table) {
		boolean padding = true;
		Map<String, Object> tableMap = new HashMap<String, Object>();
		tableMap.put("name", table.getName());
		List<Map<String, Object>> columnMaps = new ArrayList<Map<String, Object>>();
		int maxColumnNameSize = 0;
		int maxFieldNameSize = 0;
		for (ColumnEntity column : table.getColumns()) {
			final String name = column.getName();
			final String field = columnNameToFieldName(column.getName());
			maxColumnNameSize = Math.max(maxColumnNameSize, name.length());
			maxFieldNameSize = Math.max(maxFieldNameSize, field.length());

			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("name", name);
			columnMap.put("field", field);
			columnMap.put("default", getDefaultValue(column.getType()));
			columnMaps.add(columnMap);
		}
		if (padding) {
			for (Map<String, Object> columnMap : columnMaps) {
				final String name = (String) columnMap.get("name");
				final String field = (String) columnMap.get("field");
				columnMap.put("namePad", DevToolsUtil.padding(maxColumnNameSize - name.length()));
				columnMap.put("fieldPad", DevToolsUtil.padding(maxFieldNameSize - field.length()));
			}
		}
		tableMap.put("columns", columnMaps);

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("table", tableMap);
		velocityContext.put("object", "record");

		StringWriter stringWriter = null;

		stringWriter = new StringWriter();
		engine.mergeTemplate("DomaInsert.vm", "UTF-8", velocityContext, stringWriter);
		System.out.println("=========================================================");
		System.out.println(stringWriter.toString());

		stringWriter = new StringWriter();
		engine.mergeTemplate("DomaUpdate.vm", "UTF-8", velocityContext, stringWriter);
		System.out.println("=========================================================");
		System.out.println(stringWriter.toString());

		stringWriter = new StringWriter();
		engine.mergeTemplate("DomaSelect.vm", "UTF-8", velocityContext, stringWriter);
		System.out.println("=========================================================");
		System.out.println(stringWriter.toString());

		stringWriter = new StringWriter();
		engine.mergeTemplate("DomaDelete.vm", "UTF-8", velocityContext, stringWriter);
		System.out.println("=========================================================");
		System.out.println(stringWriter.toString());

		return "";
	}

	private String toType(final String type, final Set<String> imports) {
		if ("bigint".equals(type)) {
			return "Long";
		} else if ("boolean".equals(type)) {
			return "Boolean";
		} else if (type.startsWith("character")) {
			return "String";
		} else if ("date".equals(type)) {
			imports.add("java.util.Date");
			return "Date";
		} else if ("integer".equals(type)) {
			return "Integer";
		} else if ("text".equals(type)) {
			return "String";
		} else if (type.startsWith("time ")) {
			imports.add("java.util.Date");
			return "Date";
		} else if (type.startsWith("timestamp ")) {
			imports.add("java.util.Date");
			return "Date";
		} else if (type.startsWith("numeric")) {
			return "Double";
		} else {
			throw new UnsupportedColumnTypeException(type);
		}
	}

	private String getDefaultValue(final String type) {
		if ("bigint".equals(type)) {
			return "0";
		} else if ("boolean".equals(type)) {
			return "false";
		} else if (type.startsWith("character")) {
			return "''";
		} else if ("date".equals(type)) {
			return "'2017-01-01 00:00:00'";
		} else if ("integer".equals(type)) {
			return "0";
		} else if ("text".equals(type)) {
			return "''";
		} else if (type.startsWith("time ")) {
			return "'2017-01-01 00:00:00'";
		} else if (type.startsWith("timestamp ")) {
			return "'2017-01-01 00:00:00'";
		} else if (type.startsWith("numeric")) {
			return "0";
		} else {
			throw new UnsupportedColumnTypeException(type);
		}
	}

	private String tableNameToClassName(final String tableName) {
		String result = null;
		if (null != tableName) {
			result = DevToolsUtil.toUpperCamelCase(tableName);
		}
		return result;
	}

	private String columnNameToFieldName(final String columnName) {
		String result = null;
		if (null != columnName) {
			result = DevToolsUtil.toLowerCamelCase(columnName);
		}
		return result;
	}

	private String toSetterMethodName(final String fieldName, final String fieldType) {
		String result = null;
		if (DevToolsUtil.isNotNull(fieldName)) {
			result = "set" + DevToolsUtil.toUpperCamelCase(fieldName);
		}
		return result;
	}

	private String toGetterMethodName(final String fieldName, final String fieldType) {
		String result = null;
		if (DevToolsUtil.isNotNull(fieldName)) {
			if (DevToolsUtil.isAnyEquals(fieldType, "Boolean", "boolean")) {
				result = "is" + DevToolsUtil.toUpperCamelCase(fieldName);
			} else {
				result = "get" + DevToolsUtil.toUpperCamelCase(fieldName);
			}
		}
		return result;
	}

}
