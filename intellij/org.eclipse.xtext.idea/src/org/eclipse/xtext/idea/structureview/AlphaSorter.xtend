/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.intellij.icons.AllIcons
import com.intellij.ide.IdeBundle
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import java.util.Comparator
import org.eclipse.xtend.lib.annotations.Accessors

class AlphaSorter implements Sorter {

	static public val ALPHA_SORTER_ID = 'OUTLINE_ALPHA_COMPARATOR'
	
	@Accessors
	Comparator<TreeElement> comparator

	override isVisible() {
		comparator != null
	}

	override getName() {
		ALPHA_SORTER_ID
	}

	override getPresentation() {
		new ActionPresentationData(
			IdeBundle.message("action.sort.alphabetically"),
			IdeBundle.message("action.sort.alphabetically"),
			AllIcons.ObjectBrowser.Sorted
		)
	}

	override toString() {
		name
	}

}