/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.editor.Editor
import org.eclipse.xtend.ide.common.outline.XtendOutlineJvmTreeBuilder

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendJvmStructureViewBuilder extends AbstractXtendStructureViewBuilder {

	@Inject
	Provider<XtendOutlineJvmTreeBuilder> xtendOutlineJvmTreeBuilderProvider

	@Inject
	Provider<XtendStructureViewTreeElementProvider> xtendStructureViewTreeElementProviderProvider
	
	override createStructureViewModel(Editor editor) {
		new XtendFileJvmTreeModel(xtextFile, editor)
	}

	override createStructureViewTreeElementProvider() {
		val jvmProvider = xtendStructureViewTreeElementProviderProvider.get
		val jvmBuilder = xtendOutlineJvmTreeBuilderProvider.get
		jvmBuilder.xtendOutlineNodeBuilder = jvmProvider
		jvmProvider.xtendOutlineTreeBuilder = jvmBuilder
		jvmProvider
	}

}