// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DatTimUt {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
	////
	//// END nested classes and enums
	//// =======================================================================
	////
	//// S T A T I C
	//// =======================================================================
	//// BEGIN static variables
	//// =======================================================================
	//// BEGIN static public variables
	////
	////
	//// END static public variables
	//// =======================================================================
	//// BEGIN static protected variables
	////
	////
	//// END static protected variables
	//// =======================================================================
	//// BEGIN static package variables
	////
	////
	//// END static package variables
	//// =======================================================================
	//// BEGIN static private variables
	////
	////
	//// END static private variables
	//// =======================================================================
	//// END static variables
	//// =======================================================================
	////
	//// I N S T A N C E
	//// =======================================================================
	//// BEGIN instance variables
	//// =======================================================================
	//// BEGIN instance public variables
	////
	////
	//// END instance public variables
	//// =======================================================================
	//// BEGIN instance protected variables
	////
	////
	//// END instance protected variables
	//// =======================================================================
	//// BEGIN instance package variables
	////
	////
	//// END instance package variables
	//// =======================================================================
	//// BEGIN instance private variables
	////
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** Converts a {@link LocalDate} to a {@link java.util.Date}.
	 * @param localDate To be converted.
	 * @return The localDate converted to {@link java.util.Date}.
	 */
	public static java.util.Date convLocDatToUtDat(final LocalDate localDate) {

		final java.util.Date date;
		if (localDate == null) {
			date = null;
		} else {
			final Instant instantOfLocalDate =
					localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			date = java.util.Date.from(instantOfLocalDate);
		}

		return date;
	}

	/** Converts a {@link LocalDate} to a {@link java.sql.Timestamp}.
	 * @param localDate To be converted.
	 * @return The localDate converted to {@link java.sql.Timestamp}.
	 */
	public static Timestamp convLocDatToTS(final LocalDate localDate) {

		final Timestamp timestamp;
		if (localDate == null) {
			timestamp = null;
		} else {
			final Instant instantOfLocalDate =
					localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			timestamp = Timestamp.from(instantOfLocalDate);
		}

		return timestamp;
	}

	/** Converts a {@link LocalDateTime} to a {@link java.util.Date}.
	 * @param localDateTime To be converted.
	 * @return The localDateTime converted to {@link java.util.Date}.
	 */
	public static java.util.Date convLocDatTimToUtDat(final LocalDateTime localDateTime) {

		final Date date;
		if (localDateTime == null) {
			date = null;
		} else {
			final Instant instant =
					localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			date = Date.from(instant);
		}

		return date;
	}

	/** Converts a {@link LocalDateTime} to a {@link java.sql.Timestamp}.
	 * @param localDateTime To be converted.
	 * @return The localDateTime converted to {@link java.sql.Timestamp}.
	 */
	public static Timestamp convLocDatTimToTS(final LocalDateTime localDateTime) {

		final Timestamp date;
		if (localDateTime == null) {
			date = null;
		} else {
			final Instant instant =
					localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			date = Timestamp.from(instant);
		}

		return date;
	}
	
	// =========================================================================

	/** Converts a {@link java.util.Date} to a {@link LocalDate}.
	 * @param date To be converted.
	 * @return The date converted to {@link LocalDate}.
	 */
	public static LocalDate convUtDatToLocDat(final java.util.Date date) {

		final LocalDate localDate;
		if (date== null) {
			localDate = null;
		} else {
			final Instant instant = Instant.ofEpochMilli(date.getTime());
			localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		}

		return localDate;
	}

	/** Converts a {@link java.util.Date} to a {@link LocalDateTime}.
	 * @param date To be converted.
	 * @return The date converted to {@link LocalDateTime}.
	 */
	public static LocalDateTime convUtDatToLocDatTim(final java.util.Date date) {

		final LocalDateTime localDateTime;
		if (date == null) {
			localDateTime = null;
		} else {
			final Instant instant = Instant.ofEpochMilli(date.getTime());
			localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		}

		return localDateTime;
	}

	/** Converts a {@link java.sql.Timestamp} to a {@link LocalDate}.
	 * @param timestamp To be converted.
	 * @return The date converted to {@link LocalDate}.
	 */
	public static LocalDate convTSToLocDat(final java.sql.Timestamp timestamp) {

		final LocalDate localDate;
		if (timestamp == null) {
			localDate = null;
		} else {
			final Instant instant = Instant.ofEpochMilli(timestamp.getTime());
			localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		}

		return localDate;
	}

	/** Converts a {@link java.sql.Timestamp} to a {@link LocalDateTime}.
	 * @param timestamp To be converted.
	 * @return The date converted to {@link LocalDateTime}.
	 */
	public static LocalDateTime convTSToLocDatTim(final java.sql.Timestamp timestamp) {

		final LocalDateTime localDateTime;
		if (timestamp == null) {
			localDateTime = null;
		} else {
			final Instant instant = Instant.ofEpochMilli(timestamp.getTime());
			localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		}

		return localDateTime;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/