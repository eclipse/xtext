/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractStructureViewTreeElement implements ModifiableStructureViewTreeElement {
	
	@Accessors
	IStructureViewTreeElementProvider structureViewTreeElementProvider

	@Accessors
	boolean leaf
	
	List<StructureViewTreeElement> children

	@Accessors
	ItemPresentation itemPresentation

	@Accessors
	protected extension BaseXtextFile xtextFile

	override getChildren() {
		if (leaf) {
			return emptyList
		}
		if (children == null) {
			children = newArrayList
			structureViewTreeElementProvider.buildChildren(this)
		}
		if (children == null) {
			return emptyList
		} 
		children
	}
	
	override addChild(StructureViewTreeElement child) {
		if (child != null) {
			if (children == null) {
				children = newArrayList
			}
			leaf = false
			children += child
		} else {
			false
		}
	}
	
	override addChildren(Iterable<StructureViewTreeElement> children) {
		val notNullChildren = children.filterNull
		if (!notNullChildren.empty) {
			if (this.children == null) {
				this.children = newArrayList
			}
			leaf = false
			this.children += notNullChildren
		} else {
			false
		}
	}

	override getPresentation() {
		itemPresentation
	}

	protected abstract def Object getObjectToPresent()

	override canNavigate() {
		val element = navigationElement
		if (element instanceof Navigatable) {
			element.canNavigate
		} else {
			false
		}
	}

	override canNavigateToSource() {
		canNavigate
	}

	override navigate(boolean requestFocus) {
		val element = navigationElement
		if (element instanceof Navigatable) {
			element.navigate(requestFocus)
		}
	}

	protected def getNavigationElement() {
		try {
			val element = internalNavigationElement
			if (element != null && element.valid) {
				element
			}
		} catch (Exception e) {
	      	// FIXME: illegal psi element access
	      	return null
		}
	}

	protected abstract def PsiElement getInternalNavigationElement()

}