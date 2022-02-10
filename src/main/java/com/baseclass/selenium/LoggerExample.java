package com.baseclass.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerExample {
	// get a logger instance
		public static Logger logger = LogManager.getLogger(LoggerExample.class);
		
		@Test
		public void testLoggerDebug() {
			logger.debug("Hello.. im in Debug method");
		}

		@Test
		public void testLoggerInfo() {
			logger.info("Hello.. im in Info method");
		}

		@Test
		public void testLoggerWarn() {
			logger.warn("Hello.. im in Warn method");
		}

		@Test
		public void testLoggerError() {
			logger.error("Hello.. im in Error method");
		}

		@Test
		public void testLoggerFatal() {
			logger.fatal("Hello.. im in Fatal method");
		}

//		public static void main(String[] args) {
//			LoggerExample example = new LoggerExample();
//			example.testLoggerDebug();
//			example.testLoggerInfo();
//			example.testLoggerWarn();
//			example.testLoggerError();
//			example.testLoggerFatal();
//		}
}
