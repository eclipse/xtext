/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class DefaultTaskParser implements ITaskParser {
  @Override
  public List<Task> parseTasks(final String source, final TaskTags taskTags) {
    List<Task> _xblockexpression = null;
    {
      boolean _isEmpty = IterableExtensions.isEmpty(taskTags);
      if (_isEmpty) {
        return Collections.<Task>emptyList();
      }
      final Map<String, TaskTag> taskTagsByName = this.getTaskTagsByName(taskTags);
      final Matcher matcher = this.toPattern(taskTags).matcher(source);
      List<Task> tasks = null;
      int prevLine = 1;
      int prevOffset = 0;
      while (matcher.find()) {
        {
          if ((tasks == null)) {
            tasks = CollectionLiterals.<Task>newArrayList();
          }
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
      List<Task> _elvis = null;
      if (tasks != null) {
        _elvis = tasks;
      } else {
        List<Task> _emptyList = Collections.<Task>emptyList();
        _elvis = _emptyList;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  protected Map<String, TaskTag> getTaskTagsByName(final TaskTags taskTags) {
    return taskTags.getTaskTagsByName();
  }
  
  protected Pattern toPattern(final TaskTags taskTags) {
    return taskTags.toPattern();
  }
}
