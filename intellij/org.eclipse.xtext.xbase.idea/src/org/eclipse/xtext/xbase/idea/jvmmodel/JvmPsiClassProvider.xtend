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
import com.intellij.psi.PsiMethod
import java.util.Iterator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
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
import org.eclipse.xtext.resource.ISynchronizable
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.idea.jvm.JvmLanguage
import org.eclipse.xtext.xbase.idea.jvm.PsiJvmFileImpl
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
			stub = createStub
			psiClassProvider = [createPsiClass]
		]
	}

	protected def createPsiClass() {
		createPsiClass [ fileSystemAccess |
			generatePsiClass(fileSystemAccess)
		]
	}

	protected def void generatePsiClass(IFileSystemAccess fileSystemAccess) {
		switch synchronizable : jvmDeclaredType.eResource {
			ISynchronizable<Resource>:
				synchronizable.execute [
					doGeneratePsiClass(fileSystemAccess)
					null
				]
			default:
				doGeneratePsiClass(fileSystemAccess)
		}
	}

	protected def void doGeneratePsiClass(IFileSystemAccess fileSystemAccess) {
		elementIssueProviderFactory.attachData(jvmDeclaredType.eResource)
		try {
			jvmModelGenerator.internalDoGenerate(jvmDeclaredType, fileSystemAccess)
		} finally {
			elementIssueProviderFactory.detachData(jvmDeclaredType.eResource)
		}
	}

	protected def createStub() {
		createPsiClass	[ fileSystemAccess |
			jvmDeclaredType.generateStub(fileSystemAccess)
		]
	}

	protected def createPsiClass((IFileSystemAccess)=>void generator) {
		val result = <Pair<String, CharSequence>>newArrayList
		generator.apply(result.fileSystemAccess)
		val fileName = result.head.key
		val contents = result.head.value
		createPsiClass(fileName, contents)
	}

	protected def getFileSystemAccess(List<Pair<String, CharSequence>> result) {
		new IFileSystemAccess() {

			override deleteFile(String fileName) {}

			override generateFile(String fileName, CharSequence contents) {
				result += fileName -> contents
			}

			override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {}

		}
	}

	protected def createPsiClass(String fileName, CharSequence contents) {
		val psiElement = sourceElement.psiElement
		val psiFileFactory = psiElement.project.psiFileFactory
		val psiFile = psiFileFactory.createFileFromText(
			fileName,
			JvmLanguage.INSTANCE,
			contents,
			false,
			true,
			true,
			psiElement.containingFile.virtualFile
		)
		if (psiFile instanceof PsiJvmFileImpl) {
			val psiClass = psiFile.classes.head
			if (psiClass != null) {
				psiClass.bindTo(jvmDeclaredType)
				psiClass
			}
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
