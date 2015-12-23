/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.actions

import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileSystemItem
import com.intellij.psi.PsiJavaFile
import com.intellij.refactoring.actions.BaseRefactoringAction
import org.eclipse.xtend.core.idea.javaconverter.ConvertJavaCodeHandler

/**
 * @author dhuebner - Initial contribution and API
 */
class ConvertJavaCodeAction extends BaseRefactoringAction {

	override protected getHandler(DataContext dataContext) {
		new ConvertJavaCodeHandler()
	}

	override protected isAvailableInEditorOnly() {
		false
	}

	override protected isEnabledOnElements(PsiElement[] elements) {
		elements.map [
			if(it instanceof PsiFileSystemItem) it else it.containingFile
		].filter [
			it instanceof PsiJavaFile || !it.processChildren[!(it instanceof PsiJavaFile)]
		].exists [
			val module = ModuleUtil.findModuleForPsiElement(it)
			return  (module !== null && ModuleRootManager.getInstance(module).sdk !== null)
		]
	}

}
