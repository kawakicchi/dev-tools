package org.kawakicchi.dev.tools.sample.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Boolean.class, factoryMethod = "of")
public class Nullable {

	private final Boolean value;

	private Nullable(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public static Nullable of(Boolean value) {
		return new Nullable(value);
	}
}