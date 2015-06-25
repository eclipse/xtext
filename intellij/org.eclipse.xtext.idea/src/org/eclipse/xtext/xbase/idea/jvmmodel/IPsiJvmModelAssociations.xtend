/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.ImplementedBy
import com.intellij.psi.PsiElement
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

/**
 * An equivalent of {@link IJvmModelAssociations IJvmModelAssociations} for PSI model.
 * 
 * @author kosyakov - Initial contribution and API
 * @see IJvmModelAssociations
 */
@ImplementedBy(PsiJvmModelAssociations)
interface IPsiJvmModelAssociations {

	def Set<PsiElement> getSourceElements(PsiElement jvmElement)

	def Set<PsiElement> getSourceElements(EObject jvmElement)

	def Set<PsiElement> getJvmElements(PsiElement sourceElement)

	def Set<PsiElement> getJvmElements(EObject sourceElement)

	def PsiElement getPrimarySourceElement(PsiElement jvmElement)

	def PsiElement getPrimarySourceElement(EObject jvmElement)

	def PsiElement getPrimaryJvmElement(PsiElement sourceElement)

	def PsiElement getPrimaryJvmElement(EObject sourceElement)

	def boolean isPrimaryJvmElement(PsiElement jvmElement)

	def boolean isPrimaryJvmElement(EObject jvmElement)

}