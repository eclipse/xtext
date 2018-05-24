/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class DefaultTaskParser implements ITaskParser {
  @Override
  public List<Task> parseTasks(final String source, final TaskTags taskTags) {
    ArrayList<Task> _xblockexpression = null;
    {
      boolean _isEmpty = IterableExtensions.isEmpty(taskTags);
      if (_isEmpty) {
        return Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
      }
      final Map<String, TaskTag> taskTagsByName = this.getTaskTagsByName(taskTags);
      final Matcher matcher = this.toPattern(taskTags).matcher(source);
      final ArrayList<Task> tasks = CollectionLiterals.<Task>newArrayList();
      int prevLine = 1;
      int prevOffset = 0;
      while (matcher.find()) {
        {
          final Task task = new Task();
          final String matchedTag = matcher.group(2);
          String _xifexpression = null;
          boolean _isCaseSensitive = taskTags.isCaseSensitive();
          if (_isCaseSensitive) {
            _xifexpression = matchedTag;
          } else {
            _xifexpression = matchedTag.toLowerCase();
          }
          task.setTag(taskTagsByName.get(_xifexpression));
          task.setDescription(matcher.group(3));
          task.setOffset(matcher.start(2));
          int _countLineBreaks = Strings.countLineBreaks(source, prevOffset, task.getOffset());
          int _plus = (_countLineBreaks + prevLine);
          task.setLineNumber(_plus);
          prevLine = task.getLineNumber();
          prevOffset = task.getOffset();
          tasks.add(task);
        }
      }
      _xblockexpression = tasks;
    }
    return _xblockexpression;
  }
  
  protected Map<String, TaskTag> getTaskTagsByName(final TaskTags taskTags) {
    final HashMap<String, TaskTag> taskTagsByName = new HashMap<String, TaskTag>();
    for (final TaskTag tag : taskTags) {
      {
        String _xifexpression = null;
        boolean _isCaseSensitive = taskTags.isCaseSensitive();
        if (_isCaseSensitive) {
          _xifexpression = tag.getName();
        } else {
          _xifexpression = tag.getName().toLowerCase();
        }
        final String name = _xifexpression;
        final TaskTag oldTag = taskTagsByName.get(name);
        if ((oldTag != null)) {
          int _ordinal = tag.getPriority().ordinal();
          int _ordinal_1 = oldTag.getPriority().ordinal();
          boolean _lessThan = (_ordinal < _ordinal_1);
          if (_lessThan) {
            taskTagsByName.put(name, tag);
          }
        } else {
          taskTagsByName.put(name, tag);
        }
      }
    }
    return taskTagsByName;
  }
  
  protected Pattern toPattern(final TaskTags taskTags) {
    Pattern _xblockexpression = null;
    {
      int flags = Pattern.MULTILINE;
      boolean _isCaseSensitive = taskTags.isCaseSensitive();
      boolean _not = (!_isCaseSensitive);
      if (_not) {
        flags = ((flags | Pattern.CASE_INSENSITIVE) | Pattern.UNICODE_CASE);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("^.*((");
      final Function1<TaskTag, String> _function = (TaskTag it) -> {
        return Pattern.quote(it.getName());
      };
      String _join = IterableExtensions.join(IterableExtensions.<TaskTag, String>map(taskTags, _function), "|");
      _builder.append(_join);
      _builder.append(")(.*)?)$");
      _xblockexpression = Pattern.compile(_builder.toString(), flags);
    }
    return _xblockexpression;
  }
}
