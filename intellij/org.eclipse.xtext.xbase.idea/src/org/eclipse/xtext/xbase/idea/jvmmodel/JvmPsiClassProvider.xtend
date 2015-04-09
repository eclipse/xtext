/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiMethod
import java.util.Iterator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.PsiElementProvider
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.idea.jvm.JvmFileType
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass

import static extension org.eclipse.xtext.idea.extensions.IdeaProjectExtensions.*
import static extension org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions.*

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiClassProvider implements PsiElementProvider {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IPsiJvmModelAssociations

	@Inject
	JvmModelGenerator jvmModelGenerator

	@Inject
	extension JvmPsiClassStubGenerator

	@Accessors
	EObject sourceElement

	@Accessors
	JvmDeclaredType jvmDeclaredType

	@Inject
	Provider<JvmPsiClass> jvmPsiClassProvider

	@Inject
	ElementIssueProvider.Factory elementIssueProviderFactory

	override get() {
		jvmPsiClassProvider.get => [
			stub = generateStub
			psiClassProvider = [generatePsiClass]
		]
	}

	protected def generatePsiClass() {
		val classResult = <PsiClass>newArrayList
		elementIssueProviderFactory.attachData(jvmDeclaredType.eResource)
		try {
			jvmModelGenerator.internalDoGenerate(jvmDeclaredType, classResult.fileSystemAccess)
		} finally {
			elementIssueProviderFactory.detachData(jvmDeclaredType.eResource)
		}
		classResult.head
	}

	protected def generateStub() {
		val classStubResult = <PsiClass>newArrayList
		jvmDeclaredType.generateStub(classStubResult.fileSystemAccess)
		classStubResult.head
	}

	protected def getFileSystemAccess(List<PsiClass> result) {
		new IFileSystemAccess() {

			override deleteFile(String fileName) {}

			override generateFile(String fileName, CharSequence contents) {
				val psiFileFactory = sourceElement.psiElement.project.psiFileFactory
				val psiFile = psiFileFactory.createFileFromText(
					fileName,
					JvmFileType.INSTANCE,
					contents
				) as PsiJavaFile
				val psiClass = psiFile.classes.head
				if (psiClass != null) {
					psiClass.bindTo(jvmDeclaredType)
					result += psiClass
				}
			}

			override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {}

		}
	}

	protected def dispatch void bindTo(PsiElement psiElement, Void void) {
	}

	protected def dispatch void bindTo(PsiElement psiElement, EObject object) {
		psiElement.doBindTo(object)
	}

	protected def dispatch void bindTo(PsiMethod psiMethod, JvmExecutable jvmExecutable) {
		psiMethod.doBindTo(jvmExecutable)

		val i = jvmExecutable.parameters.iterator
		for (parameter : psiMethod.parameterList.parameters) {
			parameter.bindTo(i.nextEObject(JvmFormalParameter))
			if (!i.hasNext) {
				return
			}
		}
	}

	protected def dispatch void bindTo(PsiClass psiClass, JvmDeclaredType jvmDeclaredType) {
		psiClass.doBindTo(jvmDeclaredType)

		val i = jvmDeclaredType.eContents.iterator
		for (psiElement : psiClass.children) {
			switch psiElement {
				PsiField:
					psiElement.bindTo(i.nextEObject(JvmField))
				PsiMethod case psiElement.constructor:
					psiElement.bindTo(i.nextEObject(JvmConstructor))
				PsiMethod:
					psiElement.bindTo(i.nextEObject(JvmOperation))
				PsiClass:
					psiElement.bindTo(i.nextEObject(JvmDeclaredType))
			}
			if (!i.hasNext) {
				return
			}
		}
	}

	protected def <T extends EObject> T nextEObject(Iterator<? extends EObject> i, Class<T> clazz) {
		while (i.hasNext) {
			val object = i.next
			if (clazz.isInstance(object)) {
				return object as T
			}
		}
		return null
	}

	protected def void doBindTo(PsiElement element, EObject object) {
		element.jvmElement = object
		element.navigationElementProvider = [|
			object.primarySourceElement
		]
	}

}
