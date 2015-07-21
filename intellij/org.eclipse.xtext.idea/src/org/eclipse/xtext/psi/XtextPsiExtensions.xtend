/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi

import com.google.inject.Inject
import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.EObject

import static extension com.intellij.psi.util.PsiTreeUtil.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtextPsiExtensions {
	
	@Inject IPsiModelAssociations associations 
	
	def PsiElement findEObjectAssociatedPsiElement(PsiElement ctx, int offset) {
		val element = ctx.containingFile.findElementAt(offset)
		return element.findEObjectAssociatedPsiElement
	}
	
	def EObject findEObject(PsiElement ctx, int offset) {
		return associations.getEObject(ctx.findEObjectAssociatedPsiElement(offset))
	}
	
	def PsiElement findEObjectAssociatedPsiElement(PsiElement element) {
		return element.findFirstParent(false)[associations.getEObject(it) != null]
	}
	
	def EObject findEObject(PsiElement ctx) {
		return associations.getEObject(ctx.findEObjectAssociatedPsiElement)
	}
}