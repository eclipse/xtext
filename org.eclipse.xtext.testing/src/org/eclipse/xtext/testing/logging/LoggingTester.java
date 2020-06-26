/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing.logging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;

import com.google.common.annotations.Beta;
import com.google.common.primitives.Longs;

@Beta
public class LoggingTester {
	private static final Comparator<LogEntry> TEMPORAL_ORDER = ($0, $1) -> Longs.compare($0.timeStamp, $1.timeStamp);

	public static LogCapture captureLogging(Level level, Class<?> source, Runnable action) {
		Logger logger = Logger.getLogger(source);
		QueueAppender appender = new QueueAppender();
		Level oldLevel = logger.getLevel();
		List<Appender> allAppenders = appenderHierarchy(logger);
		SourceFilter filter = new SourceFilter(logger);
		try {
			allAppenders.forEach(it -> it.addFilter(filter));
			logger.addAppender(appender);
			logger.setLevel(level);
			action.run();
			List<LogEntry> events = IterableExtensions.sortWith(IterableExtensions.toList(appender.events),
					LoggingTester.TEMPORAL_ORDER);
			return new LoggingTester.LogCapture(events);
		} finally {
			logger.removeAppender(appender);
			allAppenders.forEach(it -> LoggingTester.removeFilter(it, filter));
			logger.setLevel(oldLevel);
		}
	}

	@SuppressWarnings("unchecked")
	private static List<Appender> appenderHierarchy(Logger logger) {
		List<Appender> appenders = new ArrayList<>();
		for (Category current = logger; current != null; current = current.getParent())
			appenders.addAll(Collections.list(current.getAllAppenders()));
		return appenders;
	}

	private static void removeFilter(Appender appender, Filter filter) {
		if (Objects.equals(appender.getFilter(), filter)) {
			appender.clearFilters();
			appender.addFilter(filter.getNext());
		} else {
			for (Filter current = appender.getFilter(); current != null; current = current.getNext()) {
				if (Objects.equals(current.getNext(), filter)) {
					current.setNext(filter.getNext());
					return;
				}
			}
		}
	}

	public static class LogCapture {
		private final List<LogEntry> logEntries;

		public void assertNoLogEntries() {
			assertNumberOfLogEntries(0);
		}

		public void assertLogEntry(String... messageParts) {
			assertNumberOfLogEntries(1, messageParts);
		}

		public void assertLogEntry(Level level, String... messageParts) {
			assertNumberOfLogEntries(1, level, messageParts);
		}

		public void assertNumberOfLogEntries(int number) {
			assertNumberOfLogEntries(number, new String[] {});
		}

		public void assertNumberOfLogEntries(int number, String... messageParts) {
			assertNumberOfLogEntries(number, null, messageParts);
		}

		public void assertNumberOfLogEntries(int number, Level level, String... messageParts) {
			@SuppressWarnings("unchecked")
			Iterable<LogEntry> passed = IterableExtensions
					.filter(logEntries,
							log -> ((level == null || Objects.equals(log.level, level)) && IterableExtensions.forall(
									((Iterable<String>) Conversions.doWrapArray(messageParts)),
									it -> log.message.contains(it))));
			if (IterableExtensions.size(passed) != number) {
				StringConcatenation builder = new StringConcatenation();
				if (number == 0) {
					builder.append("Expected no log entries");
					builder.newLine();
				} else {
					if (number == 1) {
						builder.append("Expected a log entry");
						builder.newLine();
					} else {
						builder.append("Expected ");
						builder.append(number);
						builder.append(" log entries");
						builder.newLineIfNotEmpty();
					}
				}
				if (level != null) {
					builder.append("with ");
					builder.append(level);
					builder.append(" level");
					builder.newLineIfNotEmpty();
				}
				builder.append("containing the phrases ");
				builder.append(Stream.of(messageParts).map(s -> "\"" + s + "\"").collect(Collectors.joining(", ")));
				builder.newLineIfNotEmpty();
				builder.append("but got");
				builder.newLine();
				builder.append(this.logEntries);
				builder.newLineIfNotEmpty();
				Assert.fail(builder.toString());
			}
		}

		public LogCapture(List<LogEntry> logEntries) {
			super();
			this.logEntries = logEntries;
		}

		@Override
		@Pure
		public int hashCode() {
			return 31 * 1 + ((logEntries == null) ? 0 : logEntries.hashCode());
		}

		@Override
		@Pure
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LogCapture other = (LogCapture) obj;
			if (logEntries == null) {
				if (other.logEntries != null)
					return false;
			} else if (!logEntries.equals(other.logEntries))
				return false;
			return true;
		}

		@Override
		@Pure
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("logEntries", logEntries);
			return b.toString();
		}

		@Pure
		public List<LogEntry> getLogEntries() {
			return logEntries;
		}
	}

	public static class LogEntry {
		private final String message;

		private final String source;

		private final long timeStamp;

		private final Level level;

		public LogEntry(String message, String source, long timeStamp, Level level) {
			this.message = message;
			this.source = source;
			this.timeStamp = timeStamp;
			this.level = level;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (message == null ? 0 : message.hashCode());
			result = prime * result + (source == null ? 0 : source.hashCode());
			result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
			return prime * result + (level == null ? 0 : level.hashCode());
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LogEntry other = (LogEntry) obj;
			if (message == null) {
				if (other.message != null)
					return false;
			} else if (!message.equals(other.message))
				return false;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			if (other.timeStamp != timeStamp)
				return false;
			if (level == null) {
				if (other.level != null)
					return false;
			} else if (!level.equals(other.level))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("message", message);
			b.add("source", source);
			b.add("timeStamp", timeStamp);
			b.add("level", level);
			return b.toString();
		}

		public String getMessage() {
			return message;
		}

		public String getSource() {
			return source;
		}

		public long getTimeStamp() {
			return timeStamp;
		}

		public Level getLevel() {
			return level;
		}
	}

	private static class QueueAppender extends AppenderSkeleton {
		private final Queue<LogEntry> events = new ConcurrentLinkedQueue<>();

		@Override
		public boolean requiresLayout() {
			return false;
		}

		@Override
		public void close() {
		}

		@Override
		protected void append(LoggingEvent event) {
			events.add(new LogEntry(event.getRenderedMessage(), event.getLoggerName(), event.getTimeStamp(),
					event.getLevel()));
		}

		@Pure
		public Queue<LoggingTester.LogEntry> getEvents() {
			return events;
		}
	}

	private static class SourceFilter extends Filter {
		private final Logger source;

		@Override
		public int decide(LoggingEvent event) {
			return Objects.equals(event.getLoggerName(), source.getName()) ? Filter.DENY : Filter.NEUTRAL;
		}

		public SourceFilter(Logger source) {
			this.source = source;
		}

		@Override
		public int hashCode() {
			return 31 * 1 + (source == null ? 0 : source.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SourceFilter other = (SourceFilter) obj;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).addAllFields().toString();
		}
	}

}
