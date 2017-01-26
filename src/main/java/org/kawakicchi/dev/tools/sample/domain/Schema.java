package org.kawakicchi.dev.tools.sample.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public class Schema {

	private final String value;

	private Schema(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Schema of(String value) {
		return new Schema(value);
	}
}