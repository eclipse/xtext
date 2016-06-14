/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderPerformanceTest;
import org.eclipse.xtext.common.types.util.jdt.JavaElementFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtTypeProviderPerformanceTest extends AbstractTypeProviderPerformanceTest {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private JavaElementFinder elementFinder;
	
	@BeforeClass public static void createMockJavaProject() throws Exception {
		TypesPackage.eINSTANCE.eAllContents();
		MockJavaProjectProvider.setUp();
	}
	
	@Before
	public void setUp() throws Exception {
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		projectProvider.setUseSource(useSources());
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		elementFinder = new JavaElementFinder();
		elementFinder.setProjectProvider(projectProvider);
	}
	
	protected boolean useSources() {
		return false;
	}
	
	@Override
	protected JvmDeclaredType loadAndResolve(String name, boolean accessMembers, boolean accessAnnotations,
			boolean accessTypeParams, boolean accessParameter, boolean accessParameterNames) {
		if (!accessParameterNames)
			resourceSet.getResources().clear();
		return super.loadAndResolve(name, accessMembers, accessAnnotations, accessTypeParams, accessParameter,
				accessParameterNames);
	}

	@After
	public void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
	}

	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

}
