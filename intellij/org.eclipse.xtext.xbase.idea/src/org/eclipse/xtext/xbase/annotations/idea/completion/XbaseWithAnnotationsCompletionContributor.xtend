/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.idea.completion

import com.google.inject.Inject
import com.intellij.codeInsight.completion.CompletionType
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage

import static com.intellij.patterns.PlatformPatterns.*

import static extension com.intellij.psi.util.PsiTreeUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

class XbaseWithAnnotationsCompletionContributor extends AbstractXbaseWithAnnotationsCompletionContributor {

	@Inject
	extension IPsiModelAssociations

	new() {
		this(XbaseWithAnnotationsLanguage.INSTANCE)
	}

	new(AbstractXtextLanguage lang) {
		super(lang)
		completeXAnnotation_AnnotationType
		completeXAnnotation_Value
	}

	protected def completeXAnnotation_AnnotationType() {
		completeJavaTypes(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE) [
			object.annotationType
		]
	}

	protected def completeXAnnotation_Value() {
		extend(
			CompletionType.BASIC,
			psiElement.withEReference(XAnnotationsPackage.Literals.XANNOTATION__VALUE)
		) [
			val psiElement = $0.position.findFirstParent(false)[EObject != null]
			val annotation = psiElement.EObject.getContainerOfType(XAnnotation)
			switch annotationType : annotation?.annotationType {
				JvmAnnotationType case !annotationType.eIsProxy: {
					val operations = annotationType.declaredOperations.toList
					if (operations.tail.empty) {
						val singleOperation = operations.head
						if ('value' == singleOperation.simpleName) {
							if (Class.name == singleOperation.returnType?.type?.qualifiedName) {
								completeJavaTypes($0, $2)[true]
							}
						}
					}
				}
			}
		]
	}
}