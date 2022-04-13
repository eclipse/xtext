/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.tasks;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendTaskFinderTest extends AbstractXtendTestCase {
  @Inject
  private ITaskFinder finder;

  @Test
  public void test() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\'\'\'", "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("«", "\t\t");
      _builder.append("«", "\t\t");
      _builder.append("«", "\t\t");
      _builder.append(" TODO this is a todo");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("TODO this is not a todo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("«", "\t\t");
      _builder.append("«", "\t\t");
      _builder.append("«", "\t\t");
      _builder.append(" FIXME this is a fixme");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("\'\'\'", "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = Strings.toUnixLineSeparator(_builder.toString());
      final XtendFile file = this.file(contents);
      Task _task = new Task();
      final Procedure1<Task> _function = (Task it) -> {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function_1 = (TaskTag it_1) -> {
          it_1.setName("TODO");
          it_1.setPriority(Priority.NORMAL);
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function_1);
        it.setTag(_doubleArrow);
        it.setDescription(" this is a todo");
        it.setOffset(50);
        it.setLineNumber(6);
      };
      Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
      Task _task_1 = new Task();
      final Procedure1<Task> _function_1 = (Task it) -> {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function_2 = (TaskTag it_1) -> {
          it_1.setName("FIXME");
          it_1.setPriority(Priority.HIGH);
        };
        TaskTag _doubleArrow_1 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function_2);
        it.setTag(_doubleArrow_1);
        it.setDescription(" this is a fixme");
        it.setOffset(102);
        it.setLineNumber(8);
      };
      Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_1);
      this.assertContainsTasks(file.eResource(), 
        Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow, _doubleArrow_1)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void assertContainsTasks(final Resource resource, final List<Task> expectedTasks) {
    final List<Task> actualTasks = this.finder.findTasks(resource);
    Assert.assertEquals(expectedTasks.size(), actualTasks.size());
    int _size = expectedTasks.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      XtendTaskFinderTest.assertExactMatch(expectedTasks.get((i).intValue()), actualTasks.get((i).intValue()));
    }
  }

  public static void assertExactMatch(final Task expected, final Task actual) {
    XtendTaskFinderTest.assertExactMatch(expected.getTag(), actual.getTag());
    Assert.assertEquals(expected.getDescription(), actual.getDescription());
    Assert.assertEquals(expected.getLineNumber(), actual.getLineNumber());
    Assert.assertEquals(expected.getOffset(), actual.getOffset());
  }

  public static void assertExactMatch(final TaskTag expected, final TaskTag actual) {
    Assert.assertEquals(expected.getName(), actual.getName());
    Assert.assertEquals(expected.getPriority(), actual.getPriority());
  }
}
