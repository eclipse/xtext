/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing.logging;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;

@Beta
@SuppressWarnings("all")
public class LoggingTester {
  @Data
  public static class LogCapture {
    private final List<LoggingTester.LogEntry> logEntries;
    
    public void assertNoLogEntries() {
      this.assertNumberOfLogEntries(0);
    }
    
    public void assertLogEntry(final String... messageParts) {
      this.assertNumberOfLogEntries(1, messageParts);
    }
    
    public void assertLogEntry(final Level level, final String... messageParts) {
      this.assertNumberOfLogEntries(1, level, messageParts);
    }
    
    public void assertNumberOfLogEntries(final int number) {
      this.assertNumberOfLogEntries(number, new String[] {});
    }
    
    public void assertNumberOfLogEntries(final int number, final String... messageParts) {
      this.assertNumberOfLogEntries(number, null, messageParts);
    }
    
    public void assertNumberOfLogEntries(final int number, final Level level, final String... messageParts) {
      final Function1<LoggingTester.LogEntry, Boolean> _function = (LoggingTester.LogEntry log) -> {
        return Boolean.valueOf(((Objects.equal(level, null) || Objects.equal(log.level, level)) && IterableExtensions.<String>forall(((Iterable<String>)Conversions.doWrapArray(messageParts)), ((Function1<String, Boolean>) (String it) -> {
          return Boolean.valueOf(log.message.contains(it));
        }))));
      };
      final Iterable<LoggingTester.LogEntry> passed = IterableExtensions.<LoggingTester.LogEntry>filter(this.logEntries, _function);
      int _size = IterableExtensions.size(passed);
      boolean _notEquals = (_size != number);
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        {
          if ((number == 0)) {
            _builder.append("Expected no log entries");
            _builder.newLine();
          } else {
            if ((number == 1)) {
              _builder.append("Expected a log entry");
              _builder.newLine();
            } else {
              _builder.append("Expected ");
              _builder.append(number, "");
              _builder.append(" log entries");
              _builder.newLineIfNotEmpty();
            }
          }
        }
        {
          boolean _notEquals_1 = (!Objects.equal(level, null));
          if (_notEquals_1) {
            _builder.append("with ");
            _builder.append(level, "");
            _builder.append(" level");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("containing the phrases ");
        final Function1<String, CharSequence> _function_1 = (String it) -> {
          return (("\"" + it) + "\"");
        };
        String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(messageParts)), ", ", _function_1);
        _builder.append(_join, "");
        _builder.newLineIfNotEmpty();
        _builder.append("but got");
        _builder.newLine();
        _builder.append(this.logEntries, "");
        _builder.newLineIfNotEmpty();
        Assert.fail(_builder.toString());
      }
    }
    
