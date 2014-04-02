/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class DefaultTaskTagProvider implements ITaskTagProvider {
  public TaskTags getTaskTags(final Resource resouce) {
    TaskTags _taskTags = new TaskTags();
    final Procedure1<TaskTags> _function = new Procedure1<TaskTags>() {
      public void apply(final TaskTags it) {
        it.setCaseSensitive(true);
        List<TaskTag> _taskTags = it.getTaskTags();
        TaskTag _taskTag = new TaskTag();
        final Procedure1<TaskTag> _function = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("TODO");
            it.setPriority(Priority.NORMAL);
          }
        };
        TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
        TaskTag _taskTag_1 = new TaskTag();
        final Procedure1<TaskTag> _function_1 = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("FIXME");
            it.setPriority(Priority.HIGH);
          }
        };
        TaskTag _doubleArrow_1 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag_1, _function_1);
        TaskTag _taskTag_2 = new TaskTag();
        final Procedure1<TaskTag> _function_2 = new Procedure1<TaskTag>() {
          public void apply(final TaskTag it) {
            it.setName("XXX");
            it.setPriority(Priority.NORMAL);
          }
        };
        TaskTag _doubleArrow_2 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag_2, _function_2);
        Iterables.<TaskTag>addAll(_taskTags, Collections.<TaskTag>unmodifiableList(Lists.<TaskTag>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2)));
      }
    };
    return ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
  }
}
