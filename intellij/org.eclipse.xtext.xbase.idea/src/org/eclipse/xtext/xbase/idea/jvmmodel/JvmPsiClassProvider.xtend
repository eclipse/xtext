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
import com.intellij.psi.PsiAnonymousClass
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiMirrorElement
import com.intellij.psi.impl.source.tree.JavaElementType
import com.intellij.psi.impl.source.tree.RecursiveTreeElementWalkingVisitor
import com.intellij.psi.impl.source.tree.TreeElement
import java.util.Iterator
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFeature
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
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnonymousClass
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
		jvmPsiClassProvider.get => [ jvmPsiClass |
			jvmPsiClass.stub = createStub
			jvmPsiClass.type = jvmDeclaredType
			jvmPsiClass.psiClassProvider = [createPsiClass]
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
			false,
			true,
			psiElement.containingFile.virtualFile
		)
		if (psiFile instanceof PsiJvmFileImpl) {
			val psiClass = psiFile.classes.head
			if (psiClass != null) {
				val mapping = newHashMap
				psiClass.bindTo(jvmDeclaredType, mapping)
				psiFile.mapping = mapping
				psiClass
			}
		}
	}

	protected def dispatch void bindTo(PsiElement psiElement, Void void, Map<EObject, PsiElement> mapping) {
	}

	protected def dispatch void bindTo(PsiElement psiElement, EObject object, Map<EObject, PsiElement> mapping) {
		psiElement.doBindTo(object, mapping)
	}

	protected def dispatch void bindTo(
		PsiMethod psiMethod,
		JvmExecutable jvmExecutable,
		Map<EObject, PsiElement> mapping
	) {
		psiMethod._bindTo(jvmExecutable as JvmFeature, mapping)

		val i = jvmExecutable.parameters.iterator
		for (parameter : psiMethod.parameterList.parameters) {
			parameter.bindTo(i.nextEObject(JvmFormalParameter), mapping)
			if (!i.hasNext) {
				return
			}
		}
	}

	protected def dispatch void bindTo(PsiElement psiElement, JvmFeature jvmFeature, Map<EObject, PsiElement> mapping) {
		psiElement.doBindTo(jvmFeature, mapping)

		val localClassesIterator = jvmFeature.localClasses.iterator
		if (localClassesIterator.hasNext) {
			val node = psiElement.node
			if (node instanceof TreeElement) {
				node.acceptTree(new RecursiveTreeElementWalkingVisitor() {

					// FIXME: it should distinguish between local classes for anonymous classes and closures
					override protected visitNode(TreeElement element) {
						if (element.elementType == JavaElementType.ANONYMOUS_CLASS) {
							element.psi.bindTo(localClassesIterator.next, mapping)
							if (!localClassesIterator.hasNext) {
								super.stopWalking
							}
						} else {
							super.visitNode(element)
						}
					}

				})
			}
		}
	}

	protected def dispatch void bindTo(
		PsiClass psiClass,
		JvmDeclaredType jvmDeclaredType,
		Map<EObject, PsiElement> mapping
	) {
		val mirror = psiClass.doBindTo(jvmDeclaredType, mapping)
		
		if (psiClass.constructors.empty) {
			for (declaredConstructor : jvmDeclaredType.declaredConstructors) {
				mapping.put(declaredConstructor, mirror)
			}
		}

		val i = jvmDeclaredType.eContents.iterator
		for (psiElement : psiClass.children) {
			switch psiElement {
				PsiField:
					psiElement.bindTo(i.nextEObject(JvmField), mapping)
				PsiMethod case psiElement.constructor:
					psiElement.bindTo(i.nextEObject(JvmConstructor), mapping)
				PsiMethod:
					psiElement.bindTo(i.nextEObject(JvmOperation), mapping)
				PsiClass:
					psiElement.bindTo(i.nextEObject(JvmDeclaredType), mapping)
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

	protected def doBindTo(PsiElement element, EObject object, Map<EObject, PsiElement> mapping) {
		val mirror = element.mirror
		mapping.put(object, mirror)
		mirror.jvmElement = object
		mirror.navigationElementProvider = [|
			object.primarySourceElement
		]
		mirror
	}

	protected def mirror(PsiElement element) {
		switch element {
			PsiMirrorElement: element
			PsiAnonymousClass: new JvmPsiAnonymousClass(element)
			default: element
		}
	}

}