    public LogCapture(final List<LoggingTester.LogEntry> logEntries) {
      super();
      this.logEntries = logEntries;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.logEntries== null) ? 0 : this.logEntries.hashCode());
      return result;
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
      LoggingTester.LogCapture other = (LoggingTester.LogCapture) obj;
      if (this.logEntries == null) {
        if (other.logEntries != null)
          return false;
      } else if (!this.logEntries.equals(other.logEntries))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("logEntries", this.logEntries);
      return b.toString();
    }
    
    @Pure
    public List<LoggingTester.LogEntry> getLogEntries() {
      return this.logEntries;
    }
  }
  
  @Data
  public static class LogEntry {
    private final String message;
    
    private final String source;
    
    private final long timeStamp;
    
    private final Level level;
    
    public LogEntry(final String message, final String source, final long timeStamp, final Level level) {
      super();
      this.message = message;
      this.source = source;
      this.timeStamp = timeStamp;
      this.level = level;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.message== null) ? 0 : this.message.hashCode());
      result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
      result = prime * result + (int) (this.timeStamp ^ (this.timeStamp >>> 32));
      result = prime * result + ((this.level== null) ? 0 : this.level.hashCode());
      return result;
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
      LoggingTester.LogEntry other = (LoggingTester.LogEntry) obj;
      if (this.message == null) {
        if (other.message != null)
          return false;
      } else if (!this.message.equals(other.message))
        return false;
      if (this.source == null) {
        if (other.source != null)
          return false;
      } else if (!this.source.equals(other.source))
        return false;
      if (other.timeStamp != this.timeStamp)
        return false;
      if (this.level == null) {
        if (other.level != null)
          return false;
      } else if (!this.level.equals(other.level))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("message", this.message);
      b.add("source", this.source);
      b.add("timeStamp", this.timeStamp);
      b.add("level", this.level);
      return b.toString();
    }
    
    @Pure
    public String getMessage() {
      return this.message;
    }
    
    @Pure
    public String getSource() {
      return this.source;
    }
    
    @Pure
    public long getTimeStamp() {
      return this.timeStamp;
    }
    
    @Pure
    public Level getLevel() {
      return this.level;
    }
  }
  
  private static class QueueAppender extends AppenderSkeleton {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private final Queue<LoggingTester.LogEntry> events = new ConcurrentLinkedQueue<LoggingTester.LogEntry>();
    
    @Override
    public boolean requiresLayout() {
      return false;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    protected void append(final LoggingEvent event) {
      String _renderedMessage = event.getRenderedMessage();
      String _loggerName = event.getLoggerName();
      long _timeStamp = event.getTimeStamp();
      Level _level = event.getLevel();
      final LoggingTester.LogEntry entry = new LoggingTester.LogEntry(_renderedMessage, _loggerName, _timeStamp, _level);
      this.events.add(entry);
    }
    
    @Pure
    public Queue<LoggingTester.LogEntry> getEvents() {
      return this.events;
    }
  }
  
  @Data
  private static class SourceFilter extends Filter {
    private final Logger source;
    
    @Override
    public int decide(final LoggingEvent event) {
      int _xifexpression = (int) 0;
      String _loggerName = event.getLoggerName();
      String _name = this.source.getName();
      boolean _equals = Objects.equal(_loggerName, _name);
      if (_equals) {
        _xifexpression = Filter.DENY;
      } else {
        _xifexpression = Filter.NEUTRAL;
      }
      return _xifexpression;
    }
    
    public SourceFilter(final Logger source) {
      super();
      this.source = source;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
      return result;
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
      LoggingTester.SourceFilter other = (LoggingTester.SourceFilter) obj;
      if (this.source == null) {
        if (other.source != null)
          return false;
      } else if (!this.source.equals(other.source))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringBuilder(this)
      	.addAllFields()
      	.toString();
      return result;
    }
    
    @Pure
    public Logger getSource() {
      return this.source;
    }
  }
  
  public static LoggingTester.LogCapture captureLogging(final Level level, final Class<?> source, final Runnable action) {
    final Logger logger = Logger.getLogger(source);
    final LoggingTester.QueueAppender appender = new LoggingTester.QueueAppender();
    final Level oldLevel = logger.getLevel();
    final ArrayList<Appender> allAppenders = LoggingTester.appenderHierarchy(logger);
    final LoggingTester.SourceFilter filter = new LoggingTester.SourceFilter(logger);
    try {
      final Consumer<Appender> _function = (Appender it) -> {
        it.addFilter(filter);
      };
      allAppenders.forEach(_function);
      logger.addAppender(appender);
      logger.setLevel(level);
      action.run();
      List<LoggingTester.LogEntry> _list = IterableExtensions.<LoggingTester.LogEntry>toList(appender.events);
      final List<LoggingTester.LogEntry> events = IterableExtensions.<LoggingTester.LogEntry>sortWith(_list, LoggingTester.TEMPORAL_ORDER);
      return new LoggingTester.LogCapture(events);
    } finally {
      logger.removeAppender(appender);
      final Consumer<Appender> _function_1 = (Appender it) -> {
        LoggingTester.removeFilter(it, filter);
      };
      allAppenders.forEach(_function_1);
      logger.setLevel(oldLevel);
    }
  }
  
  private static ArrayList<Appender> appenderHierarchy(final Logger logger) {
    ArrayList<Appender> _xblockexpression = null;
    {
      final ArrayList<Appender> appenders = CollectionLiterals.<Appender>newArrayList();
      for (Category current = logger; (!Objects.equal(current, null)); current = current.getParent()) {
        Enumeration _allAppenders = current.getAllAppenders();
        ArrayList<Appender> _list = Collections.<Appender>list(_allAppenders);
        appenders.addAll(_list);
      }
      _xblockexpression = appenders;
    }
    return _xblockexpression;
  }
  
  private static void removeFilter(final Appender appender, final Filter filter) {
    Filter _filter = appender.getFilter();
    boolean _equals = Objects.equal(_filter, filter);
    if (_equals) {
      appender.clearFilters();
      Filter _next = filter.getNext();
      appender.addFilter(_next);
    } else {
      for (Filter current = appender.getFilter(); (!Objects.equal(current, null)); current = current.getNext()) {
        Filter _next_1 = current.getNext();
        boolean _equals_1 = Objects.equal(_next_1, filter);
        if (_equals_1) {
          Filter _next_2 = filter.getNext();
          current.setNext(_next_2);
          return;
        }
      }
    }
  }
  
  private final static Comparator<LoggingTester.LogEntry> TEMPORAL_ORDER = ((Comparator<LoggingTester.LogEntry>) (LoggingTester.LogEntry $0, LoggingTester.LogEntry $1) -> {
    return Longs.compare($0.timeStamp, $1.timeStamp);
  });
}
