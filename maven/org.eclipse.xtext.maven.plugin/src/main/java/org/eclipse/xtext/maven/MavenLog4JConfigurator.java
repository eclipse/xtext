package org.eclipse.xtext.maven;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.maven.plugin.logging.Log;

/**
 * @author Michael Clay
 * @author Moritz Eysholdt
 */
public class MavenLog4JConfigurator {

	protected final static Level LOG4J_DEFAULT_LOG_LEVEL = Level.INFO;

	public void configureLog4j(Log log) {
		if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
			try {
				Logger.getRootLogger().setLevel(LOG4J_DEFAULT_LOG_LEVEL);
			} catch (NoSuchMethodError e) {
				// see http://bugzilla.slf4j.org/show_bug.cgi?id=279
			}
			Logger.getRootLogger().addAppender(createMojoLogAppender(log));
		} else {
			configureLog4j(log, "org.eclipse.xtext");
			configureLog4j(log, "org.eclipse.xtend");
		}
	}

	protected void configureLog4j(Log log, String name) {
		Logger logger = Logger.getLogger(name);
		logger.setAdditivity(false);
		try {
			logger.setLevel(LOG4J_DEFAULT_LOG_LEVEL);
		} catch (NoSuchMethodError e) {
			// see http://bugzilla.slf4j.org/show_bug.cgi?id=279
		}
		logger.removeAllAppenders();
		logger.addAppender(createMojoLogAppender(log));
	}

	protected AppenderSkeleton createMojoLogAppender(final Log log) {
		return new AppenderSkeleton() {

			@Override
			protected void append(LoggingEvent event) {
				if (event.getMessage() == null) {
					return;
				}
				if (Level.DEBUG == event.getLevel()) {
					log.debug((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.INFO == event.getLevel()) {
					log.info((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.WARN == event.getLevel()) {
					log.warn((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.ERROR == event.getLevel()) {
					log.error((CharSequence) event.getMessage(), getThrowable(event));
				}
			}

			public void close() {
			}

			private Throwable getThrowable(LoggingEvent event) {
				return event.getThrowableInformation() != null ? event.getThrowableInformation().getThrowable() : null;
			}

			public boolean requiresLayout() {
				return false;
			}
		};
	}
}
