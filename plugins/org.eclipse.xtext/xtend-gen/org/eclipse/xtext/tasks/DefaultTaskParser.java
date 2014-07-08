/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class DefaultTaskParser implements ITaskParser {
  public List<Task> parseTasks(final String source, final TaskTags taskTags) {
    ArrayList<Task> _xblockexpression = null;
    {
      boolean _isEmpty = IterableExtensions.isEmpty(taskTags);
      if (_isEmpty) {
        return Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
      }
      final Function<TaskTag, String> _function = new Function<TaskTag, String>() {
        public String apply(final TaskTag it) {
          String _name = it.getName();
          return _name.toLowerCase();
        }
      };
      final ImmutableMap<String, TaskTag> taskTagsByName = Maps.<String, TaskTag>uniqueIndex(taskTags, _function);
      Pattern _pattern = this.toPattern(taskTags);
      final Matcher matcher = _pattern.matcher(source);
      final ArrayList<Task> tasks = CollectionLiterals.<Task>newArrayList();
      while (matcher.find()) {
        Task _task = new Task();
        final Procedure1<Task> _function_1 = new Procedure1<Task>() {
          public void apply(final Task it) {
            String _group = matcher.group(2);
            String _lowerCase = _group.toLowerCase();
            TaskTag _get = taskTagsByName.get(_lowerCase);
            it.setTag(_get);
            String _group_1 = matcher.group(3);
            it.setDescription(_group_1);
            int _start = matcher.start(2);
            it.setOffset(_start);
            int _offset = it.getOffset();
            String _substring = source.substring(0, _offset);
            int _countLineBreaks = Strings.countLineBreaks(_substring);
            int _plus = (_countLineBreaks + 1);
            it.setLineNumber(_plus);
          }
        };
        Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
        tasks.add(_doubleArrow);
      }
      _xblockexpression = tasks;
    }
    return _xblockexpression;
  }
  
  protected Pattern toPattern(final TaskTags taskTags) {
    Pattern _xblockexpression = null;
    {
      int flags = Pattern.MULTILINE;
      boolean _isCaseSensitive = taskTags.isCaseSensitive();
      boolean _not = (!_isCaseSensitive);
      if (_not) {
        int _bitwiseOr = (flags | Pattern.CASE_INSENSITIVE);
        int _bitwiseOr_1 = (_bitwiseOr | Pattern.UNICODE_CASE);
        flags = _bitwiseOr_1;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("^.*((");
      final Function1<TaskTag, String> _function = new Function1<TaskTag, String>() {
        public String apply(final TaskTag it) {
          String _name = it.getName();
          return Pattern.quote(_name);
        }
      };
      Iterable<String> _map = IterableExtensions.<TaskTag, String>map(taskTags, _function);
      String _join = IterableExtensions.join(_map, "|");
      _builder.append(_join, "");
      _builder.append(")(.*)?)$");
      _xblockexpression = Pattern.compile(_builder.toString(), flags);
    }
    return _xblockexpression;
  }
}
