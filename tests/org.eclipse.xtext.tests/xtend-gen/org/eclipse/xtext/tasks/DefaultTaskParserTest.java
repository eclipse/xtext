/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.tasks.DefaultTaskParser;
import org.eclipse.xtext.tasks.DefaultTaskTagProvider;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskAssert;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultTaskParserTest {
  private ITaskParser parser;
  
  private TaskTags definitions;
  
  @Before
  public void setup() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    DefaultTaskTagProvider _defaultTaskTagProvider = new DefaultTaskTagProvider();
    TaskTags _taskTags = _defaultTaskTagProvider.getTaskTags(null);
    this.definitions = _taskTags;
  }
  
  @Test
  public void testCaseInSensitive() {
    this.definitions.setCaseSensitive(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* FixMe case insensitve match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function = new Procedure1<Task>() {
      public void apply(final Task it) {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("FIXME");
            it.setPriority(Priority.HIGH);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        it.setTag(_doubleArrow);
        it.setDescription(" case insensitve match");
        it.setLineNumber(2);
        it.setOffset(6);
      }
    };
    Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(Lists.<Task>newArrayList(_doubleArrow)));
  }
  
  @Test
  public void testCaseSensitve() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* TODO this is a task");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* FIXME this cannot work");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* XXX: god, this is bad");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* FixMe this should not match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function = new Procedure1<Task>() {
      public void apply(final Task it) {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("TODO");
            it.setPriority(Priority.NORMAL);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        it.setTag(_doubleArrow);
        it.setDescription(" this is a task");
        it.setLineNumber(1);
        it.setOffset(3);
      }
    };
    Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_1 = new Procedure1<Task>() {
      public void apply(final Task it) {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("FIXME");
            it.setPriority(Priority.HIGH);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        it.setTag(_doubleArrow);
        it.setDescription(" this cannot work");
        it.setLineNumber(2);
        it.setOffset(26);
      }
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_1);
    Task _task_2 = new Task();
    final Procedure1<Task> _function_2 = new Procedure1<Task>() {
      public void apply(final Task it) {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("XXX");
            it.setPriority(Priority.NORMAL);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        it.setTag(_doubleArrow);
        it.setDescription(": god, this is bad");
        it.setLineNumber(3);
        it.setOffset(52);
      }
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_2, _function_2);
    Task _task_3 = new Task();
    final Procedure1<Task> _function_3 = new Procedure1<Task>() {
      public void apply(final Task it) {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("TODO");
            it.setPriority(Priority.NORMAL);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        it.setTag(_doubleArrow);
        it.setDescription("");
        it.setLineNumber(4);
        it.setOffset(77);
      }
    };
    Task _doubleArrow_3 = ObjectExtensions.<Task>operator_doubleArrow(_task_3, _function_3);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(Lists.<Task>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3)));
  }
  
  private void assertContainsTasks(final CharSequence source, final List<Task> expectedTasks) {
    String _string = source.toString();
    String _unix = LineDelimiters.toUnix(_string);
    final List<Task> actualTasks = this.parser.parseTasks(_unix, this.definitions);
    int _size = expectedTasks.size();
    int _size_1 = actualTasks.size();
    Assert.assertEquals(_size, _size_1);
    int _size_2 = expectedTasks.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final Integer i : _doubleDotLessThan) {
      Task _get = expectedTasks.get((i).intValue());
      Task _get_1 = actualTasks.get((i).intValue());
      TaskAssert.assertExactMatch(_get, _get_1);
    }
  }
}
