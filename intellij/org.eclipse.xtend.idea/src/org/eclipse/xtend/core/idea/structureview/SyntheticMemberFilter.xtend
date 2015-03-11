/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement

/**
 * @author kosyakov - Initial contribution and API
 */
class SyntheticMemberFilter implements Filter {

	public static val ID = "SHOW_NO_SYNTHETIC"

	override isReverted() {
		true
	}

	override isVisible(TreeElement treeNode) {
		if (treeNode instanceof XtendFeatureTreeElement) {
			!treeNode.synthetic
		} else {
			true
		}
	}

	override getName() {
		ID
	}

	override getPresentation() {
		return new ActionPresentationData("Show Synthetic Members", null, null)
	}

}