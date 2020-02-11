/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tasks

import org.eclipse.xtext.tasks.ITaskTagProvider
import org.eclipse.emf.ecore.resource.Resource
import com.google.inject.Inject
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.preferences.PreferenceKey
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.tasks.TaskTags
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class XtendTaskTagProvider implements ITaskTagProvider {
	
	@Inject
	IPreferenceValuesProvider preferenceValuesProvider
	
	override getTaskTags(Resource resource) {
		val prefs = preferenceValuesProvider.getPreferenceValues(resource)
		val namePref = prefs.getPreference(new PreferenceKey(JavaCore.COMPILER_TASK_TAGS, "TODO,FIXME,XXX"))
		val prioritiesPref = prefs.getPreference(new PreferenceKey(JavaCore.COMPILER_TASK_PRIORITIES, "NORMAL,HIGH,NORMAL"))
		val caseSensitivePref = prefs.getPreference(new PreferenceKey(JavaCore.COMPILER_TASK_CASE_SENSITIVE, JavaCore.ENABLED))
		val tags = PreferenceTaskTagProvider.parseTags(namePref, prioritiesPref)
		
		new TaskTags => [
			taskTags += tags
			caseSensitive = caseSensitivePref.equals(JavaCore.ENABLED)
		]
	}
	
}