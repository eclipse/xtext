/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.projectview

import com.google.inject.Inject
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.ClassTreeNode
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFileTreeNode extends PsiFileNode {

	@Inject
	extension JvmPsiClasses

	new(Project project, XtendFileImpl value, ViewSettings viewSettings) {
		super(project, value, viewSettings)
		XtendLanguage.INSTANCE.injectMembers(this)
	}

	def getXtendFile() {
		value as XtendFileImpl
	}

	override getChildrenImpl() {
		val viewSettings = settings
		xtendFile.psiClasses.map [ psiClass |
			new ClassTreeNode(project, psiClass, viewSettings)
		].filter(AbstractTreeNode).toList
	}

}