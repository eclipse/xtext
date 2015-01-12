package org.eclipse.xtext.idea.structureview

import com.intellij.ide.util.treeView.smartTree.TreeElement
import java.util.Comparator

import static extension com.intellij.ide.util.treeView.smartTree.SorterUtil.*

class DefaultComparator implements Comparator<TreeElement> {

	override compare(TreeElement treeElement, TreeElement treeElement2) {
		val category = treeElement.category
		val category2 = treeElement2.category
		if (category != category2) {
			category - category2
		} else {
			val text = treeElement.stringPresentation
			val text2 = treeElement2.stringPresentation
			text.compareTo(text2)
		}
	}

	def getCategory(TreeElement element) {
		0
	}

}