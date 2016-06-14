/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.framework

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.framework.FrameworkTypeEx
import org.eclipse.xtend.core.idea.icons.XtendIcons
import org.eclipse.xtend.core.idea.lang.XtendLanguage

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFrameworkType extends FrameworkTypeEx {

	@Inject
	Provider<XtendFrameworkSupportProvider> xtendFrameworkSupportProviderProvider

	new() {
		super(XtendLanguage.INSTANCE.getID)
		XtendLanguage.INSTANCE.injectMembers(this)
	}

	override createProvider() {
		xtendFrameworkSupportProviderProvider.get
	}

	override getIcon() {
		XtendIcons.Xtend_ICON
	}

	override getPresentableName() {
		"Xtend"
	}

}
