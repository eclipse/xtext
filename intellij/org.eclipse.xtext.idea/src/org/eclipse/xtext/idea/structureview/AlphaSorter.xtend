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