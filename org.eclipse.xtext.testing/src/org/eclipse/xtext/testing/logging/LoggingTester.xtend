/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.logging

import com.google.common.annotations.Beta
import com.google.common.primitives.Longs
import java.util.Collections
import java.util.Comparator
import java.util.List
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue
import org.apache.log4j.Appender
import org.apache.log4j.AppenderSkeleton
import org.apache.log4j.Category
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.spi.Filter
import org.apache.log4j.spi.LoggingEvent
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.junit.Assert

@Beta class LoggingTester {

	@Data
	static class LogCapture {
		List<LogEntry> logEntries

		def assertNoLogEntries() {
			assertNumberOfLogEntries(0)
		}

		def assertLogEntry(String... messageParts) {
			assertNumberOfLogEntries(1, messageParts)
		}

		def assertLogEntry(Level level, String... messageParts) {
			assertNumberOfLogEntries(1, level, messageParts)
		}

		def assertNumberOfLogEntries(int number) {
			assertNumberOfLogEntries(number, #[])
		}

		def assertNumberOfLogEntries(int number, String... messageParts) {
			assertNumberOfLogEntries(number, null, messageParts)
		}

		def assertNumberOfLogEntries(int number, Level level, String... messageParts) {
			val passed = logEntries.filter [ log |
				(level == null || log.level == level) && messageParts.forall[log.message.contains(it)]
			]
			if (passed.size != number) {
				Assert.fail(
					'''
						«IF number == 0»
							Expected no log entries
						«ELSEIF number == 1»
							Expected a log entry
						«ELSE»
							Expected «number» log entries
						«ENDIF»
						«IF level != null»
							with «level» level
						«ENDIF»
						containing the phrases «messageParts.join(", ")['"' + it + '"']»
						but got
						«logEntries»
					'''
				)
			}
		}
	}

	@Data
	static class LogEntry {
		String message
		String source
		long timeStamp
		Level level
	}

	def static captureLogging(Level level, Class<?> source, Runnable action) {
		val logger = Logger.getLogger(source)
		val appender = new QueueAppender
		val oldLevel = logger.level
		val allAppenders = logger.appenderHierarchy
		val filter = new SourceFilter(logger)
		try {
			allAppenders.forEach[addFilter(filter)]
			logger.addAppender(appender)
			logger.level = level
			action.run
			val events = appender.events.toList.sortWith(TEMPORAL_ORDER)
			return new LogCapture(events)
		} finally {
			logger.removeAppender(appender)
			allAppenders.forEach[removeFilter(filter)]
			logger.level = oldLevel
		}
	}

	private static def appenderHierarchy(Logger logger) {
		val appenders = newArrayList
		for (var Category current = logger; current != null; current = current.parent) {
			appenders.addAll(Collections.<Appender>list(current.allAppenders))
		}
		appenders
	}

	private static def removeFilter(Appender appender, Filter filter) {
		if (appender.filter == filter) {
			appender.clearFilters
			appender.addFilter(filter.getNext)
		} else {
			for (var current = appender.filter; current != null; current = current.getNext) {
				if (current.getNext == filter) {
					current.setNext(filter.getNext)
					return
				}
			}	
		}
	}

	private static class QueueAppender extends AppenderSkeleton {
		@Accessors(PUBLIC_GETTER)
		val Queue<LogEntry> events = new ConcurrentLinkedQueue

		override boolean requiresLayout() {
			false
		}

		override void close() {
		}

		override protected void append(LoggingEvent event) {
			val entry = new LogEntry(event.renderedMessage, event.loggerName, event.getTimeStamp, event.getLevel)
			events += entry
		}
	}

	@Data
	private static class SourceFilter extends Filter {
		val Logger source

		override decide(LoggingEvent event) {
			if(event.loggerName == source.name) DENY else NEUTRAL
		}
	}

	static val Comparator<LogEntry> TEMPORAL_ORDER = [Longs.compare($0.timeStamp, $1.timeStamp)]

}
