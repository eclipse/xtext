/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import java.util.List;

import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class PreferenceTaskTagProviderTest {
	@Test
	public void test() {
		TaskTag taskTag1 = new TaskTag();
		taskTag1.setName("Foo");
		taskTag1.setPriority(Priority.LOW);
		TaskTag taskTag2 = new TaskTag();
		taskTag2.setName("BAR");
		taskTag2.setPriority(Priority.NORMAL);
		TaskTag taskTag3 = new TaskTag();
		taskTag3.setName("baZ");
		taskTag3.setPriority(Priority.HIGH);
		List<TaskTag> tags = Lists.newArrayList(taskTag1, taskTag2, taskTag3);
		String names = PreferenceTaskTagProvider.serializeTags(tags);
		String prios = PreferenceTaskTagProvider.serializePriorities(tags);
		IPreferenceValuesProvider.SingletonPreferenceValuesProvider valueProvider = new IPreferenceValuesProvider.SingletonPreferenceValuesProvider();
		MapBasedPreferenceValues values = valueProvider.getPreferenceValues(null);
		values.put(PreferenceTaskTagProvider.TAGS_KEY.getId(), names);
		values.put(PreferenceTaskTagProvider.PRIORITIES_KEY.getId(), prios);
		values.put(PreferenceTaskTagProvider.CASE_SENSITIVE_KEY.getId(), "false");
		PreferenceTaskTagProvider tagProvider = new PreferenceTaskTagProvider();
		tagProvider.setPreferenceValuesProvider(valueProvider);
		TaskTags parsedTags = tagProvider.getTaskTags(null);
		Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(parsedTags.isCaseSensitive()));
		Assert.assertEquals(tags.size(), IterableExtensions.size(parsedTags));
		int _size = tags.size();
		for (int i = 0; i < _size; i++) {
			Assert.assertEquals(tags.get(i), Iterables.get(parsedTags, i));
		}
	}
}
