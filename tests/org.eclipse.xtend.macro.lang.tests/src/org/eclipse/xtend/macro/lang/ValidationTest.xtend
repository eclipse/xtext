package org.eclipse.xtend.macro.lang

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(MacroInjectorProvider))
class ValidationTest {
	
	@Inject extension CompilationTestHelper
	@Inject extension MacroTestExtensions
	
	@Test def void testValidationError() {
		val resourceSet = resourceSet(
		'''
			@MyAnnotation class Foo {}
		'''.xtend, 
		'''
			@MyAnnotation for class {
				foo // compile error
			}
		'''.macro)
		EcoreUtil::resolveAll(resourceSet)
		assertTrue( resourceSet.resources.findFirst[ URI.fileExtension == 'xtend'].errors.head.message.contains('macro'))
		assertFalse( resourceSet.resources.findFirst[ URI.fileExtension == 'macro'].errors.empty)
	}
	
	@Test def void testValidationError_01() {
		val resourceSet = resourceSet(
		'''
			@MyAnnotation class Foo {}
		'''.xtend, 
		'''
			@MyAnnotation for class {
				process {
					throw new NullPointerException("name : "+elements.head.name)
				}
			}
		'''.macro)
		EcoreUtil::resolveAll(resourceSet)
		val message = resourceSet.resources.findFirst[ URI.fileExtension == 'xtend'].errors.head.message
		assertTrue(message.contains('name : Foo'))
		assertTrue(message.contains('throw new NullPointerException'))
		assertTrue( resourceSet.resources.findFirst[ URI.fileExtension == 'macro'].errors.empty)
	}
	
	@Test def void testValidationError_02() {
		val resourceSet = resourceSet(
		'''
			@MyAnnotation class Foo {}
		'''.xtend, 
		'''
			@MyAnnotation for method {
				process {
				}
			}
		'''.macro)
		EcoreUtil::resolveAll(resourceSet)
		val message = resourceSet.resources.findFirst[ URI.fileExtension == 'xtend'].errors.head.message
		assertTrue(message.contains('MyAnnotation'))
		assertTrue(message.contains('method'))
		assertTrue( resourceSet.resources.findFirst[ URI.fileExtension == 'macro'].errors.empty)
	}
	
	@Test def void testValidationError_03() {
		val resourceSet = resourceSet(
		'''
			@MyAnnotation class Foo {}
		'''.xtend, 
		'''
			@MyAnnotation for class {
				process {
					error(elements.head, 'Bad name '+elements.head.name)
				}
			}
		'''.macro)
		EcoreUtil::resolveAll(resourceSet)
		val message = resourceSet.resources.findFirst[ URI.fileExtension == 'xtend'].errors.head.message
		assertTrue(message, message.contains('Bad name Foo'))
		assertTrue( resourceSet.resources.findFirst[ URI.fileExtension == 'macro'].errors.empty)
	}
}