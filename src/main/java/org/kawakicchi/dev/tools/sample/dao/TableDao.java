package org.kawakicchi.dev.tools.sample.dao;

import java.util.List;

import org.kawakicchi.dev.tools.sample.domain.Schema;
import org.kawakicchi.dev.tools.sample.table.Column;
import org.kawakicchi.dev.tools.sample.table.Table;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface TableDao {

	@Select
	List<Table> selectTable(Schema schema, String table);

	@Select
	Table selectTableBySchemaAndTable(Schema schema, String table);

	@Select
	List<Column> selectColumn(Schema schema, String tableName);
}
