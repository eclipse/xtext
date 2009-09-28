/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.AnnotationReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.Void;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScopeTest extends TestCase {

	private MockJavaProjectProvider projectProvider;
	private JdtTypeProviderFactory factory;
	private ResourceSet resourceSet;
	private JdtBasedSimpleTypeScope typeScope;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		projectProvider = new MockJavaProjectProvider();
		factory = new JdtTypeProviderFactory(projectProvider);
		resourceSet = new ResourceSetImpl();
		typeScope = new JdtBasedSimpleTypeScope(factory.createTypeProvider(resourceSet));
	}
	
	public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, typeScope.getOuterScope());
	}
	
	public void testGetElementByName_01() {
		IScopedElement objectElement = typeScope.getContentByName(Object.class.getName());
		assertNotNull(objectElement);
		assertFalse(objectElement.element().eIsProxy());
		assertEquals("java.lang.Object", objectElement.name());
	}
	
	public void testGetElementByName_02() {
		IScopedElement objectElement = typeScope.getContentByName(Object.class.getName() + "Foo");
		assertNull(objectElement);
	}
	
	public void testGetElementByInstance_01() {
		Void voidType = TypesFactory.eINSTANCE.createVoid();
		IScopedElement element = typeScope.getContentByEObject(voidType);
		assertNotNull(element);
		assertEquals(voidType.getCanonicalName(), element.name());
	}
	
	public void testGetElementByInstance_02() {
		AnnotationReference annotationReference = TypesFactory.eINSTANCE.createAnnotationReference();
		IScopedElement element = typeScope.getContentByEObject(annotationReference);
		assertNull(element);
	}
	
	public void testGetContents_01() {
		Iterable<IScopedElement> contents = typeScope.getContents();
		assertTrue(Iterables.any(contents, new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement input) {
				return List.class.getName().equals(input.name());
			}
		}));
	}
}
