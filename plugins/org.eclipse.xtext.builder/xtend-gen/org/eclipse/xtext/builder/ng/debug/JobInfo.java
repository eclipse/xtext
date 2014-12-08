/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.internal.jobs.JobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class JobInfo {
  private final String name;
  
  private final Map<String, String> properties;
  
  public JobInfo(final Job job) {
    String _name = job.getName();
    this.name = _name;
    Thread _thread = job.getThread();
    String _name_1 = null;
    if (_thread!=null) {
      _name_1=_thread.getName();
    }
    Pair<String, String> _mappedTo = Pair.<String, String>of("threadName", _name_1);
    String _printState = JobManager.printState(job);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("state", _printState);
    String _switchResult = null;
    int _priority = job.getPriority();
    final int p = _priority;
    switch (p) {
      case Job.INTERACTIVE:
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("INTERACTIVE (");
        _builder.append(p, "");
        _builder.append(")");
        _switchResult = _builder.toString();
        break;
      case Job.SHORT:
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("SHORT (");
        _builder_1.append(p, "");
        _builder_1.append(")");
        _switchResult = _builder_1.toString();
        break;
      case Job.LONG:
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("LONG (");
        _builder_2.append(p, "");
        _builder_2.append(")");
        _switchResult = _builder_2.toString();
        break;
      case Job.BUILD:
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("BUILD (");
        _builder_3.append(p, "");
        _builder_3.append(")");
        _switchResult = _builder_3.toString();
        break;
      case Job.DECORATE:
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("DECORATE (");
        _builder_4.append(p, "");
        _builder_4.append(")");
        _switchResult = _builder_4.toString();
        break;
      default:
        _switchResult = Integer.valueOf(p).toString();
        break;
    }
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("priority", _switchResult);
    this.properties = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2));
  }
  
  public String toString() {
    Set<Map.Entry<String, String>> _entrySet = this.properties.entrySet();
    final Function1<Map.Entry<String, String>, String> _function = new Function1<Map.Entry<String, String>, String>() {
      public String apply(final Map.Entry<String, String> it) {
        StringConcatenation _builder = new StringConcatenation();
        String _key = it.getKey();
        _builder.append(_key, "");
        _builder.append(": ");
        String _value = it.getValue();
        _builder.append(_value, "");
        return _builder.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<Map.Entry<String, String>, String>map(_entrySet, _function);
    String _join = IterableExtensions.join(_map, ", ");
    return ((this.name + ": ") + _join);
  }
  
  public String compareWithNew(final JobInfo current) {
    final Function2<String, String, Boolean> _function = new Function2<String, String, Boolean>() {
      public Boolean apply(final String k, final String v) {
        String _get = current.properties.get(k);
        return Boolean.valueOf((!Objects.equal(v, _get)));
      }
    };
    final Map<String, String> changed = MapExtensions.<String, String>filter(this.properties, _function);
    Set<Map.Entry<String, String>> _entrySet = changed.entrySet();
    final Function1<Map.Entry<String, String>, String> _function_1 = new Function1<Map.Entry<String, String>, String>() {
      public String apply(final Map.Entry<String, String> it) {
        StringConcatenation _builder = new StringConcatenation();
        String _key = it.getKey();
        _builder.append(_key, "");
        _builder.append(": ");
        String _value = it.getValue();
        _builder.append(_value, "");
        _builder.append(" -> ");
        String _key_1 = it.getKey();
        String _get = current.properties.get(_key_1);
        _builder.append(_get, "");
        return _builder.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<Map.Entry<String, String>, String>map(_entrySet, _function_1);
    final Set<String> changes = IterableExtensions.<String>toSet(_map);
    boolean _notEquals = (!Objects.equal(current.name, this.name));
    if (_notEquals) {
      changes.add(("renamed to: " + current.name));
    }
    String _join = IterableExtensions.join(changes, ", ");
    return ((this.name + ": ") + _join);
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public Map<String, String> getProperties() {
    return this.properties;
  }
}
