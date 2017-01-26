package org.kawakicchi.dev.tools.sample.table;

import org.kawakicchi.dev.tools.sample.domain.Schema;
import org.seasar.doma.Entity;

@Entity
public class Table {

	private Schema schema;

	private String name;
	private String comment;

	/**
	 * schemaのGetter
	 * 
	 * @return schemaを返却
	 */
	public Schema getSchema() {
		return schema;
	}

	/**
	 * schemaのSetter
	 * 
	 * @param schema schemaの設定値
	 */
	public void setSchema(Schema schema) {
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
