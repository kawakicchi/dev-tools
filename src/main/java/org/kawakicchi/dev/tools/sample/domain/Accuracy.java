package org.kawakicchi.dev.tools.sample.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "of")
public class Accuracy {

	private final Integer value;

	private Accuracy(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Accuracy of(Integer value) {
		return new Accuracy(value);
	}
}