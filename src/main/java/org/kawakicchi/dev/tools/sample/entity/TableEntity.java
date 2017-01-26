package org.kawakicchi.dev.tools.sample.entity;

import java.io.Serializable;
import java.util.List;

public class TableEntity implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -8005469953055454717L;

	private String schema;
	private String name;
	private List<ColumnEntity> columns;
	private String comment;

	/**
	 * schemaのGetter
	 * 
	 * @return schemaを返却
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * schemaのSetter
	 * 
	 * @param schema schemaの設定値
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}

	/**
	 * nameのGetter
	 * 
	 * @return nameを返却
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameのSetter
	 * 
	 * @param name nameの設定値
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * columnsのGetter
	 * 
	 * @return columnsを返却
	 */
	public List<ColumnEntity> getColumns() {
		return columns;
	}

	/**
	 * columnsのSetter
	 * 
	 * @param columns columnsの設定値
	 */
	public void setColumns(List<ColumnEntity> columns) {
		this.columns = columns;
	}

	/**
	 * commentのGetter
	 * 
	 * @return commentを返却
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * commentのSetter
	 * 
	 * @param comment commentの設定値
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
