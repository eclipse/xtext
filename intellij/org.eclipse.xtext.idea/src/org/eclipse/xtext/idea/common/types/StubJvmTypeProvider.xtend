/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.intellij.openapi.module.Module
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.PsiClass
import com.intellij.psi.impl.compiled.SignatureParsing
import com.intellij.psi.search.GlobalSearchScope
import java.text.StringCharacterIterator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider
import org.eclipse.xtext.common.types.access.impl.ITypeFactory
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.resource.ISynchronizable
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.util.Strings
import com.intellij.openapi.application.ApplicationManager
import org.eclipse.xtext.common.types.access.impl.IClassMirror
import com.intellij.psi.JavaPsiFacade
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.openapi.progress.ProcessCanceledException

class StubJvmTypeProvider extends AbstractRuntimeJvmTypeProvider {

	val ITypeFactory<PsiClass, JvmDeclaredType> psiClassFactory
	@Accessors val Module module
	@Accessors val extension StubURIHelper uriHelper
	@Accessors val GlobalSearchScope searchScope

	new(Module module, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess,
		TypeResourceServices services, IPsiModelAssociator psiModelAssociator, GlobalSearchScope searchScope) {
		super(resourceSet, indexedJvmTypeAccess, services)
		this.module = module
		this.searchScope = searchScope
		this.uriHelper = createStubURIHelper
		this.psiClassFactory = createPsiClassFactory(psiModelAssociator)
	}

	def createPsiClassFactory(IPsiModelAssociator psiModelAssociator) {
		new PsiBasedTypeFactory(uriHelper, psiModelAssociator)
	}

	protected def createStubURIHelper() {
		new StubURIHelper
	}

	override findTypeByName(String name) {
		doFindTypeByName(name, false)
	}

	override findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		var result = doFindTypeByName(name, false)
		if (result != null || isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return result
		}
		val nameVariants = new ClassNameVariants(name)
		while (result == null && nameVariants.hasNext) {
			val nextVariant = nameVariants.next
			result = doFindTypeByName(nextVariant, true)
		}
		result
	}

	def doFindTypeByName(String name, boolean traverseNestedTypes) {
		ProgressIndicatorProvider.checkCanceled
		val normalizedName = name.normalize
		val resourceURI = createResourceURI(normalizedName)
		val fragment = getFragment(normalizedName)
		switch resourceSet : resourceSet {
			ISynchronizable<ResourceSet>:
				resourceSet.execute [
					findType(resourceURI, fragment, traverseNestedTypes)
				]
			default:
				findType(resourceURI, fragment, traverseNestedTypes)
		}
	}

	protected def normalize(String name) {
		if (name.startsWith('[')) {
			SignatureParsing.parseTypeString(new StringCharacterIterator(name))
		} else {
			name
		}
	}

	def findType(URI resourceURI, String fragment, boolean traverseNestedTypes) {
		val indexedJvmTypeAccess = getIndexedJvmTypeAccess
		if (indexedJvmTypeAccess !== null) {
			val proxyURI = resourceURI.appendFragment(fragment)
			val candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, resourceSet)
			if (candidate instanceof JvmType) {
				return candidate
			}
		}
		ProgressIndicatorProvider.checkCanceled
		try {
			val existing = resourceSet.getResource(resourceURI, false)
			if (existing != null) {
				return existing.findType(fragment, traverseNestedTypes)
			}
			val mirror = createMirror(resourceURI)
			if (mirror == null) {
				return null
			}
			val resource = doCreateResource(resourceURI)
			resource.mirror = mirror
			resourceSet.getResources().add(resource)
			resource.load(null)
			return resource.findType(fragment, traverseNestedTypes)
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

	protected def findType(Resource resource, String fragment, boolean traverseNestedTypes) {
		ApplicationManager.application.<JvmType>runReadAction[
			val result = resource.getEObject(fragment) as JvmType
			if (result != null || !traverseNestedTypes) {
				return result
			}
			val rootType = resource.contents.head
			if (rootType instanceof JvmDeclaredType) {
				val rootTypeName = resource.getURI.segment(1)
				val nestedTypeName = fragment.substring(rootTypeName.length + 1)
				val segments = Strings.split(nestedTypeName, '$')
				return findNestedType(rootType, segments, 0)
			}
			return null
		]
	}

	protected override createMirrorForFQN(String name) {
		ApplicationManager.application.<IClassMirror>runReadAction[
			try {
				val psiClass = JavaPsiFacade.getInstance(module.project).findClass(name, searchScope)
				if (psiClass == null || psiClass.containingClass != null) {
					return null
				}
				new PsiClassMirror(psiClass, psiClassFactory)
			} catch (IndexNotReadyException e) {
				throw new OperationCanceledError(new ProcessCanceledException)
			}
		]
	}

	protected def getSearchScope() {
		searchScope
	}

}
