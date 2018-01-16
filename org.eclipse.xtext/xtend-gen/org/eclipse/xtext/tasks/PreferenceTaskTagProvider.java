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
  
  public final static List<PreferenceKey> KEYS = Collections.<PreferenceKey>unmodifiableList(CollectionLiterals.<PreferenceKey>newArrayList(PreferenceTaskTagProvider.TAGS_KEY, PreferenceTaskTagProvider.PRIORITIES_KEY, PreferenceTaskTagProvider.CASE_SENSITIVE_KEY));
  
  public static List<TaskTag> parseTags(final String names, final String priorities) {
    final Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
    final List<String> tags = IterableExtensions.<String>toList(splitter.split(names));
    final List<String> prios = IterableExtensions.<String>toList(splitter.split(priorities));
    final ArrayList<TaskTag> elements = CollectionLiterals.<TaskTag>newArrayList();
    int _size = tags.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      TaskTag _taskTag = new TaskTag();
      final Procedure1<TaskTag> _function = (TaskTag it) -> {
        it.setName(tags.get((i).intValue()));
        Priority _xifexpression = null;
        int _size_1 = prios.size();
        boolean _greaterEqualsThan = (_size_1 >= (i).intValue());
        if (_greaterEqualsThan) {
          Priority _xtrycatchfinallyexpression = null;
          try {
            _xtrycatchfinallyexpression = Priority.valueOf(prios.get((i).intValue()));
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
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
      };
      TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
      elements.add(_doubleArrow);
    }
    return elements;
  }
  
  public static String serializeTags(final List<TaskTag> tags) {
    final Function1<TaskTag, String> _function = (TaskTag it) -> {
      return it.getName();
    };
    return Joiner.on(",").join(ListExtensions.<TaskTag, String>map(tags, _function));
  }
  
  public static String serializePriorities(final List<TaskTag> tags) {
    final Function1<TaskTag, Priority> _function = (TaskTag it) -> {
      return it.getPriority();
    };
    return Joiner.on(",").join(ListExtensions.<TaskTag, Priority>map(tags, _function));
  }
  
  private IPreferenceValuesProvider preferenceValuesProvider;
  
  @Override
  public TaskTags getTaskTags(final Resource resource) {
    TaskTags _xblockexpression = null;
    {
      final IPreferenceValues prefs = this.preferenceValuesProvider.getPreferenceValues(resource);
      final String names = prefs.getPreference(PreferenceTaskTagProvider.TAGS_KEY);
      final String priorities = prefs.getPreference(PreferenceTaskTagProvider.PRIORITIES_KEY);
      TaskTags _taskTags = new TaskTags();
      final Procedure1<TaskTags> _function = (TaskTags it) -> {
        it.setCaseSensitive((Boolean.valueOf(prefs.getPreference(PreferenceTaskTagProvider.CASE_SENSITIVE_KEY))).booleanValue());
        List<TaskTag> _taskTags_1 = it.getTaskTags();
        List<TaskTag> _parseTags = PreferenceTaskTagProvider.parseTags(names, priorities);
        Iterables.<TaskTag>addAll(_taskTags_1, _parseTags);
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
