/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.idea.common.types.StubJvmTypeProvider;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.resource.IndexingAwareGlobalSearchScope;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.intellij.openapi.module.Module;

/*
 * This class is abstract to filter it from the JUnit test suite.
 */
abstract class StubJvmTypeProviderTestDelegate extends AbstractTypeProviderTest {

	@Inject
	protected IdeaResourceSetProvider resourceSetProvider;

	@Inject
	protected IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	protected IPsiModelAssociator psiModelAssociator;
	
	@Inject
	protected TypeResourceServices services;
	
	@Inject
	protected IndexingAwareGlobalSearchScope.Factory awareGlobalSearchScopeFactory;

	private IJvmTypeProvider typeProvider;

	public void setUp(Module module) throws Exception {
		super.setUp();
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
		ResourceSet resourceSet = resourceSetProvider.get(module);
		IndexingAwareGlobalSearchScope searchScope = awareGlobalSearchScopeFactory.createSearchScope((XtextResourceSet) resourceSet);
		typeProvider = new StubJvmTypeProvider(module, resourceSet, indexedJvmTypeAccess, services, psiModelAssociator, searchScope);
	}

	public void tearDown() {
		typeProvider = null;
	}

	@Override
	protected String getCollectionParamName() {
		return "collection";
	}

	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

}