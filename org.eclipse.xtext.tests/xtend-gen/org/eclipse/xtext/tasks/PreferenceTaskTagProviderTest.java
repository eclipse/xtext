/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider;
import org.eclipse.xtext.tasks.Priority;
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
    values.put(PreferenceTaskTagProvider.TAGS_KEY.getId(), names);
    values.put(PreferenceTaskTagProvider.PRIORITIES_KEY.getId(), prios);
    values.put(PreferenceTaskTagProvider.CASE_SENSITIVE_KEY.getId(), "false");
    final PreferenceTaskTagProvider tagProvider = new PreferenceTaskTagProvider();
    tagProvider.setPreferenceValuesProvider(valueProvider);
    final TaskTags parsedTags = tagProvider.getTaskTags(null);
    Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(parsedTags.isCaseSensitive()));
    Assert.assertEquals(tags.size(), IterableExtensions.size(parsedTags));
    int _size = tags.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      Assert.assertEquals(tags.get((i).intValue()), ((Object[])Conversions.unwrapArray(parsedTags, Object.class))[(i).intValue()]);
    }
  }
}
