/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util.jdt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.testSetups.TypeParamEndsWithDollar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementFinderTest extends Assert {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private JavaElementFinder elementFinder;
	
	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}

	@Before
	public void setUp() throws Exception {
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		projectProvider.setUseSource(true);
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		elementFinder = new JavaElementFinder();
		elementFinder.setProjectProvider(projectProvider);
	}
	
	@After
	public void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
		elementFinder = null;
	}
	
	@Test public void testListContainsAll() throws Exception {
		doTestFindMethod(List.class, "containsAll", 1);
	}
	
	@Test public void testListToArray() throws Exception {
		doTestFindMethod(List.class, "toArray", 0);
		doTestFindMethod(List.class, "toArray", 1);
	}

	@Test public void testArraysAsList() throws Exception {
		doTestFindMethod(Arrays.class, "asList", 1);
	}
	
	@Test public void testCollectionsSort() throws Exception {
		doTestFindMethod(Collections.class, "sort", 1);
		doTestFindMethod(Collections.class, "sort", 2);
	}
	
	@Test public void testCollectionsBinarySearch() throws Exception {
		doTestFindMethod(Collections.class, "binarySearch", 2);
		doTestFindMethod(Collections.class, "binarySearch", 3);
	}
	
	@Test public void testCollectionsReverse() throws Exception {
		doTestFindMethod(Collections.class, "reverse", 1);
	}
	
	@Test public void testTypeParamEndsWithDollar_01() throws Exception {
		doTestFindMethod(TypeParamEndsWithDollar.class, "function1", 1);
	}
	
	@Test public void testTypeParamEndsWithDollar_02() throws Exception {
		doTestFindMethod(TypeParamEndsWithDollar.class, "function2", 2);
	}
	
	@Test public void testTypeParamEndsWithDollar_03() throws Exception {
		doTestFindMethod(TypeParamEndsWithDollar.class, "function3", 1);
	}

	protected void doTestFindMethod(Class<?> declaringType, String methodName, int numberOfParameters) {
		JvmGenericType type = (JvmGenericType) typeProvider.findTypeByName(declaringType.getCanonicalName());
		JvmOperation foundOperation = null;
		for(JvmOperation operation: type.getDeclaredOperations()) {
			if (methodName.equals(operation.getSimpleName()) && operation.getParameters().size() == numberOfParameters) {
				foundOperation = operation;
				break;
			}
		}
		assertNotNull(foundOperation);
		IJavaElement found = elementFinder.findElementFor(foundOperation);
		assertEquals(IJavaElement.METHOD, found.getElementType());
		assertEquals(methodName, found.getElementName());
		IMethod foundMethod = (IMethod) found;
		assertEquals(numberOfParameters, foundMethod.getNumberOfParameters());
	}
	
}
