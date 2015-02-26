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
import java.util.Set;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
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
  private static class LoggerNameFilter extends Filter {
    private final Set<String> loggerNames;
    
    @Override
    public int decide(final LoggingEvent event) {
      int _xifexpression = (int) 0;
      String _loggerName = event.getLoggerName();
      boolean _contains = this.loggerNames.contains(_loggerName);
      if (_contains) {
        _xifexpression = Filter.NEUTRAL;
      } else {
        _xifexpression = Filter.DENY;
      }
      return _xifexpression;
    }
    
    public LoggerNameFilter(final Set<String> loggerNames) {
      super();
      this.loggerNames = loggerNames;
    }
  }
  
  private final static DenyAllFilter DENY_ALL = new DenyAllFilter();
  
  private final static Comparator<LoggingTester.LogEntry> TEMPORAL_ORDER = new Comparator<LoggingTester.LogEntry>() {
    @Override
    public int compare(final LoggingTester.LogEntry $0, final LoggingTester.LogEntry $1) {
      return Longs.compare($0.timeStamp, $1.timeStamp);
    }
  };
  
  private LoggingTester.QueueAppender appender;
  
  private Level oldLevel;
  
  private ArrayList<Appender> allAppenders;
  
  public List<LoggingTester.LogEntry> getLogEntries() {
    List<LoggingTester.LogEntry> _list = IterableExtensions.<LoggingTester.LogEntry>toList(this.appender.events);
    return IterableExtensions.<LoggingTester.LogEntry>sortWith(_list, LoggingTester.TEMPORAL_ORDER);
  }
  
  public void clearLog() {
    this.appender.events.clear();
  }
  
  public void addSourceFilter(final Class<?> source) {
    this.addSourceFilter(Collections.<Class<?>>unmodifiableSet(CollectionLiterals.<Class<?>>newHashSet(source)));
  }
  
  public void addSourceFilter(final Set<Class<?>> sources) {
    final Function1<Class<?>, String> _function = new Function1<Class<?>, String>() {
      @Override
      public String apply(final Class<?> it) {
        return it.getCanonicalName();
      }
    };
    Iterable<String> _map = IterableExtensions.<Class<?>, String>map(sources, _function);
    Set<String> _set = IterableExtensions.<String>toSet(_map);
    LoggingTester.LoggerNameFilter _loggerNameFilter = new LoggingTester.LoggerNameFilter(_set);
    this.appender.addFilter(_loggerNameFilter);
  }
  
  public void clearFilters() {
    this.appender.clearFilters();
  }
  
  public void setLevel(final Level level) {
    Logger _rootLogger = Logger.getRootLogger();
    _rootLogger.setLevel(level);
  }
  
  @Override
  public void before() {
    final Logger rootLogger = Logger.getRootLogger();
    LoggingTester.QueueAppender _queueAppender = new LoggingTester.QueueAppender();
    this.appender = _queueAppender;
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
    rootLogger.addAppender(this.appender);
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
