/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.ide.structureView.StructureView
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner
import com.intellij.openapi.editor.Editor
import org.eclipse.xtext.idea.structureview.AbstractStructureViewBuilder
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractXtendStructureViewBuilder extends AbstractStructureViewBuilder {

	override createStructureViewModel(Editor editor) {
		new XtendFileTreeModel(xtextFile, editor)
	}

	override configureStructureViewTreeElementProvider(
		IStructureViewTreeElementProvider structureViewTreeElementProvider,
		XtextFileTreeModel model,
		StructureView view
	) {
		if (structureViewTreeElementProvider instanceof XtendStructureViewTreeElementProvider) {
			if (view instanceof TreeActionsOwner) {
				structureViewTreeElementProvider.treeActionsOwner = view
			}
		}
	}

}