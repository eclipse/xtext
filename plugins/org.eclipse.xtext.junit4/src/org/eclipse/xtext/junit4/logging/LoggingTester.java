/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.logging;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Beta
public class LoggingTester {
	
	public static void setLoggingLevel(Class<?> clazz, Level level) {
		Logger log = getLogger(clazz);
		if (log != null) {
			log.setLevel(level);
		}
	}
	
	public static int countErrorLogging(Class<?> clazz, Runnable executable) {
		final Logger original = getLogger(clazz);
		try {
			final AtomicInteger numberOfLoggings = new AtomicInteger();
			setLogger(clazz, new DelegatingLogger(original) {
				@Override
				public void error(Object message, Throwable t) {
					numberOfLoggings.incrementAndGet();
				}
				
				@Override
				public void error(Object message) {
					numberOfLoggings.incrementAndGet();
				}
			});
			executable.run();
			return numberOfLoggings.get();
		} finally {
			setLogger(clazz, original);
		}
	}
	
	private static Logger getLogger(Class<?> clazz) {
		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && f.getType().isAssignableFrom(Logger.class))
				try {
					f.setAccessible(true);
					return (Logger) f.get(null);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		}
		throw new IllegalArgumentException("The class " + clazz.getName() + " does not declare a static field of type org.apache.log4j.Logger.");
	}
	
	private static void setLogger(Class<?> clazz, Logger logger) {
		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && f.getType().isAssignableFrom(Logger.class))
				try {
					f.setAccessible(true);
					f.set(null, logger);
					return;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
		}
		throw new IllegalArgumentException("The class " + clazz.getName() + " does not declare a static field of type org.apache.log4j.Logger.");
	}
	
	@SuppressWarnings("all")
	static class DelegatingLogger extends Logger {

		private Logger delegate;

		protected DelegatingLogger(Logger delegate) {
			super(delegate.getName());
			this.delegate = delegate;
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return delegate.equals(obj);
		}

		@Override
		public void trace(Object message) {
			delegate.trace(message);
		}

		@Override
		public void addAppender(Appender newAppender) {
			delegate.addAppender(newAppender);
		}

		@Override
		public void trace(Object message, Throwable t) {
			delegate.trace(message, t);
		}

		@Override
		public void assertLog(boolean assertion, String msg) {
			delegate.assertLog(assertion, msg);
		}

		@Override
		public boolean isTraceEnabled() {
			return delegate.isTraceEnabled();
		}

		@Override
		public void callAppenders(LoggingEvent event) {
			delegate.callAppenders(event);
		}

		@Override
		public void debug(Object message) {
			delegate.debug(message);
		}

		@Override
		public void debug(Object message, Throwable t) {
			delegate.debug(message, t);
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		@Override
		public void error(Object message) {
			delegate.error(message);
		}

		@Override
		public void error(Object message, Throwable t) {
			delegate.error(message, t);
		}

		@Override
		public void fatal(Object message) {
			delegate.fatal(message);
		}

		@Override
		public void fatal(Object message, Throwable t) {
			delegate.fatal(message, t);
		}

		@Override
		public boolean getAdditivity() {
			return delegate.getAdditivity();
		}

		@Override
		public Enumeration getAllAppenders() {
			return delegate.getAllAppenders();
		}

		@Override
		public Appender getAppender(String name) {
			return delegate.getAppender(name);
		}

		@Override
		public Level getEffectiveLevel() {
			return delegate.getEffectiveLevel();
		}

		@Override
		public Priority getChainedPriority() {
			return delegate.getChainedPriority();
		}

		@Override
		public LoggerRepository getHierarchy() {
			return delegate.getHierarchy();
		}

		@Override
		public LoggerRepository getLoggerRepository() {
			return delegate.getLoggerRepository();
		}

		@Override
		public ResourceBundle getResourceBundle() {
			return delegate.getResourceBundle();
		}

		@Override
		public void info(Object message) {
			delegate.info(message);
		}

		@Override
		public void info(Object message, Throwable t) {
			delegate.info(message, t);
		}

		@Override
		public boolean isAttached(Appender appender) {
			return delegate.isAttached(appender);
		}

		@Override
		public boolean isDebugEnabled() {
			return delegate.isDebugEnabled();
		}

		@Override
		public boolean isEnabledFor(Priority level) {
			return delegate.isEnabledFor(level);
		}

		@Override
		public boolean isInfoEnabled() {
			return delegate.isInfoEnabled();
		}

		@Override
		public void l7dlog(Priority priority, String key, Throwable t) {
			delegate.l7dlog(priority, key, t);
		}

		@Override
		public void l7dlog(Priority priority, String key, Object[] params, Throwable t) {
			delegate.l7dlog(priority, key, params, t);
		}

		@Override
		public void log(Priority priority, Object message, Throwable t) {
			delegate.log(priority, message, t);
		}

		@Override
		public void log(Priority priority, Object message) {
			delegate.log(priority, message);
		}

		@Override
		public void log(String callerFQCN, Priority level, Object message, Throwable t) {
			delegate.log(callerFQCN, level, message, t);
		}

		@Override
		public void removeAllAppenders() {
			delegate.removeAllAppenders();
		}

		@Override
		public void removeAppender(Appender appender) {
			delegate.removeAppender(appender);
		}

		@Override
		public void removeAppender(String name) {
			delegate.removeAppender(name);
		}

		@Override
		public void setAdditivity(boolean additive) {
			delegate.setAdditivity(additive);
		}

		@Override
		public void setLevel(Level level) {
			delegate.setLevel(level);
		}

		@Override
		public void setPriority(Priority priority) {
			delegate.setPriority(priority);
		}

		@Override
		public void setResourceBundle(ResourceBundle bundle) {
			delegate.setResourceBundle(bundle);
		}

		@Override
		public void warn(Object message) {
			delegate.warn(message);
		}

		@Override
		public void warn(Object message, Throwable t) {
			delegate.warn(message, t);
		}
		
		
	}
}
