/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@SuppressWarnings("all")
public class TaskTags implements Iterable<TaskTag> {
  private boolean caseSensitive;
  
  private final List<TaskTag> taskTags = CollectionLiterals.<TaskTag>newArrayList();
  
  @Accessors(AccessorType.NONE)
  private Pattern pattern;
  
  @Accessors(AccessorType.NONE)
  private Map<String, TaskTag> taskTagsByName;
  
  @Override
  public Iterator<TaskTag> iterator() {
    return this.taskTags.iterator();
  }
  
  public Pattern toPattern() {
    if ((this.pattern == null)) {
      int flags = Pattern.MULTILINE;
      if ((!this.caseSensitive)) {
        flags = ((flags | Pattern.CASE_INSENSITIVE) | Pattern.UNICODE_CASE);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("^.*((");
      final Function1<TaskTag, String> _function = (TaskTag it) -> {
        return Pattern.quote(it.getName());
      };
      String _join = IterableExtensions.join(ListExtensions.<TaskTag, String>map(this.taskTags, _function), "|");
      _builder.append(_join);
      _builder.append(")(.*)?)$");
      this.pattern = Pattern.compile(_builder.toString(), flags);
    }
    return this.pattern;
  }
  
  public Map<String, TaskTag> getTaskTagsByName() {
    if ((this.taskTagsByName == null)) {
      HashMap<String, TaskTag> _hashMap = new HashMap<String, TaskTag>();
      this.taskTagsByName = _hashMap;
      for (final TaskTag tag : this.taskTags) {
        {
          String _xifexpression = null;
          if (this.caseSensitive) {
            _xifexpression = tag.getName();
          } else {
            _xifexpression = tag.getName().toLowerCase();
          }
          final String name = _xifexpression;
          final TaskTag oldTag = this.taskTagsByName.get(name);
          if ((oldTag != null)) {
            int _ordinal = tag.getPriority().ordinal();
            int _ordinal_1 = oldTag.getPriority().ordinal();
            boolean _lessThan = (_ordinal < _ordinal_1);
            if (_lessThan) {
              this.taskTagsByName.put(name, tag);
            }
          } else {
            this.taskTagsByName.put(name, tag);
          }
        }
      }
    }
    return this.taskTagsByName;
  }
  
  @Pure
  public boolean isCaseSensitive() {
    return this.caseSensitive;
  }
  
  public void setCaseSensitive(final boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
  }
  
  @Pure
  public List<TaskTag> getTaskTags() {
    return this.taskTags;
  }
}
