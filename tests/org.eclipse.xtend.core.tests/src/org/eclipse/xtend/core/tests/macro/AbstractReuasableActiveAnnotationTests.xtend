package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractReuasableActiveAnnotationTests {
	
	@Test def void testSimpleModification() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				@Active(typeof(AbstractProcessor))
				annotation Abstract { }
				class AbstractProcessor implements TransformationParticipant<MutableClassDeclaration> {
					
					override doTransform(List<? extends MutableClassDeclaration> annotatedSourceClasses, extension TransformationContext context) {
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
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertTrue(clazz.isAbstract)
		]
	}
	
	@Test def void testCreateTypeFromUsage() {
		assertProcessing(
			'myannotation/SomeAnnotation.xtend' -> '''
				package myannotation
				
				import java.lang.annotation.Documented
				import java.lang.annotation.ElementType
				import java.lang.annotation.Target
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
				import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
				
				@Active(typeof(SomeProcessor))
				@Documented
				@Target(ElementType::TYPE)
				annotation SomeAnnotation {}
				class SomeProcessor implements RegisterGlobalsParticipant<TypeDeclaration> {
					override doRegisterGlobals(List<? extends TypeDeclaration> types, RegisterGlobalsContext context) {
						types.forEach[
							declaredMethods.forEach[
								context.registerClass(parameterType)
							]
						]
					}
					private def getParameterType(MethodDeclaration it) {
						parameters.head.type.type.name
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.SomeAnnotation
				class MyClass {
					def void myMethod(DoesNotExist p) {}
				}
			'''
		) [
			assertTrue(typeLookup.findClass('myusercode.DoesNotExist').simpleName == 'DoesNotExist')
		]
	}
	
	@Test def void testPropertyAnnotation() {
		assertProcessing(
			'myannotation/PropertyAnnotation.xtend' -> "
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				@Active(typeof(PropertyProcessor))
				annotation Property2 { }
				class PropertyProcessor implements TransformationParticipant<MutableFieldDeclaration> {
					
					override doTransform(List<? extends MutableFieldDeclaration> annotatedTargetFields, extension TransformationContext context) {
						annotatedTargetFields.forEach [ field |
							val declaringType = field.declaringType 
							declaringType.addMethod(field.getterName) [
								returnType = field.type
								body = ['''
									return this.«field.name»;
								''']
							]
							declaringType.addMethod('set'+field.name.toFirstUpper) [
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
			val clazz = typeLookup.findClass('myusercode.MyClass')
			val getter = clazz.declaredMethods.head
			assertEquals('getMyField', getter.name)
			assertEquals('String', getter.returnType.toString)
			
			val setter = clazz.findMethod('setMyField', getter.returnType)
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
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration

				@Active(typeof(ThrowsAndTypeParamProcessor))
				annotation ThrowsAndTypeParam { }
				class ThrowsAndTypeParamProcessor implements TransformationParticipant<MutableMethodDeclaration> {
					
					override doTransform(List<? extends MutableMethodDeclaration> annotatedMethods, extension TransformationContext context) {
						annotatedMethods.forEach [
							val type = addTypeParameter('A')
							addParameter('myParam', newTypeReference(type))
							setExceptions(newTypeReference('java.lang.Exception'))
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
			val type = typeLookup.findClass('myusercode.MyClass')
			val method = type.declaredMethods.head
			assertEquals('A', method.typeParameters.head.name)
			assertEquals('myParam', method.parameters.head.name)
			assertSame(method.typeParameters.head, method.parameters.head.type.type)
			assertEquals(1, method.exceptions.size)
		]
	}
	
	@Test def void testValidation() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration

				@Active(typeof(ValidatedProcessor))
				annotation Validated { }
				class ValidatedProcessor implements TransformationParticipant<MutableNamedElement> {
					
					override doTransform(List<? extends MutableNamedElement> annotatedMethods, extension TransformationContext context) {
						annotatedMethods.forEach [ ele |
							switch ele {
								MutableFieldDeclaration : ele.addWarning('field-warning')
								default : ele.addWarning('warning')
							}
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					@myannotation.Validated
					def void foo() {
					}
					
					@myannotation.Validated
					String name
				}
			'''
		) [
			val type = typeLookup.findClass('myusercode.MyClass')
			val method = type.declaredMethods.head
			val field = type.declaredFields.head
			assertEquals('field-warning', problemSupport.getProblems(field).head.message)
			assertEquals('warning', problemSupport.getProblems(method).head.message)
		]
	}
	
	@Test def void testIntroduceNewTypes() {
		assertProcessing(
			'myannotation/NewTypesAddingAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration

				@Active(typeof(NewTypesAddingAnnotationProcessor))
				annotation NewTypesAddingAnnotation { }
				class NewTypesAddingAnnotationProcessor implements RegisterGlobalsParticipant<ClassDeclaration> {
					
					override doRegisterGlobals(List<? extends ClassDeclaration> sourceClasses, RegisterGlobalsContext context) {
						for (clazz : sourceClasses) {
							context.registerClass(clazz.name+".InnerClass")
							context.registerInterface(clazz.name+"Interface")
							context.registerEnumerationType(clazz.name+"Enum")
							context.registerAnnotationType(clazz.name+"Annotation")
						}
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.NewTypesAddingAnnotation
				class MyClass {
				}
			'''
		) [
			assertNotNull(typeLookup.findClass('myusercode.MyClass'))
			assertNotNull(typeLookup.findClass('myusercode.MyClass.InnerClass'))
			assertNotNull(typeLookup.findInterface('myusercode.MyClassInterface'))
			assertNotNull(typeLookup.findEnumerationType('myusercode.MyClassEnum'))
			assertNotNull(typeLookup.findAnnotationType('myusercode.MyClassAnnotation'))
		]
	}
	
	val THREE_ANNOTATIONS = 'three.xtend' -> '''
		import java.util.List
		import org.eclipse.xtend.lib.macro.Active
		import org.eclipse.xtend.lib.macro.TransformationContext
		import org.eclipse.xtend.lib.macro.TransformationParticipant
		import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement

		@Active(typeof(Aprocessor))
		annotation _A {}
		class Aprocessor implements TransformationParticipant<MutableNamedElement> {
			
			override doTransform(List<? extends MutableNamedElement> annotatedTargetElements, extension TransformationContext context) {
				annotatedTargetElements.forEach[
					name = name + num()
				]
			}
		
			def num() {
				'_A'
			}
			
		}
		@Active(typeof(Bprocessor))
		annotation _B {}
		class Bprocessor extends Aprocessor {
			override num() { '_B' }
		}
		
		@Active(typeof(Cprocessor))
		annotation _C {}
		class Cprocessor extends Aprocessor {
			override num() { '_C' }
		}
	'''
	
	@Test def void testDeterministicExecutionOrder_01() {
		assertProcessing(THREE_ANNOTATIONS,
			'MyClass.xtend' -> '''
				class MyClass {
					@_A @_B @_C String field
				}
			'''
		) [
			val myClass = typeLookup.findClass('MyClass')
			assertEquals('field_A_B_C',myClass.declaredFields.head.name)
		]
	}
	
	@Test def void testDeterministicExecutionOrder_02() {
		// annotation processors are called in the order their annotations first occur in the file
		assertProcessing(THREE_ANNOTATIONS,
			'MyClass.xtend' -> '''
				class MyClass {
					@_A @_B @_C String field1
					@_C @_B @_A String field2
				}
			'''
		) [
			val myClass = typeLookup.findClass('MyClass')
			assertEquals('field1_A_B_C',myClass.declaredFields.head.name)
			assertEquals('field2_A_B_C',myClass.declaredFields.get(1).name)
		]
	}
	
	def void assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnitImpl)=>void expectations)
}