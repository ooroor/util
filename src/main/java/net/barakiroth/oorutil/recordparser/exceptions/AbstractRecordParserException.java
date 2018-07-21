package net.barakiroth.oorutil.recordparser.exceptions;

public abstract class AbstractRecordParserException
	extends RuntimeException {

	private static final long serialVersionUID = -7871066124677013313L;

	public AbstractRecordParserException() {}

	public AbstractRecordParserException(
		final Throwable cause) {

		super(cause);
	}

	public AbstractRecordParserException(
		final String message,
		final Throwable cause) {

		super(message, cause);
	}
}