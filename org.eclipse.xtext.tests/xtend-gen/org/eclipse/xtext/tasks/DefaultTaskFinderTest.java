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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tasks.DefaultTaskFinder;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskAssert;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.LineDelimiters;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
public class DefaultTaskFinderTest extends AbstractXtextTests {
  private ITaskFinder finder;
  
  @Before
  public void setup() {
    try {
      this.with(NoJdtTestLanguageStandaloneSetup.class);
      DefaultTaskFinder _get = this.<DefaultTaskFinder>get(DefaultTaskFinder.class);
      this.finder = _get;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNonXtextResource() {
    ResourceImpl _resourceImpl = new ResourceImpl();
    this.assertContainsTasks(_resourceImpl, Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList()));
  }
  
  @Test
  public void test() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//TODO foo");
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* FIXME bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Fixme no match");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* FOO also no match");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("Hello notATODO!");
      _builder.newLine();
      String _unix = LineDelimiters.toUnix(_builder.toString());
      XtextResource _resourceFromString = this.getResourceFromString(_unix);
      Task _task = new Task();
      final Procedure1<Task> _function = (Task it) -> {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function_1 = (TaskTag it_1) -> {
          it_1.setName("TODO");
          it_1.setPriority(Priority.NORMAL);
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function_1);
        it.setTag(_doubleArrow);
        it.setDescription(" foo");
        it.setOffset(2);
        it.setLineNumber(1);
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
        it.setDescription(" bar");
        it.setOffset(17);
        it.setLineNumber(3);
      };
      Task _doubleArrow_1 = ObjectExtensions.<Task>operator_doubleArrow(_task_1, _function_1);
      this.assertContainsTasks(_resourceFromString, 
        Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow, _doubleArrow_1)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertContainsTasks(final Resource resource, final List<Task> expectedTasks) {
    final List<Task> actualTasks = this.finder.findTasks(resource);
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
