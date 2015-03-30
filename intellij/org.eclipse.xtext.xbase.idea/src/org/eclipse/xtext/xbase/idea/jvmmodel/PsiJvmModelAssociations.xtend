/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static extension org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class PsiJvmModelAssociations implements IPsiJvmModelAssociations {

	@Inject
	extension IPsiModelAssociations

	@Inject
	IJvmModelAssociations jvmModelAssociations

	override getSourceElements(PsiElement jvmElement) {
		jvmElement.jvmElement.sourceElements
	}

	override getSourceElements(EObject jvmElement) {
		jvmModelAssociations.getSourceElements(jvmElement).map [
			psiElement
		].toSet
	}

	override getJvmElements(PsiElement sourceElement) {
		sourceElement.EObject.jvmElements
	}

	override getJvmElements(EObject sourceElement) {
		jvmModelAssociations.getJvmElements(sourceElement).map [
			psiElement
		].toSet
	}

	override getPrimarySourceElement(PsiElement jvmElement) {
		jvmElement.jvmElement.primarySourceElement
	}

	override getPrimarySourceElement(EObject jvmElement) {
		jvmModelAssociations.getPrimarySourceElement(jvmElement).psiElement
	}

	override getPrimaryJvmElement(PsiElement sourceElement) {
		sourceElement.EObject.getPrimaryJvmElement
	}

	override getPrimaryJvmElement(EObject sourceElement) {
		jvmModelAssociations.getPrimaryJvmElement(sourceElement).psiElement
	}

	override isPrimaryJvmElement(PsiElement jvmElement) {
		jvmElement.jvmElement.isPrimaryJvmElement
	}

	override isPrimaryJvmElement(EObject jvmElement) {
		jvmModelAssociations.isPrimaryJvmElement(jvmElement)
	}

}