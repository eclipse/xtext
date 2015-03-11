/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.ide.hierarchy

import com.intellij.ide.hierarchy.call.CallHierarchyBrowser
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiElement

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmExecutableCallHierarchyBrowser extends CallHierarchyBrowser {
	
	new(Project project, PsiMethod method) {
		super(project, method)
	}
	
	override protected createHierarchyTreeStructure(String typeName, PsiElement psiElement) {
		if (CALLEE_TYPE.equals(typeName)) {
			new JvmExecutableCalleeMethodsTreeStructure(myProject, psiElement as PsiMethod, currentScopeType)
    	} else {
			super.createHierarchyTreeStructure(typeName, psiElement)
		}
	}
	
}