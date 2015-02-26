package org.eclipse.xtext.junit4.logging

import com.google.common.annotations.Beta
import com.google.common.primitives.Longs
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Queue
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
import org.junit.Assert
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
	private static class ClassFilter extends Filter {
		val Class<?> cls

		override decide(LoggingEvent event) {
			if(cls.canonicalName == event.loggerName) NEUTRAL else DENY
		}
	}

	static val DENY_ALL = new DenyAllFilter
	static val Comparator<LogEntry> TEMPORAL_ORDER = [Longs.compare($0.timeStamp, $1.timeStamp)]
	
	val Level defaultLevel
	val Class<?> classToIntercept

	QueueAppender appender
	Level oldLevel
	ArrayList<Appender> allAppenders

	new() {
		this(Level.INFO)
	}
	
	new (Level defaultLevel) {
		this(defaultLevel, null)
	}
	
	new(Level defaultLevel, Class<?> classToIntercept) {
		this.defaultLevel = defaultLevel 
		this.classToIntercept = classToIntercept
	}

	def getLogEntries() {
		appender.events.toList.sortWith(TEMPORAL_ORDER)
	}
	
	def assertNoLogEntries() {
		val entries = logEntries
		if (!entries.isEmpty) {
			Assert.fail('''
				Expected no log entries, but got
				«entries»
			''')
		}
	}
	
	def assertNumberOfLogEntries(int number) {
		val entries = logEntries
		if (entries.size != number) {
			Assert.fail('''
				Expected «number» log entries, but got
				«entries»
			''')
		}
	}
	
	def assertLogEntry(String... messageParts) {
		assertLogEntry(null, messageParts)
	}
	
	def assertLogEntry(Level level, String... messageParts) {
		assertLogEntry(null, level, messageParts)
	}
	
	def assertLogEntry(Class<?> source, Level level, String... messageParts) {
		val entries = logEntries
		val passed = entries.exists [ log |
			(level == null || log.level == level) 
			&& (source == null || log.source == source) 
			&& messageParts.forall[log.message.contains(it)]
		]
		if (!passed) {
			Assert.fail(
				'''
					Expected a log entry
					«IF level != null»
						with «level» level
					«ENDIF»
					«IF source != null»
						from «source»
					«ENDIF»
					containing the phrases «messageParts.join(", ")['"' + it + '"']»
					but got
					«entries»
				'''
			)
		}
	}
	
	def clearLog() {
		appender.events.clear
	}

	def setLevel(Level level) {
		Logger.rootLogger.level = level
	}

	override public before() {
		val rootLogger = Logger.rootLogger
		oldLevel = rootLogger.level
		allAppenders = Collections.<Appender>list(rootLogger.allAppenders)
		allAppenders.forEach[silence]
		appender = new QueueAppender
		appender.addFilter(new ClassFilter(classToIntercept))
		rootLogger.addAppender(appender)
		rootLogger.level = defaultLevel
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
