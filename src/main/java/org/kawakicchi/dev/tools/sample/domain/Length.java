package org.kawakicchi.dev.tools.sample.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "of")
public class Length {

	private final Integer value;

	private Length(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Length of(Integer value) {
		return new Length(value);
	}
}