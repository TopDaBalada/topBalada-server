package br.com.calcard.calsystem.util;

import org.apache.logging.log4j.LogManager;

public abstract class Logger {

	protected org.apache.logging.log4j.Logger logger;

	public Logger(Class entityClass) {
		logger = LogManager.getLogger(entityClass.getName());
	}

}
