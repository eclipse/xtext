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

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementFinderTest extends TestCase {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private JavaElementFinder elementFinder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		projectProvider.setUseSource(true);
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		elementFinder = new JavaElementFinder();
		elementFinder.setProjectProvider(projectProvider);
	}
	
	@Override
	protected void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
		elementFinder = null;
		super.tearDown();
	}
	
	public void testListContainsAll() throws Exception {
		doTestFindMethod(List.class, "containsAll", 1);
	}
	
	public void testListToArray() throws Exception {
		doTestFindMethod(List.class, "toArray", 0);
		doTestFindMethod(List.class, "toArray", 1);
	}

	public void testArraysAsList() throws Exception {
		doTestFindMethod(Arrays.class, "asList", 1);
	}
	
	public void testCollectionsSort() throws Exception {
		doTestFindMethod(Collections.class, "sort", 1);
		doTestFindMethod(Collections.class, "sort", 2);
	}
	
	public void testCollectionsBinarySearch() throws Exception {
		doTestFindMethod(Collections.class, "binarySearch", 2);
		doTestFindMethod(Collections.class, "binarySearch", 3);
	}
	
	public void testCollectionsReverse() throws Exception {
		doTestFindMethod(Collections.class, "reverse", 1);
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
