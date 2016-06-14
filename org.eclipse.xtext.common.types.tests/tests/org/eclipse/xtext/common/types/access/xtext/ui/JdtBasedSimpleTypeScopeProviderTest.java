/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScope;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScope;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScopeProviderTest extends Assert {

	private MockJavaProjectProvider projectProvider;
	private JdtTypeProviderFactory factory;
	private JdtBasedSimpleTypeScopeProvider scopeProvider;
	private ResourceSet resourceSet;
	private ResourceImpl resource;
	private JvmField field;
	private ResourceImpl emptyResource;
	
	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}

	@Before
	public void setUp() throws Exception {
		projectProvider = new MockJavaProjectProvider();
		factory = new JdtTypeProviderFactory(projectProvider);
		IQualifiedNameConverter qualifiedNameConverter = new IQualifiedNameConverter.DefaultImpl();
		scopeProvider = new JdtBasedSimpleTypeScopeProvider(factory, qualifiedNameConverter);
		resourceSet = new ResourceSetImpl();
		resource = new ResourceImpl();
		resource.setURI(URI.createURI("http://does/not/exist.file"));
		emptyResource = new ResourceImpl();
		emptyResource.setURI(URI.createURI("http://does/not/exist.file2"));
		resourceSet.getResources().add(emptyResource);
		resourceSet.getResources().add(resource);
		field = TypesFactory.eINSTANCE.createJvmField();
		resource.getContents().add(field);
	}
	
	@Test public void testGetScope_01() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		assertNotNull(scope);
		assertSame(factory.findTypeProvider(resourceSet), scope.getTypeProvider());
	}

	@Test public void testGetScope_02() {
		resourceSet.getResources().clear();
		try {
			scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	@Test public void testGetScope_03() {
		resource.getContents().clear();
		try {
			scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	@Test public void testGetScope_04() {
		resourceSet.getResources().clear();
		try {
			scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	@Test public void testGetScope_05() {
		resource.getContents().clear();
		try {
			scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	@Test public void testGetScope_06() {
		IScope scope = scopeProvider.getScope(field.eResource(), TypesPackage.Literals.JVM_CONSTRAINT_OWNER__CONSTRAINTS);
		assertSame(IScope.NULLSCOPE, scope);
	}
	
}
