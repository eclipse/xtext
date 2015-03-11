/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.ide.hierarchy

import com.google.inject.Inject
import com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

import static com.intellij.openapi.actionSystem.CommonDataKeys.*

import static extension org.eclipse.xtext.idea.actionSystem.DataContextExtensions.*

class JvmExecutableCallHierarchyProvider extends JavaCallHierarchyProvider {

	@Inject
	extension IPsiJvmModelAssociations

	override getTarget(DataContext dataContext) {
		super.getTarget [ String dataId |
			if (dataId == PSI_ELEMENT.name) {
				dataContext.psiElement.getPrimaryJvmElement
			} else {
				dataContext.getData(dataId)
			}
		]
	}
	
	override createHierarchyBrowser(PsiElement target) {
		new JvmExecutableCallHierarchyBrowser(target.project, target as PsiMethod)
	}

}