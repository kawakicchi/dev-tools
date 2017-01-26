package org.kawakicchi.dev.tools.sample.entity;

import java.io.Serializable;

public class ColumnEntity implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6194851507292244799L;

	private String name;
	private String type;
	private Integer length;
	private Integer accuracy;
	private Boolean nullable;
	private String comment;

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
	 * typeのGetter
	 * 
	 * @return typeを返却
	 */
	public String getType() {
		return type;
	}

	/**
	 * typeのSetter
	 * 
	 * @param type typeの設定値
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * lengthのGetter
	 * 
	 * @return lengthを返却
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * lengthのSetter
	 * 
	 * @param length lengthの設定値
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * accuracyのGetter
	 * 
	 * @return accuracyを返却
	 */
	public Integer getAccuracy() {
		return accuracy;
	}

	/**
	 * accuracyのSetter
	 * 
	 * @param accuracy accuracyの設定値
	 */
	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * nullableのGetter
	 * 
	 * @return nullableを返却
	 */
	public Boolean getNullable() {
		return nullable;
	}

	/**
	 * nullableのSetter
	 * 
	 * @param nullable nullableの設定値
	 */
	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
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
