/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.projectview

import com.google.inject.Inject
import com.intellij.ide.projectView.SelectableTreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import java.util.Collection
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl
import org.eclipse.xtext.idea.types.psi.JvmPsiClasses

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendSelectableTreeStructureProvider implements SelectableTreeStructureProvider {

	val Project project

	@Inject
	extension JvmPsiClasses

	new(Project project) {
		this.project = project
		XtendLanguage.INSTANCE.injectMembers(this)
	}

	override getTopLevelElement(PsiElement element) {
		null
	}

	override getData(Collection<AbstractTreeNode> selected, String dataName) {
		null
	}

	override modify(AbstractTreeNode parent, Collection<AbstractTreeNode> children, ViewSettings settings) {
		if (parent instanceof PsiFileNode) {
			val value = parent.value
			if (value instanceof XtendFileImpl) {
				return value.jvmPsiClasses.map [ psiClass |
					new JvmPsiClassTreeNode(project, psiClass, parent.settings)
				].filter(AbstractTreeNode).toList
			}
		}
		children
	}

}