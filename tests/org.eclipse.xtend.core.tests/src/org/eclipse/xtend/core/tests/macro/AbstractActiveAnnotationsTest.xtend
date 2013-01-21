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
								returnType = field.type
								body = ['''
									return this.«field.name»;
								''']
							]
							field.declaringType.addMethod('set'+field.name.toFirstUpper) [
								addParameter(field.name, field.type)
								body = ['''
									this.«field.name» = «field.name»;
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
			assertEquals('String', getter.returnType.toString)
			
			val setter = clazz.members.filter(typeof(MutableMethodDeclaration)).drop(1).head
			assertEquals('setMyField', setter.name)
			assertEquals('void', setter.returnType.toString)
			assertEquals('myField', setter.parameters.head.name)
			assertEquals('String', setter.parameters.head.type.toString)
		]
	}
	
	@Test def void testThrowsAndTypeParam() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.ModifyContext
				import org.eclipse.xtend.lib.macro.ModifyProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration

				@Active(typeof(ThrowsAndTypeParamProcessor))
				annotation ThrowsAndTypeParam { }
				class ThrowsAndTypeParamProcessor implements ModifyProcessor<MutableMethodDeclaration> {
					
					extension ModifyContext ctx
					
					override modify(List<? extends MutableMethodDeclaration> annotatedMethods, ModifyContext context) {
						ctx = context
						annotatedMethods.forEach [
							val type = addTypeParameter('A')
							addParameter('myParam', compilationUnit.typeReferenceProvider.newTypeReference(type))
							setExceptions(compilationUnit.typeReferenceProvider.newTypeReference('java.lang.Exception'))
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					@myannotation.ThrowsAndTypeParam
					def void foo(){
					}
				}
			'''
		) [
			val method = generatedClassDeclarations.head.members.filter(typeof(MutableMethodDeclaration)).head
			assertEquals('A', method.typeParameters.head.name)
			assertEquals('myParam', method.parameters.head.name)
			assertSame(method.typeParameters.head, method.parameters.head.type.type)
			assertEquals(1, method.exceptions.size)
		]
	}
	
	
	def void assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnit)=>void expectations)
}