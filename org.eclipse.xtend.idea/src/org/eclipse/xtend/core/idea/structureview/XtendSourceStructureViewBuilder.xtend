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
import org.eclipse.xtend.ide.common.outline.XtendOutlineSourceTreeBuilder

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendSourceStructureViewBuilder extends AbstractXtendStructureViewBuilder {

	@Inject
	Provider<XtendOutlineSourceTreeBuilder> xtendOutlineSourceTreeBuilderProvider

	@Inject
	Provider<XtendStructureViewTreeElementProvider> xtendStructureViewTreeElementProviderProvider

	override createStructureViewTreeElementProvider() {
		val sourceProvider = xtendStructureViewTreeElementProviderProvider.get
		val sourceBuilder = xtendOutlineSourceTreeBuilderProvider.get
		sourceBuilder.xtendOutlineNodeBuilder = sourceProvider
		sourceProvider.xtendOutlineTreeBuilder = sourceBuilder
		sourceProvider
	}

}