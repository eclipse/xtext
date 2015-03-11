/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.intellij.lang.Language
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.impl.light.LightElement
import org.eclipse.xtext.psi.PsiEObjectIdentifier

class PsiEObjectIdentifierImpl extends LightElement implements PsiEObjectIdentifier {
	
	val PsiElement psiElement
	
	new(PsiElement psiElement) {
		this(psiElement.manager, psiElement.language, psiElement)
	}
	
	new(PsiManager manager, Language language, PsiElement psiElement) {
		super(manager, language)
		this.psiElement = psiElement
	}
	
	override isValid() {
		psiElement.valid
	}
	
	override getContainingFile() {
		psiElement.containingFile
	}
	
	override getNavigationElement() {
		parent
	}
	
	override getParent() {
		psiElement.parent
	}
	
	override getPrevSibling() {
		psiElement.prevSibling
	}
	
	override getNextSibling() {
		psiElement.nextSibling
	}
	
	override getStartOffsetInParent() {
		textRange.startOffset - parent.textRange.startOffset 
	}
	
	override getTextRange() {
		new TextRange(parent.textOffset, node.textRange.endOffset)
	}
	
	override copy() {
		new PsiEObjectIdentifierImpl(psiElement)
	}
	
	override getText() {
		val textRange = textRange
		containingFile.text.substring(textRange.startOffset, textRange.endOffset)
	}
	
	override getNode() {
		psiElement.node
	}
	
	override toString() {
		'''«class.simpleName»: «text»'''
	}
	
}