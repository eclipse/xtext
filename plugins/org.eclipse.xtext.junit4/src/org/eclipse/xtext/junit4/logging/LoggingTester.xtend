package org.eclipse.xtext.junit4.logging

import com.google.common.annotations.Beta
import com.google.common.primitives.Longs
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Queue
import java.util.Set
import java.util.concurrent.ConcurrentLinkedQueue
import org.apache.log4j.Appender
import org.apache.log4j.AppenderSkeleton
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.spi.Filter
import org.apache.log4j.spi.LoggingEvent
import org.apache.log4j.varia.DenyAllFilter
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.junit.rules.ExternalResource

@Beta class LoggingTester extends ExternalResource {

	@Data
	static class LogEntry {
		String message
		String source
		long timeStamp
		Level level
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

	@FinalFieldsConstructor
	private static class LoggerNameFilter extends Filter {
		val Set<String> loggerNames

		override decide(LoggingEvent event) {
			if(loggerNames.contains(event.loggerName)) NEUTRAL else DENY
		}
	}

	static val DENY_ALL = new DenyAllFilter
	static val Comparator<LogEntry> TEMPORAL_ORDER = [Longs.compare($0.timeStamp, $1.timeStamp)]

	QueueAppender appender
	Level oldLevel
	ArrayList<Appender> allAppenders

	def getLogEntries() {
		appender.events.toList.sortWith(TEMPORAL_ORDER)
	}
	
	def clearLog() {
		appender.events.clear
	}

	def addSourceFilter(Class<?> source) {
		addSourceFilter(#{source})
	}

	def addSourceFilter(Set<Class<?>> sources) {
		appender.addFilter(new LoggerNameFilter(sources.map[canonicalName].toSet))
	}
	
	def clearFilters() {
		appender.clearFilters
	}

	def setLevel(Level level) {
		Logger.rootLogger.level = level
	}

	override public before() {
		val rootLogger = Logger.rootLogger
		appender = new QueueAppender
		oldLevel = rootLogger.level
		allAppenders = Collections.<Appender>list(rootLogger.allAppenders)
		allAppenders.forEach[silence]
		rootLogger.addAppender(appender)
	}

	private def silence(Appender appender) {
		appender.addFilter(DENY_ALL)
	}

	override public after() {
		val rootLogger = Logger.rootLogger
		rootLogger.removeAppender(appender)
		allAppenders.forEach[unSilence]
		rootLogger.level = oldLevel
	}

	private def unSilence(Appender appender) {
		for (var current = appender.filter; current != null; current = current.getNext) {
			if (current.getNext == DENY_ALL) {
				current.setNext(null)
			}
		}
	}

}
