/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.intellij.psi.impl.smartPointers

import com.intellij.lang.LanguageUtil
import com.intellij.openapi.util.ProperTextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import org.eclipse.xtext.psi.impl.PsiEObjectImpl

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextSmartPointerElementInfoFactory extends SmartPointerElementInfoFactory {

	override createElementInfo(PsiElement element, PsiFile containingFile) {
		if (element instanceof PsiEObjectImpl)
			return new XtextSelfElementInfo(
				containingFile.project,
				ProperTextRange.create(element.textRange),
				element.elementType,
				containingFile,
				LanguageUtil.getRootLanguage(element),
				false
			)
	}

}