package org.kawakicchi.dev.tools.sample.table;

import org.kawakicchi.dev.tools.sample.domain.Accuracy;
import org.kawakicchi.dev.tools.sample.domain.Length;
import org.kawakicchi.dev.tools.sample.domain.Nullable;
import org.seasar.doma.Entity;

@Entity
public class Column {

	private String name;

	private String type;

	private Length length;

	private Accuracy accuracy;

	private Nullable nullable;

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
	public Length getLength() {
		return length;
	}

	/**
	 * lengthのSetter
	 * 
	 * @param length lengthの設定値
	 */
	public void setLength(Length length) {
		this.length = length;
	}

	/**
	 * accuracyのGetter
	 * 
	 * @return accuracyを返却
	 */
	public Accuracy getAccuracy() {
		return accuracy;
	}

	/**
	 * accuracyのSetter
	 * 
	 * @param accuracy accuracyの設定値
	 */
	public void setAccuracy(Accuracy accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * nullableのGetter
	 * 
	 * @return nullableを返却
	 */
	public Nullable getNullable() {
		return nullable;
	}

	/**
	 * nullableのSetter
	 * 
	 * @param nullable nullableの設定値
	 */
	public void setNullable(Nullable nullable) {
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
