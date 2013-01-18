package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
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
	
	@Test def void testPropertyAnnotation() {
		assertProcessing(
			'myannotation/PropertyAnnotation.xtend' -> "
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.ModifyContext
				import org.eclipse.xtend.lib.macro.ModifyProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration

				@Active(typeof(PropertyProcessor))
				annotation Property2 { }
				class PropertyProcessor implements ModifyProcessor<MutableFieldDeclaration> {
					
					extension ModifyContext ctx
					
					override modify(List<? extends MutableFieldDeclaration> annotatedSourceFields, ModifyContext context) {
						ctx = context
						annotatedSourceFields.forEach [ field |
							field.declaringType.addMethod(field.getterName) [
								body = ['''
									return this.«field.name»;
								''']
							]
						]
					}
					
					def private String getterName(MutableFieldDeclaration field) {
						return 'get'+field.name.toFirstUpper
					}
				}
			",
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					
					@myannotation.Property2 String myField
				}
			'''
		) [
			val clazz = generatedClassDeclarations.head
			val getter = clazz.members.filter(typeof(MutableMethodDeclaration)).head
			assertEquals('getMyField', getter.name)
		]
	}
	
	
	
	def void assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnit)=>void expectations)
}