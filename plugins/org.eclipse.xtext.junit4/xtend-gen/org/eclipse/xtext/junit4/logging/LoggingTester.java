package org.eclipse.xtext.junit4.logging;

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
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.varia.DenyAllFilter;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;
import org.junit.rules.ExternalResource;

@Beta
@SuppressWarnings("all")
public class LoggingTester extends ExternalResource {
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
  
  @FinalFieldsConstructor
  private static class ClassFilter extends Filter {
    private final Class<?> cls;
    
    @Override
    public int decide(final LoggingEvent event) {
      int _xifexpression = (int) 0;
      String _canonicalName = this.cls.getCanonicalName();
      String _loggerName = event.getLoggerName();
      boolean _equals = Objects.equal(_canonicalName, _loggerName);
      if (_equals) {
        _xifexpression = Filter.NEUTRAL;
      } else {
        _xifexpression = Filter.DENY;
      }
      return _xifexpression;
    }
    
    public ClassFilter(final Class<?> cls) {
      super();
      this.cls = cls;
    }
  }
  
  private final static DenyAllFilter DENY_ALL = new DenyAllFilter();
  
  private final static Comparator<LoggingTester.LogEntry> TEMPORAL_ORDER = new Comparator<LoggingTester.LogEntry>() {
    @Override
    public int compare(final LoggingTester.LogEntry $0, final LoggingTester.LogEntry $1) {
      return Longs.compare($0.timeStamp, $1.timeStamp);
    }
  };
  
  private final Level defaultLevel;
  
  private final Class<?> classToIntercept;
  
  private LoggingTester.QueueAppender appender;
  
  private Level oldLevel;
  
  private ArrayList<Appender> allAppenders;
  
  public LoggingTester() {
    this(Level.INFO);
  }
  
  public LoggingTester(final Level defaultLevel) {
    this(defaultLevel, null);
  }
  
  public LoggingTester(final Level defaultLevel, final Class<?> classToIntercept) {
    this.defaultLevel = defaultLevel;
    this.classToIntercept = classToIntercept;
  }
  
  public List<LoggingTester.LogEntry> getLogEntries() {
    List<LoggingTester.LogEntry> _list = IterableExtensions.<LoggingTester.LogEntry>toList(this.appender.events);
    return IterableExtensions.<LoggingTester.LogEntry>sortWith(_list, LoggingTester.TEMPORAL_ORDER);
  }
  
