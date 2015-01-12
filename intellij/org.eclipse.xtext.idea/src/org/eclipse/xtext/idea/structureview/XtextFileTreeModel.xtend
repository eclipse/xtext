/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.NodeProvider
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.openapi.editor.Editor
import java.util.Comparator
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.impl.BaseXtextFile

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextFileTreeModel extends TextEditorBasedStructureViewModel implements StructureViewModel.ElementInfoProvider {

	@Accessors
	IStructureViewTreeElementProvider structureViewTreeElementProvider

	protected val List<Sorter> sorters

	protected val List<Filter> filters

	protected val List<Grouper> groupers
	
	protected val List<Class<?>> suitableClasses

	protected val List<NodeProvider> nodeProviders

	new(BaseXtextFile xtextFile, Editor editor) {
		super(editor, xtextFile)
		xtextFile.xtextLanguage.injectMembers(this)
		sorters = newArrayList
		val comparator = comparator
		if (comparator != null) {
			sorters += new AlphaSorter => [
				it.comparator = comparator
			]
		}
		filters = newArrayList
		groupers = newArrayList
		nodeProviders = newArrayList
		suitableClasses = newArrayList(PsiEObject)
	}

	override protected BaseXtextFile getPsiFile() {
		super.getPsiFile() as BaseXtextFile
	}

	override getRoot() {
		val rootTreeElement = new XtextFileTreeElement(psiFile)
		rootTreeElement.structureViewTreeElementProvider = structureViewTreeElementProvider
		rootTreeElement
	}

	override isAlwaysLeaf(StructureViewTreeElement element) {
		if (element instanceof AbstractStructureViewTreeElement) {
			element.leaf
		} else {
			false
		}
	}

	override isAlwaysShowsPlus(StructureViewTreeElement element) {
		false
	}

	override getFilters() {
		filters
	}

	override getSorters() {
		sorters
	}

	override getGroupers() {
		groupers
	}

	override getNodeProviders() {
		nodeProviders
	}

	def Comparator<TreeElement> getComparator() {
		new DefaultComparator
	}
	
	override getCurrentEditorElement() {
		val element = super.currentEditorElement
		if (element instanceof PsiEObject) {
			element.EObject?.URI
		} else {
			element
		}
	}
	
	protected def getSuperCurrentEditorElement() {
		super.currentEditorElement
	}
	
	override protected getSuitableClasses() {
		suitableClasses
	}

}