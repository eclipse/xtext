/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractScopeTest extends Assert {

	protected IEObjectDescription descriptionA;
	protected IEObjectDescription descriptionA_aliased;
	protected IEObjectDescription descriptionB_as_A;
	protected IEObjectDescription descriptionB;
	protected EAnnotation annotationA;
	protected EAnnotation annotationB;
	private Resource resource;

	@Before
	public void setUp() throws Exception {
		resource = new ResourceImpl(URI.createURI("uri"));
		annotationA = EcoreFactory.eINSTANCE.createEAnnotation();
		annotationB = EcoreFactory.eINSTANCE.createEAnnotation();
		resource.getContents().add(annotationA);
		resource.getContents().add(annotationB);
		descriptionA = EObjectDescription.create("a", annotationA);
		descriptionA_aliased = EObjectDescription.create("aliasedA", annotationA);
		descriptionB = EObjectDescription.create("b", annotationB);
		descriptionB_as_A = EObjectDescription.create("a", annotationB);
	}
	
	@After
	public void tearDown() throws Exception {
		annotationA = null;
		annotationB = null;
		descriptionA = null;
		descriptionA_aliased = null;
		descriptionB = null;
		descriptionB_as_A = null;
		resource = null;
	}
	
	protected abstract IScope createScope(IScope parent, Iterable<IEObjectDescription> content);
	
	@Test public void testSingleByName() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB));
		assertSame(descriptionA, scope.getSingleElement(descriptionA.getName()));
		assertSame(descriptionB, scope.getSingleElement(descriptionB.getName()));
	}
	
	@Test public void testSingleByNameWithDuplicate() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB_as_A, descriptionB));
		assertSame(descriptionA, scope.getSingleElement(descriptionA.getName()));
		assertSame(descriptionB, scope.getSingleElement(descriptionB.getName()));
	}
	
	@Test public void testSingleByObject() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB));
		assertSame(descriptionA, scope.getSingleElement(annotationA));
		assertSame(descriptionB, scope.getSingleElement(annotationB));
	}
	
	@Test public void testSingleByObjectWithDuplicate_01() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB_as_A, descriptionB));
		assertSame(descriptionA, scope.getSingleElement(annotationA));
		assertSame(descriptionB, scope.getSingleElement(annotationB));
	}
	
	@Test public void testSingleByObjectWithDuplicate_02() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionB));
		assertNull(scope.getSingleElement(annotationA));
		assertSame(descriptionB_as_A, scope.getSingleElement(annotationB));
	}
	
	@Test public void testSingleByObjectWithDuplicate_03() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionA_aliased));
		assertSame(descriptionA_aliased, scope.getSingleElement(annotationA));
		assertSame(descriptionB_as_A, scope.getSingleElement(annotationB));
	}
	
	@Test public void testByName() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB));
		assertEqualElements(Collections.singleton(descriptionA), scope.getElements(descriptionA.getName()));
		assertEqualElements(Collections.singleton(descriptionB), scope.getElements(descriptionB.getName()));
	}
	
	@Test public void testByNameWithDuplicate_01() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB_as_A, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionA, descriptionB_as_A), scope.getElements(descriptionA.getName()));
		assertEqualElements(Collections.singleton(descriptionB), scope.getElements(descriptionB.getName()));
	}
	
	@Test public void testByNameWithDuplicate_02() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionB_as_A, descriptionA), scope.getElements(descriptionA.getName()));
		assertEqualElements(Collections.singleton(descriptionB), scope.getElements(descriptionB.getName()));
	}
	
	@Test public void testByObject() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionA), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(descriptionB), scope.getElements(annotationB));
	}
	
	@Test public void testByObjectWithDuplicate_01() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB_as_A, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionA), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(descriptionB), scope.getElements(annotationB));
	}
	
	@Test public void testByObjectWithDuplicate_02() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionB));
		assertEqualElements(ImmutableList.of(), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(descriptionB_as_A, descriptionB), scope.getElements(annotationB));
	}
	
	@Test public void testByObjectWithDuplicate_03() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionA_aliased));
		assertEqualElements(ImmutableList.of(descriptionA_aliased), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(descriptionB_as_A), scope.getElements(annotationB));
	}
	
	@Test public void testByObjectWithDuplicate_04() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA_aliased, descriptionB_as_A, descriptionA));
		assertEqualElements(ImmutableList.of(descriptionA_aliased), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(descriptionB_as_A), scope.getElements(annotationB));
	}
	
	@Test public void testByObjectWithDuplicate_05() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA_aliased, descriptionA, descriptionB_as_A));
		assertEqualElements(ImmutableList.of(descriptionA_aliased, descriptionA), scope.getElements(annotationA));
		assertEqualElements(ImmutableList.of(), scope.getElements(annotationB));
	}
	
	protected void assertEqualElements(Iterable<?> expected, Iterable<?> actual) {
		assertTrue(Iterables.elementsEqual(expected, actual));
	}
	
}
