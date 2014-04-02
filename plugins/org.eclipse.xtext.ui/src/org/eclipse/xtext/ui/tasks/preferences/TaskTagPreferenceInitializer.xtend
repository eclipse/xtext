/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
