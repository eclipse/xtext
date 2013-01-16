package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractActiveAnnotationsTest {
	
	@Test def void testSimpleModification() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.ModifyContext
				import org.eclipse.xtend.lib.macro.ModifyProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				@Active(typeof(AbstractProcessor))
				annotation Abstract { }
				class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {
					
					extension ModifyContext ctx
					
					override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {
						ctx = context
						annotatedSourceClasses.forEach [
							^abstract = true
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.Abstract
				class MyClass {
					
				}
			'''
		) [
			val clazz = generatedClassDeclarations.head
			assertTrue(clazz.isAbstract)
		]
	}
	
	def void assertProcessing(Pair<String,CharSequence> macroFile, Pair<String,CharSequence> clientFile, (CompilationUnit)=>void expectations)
}