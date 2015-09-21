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
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel
import com.intellij.openapi.module.JavaModuleType
import com.intellij.openapi.module.ModuleType

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFrameworkSupportProvider extends FrameworkSupportInModuleProvider {

	@Inject
	Provider<XtendSupportConfigurable> xtendSupportConfigurableProvider
	
	override getFrameworkType() {
		FrameworkTypeEx.EP_NAME.findExtension(XtendFrameworkType)
	}

	override createConfigurable(FrameworkSupportModel model) {
		xtendSupportConfigurableProvider.get
	}

	override isEnabledForModuleType(ModuleType moduleType) {
		moduleType instanceof JavaModuleType
	}

}
