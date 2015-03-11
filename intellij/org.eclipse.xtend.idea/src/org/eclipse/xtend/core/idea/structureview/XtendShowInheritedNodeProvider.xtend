/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.icons.AllIcons
import com.intellij.ide.IdeBundle
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.NodeProvider
import com.intellij.ide.util.treeView.smartTree.TreeElement

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendShowInheritedNodeProvider implements NodeProvider<TreeElement> {
	
	public static val String ID = "XTEND_SHOW_INHERITED";
	
	override provideNodes(TreeElement node) {
		emptyList
	}
	
	override getName() {
		ID
	}
	
	override getPresentation() {
		return new ActionPresentationData(IdeBundle.message("action.structureview.show.inherited"), null, AllIcons.Hierarchy.Supertypes);
	}
	
}