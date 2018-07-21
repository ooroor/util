package net.barakiroth.oorutil.recordparser.exceptions;

public class StringTooShortRecordParserException
	extends AbstractRecordParserException {

	private static final long serialVersionUID = -3229148708475962864L;

	public StringTooShortRecordParserException(Throwable cause, final String record) {
		super("The record " + record + " is too short", cause);
	}
}