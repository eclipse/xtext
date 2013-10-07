package org.xpect.tests.state;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import org.xpect.state.Creates;
import org.xpect.state.Invalidates;
import org.xpect.state.Managed;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class LoggingTestData {

	public static class LoggingManaged implements Managed<String> {
		private final EventLogger logger;
		private final String value;

		public LoggingManaged(EventLogger logger, String value) {
			super();
			this.logger = logger;
			this.value = value;
		}

		public String get() {
			logger.logMsg(value);
			return value;
		}

		public void invalidate() {
			logger.logMsg(value);
		}
	}

	public static class StaticValueLoggingProvider {
		private final EventLogger logger;

		public StaticValueLoggingProvider(EventLogger logger) {
			super();
			this.logger = logger;
			this.logger.logMsg("instantiate");
		}

		@Creates
		public String getDefaultValue() {
			logger.logMsg("DefaultValue");
			return "DefaultValue";
		}

		@Creates(Ann.class)
		public String getAnnotatedValue() {
			logger.logMsg("AnnotatedValue");
			return "AnnotatedValue";
		}

		@Invalidates
		public void invalidateDefaultValue(String string) {
			logger.logParam(string);
		}

		@Invalidates(annotatedWith = Ann.class)
		public void invalidateAnnotatedValue(String string) {
			logger.logParam(string);
		}
	}

	public static class StaticManagedLoggingProvider {
		private final EventLogger logger;

		public StaticManagedLoggingProvider(EventLogger logger) {
			super();
			this.logger = logger;
			this.logger.logMsg("instantiate");
		}

		@Creates
		public Managed<String> getDefaultManaged() {
			logger.logMsg("DefaultManaged");
			return new LoggingManaged(logger, "DefaultManaged");
		}

		@Creates(Ann.class)
		public Managed<String> getAnnotatedManaged() {
			logger.logMsg("AnnotatedManaged");
			return new LoggingManaged(logger, "AnnotatedManaged");
		}
	}

	public static class EventLogger {
		private final List<String> messages = Lists.newArrayList();

		public void logParam(String param) {
			messages.add(calledMethod() + "(" + param + ")");
		}

		public void logMsg(String param, String msg) {
			messages.add(calledMethod() + "(" + param + ") -> " + msg);
		}

		public void logMsg(String msg) {
			messages.add(calledMethod() + "() -> " + msg);
		}

		private String calledMethod() {
			String caller = Thread.currentThread().getStackTrace()[3].toString();
			caller = caller.substring(0, caller.indexOf('('));
			String[] seg = caller.split("\\.");
			caller = seg[seg.length - 2] + "." + seg[seg.length - 1];
			return caller;
		}

		@Override
		public String toString() {
			return Joiner.on("\n").join(messages);
		}
	}

	public static class DerivedProvider {
		private final String defaultValue;
		private final String annotatedValue;
		private final EventLogger logger;

		public DerivedProvider(EventLogger logger, String defaultValue, @Ann String annotatedValue) {
			super();
			this.logger = logger;
			this.defaultValue = "derived" + defaultValue;
			this.annotatedValue = "derived" + annotatedValue;
		}

		@Creates(AnnDerived1.class)
		public String getDerived1() {
			logger.logMsg(defaultValue);
			return defaultValue;
		}

		@Creates(AnnDerived2.class)
		public String getDerived2() {
			logger.logMsg(annotatedValue);
			return annotatedValue;
		}

		@Invalidates(annotatedWith = AnnDerived1.class)
		public void invalidatesDerived1(String val) {
			logger.logParam(val);
		}

		@Invalidates(annotatedWith = AnnDerived2.class)
		public void invalidateDerived2(String val) {
			logger.logParam(val);
		}

	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Ann {
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface AnnDerived1 {
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface AnnDerived2 {
	}

}
