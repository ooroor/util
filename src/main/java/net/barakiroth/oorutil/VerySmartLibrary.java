package net.barakiroth.oorutil;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class VerySmartLibrary {

	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(VerySmartLibrary.class);
	
	public <T> T returnSame(final T someObject) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Entering VerySmartLibrary.returnSame(" + someObject + ")");
		}
		
		return someObject;
	}

}
