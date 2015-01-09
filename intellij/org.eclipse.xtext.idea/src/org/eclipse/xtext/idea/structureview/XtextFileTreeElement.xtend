/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextFileTreeElement extends PsiTreeElementBase<BaseXtextFile> implements ModifiableStructureViewTreeElement {

	List<StructureViewTreeElement> children

	@Accessors
	IStructureViewTreeElementProvider structureViewTreeElementProvider

	new(BaseXtextFile psiElement) {
		super(psiElement)
	}

	override getChildrenBase() {
		children = null
		structureViewTreeElementProvider.buildChildren(this)
		if (children == null) {
			return emptyList
		}
		children
	}

	override getPresentableText() {
		element.name
	}

	override addChild(StructureViewTreeElement child) {
		if (child != null) {
			if (children == null) {
				children = newArrayList
			}
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
			this.children += notNullChildren
		} else {
			false
		}
	}

}