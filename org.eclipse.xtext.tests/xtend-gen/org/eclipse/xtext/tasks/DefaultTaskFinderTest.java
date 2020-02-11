/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.impl.AbstractMultiLineCommentProvider;
import org.eclipse.xtext.tasks.DefaultTaskFinder;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageRuntimeModule;
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
  public static class NoJdtTestLanguageStandaloneSetupCustom extends NoJdtTestLanguageStandaloneSetup {
    @Override
    public Injector createInjector() {
      abstract class __NoJdtTestLanguageStandaloneSetupCustom_1 extends NoJdtTestLanguageRuntimeModule {
        public abstract void configureEndTag(final Binder binder);
      }
      
      __NoJdtTestLanguageStandaloneSetupCustom_1 ___NoJdtTestLanguageStandaloneSetupCustom_1 = new __NoJdtTestLanguageStandaloneSetupCustom_1() {
        public void configureEndTag(final Binder binder) {
          binder.<String>bind(String.class).annotatedWith(
            Names.named(AbstractMultiLineCommentProvider.END_TAG)).toInstance("\\*\\*\\*/");
        }
      };
      return Guice.createInjector(___NoJdtTestLanguageStandaloneSetupCustom_1);
    }
  }
  
  private ITaskFinder finder;
  
  @Before
  public void setup() {
    try {
      this.with(NoJdtTestLanguageStandaloneSetup.class);
      this.finder = this.<DefaultTaskFinder>get(DefaultTaskFinder.class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNonXtextResource() {
    this.assertContainsTasks(new ResourceImpl(), Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList()));
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
      _builder.append("/* TODO Get rid of this */");
      _builder.newLine();
      _builder.append("Hello notATODO!");
      _builder.newLine();
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
      Task _task_2 = new Task();
      final Procedure1<Task> _function_2 = (Task it) -> {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function_3 = (TaskTag it_1) -> {
          it_1.setName("TODO");
          it_1.setPriority(Priority.NORMAL);
        };
        TaskTag _doubleArrow_2 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function_3);
        it.setTag(_doubleArrow_2);
        it.setDescription(" Get rid of this ");
        it.setOffset(73);
        it.setLineNumber(7);
      };
      Task _doubleArrow_2 = ObjectExtensions.<Task>operator_doubleArrow(_task_2, _function_2);
      this.assertContainsTasks(this.getResourceFromString(
        LineDelimiters.toUnix(_builder.toString())), 
        Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSpecialEndTag() {
    try {
      this.with(DefaultTaskFinderTest.NoJdtTestLanguageStandaloneSetupCustom.class);
      this.finder = this.<DefaultTaskFinder>get(DefaultTaskFinder.class);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* TODO Get rid of this ***/");
      _builder.newLine();
      _builder.append("Hello notATODO!");
      _builder.newLine();
      Task _task = new Task();
      final Procedure1<Task> _function = (Task it) -> {
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function_1 = (TaskTag it_1) -> {
          it_1.setName("TODO");
          it_1.setPriority(Priority.NORMAL);
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function_1);
        it.setTag(_doubleArrow);
        it.setDescription(" Get rid of this ");
        it.setOffset(3);
        it.setLineNumber(1);
      };
      Task _doubleArrow = ObjectExtensions.<Task>operator_doubleArrow(_task, _function);
      this.assertContainsTasks(this.getResourceFromString(
        LineDelimiters.toUnix(_builder.toString())), 
        Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList(_doubleArrow)));
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
      Assert.assertEquals(expectedTasks.get((i).intValue()), actualTasks.get((i).intValue()));
    }
  }
}
