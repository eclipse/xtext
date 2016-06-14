/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.projectview

import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.openapi.project.Project
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFileTreeNode extends PsiFileNode {

	new(Project project, XtendFileImpl value, ViewSettings viewSettings) {
		super(project, value, viewSettings)
		XtendLanguage.INSTANCE.injectMembers(this)
	}

	def getXtendFile() {
		value as XtendFileImpl
	}

	override getChildrenImpl() {
		#[]
	}

}