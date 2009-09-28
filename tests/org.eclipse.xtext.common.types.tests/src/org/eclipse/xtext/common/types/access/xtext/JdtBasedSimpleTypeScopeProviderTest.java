/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScopeProviderTest extends TestCase {

	private MockJavaProjectProvider projectProvider;
	private JdtTypeProviderFactory factory;
	private JdtBasedSimpleTypeScopeProvider scopeProvider;
	private ResourceSet resourceSet;
	private ResourceImpl resource;
	private Field field;
	private ResourceImpl emptyResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		projectProvider = new MockJavaProjectProvider();
		factory = new JdtTypeProviderFactory(projectProvider);
		scopeProvider = new JdtBasedSimpleTypeScopeProvider();
		scopeProvider.setTypeProviderFactory(factory);
		resourceSet = new ResourceSetImpl();
		resource = new ResourceImpl();
		resource.setURI(URI.createURI("http://does/not/exist.file"));
		emptyResource = new ResourceImpl();
		emptyResource.setURI(URI.createURI("http://does/not/exist.file2"));
		resourceSet.getResources().add(emptyResource);
		resourceSet.getResources().add(resource);
		field = TypesFactory.eINSTANCE.createField();
		resource.getContents().add(field);
	}
	
	public void testGetScope_01() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
		assertNotNull(scope);
		assertSame(factory.findTypeProvider(resourceSet), scope.getTypeProvider());
	}

	public void testGetScope_02() {
		resourceSet.getResources().clear();
		try {
			scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	public void testGetScope_03() {
		resource.getContents().clear();
		try {
			scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	public void testGetScope_04() {
		resourceSet.getResources().clear();
		try {
			scopeProvider.getScope(field, TypesPackage.Literals.CONSTRAINED_TYPE__CONSTRAINTS);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	public void testGetScope_05() {
		resource.getContents().clear();
		try {
			scopeProvider.getScope(field, TypesPackage.Literals.CONSTRAINED_TYPE__CONSTRAINTS);
			fail("Expected IllegalStateException");
		} catch( IllegalStateException ex) {
			// ok
		}
	}
	
	public void testGetScope_06() {
		IScope scope = scopeProvider.getScope(field, TypesPackage.Literals.CONSTRAINED_TYPE__CONSTRAINTS);
		assertSame(IScope.NULLSCOPE, scope);
	}
	
	public void testNotification_01() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
		assertTrue(resourceSet.eAdapters().isEmpty());
		IScopedElement objectElement = scope.getContentByName(Object.class.getName());
		assertNotNull(objectElement);
		assertEquals(1, resourceSet.eAdapters().size());
	}
	
	public void testNotification_02() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
		assertTrue(resourceSet.eAdapters().isEmpty());
		IScopedElement objectElement = scope.getContentByName(Object.class.getName());
		Resource objectResource = objectElement.element().eResource();
		assertTrue(objectResource.isLoaded());
		int size = resourceSet.getResources().size();
		int adaptersSize = resourceSet.eAdapters().size();
		resourceSet.getResources().remove(objectResource);
		assertEquals(size - 1, resourceSet.getResources().size());
		assertEquals(adaptersSize - 1, resourceSet.eAdapters().size());
		assertFalse(objectResource.isLoaded());
	}
	
	public void testNotification_03() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
		assertTrue(resourceSet.eAdapters().isEmpty());
		IScopedElement objectElement = scope.getContentByName(Object.class.getName());
		Resource objectResource = objectElement.element().eResource();
		assertTrue(objectResource.isLoaded());
		int adaptersSize = resourceSet.eAdapters().size();
		resourceSet.getResources().clear();
		assertTrue(resourceSet.getResources().isEmpty());
		assertEquals(adaptersSize - 1, resourceSet.eAdapters().size());
		assertFalse(objectResource.isLoaded());
	}
	
	public void testNotification_04() {
		JdtBasedSimpleTypeScope scope = (JdtBasedSimpleTypeScope) scopeProvider.getScope(field, TypesPackage.Literals.FIELD__TYPE);
		assertTrue(resourceSet.eAdapters().isEmpty());
		IScopedElement objectElement = scope.getContentByName(Object.class.getName());
		IScopedElement stringElement = scope.getContentByName(String.class.getName());
		Resource objectResource = objectElement.element().eResource();
		int size = resourceSet.getResources().size();
		int adaptersSize = resourceSet.eAdapters().size();
		resourceSet.getResources().remove(objectResource);
		assertEquals(size - 1, resourceSet.getResources().size());
		assertEquals(adaptersSize - 1, resourceSet.eAdapters().size());
		assertFalse(objectResource.isLoaded());
		assertTrue(stringElement.element().eResource().isLoaded());
	}
}
