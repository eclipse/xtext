package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.resource.XbaseResource
import org.junit.Test
import org.eclipse.emf.ecore.resource.Resource

class XtendResourceSetBasedResourceDescriptionsTest extends AbstractXtendTestCase {

	@Inject CompilationTestHelper compiler
	@Inject IResourceValidator validator
	
	@Test def void testBidirectionalRef() {
		val resourceSet  = compiler.resourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		for (Resource res : resourceSet.resources.toSet) {
			val issues = validator.validate(res, CheckMode::ALL, CancelIndicator::NullImpl)
			assertTrue(issues.toString, issues.empty)
		}
	}
	
	@Test def void testUnloadedBidirectionalRef() {
		val resourceSet  = compiler.unLoadedResourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		for (Resource res : resourceSet.resources.toSet) {
			val issues = validator.validate(res, CheckMode::ALL, CancelIndicator::NullImpl)
			assertTrue(issues.toString, issues.empty)
		}
	}
	
	@Test def void testUnloadedInstallDerivedStateThrowsException() {
		val resourceSet  = compiler.unLoadedResourceSet(
			'foo/ClassA.xtend'->'''package foo class ClassA extends bar.ClassB {}''',
			'bar/ClassB.xtend'->'''package bar class ClassB { public foo.ClassA myField }'''
		)
		for (Resource res : resourceSet.resources.toSet) {
			assertFalse(res.loaded)
			try {
				(res as XbaseResource).installDerivedState(true)
				fail("expected exception")
			} catch (IllegalStateException e) {
				// expected
			}
		}
	}
}