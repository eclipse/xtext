/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.framework

import com.google.inject.Inject
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import javax.inject.Provider
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator
import org.eclipse.xtend.core.idea.config.XtendProjectConfigurator

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {

	@Inject
	Provider<XtendLibraryDescription> libraryDescriptionProvider
	@Inject XtendLibraryConfigurator xtendLibManager
	@Inject extension  XtendProjectConfigurator projectConfiguator

	override addSupport(
		Module module,
		ModifiableRootModel rootModel,
		ModifiableModelsProvider modifiableModelsProvider
	) {
		val conf = rootModel.module.createOrGetXtendFacetConf
		rootModel.setupOutputConfiguration(conf)
		rootModel.createOutputFolders(conf.state)
		xtendLibManager.ensureXtendLibAvailable(rootModel)
	}

	override createComponent() {
		null
	}

	override createLibraryDescription() {
		libraryDescriptionProvider.get
	}
}
