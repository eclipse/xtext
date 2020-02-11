/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline

import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion
import java.util.List

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendOutlineWithEditorLinker extends OutlineWithEditorLinker {
	
	override void selectInTreeView(ISelection selection) {
		if (selection instanceof ITextSelection && !treeViewer.getTree().isDisposed()) {
			val textSelection = selection as ITextSelection
			val selectedTextRegion = new TextRegion(textSelection.offset, textSelection.length);
			val input = treeViewer.getInput();
			if (input instanceof IOutlineNode) {
				val List<IOutlineNode> matchingNodes = newArrayList()
				findNodesInRange(input, selectedTextRegion, matchingNodes);
				if (!matchingNodes.isEmpty) {
					val smallestMatch = matchingNodes.map[fullTextRegion.length].min
					val nodesToBeSelected = matchingNodes.filter[fullTextRegion.length == smallestMatch]
					if (!nodesToBeSelected.isEmpty)
						treeViewer.setSelection(new StructuredSelection(nodesToBeSelected.toList.toArray));
				}
			}
		}
	}
	
	def protected void findNodesInRange(IOutlineNode input, ITextRegion selectedTextRegion, List<IOutlineNode> nodes) {
		val ITextRegion textRegion = input.getFullTextRegion();
		if (textRegion === null || textRegion.contains(selectedTextRegion)) {
			nodes.add(input)
		}
		for (IOutlineNode child : input.getChildren()) {
			findNodesInRange(child, selectedTextRegion, nodes);
		}
	}
}