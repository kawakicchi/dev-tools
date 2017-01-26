package org.kawakicchi.dev.tools.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.kawakicchi.dev.tools.sample.dao.TableDao;
import org.kawakicchi.dev.tools.sample.domain.Schema;
import org.kawakicchi.dev.tools.sample.entity.ColumnEntity;
import org.kawakicchi.dev.tools.sample.entity.TableEntity;
import org.kawakicchi.dev.tools.sample.table.Column;
import org.kawakicchi.dev.tools.sample.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

	@Autowired
	private TableDao tableDao;

	public TableEntity getTable(final String schemaName, final String tableName) {
		TableEntity table = null;

		final Table rcdTable = tableDao.selectTableBySchemaAndTable(Schema.of(schemaName), tableName);
		if (null != rcdTable) {
			List<Column> rcdColumns = tableDao.selectColumn(rcdTable.getSchema(), rcdTable.getName());

			List<ColumnEntity> columns = new ArrayList<ColumnEntity>();
			for (Column rcdColumn : rcdColumns) {
				ColumnEntity column = new ColumnEntity();

				column.setName(rcdColumn.getName());
				column.setType(rcdColumn.getType());
				column.setLength((null != rcdColumn.getLength()) ? rcdColumn.getLength().getValue() : null);
				column.setAccuracy((null != rcdColumn.getAccuracy()) ? rcdColumn.getAccuracy().getValue() : null);
				column.setNullable(rcdColumn.getNullable().getValue());
				column.setComment(rcdColumn.getComment());

				columns.add(column);
			}

			table = new TableEntity();
			table.setSchema(rcdTable.getSchema().getValue());
			table.setName(rcdTable.getName());
			table.setColumns(columns);
			table.setComment(rcdTable.getComment());
		}

		return table;
	}
}
