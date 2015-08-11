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
import org.eclipse.xtend.lib.annotations.Data
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiUtil

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class VirtualFileInProject {
	
	def static VirtualFileInProject forPsiElement(PsiElement element) {
		return new VirtualFileInProject(PsiUtil.getVirtualFile(element), element.project)
	}
	
	VirtualFile file
	Project project
}