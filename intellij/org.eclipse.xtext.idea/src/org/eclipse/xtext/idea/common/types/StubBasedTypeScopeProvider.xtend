/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider
import org.eclipse.xtext.idea.common.types.StubJvmTypeProvider
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription

class StubBasedTypeScopeProvider extends AbstractTypeScopeProvider {

	@Inject
	@Accessors
	StubTypeProviderFactory typeProviderFactory

	@Inject
	IQualifiedNameConverter qualifiedNameConverter

	override StubBasedConstructorScope createConstructorScope(IJvmTypeProvider typeProvider,
		Predicate<IEObjectDescription> filter) {
		new StubBasedConstructorScope(createTypeScope(typeProvider, filter))
	}

	override StubBasedTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		new StubBasedTypeScope(typeProvider as StubJvmTypeProvider, qualifiedNameConverter, filter)
	}

}

class StubBasedConstructorScope extends AbstractConstructorScope {

	protected new(StubBasedTypeScope typeScope) {
		super(typeScope)
	}

}

class StubBasedTypeScope extends AbstractTypeScope {

	protected new(StubJvmTypeProvider typeProvider, IQualifiedNameConverter qualifiedNameConverter,
		Predicate<IEObjectDescription> filter) {
		super(typeProvider, qualifiedNameConverter, filter)
	}
	
	override protected internalGetAllElements() {
		emptyList
//		val allScopedElements = Lists.<IEObjectDescription>newArrayListWithExpectedSize(25000)
//		val project = (typeProvider as StubJvmTypeProvider).project
//		val scope = GlobalSearchScope.allScope(project)
//		val index = JavaShortClassNameIndex.getInstance() 
//		for (fullClassName : index.getAllKeys(project)) {
//			for (psiClass : index.get(fullClassName, project, scope)) {
//				val proxy = psiClass.qualifiedName.createProxy
//				val qualifiedName = getQualifiedNameConverter().toQualifiedName(psiClass.qualifiedName)
//				allScopedElements += EObjectDescription.create(qualifiedName, proxy)
//			}	
//		}
//		allScopedElements
	}

	protected def createProxy(String fullClassName) {
		val uri = (typeProvider as StubJvmTypeProvider).uriHelper.getFullURI(fullClassName);
		val proxy = TypesFactory.eINSTANCE.createJvmVoid as InternalEObject
		proxy.eSetProxyURI(uri)
		proxy
	}

}
