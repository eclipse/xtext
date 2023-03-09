/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import static java.util.stream.Collectors.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class PreferenceTaskTagProvider implements ITaskTagProvider {
	public static final PreferenceKey TAGS_KEY = new PreferenceKey("task.tags", "TODO,FIXME,XXX");

	public static final PreferenceKey PRIORITIES_KEY = new PreferenceKey("task.priorities", "NORMAL,HIGH,NORMAL");

	public static final PreferenceKey CASE_SENSITIVE_KEY = new PreferenceKey("task.caseSensitive", "true");

	public static final List<PreferenceKey> KEYS = Collections.<PreferenceKey>unmodifiableList(
			Lists.newArrayList(PreferenceTaskTagProvider.TAGS_KEY,
					PreferenceTaskTagProvider.PRIORITIES_KEY, PreferenceTaskTagProvider.CASE_SENSITIVE_KEY));

	public static List<TaskTag> parseTags(String names, String priorities) {
		Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
		List<String> tags = toList(splitter.split(names));
		List<String> prios = toList(splitter.split(priorities));
		List<TaskTag> elements = new ArrayList<>();
		for (int i=0; i<tags.size(); i++) {
			TaskTag taskTag = new TaskTag();
			taskTag.setName(tags.get(i));
			Priority priority = Priority.NORMAL;
			if (prios.size() >= i) {
				try {
					priority = Priority.valueOf(prios.get(i));
				} catch (IllegalArgumentException ignore) {}
			}
			taskTag.setPriority(priority);
			elements.add(taskTag);
		}
		return elements;
	}

	public static String serializeTags(List<TaskTag> tags) {
		return tags.stream().map(t -> t.getName()).collect(joining(","));
	}

	public static String serializePriorities(List<TaskTag> tags) {
		return tags.stream().map(t -> t.getPriority().toString()).collect(joining(","));
	}

	private IPreferenceValuesProvider preferenceValuesProvider;

	@Override
	public TaskTags getTaskTags(Resource resource) {
		IPreferenceValues prefs = this.preferenceValuesProvider.getPreferenceValues(resource);
		String names = prefs.getPreference(PreferenceTaskTagProvider.TAGS_KEY);
		String priorities = prefs.getPreference(PreferenceTaskTagProvider.PRIORITIES_KEY);
		TaskTags taskTags = new TaskTags();
		taskTags.setCaseSensitive(Boolean.valueOf(prefs.getPreference(PreferenceTaskTagProvider.CASE_SENSITIVE_KEY)));
		List<TaskTag> tags = PreferenceTaskTagProvider.parseTags(names, priorities);
		taskTags.getTaskTags().addAll(tags);
		return taskTags;
	}

	@Inject
	public void setPreferenceValuesProvider(IPreferenceValuesProvider preferenceValuesProvider) {
		this.preferenceValuesProvider = preferenceValuesProvider;
	}
}