  public void assertNoLogEntries() {
    final List<LoggingTester.LogEntry> entries = this.getLogEntries();
    boolean _isEmpty = entries.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected no log entries, but got");
      _builder.newLine();
      _builder.append(entries, "");
      _builder.newLineIfNotEmpty();
      Assert.fail(_builder.toString());
    }
  }
  
  public void assertNumberOfLogEntries(final int number) {
    final List<LoggingTester.LogEntry> entries = this.getLogEntries();
    int _size = entries.size();
    boolean _notEquals = (_size != number);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected ");
      _builder.append(number, "");
      _builder.append(" log entries, but got");
      _builder.newLineIfNotEmpty();
      _builder.append(entries, "");
      _builder.newLineIfNotEmpty();
      Assert.fail(_builder.toString());
    }
  }
  
  public void assertLogEntry(final String... messageParts) {
    this.assertLogEntry(null, messageParts);
  }
  
  public void assertLogEntry(final Level level, final String... messageParts) {
    this.assertLogEntry(null, level, messageParts);
  }
  
  public void assertLogEntry(final Class<?> source, final Level level, final String... messageParts) {
    final List<LoggingTester.LogEntry> entries = this.getLogEntries();
    final Function1<LoggingTester.LogEntry, Boolean> _function = new Function1<LoggingTester.LogEntry, Boolean>() {
      @Override
      public Boolean apply(final LoggingTester.LogEntry log) {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _or = false;
        boolean _equals = Objects.equal(level, null);
        if (_equals) {
          _or = true;
        } else {
          boolean _equals_1 = Objects.equal(log.level, level);
          _or = _equals_1;
        }
        if (!_or) {
          _and_1 = false;
        } else {
          boolean _or_1 = false;
          boolean _equals_2 = Objects.equal(source, null);
          if (_equals_2) {
            _or_1 = true;
          } else {
            boolean _equals_3 = Objects.equal(log.source, source);
            _or_1 = _equals_3;
          }
          _and_1 = _or_1;
        }
        if (!_and_1) {
          _and = false;
        } else {
          final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
            @Override
            public Boolean apply(final String it) {
              return Boolean.valueOf(log.message.contains(it));
            }
          };
          boolean _forall = IterableExtensions.<String>forall(((Iterable<String>)Conversions.doWrapArray(messageParts)), _function);
          _and = _forall;
        }
        return Boolean.valueOf(_and);
      }
    };
    final boolean passed = IterableExtensions.<LoggingTester.LogEntry>exists(entries, _function);
    if ((!passed)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected a log entry");
      _builder.newLine();
      {
        boolean _notEquals = (!Objects.equal(level, null));
        if (_notEquals) {
          _builder.append("with ");
          _builder.append(level, "");
          _builder.append(" level");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _notEquals_1 = (!Objects.equal(source, null));
        if (_notEquals_1) {
          _builder.append("from ");
          _builder.append(source, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("containing the phrases ");
      final Function1<String, CharSequence> _function_1 = new Function1<String, CharSequence>() {
        @Override
        public CharSequence apply(final String it) {
          return (("\"" + it) + "\"");
        }
      };
      String _join = IterableExtensions.<String>join(((Iterable<String>)Conversions.doWrapArray(messageParts)), ", ", _function_1);
      _builder.append(_join, "");
      _builder.newLineIfNotEmpty();
      _builder.append("but got");
      _builder.newLine();
      _builder.append(entries, "");
      _builder.newLineIfNotEmpty();
      Assert.fail(_builder.toString());
    }
  }
  
  public void clearLog() {
    this.appender.events.clear();
  }
  
  public void setLevel(final Level level) {
    Logger _rootLogger = Logger.getRootLogger();
    _rootLogger.setLevel(level);
  }
  
  @Override
  public void before() {
    final Logger rootLogger = Logger.getRootLogger();
    Level _level = rootLogger.getLevel();
    this.oldLevel = _level;
    Enumeration _allAppenders = rootLogger.getAllAppenders();
    ArrayList<Appender> _list = Collections.<Appender>list(_allAppenders);
    this.allAppenders = _list;
    final Procedure1<Appender> _function = new Procedure1<Appender>() {
      @Override
      public void apply(final Appender it) {
        LoggingTester.this.silence(it);
      }
    };
    IterableExtensions.<Appender>forEach(this.allAppenders, _function);
    LoggingTester.QueueAppender _queueAppender = new LoggingTester.QueueAppender();
    this.appender = _queueAppender;
    LoggingTester.ClassFilter _classFilter = new LoggingTester.ClassFilter(this.classToIntercept);
    this.appender.addFilter(_classFilter);
    rootLogger.addAppender(this.appender);
    rootLogger.setLevel(this.defaultLevel);
  }
  
  private void silence(final Appender appender) {
    appender.addFilter(LoggingTester.DENY_ALL);
  }
  
  @Override
  public void after() {
    final Logger rootLogger = Logger.getRootLogger();
    rootLogger.removeAppender(this.appender);
    final Procedure1<Appender> _function = new Procedure1<Appender>() {
      @Override
      public void apply(final Appender it) {
        LoggingTester.this.unSilence(it);
      }
    };
    IterableExtensions.<Appender>forEach(this.allAppenders, _function);
    rootLogger.setLevel(this.oldLevel);
  }
  
  private void unSilence(final Appender appender) {
    for (Filter current = appender.getFilter(); (!Objects.equal(current, null)); current = current.getNext()) {
      Filter _next = current.getNext();
      boolean _equals = Objects.equal(_next, LoggingTester.DENY_ALL);
      if (_equals) {
        current.setNext(null);
      }
    }
  }
}
