/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RefactoringTestLanguageInjectorProvider.class)
public class ClasspathTypeProviderPerformanceTest extends AbstractTypeProviderPerformanceTest {

	@Inject
	private ResourceSet resourceSet;

	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	private ClasspathTypeProvider typeProvider;

	@Before
	public void setUp() throws Exception {
		typeProvider = new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet, indexedJvmTypeAccess, null);
	}
	
	@After
	public void tearDown() throws Exception {
		typeProvider = null;
	}
	
	@Override
	public ClasspathTypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	@Override
	protected JvmDeclaredType loadAndResolve(String name, boolean accessMembers, boolean accessAnnotations,
			boolean accessTypeParams, boolean accessParameter, boolean accessParameterNames) {
		resourceSet.getResources().clear();
		return super.loadAndResolve(name, accessMembers, accessAnnotations, accessTypeParams, accessParameter,
				accessParameterNames);
	}
	

}
