/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.lang.annotation.RetentionPolicy
import java.util.List
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver
import org.junit.After
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow
 */
class LogicalContainerAwareReentrantTypeResolverTest extends AbstractXbaseTestCase {
	
	@Inject LogicalContainerAwareReentrantTypeResolver testMe
	@Inject TypeReferences typeReferences
	
	XtextResourceSet resourceSet
	
	override setUp() {
		super.setUp
		resourceSet = get(typeof(XtextResourceSet));
	}
	
	@After def void tearDown() {
		resourceSet = null
	}
	
	@Test def void testResolve_01() {
		val type = typeReferences.findDeclaredType(typeof(TypeResolutionTestData$NestedList), resourceSet)
		testMe.initializeFrom(type)
		val resolveMe = typeReferences.getTypeForName(typeof(TypeResolutionTestData$NestedList), type)
		val resolved = testMe.resolve(resolveMe)
		assertEquals("NestedList<T>", resolved.simpleName)
	}
	
	@Test def void testResolve_02() {
		val type = typeReferences.findDeclaredType(typeof(TypeResolutionTestData$NestedList), resourceSet)
		testMe.initializeFrom(type)
		val resolveMe = typeReferences.getTypeForName(typeof(List), type)
		val resolved = testMe.resolve(resolveMe)
		assertEquals("List<List<T>>", resolved.simpleName)
	}
	
	@Test def void testResolve_03() {
		val type = typeReferences.findDeclaredType(typeof(TypeResolutionTestData$NestedList), resourceSet)
		testMe.initializeFrom(type)
		val resolveMe = typeReferences.getTypeForName(typeof(Iterable), type)
		val resolved = testMe.resolve(resolveMe)
		assertEquals("Iterable<List<T>>", resolved.simpleName)
	}
	
	@Test def void testResolve_04() {
		val type = typeReferences.findDeclaredType(typeof(TypeResolutionTestData$NestedList), resourceSet)
		testMe.initializeFrom(type)
		val resolveMe = typeReferences.getTypeForName(typeof(Iterable), type)
		val resolved = testMe.resolve(resolveMe)
		assertEquals("Iterable<List<T>>", resolved.simpleName)
	}
	
	@Test def void testResolve_05() {
		val type = typeReferences.findDeclaredType(typeof(RetentionPolicy), resourceSet)
		testMe.initializeFrom(type)
		val resolveMe = typeReferences.getTypeForName(typeof(Enum), type)
		val resolved = testMe.resolve(resolveMe)
		assertEquals("Enum<RetentionPolicy>", resolved.simpleName)
	}
	
}