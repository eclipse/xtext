/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class PreferenceTaskTagProvider implements ITaskTagProvider {
  public final static PreferenceKey TAGS_KEY = new PreferenceKey("task.tags", "TODO,FIXME,XXX");
  
  public final static PreferenceKey PRIORITIES_KEY = new PreferenceKey("task.priorities", "NORMAL,HIGH,NORMAL");
  
  public final static PreferenceKey CASE_SENSITIVE_KEY = new PreferenceKey("task.caseSensitive", "true");
  
  public final static List<PreferenceKey> KEYS = Collections.<PreferenceKey>unmodifiableList(Lists.<PreferenceKey>newArrayList(PreferenceTaskTagProvider.TAGS_KEY, PreferenceTaskTagProvider.PRIORITIES_KEY, PreferenceTaskTagProvider.CASE_SENSITIVE_KEY));
  
  public static List<TaskTag> parseTags(final String names, final String priorities) {
    Splitter _on = Splitter.on(",");
    Splitter _omitEmptyStrings = _on.omitEmptyStrings();
    final Splitter splitter = _omitEmptyStrings.trimResults();
    Iterable<String> _split = splitter.split(names);
    final List<String> tags = IterableExtensions.<String>toList(_split);
    Iterable<String> _split_1 = splitter.split(priorities);
    final List<String> prios = IterableExtensions.<String>toList(_split_1);
    final ArrayList<TaskTag> elements = CollectionLiterals.<TaskTag>newArrayList();
    int _size = tags.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      TaskTag _taskTag = new TaskTag();
      final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
        public void apply(final TaskTag it) {
          String _get = tags.get((i).intValue());
          it.setName(_get);
          Priority _xifexpression = null;
          int _size = prios.size();
          boolean _greaterEqualsThan = (_size >= (i).intValue());
          if (_greaterEqualsThan) {
            Priority _xtrycatchfinallyexpression = null;
            try {
              String _get_1 = prios.get((i).intValue());
              _xtrycatchfinallyexpression = Priority.valueOf(_get_1);
            } catch (final Throwable _t) {
              if (_t instanceof IllegalArgumentException) {
                final IllegalArgumentException e = (IllegalArgumentException)_t;
                _xtrycatchfinallyexpression = Priority.NORMAL;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            _xifexpression = _xtrycatchfinallyexpression;
          } else {
            _xifexpression = Priority.NORMAL;
          }
          it.setPriority(_xifexpression);
        }
      };
      TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
      elements.add(_doubleArrow);
    }
    return elements;
  }
  
  public static String serializeTags(final List<TaskTag> tags) {
    Joiner _on = Joiner.on(",");
    final Function1<TaskTag, String> _function = new Function1<TaskTag, String>() {
      public String apply(final TaskTag it) {
        return it.getName();
      }
    };
    List<String> _map = ListExtensions.<TaskTag, String>map(tags, _function);
    return _on.join(_map);
  }
  
  public static String serializePriorities(final List<TaskTag> tags) {
    Joiner _on = Joiner.on(",");
    final Function1<TaskTag, Priority> _function = new Function1<TaskTag, Priority>() {
      public Priority apply(final TaskTag it) {
        return it.getPriority();
      }
    };
    List<Priority> _map = ListExtensions.<TaskTag, Priority>map(tags, _function);
    return _on.join(_map);
  }
  
  private IPreferenceValuesProvider preferenceValuesProvider;
  
  public TaskTags getTaskTags(final Resource resource) {
    TaskTags _xblockexpression = null;
    {
      final IPreferenceValues prefs = this.preferenceValuesProvider.getPreferenceValues(resource);
      final String names = prefs.getPreference(PreferenceTaskTagProvider.TAGS_KEY);
      final String priorities = prefs.getPreference(PreferenceTaskTagProvider.PRIORITIES_KEY);
      TaskTags _taskTags = new TaskTags();
      final Procedure1<TaskTags> _function = new Procedure1<TaskTags>() {
        public void apply(final TaskTags it) {
          String _preference = prefs.getPreference(PreferenceTaskTagProvider.CASE_SENSITIVE_KEY);
          Boolean _valueOf = Boolean.valueOf(_preference);
          it.setCaseSensitive((_valueOf).booleanValue());
          List<TaskTag> _taskTags = it.getTaskTags();
          List<TaskTag> _parseTags = PreferenceTaskTagProvider.parseTags(names, priorities);
          Iterables.<TaskTag>addAll(_taskTags, _parseTags);
        }
      };
      _xblockexpression = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    }
    return _xblockexpression;
  }
  
  @Inject
  public void setPreferenceValuesProvider(final IPreferenceValuesProvider preferenceValuesProvider) {
    this.preferenceValuesProvider = preferenceValuesProvider;
  }
}
