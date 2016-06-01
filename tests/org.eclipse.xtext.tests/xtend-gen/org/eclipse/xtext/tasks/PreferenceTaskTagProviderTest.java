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
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.TaskAssert;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class PreferenceTaskTagProviderTest {
  @Test
  public void test() {
    TaskTag _taskTag = new TaskTag();
    final Procedure1<TaskTag> _function = (TaskTag it) -> {
      it.setName("Foo");
      it.setPriority(Priority.LOW);
    };
    TaskTag _doubleArrow = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag, _function);
    TaskTag _taskTag_1 = new TaskTag();
    final Procedure1<TaskTag> _function_1 = (TaskTag it) -> {
      it.setName("BAR");
      it.setPriority(Priority.NORMAL);
    };
    TaskTag _doubleArrow_1 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag_1, _function_1);
    TaskTag _taskTag_2 = new TaskTag();
    final Procedure1<TaskTag> _function_2 = (TaskTag it) -> {
      it.setName("baZ");
      it.setPriority(Priority.HIGH);
    };
    TaskTag _doubleArrow_2 = ObjectExtensions.<TaskTag>operator_doubleArrow(_taskTag_2, _function_2);
    final List<TaskTag> tags = Collections.<TaskTag>unmodifiableList(CollectionLiterals.<TaskTag>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2));
    final String names = PreferenceTaskTagProvider.serializeTags(tags);
    final String prios = PreferenceTaskTagProvider.serializePriorities(tags);
    final IPreferenceValuesProvider.SingletonPreferenceValuesProvider valueProvider = new IPreferenceValuesProvider.SingletonPreferenceValuesProvider();
    final MapBasedPreferenceValues values = valueProvider.getPreferenceValues(null);
    String _id = PreferenceTaskTagProvider.TAGS_KEY.getId();
    values.put(_id, names);
    String _id_1 = PreferenceTaskTagProvider.PRIORITIES_KEY.getId();
    values.put(_id_1, prios);
    String _id_2 = PreferenceTaskTagProvider.CASE_SENSITIVE_KEY.getId();
    values.put(_id_2, "false");
    final PreferenceTaskTagProvider tagProvider = new PreferenceTaskTagProvider();
    tagProvider.setPreferenceValuesProvider(valueProvider);
    final TaskTags parsedTags = tagProvider.getTaskTags(null);
    boolean _isCaseSensitive = parsedTags.isCaseSensitive();
    Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(_isCaseSensitive));
    int _size = tags.size();
    int _size_1 = IterableExtensions.size(parsedTags);
    Assert.assertEquals(_size, _size_1);
    int _size_2 = tags.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final Integer i : _doubleDotLessThan) {
      TaskTag _get = tags.get((i).intValue());
      TaskTag _get_1 = ((TaskTag[])Conversions.unwrapArray(parsedTags, TaskTag.class))[(i).intValue()];
      TaskAssert.assertExactMatch(_get, _get_1);
    }
  }
}
