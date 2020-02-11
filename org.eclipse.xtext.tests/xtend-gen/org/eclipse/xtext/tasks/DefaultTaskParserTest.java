/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.tasks.DefaultTaskParser;
import org.eclipse.xtext.tasks.DefaultTaskTagProvider;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.tests.LineDelimiters;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
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
  
  private final TaskTag TODO = DefaultTaskParserTest.createTaskTag("TODO", Priority.NORMAL);
  
  private final TaskTag todo = DefaultTaskParserTest.createTaskTag("todo", Priority.NORMAL);
  
  @Pure
  private static TaskTag createTaskTag(final String tag, final Priority priority) {
    TaskTag _taskTag = new TaskTag();
    final Procedure1<TaskTag> _function = (TaskTag it) -> {
      it.setName(tag);
      it.setPriority(priority);
    };
    return ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
  }
  
  @Before
  public void setup() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    this.definitions = new DefaultTaskTagProvider().getTaskTags(null);
  }
  
  @Test
  public void testTasksWithDifferentCase() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = (TaskTags it) -> {
      it.setCaseSensitive(true);
      List<TaskTag> _taskTags_1 = it.getTaskTags();
      Iterables.<TaskTag>addAll(_taskTags_1, Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(this.TODO, this.todo)));
    };
    TaskTags _doubleArrow = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    this.definitions = _doubleArrow;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO uppercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* todo lowercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" uppercase match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(this.todo);
      it.setDescription(" lowercase match");
      it.setLineNumber(3);
      it.setOffset(30);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_2);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow_1, _doubleArrow_2)));
  }
  
  @Test
  public void testTasksWithDifferentCaseCaseInsensitive() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = (TaskTags it) -> {
      it.setCaseSensitive(false);
      List<TaskTag> _taskTags_1 = it.getTaskTags();
      Iterables.<TaskTag>addAll(_taskTags_1, Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(this.TODO, this.todo)));
    };
    TaskTags _doubleArrow = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    this.definitions = _doubleArrow;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO uppercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* todo lowercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" uppercase match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" lowercase match");
      it.setLineNumber(3);
      it.setOffset(30);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_2);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow_1, _doubleArrow_2)));
  }
  
  @Test
  public void testTasksWithDifferentCasePriorityMergeIfHigher() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = (TaskTags it) -> {
      it.setCaseSensitive(false);
      List<TaskTag> _taskTags_1 = it.getTaskTags();
      TaskTag _createTaskTag = DefaultTaskParserTest.createTaskTag("todo", Priority.HIGH);
      Iterables.<TaskTag>addAll(_taskTags_1, Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(this.TODO, _createTaskTag)));
    };
    TaskTags _doubleArrow = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    this.definitions = _doubleArrow;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO uppercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* todo lowercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(DefaultTaskParserTest.createTaskTag("todo", Priority.HIGH));
      it.setDescription(" uppercase match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(DefaultTaskParserTest.createTaskTag("todo", Priority.HIGH));
      it.setDescription(" lowercase match");
      it.setLineNumber(3);
      it.setOffset(30);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_2);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow_1, _doubleArrow_2)));
  }
  
  @Test
  public void testTasksWithDifferentCasePriorityNoMergeIfLower() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = (TaskTags it) -> {
      it.setCaseSensitive(false);
      List<TaskTag> _taskTags_1 = it.getTaskTags();
      TaskTag _createTaskTag = DefaultTaskParserTest.createTaskTag("todo", Priority.LOW);
      Iterables.<TaskTag>addAll(_taskTags_1, Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(this.TODO, _createTaskTag)));
    };
    TaskTags _doubleArrow = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    this.definitions = _doubleArrow;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO uppercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* todo lowercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" uppercase match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" lowercase match");
      it.setLineNumber(3);
      it.setOffset(30);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_2);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow_1, _doubleArrow_2)));
  }
  
  @Test
  public void testTasksWithDifferentCasePriorityNoMergeIfSame() {
    DefaultTaskParser _defaultTaskParser = new DefaultTaskParser();
    this.parser = _defaultTaskParser;
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = (TaskTags it) -> {
      it.setCaseSensitive(false);
      List<TaskTag> _taskTags_1 = it.getTaskTags();
      Iterables.<TaskTag>addAll(_taskTags_1, Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(this.TODO, this.todo)));
    };
    TaskTags _doubleArrow = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    this.definitions = _doubleArrow;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO uppercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* todo lowercase match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" uppercase match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task, _function_1);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" lowercase match");
      it.setLineNumber(3);
      it.setOffset(30);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_2);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow_1, _doubleArrow_2)));
  }
  
  @Test
  public void testCaseInSensitive() {
    this.definitions.setCaseSensitive(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* FixMe case insensitive match");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    Task _task = new Task();
    final Procedure1<Task> _function = (Task it) -> {
      it.setTag(DefaultTaskParserTest.createTaskTag("FIXME", Priority.HIGH));
      it.setDescription(" case insensitive match");
      it.setLineNumber(2);
      it.setOffset(6);
    };
    Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow)));
  }
  
  @Test
  public void testCaseSensitive() {
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
    final Procedure1<Task> _function = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription(" this is a task");
      it.setLineNumber(1);
      it.setOffset(3);
    };
    Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
    Task _task_1 = new Task();
    final Procedure1<Task> _function_1 = (Task it) -> {
      it.setTag(DefaultTaskParserTest.createTaskTag("FIXME", Priority.HIGH));
      it.setDescription(" this cannot work");
      it.setLineNumber(2);
      it.setOffset(26);
    };
    Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_1);
    Task _task_2 = new Task();
    final Procedure1<Task> _function_2 = (Task it) -> {
      it.setTag(DefaultTaskParserTest.createTaskTag("XXX", Priority.NORMAL));
      it.setDescription(": god, this is bad");
      it.setLineNumber(3);
      it.setOffset(52);
    };
    Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_2, _function_2);
    Task _task_3 = new Task();
    final Procedure1<Task> _function_3 = (Task it) -> {
      it.setTag(this.TODO);
      it.setDescription("");
      it.setLineNumber(4);
      it.setOffset(77);
    };
    Task _doubleArrow_3 = ObjectExtensions.<Task>operator_doubleArrow(_task_3, _function_3);
    this.assertContainsTasks(_builder, 
      Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3)));
  }
  
  @Test
  public void testLongInputManyTasks() {
    final int expectation = 100000;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    {
      IntegerRange _upTo = new IntegerRange(1, expectation);
      for(final Integer i : _upTo) {
        _builder.append(" ");
        _builder.append("* FIXME this cannot work");
        _builder.newLine();
      }
    }
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    final String source = _builder.toString();
    final List<Task> parsed = this.parser.parseTasks(LineDelimiters.toUnix(source), this.definitions);
    Assert.assertEquals(expectation, parsed.size());
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, expectation, true);
    for (final Integer i_1 : _doubleDotLessThan) {
      Assert.assertEquals(((i_1).intValue() + 2), parsed.get((i_1).intValue()).getLineNumber());
    }
  }
  
  private void assertContainsTasks(final CharSequence source, final List<Task> expectedTasks) {
    final List<Task> actualTasks = this.parser.parseTasks(LineDelimiters.toUnix(source.toString()), this.definitions);
    Assert.assertEquals(expectedTasks.size(), actualTasks.size());
    int _size = expectedTasks.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      Assert.assertEquals(expectedTasks.get((i).intValue()), actualTasks.get((i).intValue()));
    }
  }
}
