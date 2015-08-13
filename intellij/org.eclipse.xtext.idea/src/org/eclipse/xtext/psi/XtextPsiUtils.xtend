/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.util.indexing.IndexingDataKeys

/**
 * @author efftinge - Initial contribution and API
 */
class XtextPsiUtils {
	
	def static VirtualFile findVirtualFile(PsiElement element) {
		if (element instanceof PsiFile) {
			var PsiFile originalFile=element.getOriginalFile() 
			if (originalFile !== element && originalFile !== null) {
				return findVirtualFile(originalFile) 
			}
			var VirtualFile virtualFile=element.getUserData(IndexingDataKeys.VIRTUAL_FILE) 
			if (virtualFile !== null) {
				return virtualFile 
			}
			return element.getViewProvider().getVirtualFile() 
		} else if (element == null) {
			return null
		} else {
			findVirtualFile(element.containingFile)
		}
	} 
}