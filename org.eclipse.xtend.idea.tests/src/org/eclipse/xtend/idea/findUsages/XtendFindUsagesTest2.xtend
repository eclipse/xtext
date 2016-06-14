/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.findUsages

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.VfsUtil
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.facet.FacetProvider

/**
 * @author efftinge - Initial contribution and API
 */
class XtendFindUsagesTest2 extends XtendFindUsagesTest {
	
	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		super.configureModule(module, model, contentEntry)
		val facetProvider = XtendLanguage.INSTANCE.getInstance(FacetProvider)
		val facet = facetProvider.getFacet(module)
		
		val base = model.contentRoots.head
		
		val file = VfsUtil.findRelativeFile(facet.configuration.state.outputDirectory, base)
		facet.configuration.state.outputDirectory = file.path
		
	}
	
}