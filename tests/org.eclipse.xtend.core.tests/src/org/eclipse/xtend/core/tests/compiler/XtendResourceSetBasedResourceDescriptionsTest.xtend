/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendResourceSetBasedResourceDescriptionsTest extends AbstractXtendTestCase {

	@Inject CompilationTestHelper compiler
	@Inject IResourceValidator validator
	
	@Test def void testBidirectionalRef() {
		val resourceSet  = compiler.resourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		val List<? extends Resource> resources = resourceSet.resources
		for (Resource res : new ArrayList<Resource>(resources)) {
			val issues = validator.validate(res, CheckMode::ALL, CancelIndicator::NullImpl)
			assertTrue(issues.toString, issues.empty)
		}
	}
	
	@Test def void testUnloadedBidirectionalRef() {
		val resourceSet  = compiler.unLoadedResourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		val List<? extends Resource> resources = resourceSet.resources
		for (Resource res : new ArrayList<Resource>(resources)) {
			val issues = validator.validate(res, CheckMode::ALL, CancelIndicator::NullImpl)
			assertTrue(issues.toString, issues.empty)
		}
	}
	
	@Test def void testUnloadedInstallDerivedStateThrowsException() {
		val resourceSet  = compiler.unLoadedResourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		val List<? extends Resource> resources = resourceSet.resources
		for (Resource res : new ArrayList<Resource>(resources)) {
			assertFalse(res.loaded)
			try {
				(res as DerivedStateAwareResource).installDerivedState(true)
				fail("expected exception")
			} catch (IllegalStateException e) {
				// expected
			}
		}
	}
}