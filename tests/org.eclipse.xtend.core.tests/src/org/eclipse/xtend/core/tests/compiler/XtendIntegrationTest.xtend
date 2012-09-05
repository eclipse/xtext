package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class XtendIntegrationTest {
	
	@Inject extension CompilationTestHelper
	
	@Test def void testAnnotationProcessing() {
		'''
			import java.lang.annotation.*
			
			@MyProcessedAnnotation
			class Foo {
			}
			
			@Retention(RetentionPolicy::RUNTIME)
			annotation MyProcessedAnnotation {
				do {
					println('foo')
				}
			}
		'''.compile [
			val fooClass = getCompiledClass('Foo')
			val annotation = getCompiledClass('MyProcessedAnnotation')
			assertTrue( fooClass.annotations.exists[ annotationType == annotation ])
		]
	}
}