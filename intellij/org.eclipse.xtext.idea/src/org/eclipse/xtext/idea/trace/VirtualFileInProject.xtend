/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.psi.XtextPsiUtils

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class VirtualFileInProject {
	
	def static VirtualFileInProject forPsiElement(PsiElement element) {
		val virtualFile = XtextPsiUtils.findVirtualFile(element)
		if (virtualFile == null)
			return null

		return new VirtualFileInProject(virtualFile, element.project)
	}
	
	VirtualFile file
	Project project
}