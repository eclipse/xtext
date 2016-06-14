/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences

import java.util.Map
import org.eclipse.xtext.util.internal.EmfAdaptable

@EmfAdaptable class PreferenceValuesByLanguage {
	val Map<String, IPreferenceValues> preferencesByLanguage = newHashMap

	def get(String languageId) {
		preferencesByLanguage.get(languageId)
	}

	def put(String languageId, IPreferenceValues values) {
		preferencesByLanguage.put(languageId, values)
	}
}