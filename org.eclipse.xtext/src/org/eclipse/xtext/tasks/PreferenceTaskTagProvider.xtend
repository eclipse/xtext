/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import com.google.common.base.Joiner
import com.google.common.base.Splitter
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.preferences.PreferenceKey

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class PreferenceTaskTagProvider implements ITaskTagProvider {
	public static val TAGS_KEY = new PreferenceKey("task.tags", "TODO,FIXME,XXX")
	public static val PRIORITIES_KEY = new PreferenceKey("task.priorities", "NORMAL,HIGH,NORMAL")
	public static val CASE_SENSITIVE_KEY = new PreferenceKey("task.caseSensitive", "true")
	public static val KEYS = #[TAGS_KEY, PRIORITIES_KEY, CASE_SENSITIVE_KEY]

	static def List<TaskTag> parseTags(String names, String priorities) {
		val splitter = Splitter.on(',').omitEmptyStrings.trimResults
		val tags = splitter.split(names).toList
		val prios = splitter.split(priorities).toList
		val elements = newArrayList
		for (i : 0 ..< tags.size) {
			elements += new TaskTag => [
				name = tags.get(i)
				priority = 
					if (prios.size >= i) {
						try {
							Priority.valueOf(prios.get(i))
						} catch (IllegalArgumentException e) {
							Priority.NORMAL
						}
					} else {
						Priority.NORMAL
					}
			]
		}
		return elements
	}

	static def String serializeTags(List<TaskTag> tags) {
		Joiner.on(',').join(tags.map[name])
	}

	static def String serializePriorities(List<TaskTag> tags) {
		Joiner.on(',').join(tags.map[priority])
	}

	IPreferenceValuesProvider preferenceValuesProvider

	override getTaskTags(Resource resource) {
		val prefs = preferenceValuesProvider.getPreferenceValues(resource)
		val names = prefs.getPreference(TAGS_KEY)
		val priorities = prefs.getPreference(PRIORITIES_KEY)
		new TaskTags => [
			caseSensitive = Boolean.valueOf(prefs.getPreference(CASE_SENSITIVE_KEY))
			getTaskTags += parseTags(names, priorities)
		]
	}
	
	@Inject
	def void setPreferenceValuesProvider(IPreferenceValuesProvider preferenceValuesProvider) {
		this.preferenceValuesProvider = preferenceValuesProvider
	}

}
