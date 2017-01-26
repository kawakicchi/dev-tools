package org.kawakicchi.dev.tools.sample.domain;

public class UnsupportedColumnTypeException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = -5362172509810202451L;

	public UnsupportedColumnTypeException(final String type) {
		super("Unsupported column type[" + type + "]");
	}
}
