/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.projectview

import com.intellij.ide.projectView.PsiClassChildrenSource
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.ClassTreeNode
import com.intellij.ide.projectView.impl.nodes.PsiFieldNode
import com.intellij.ide.projectView.impl.nodes.PsiMethodNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiClassTreeNode extends ClassTreeNode {

	new(Project project, PsiClass value, ViewSettings viewSettings) {
		super(project, value, viewSettings)
	}

	override getChildrenImpl() {
		if (!settings.showMembers) {
			return emptyList
		}
		var parent = value
		val treeNodes = <AbstractTreeNode>newArrayList
		val result = newArrayList
		PsiClassChildrenSource.DEFAULT_CHILDREN.addChildren(parent, result)
		for (element : result) {
			switch element {
				PsiClass:
					treeNodes += new JvmPsiClassTreeNode(project, element, settings)
				PsiMethod:
					treeNodes += new PsiMethodNode(project, element, settings)
				PsiField:
					treeNodes += new PsiFieldNode(project, element, settings)
			}
		}
		treeNodes
	}

}