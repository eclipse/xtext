/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks.preferences

import org.eclipse.xtext.tasks.PreferenceTaskTagProvider
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class TaskTagPreferenceInitializer implements IPreferenceStoreInitializer {
	override initialize(IPreferenceStoreAccess access) {
		val store = access.writablePreferenceStore
		PreferenceTaskTagProvider.KEYS.forEach [
			store.setDefault(id, defaultValue)
		]
	}
}
