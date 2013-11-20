package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractReusableActiveAnnotationTests {
	
	@Test def void testAnnotationValueSetting() {
		assertProcessing(
			'myannotation/ConfigurableAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.*
				import org.eclipse.xtend.lib.macro.declaration.*
				
				import static com.google.common.base.Preconditions.*
				
				@Active(ConfigurableAnnotationProcessor)
				annotation ConfigurableAnnotation {
					BlackOrWhite color
					BlackOrWhite[] colors
					Class<?> type
					Class<?>[] types
				}
				
				enum BlackOrWhite {
					BLACK, WHITE
				}
				
				class ConfigurableAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val anno = annotatedClass.annotations.head
						val enumType = findTypeGlobally('myannotation.BlackOrWhite') as EnumerationTypeDeclaration
						val white = enumType.findDeclaredValue('WHITE')
						val black = enumType.findDeclaredValue('BLACK')
						
						val existingValue = anno.getValue('color')
						if (existingValue !=  white)
							throw new AssertionError("color")
						anno.set('color', black)
							
						val existingColorsValue = anno.getValue('colors') as Object[]
						if (existingColorsValue.get(0) !=  white && existingColorsValue.get(1) != black && existingColorsValue.length != 2)
							throw new AssertionError("colors")
							
						anno.set('colors', black, white)
						
						val existingType = anno.getValue('type')
						if (existingType != string)
							throw new AssertionError("type")
						anno.set('type', annotatedClass.newTypeReference)
							
						val existingTypes = anno.getValue('types') as Object[]
						if (existingTypes.get(0) !=  primitiveInt && existingTypes.get(1) != annotatedClass.newTypeReference && existingTypes.length != 2)
							throw new AssertionError("types")
							
						anno.set('types', primitiveBoolean)
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@ConfigurableAnnotation(color=BlackOrWhite.WHITE, colors=#[BlackOrWhite.WHITE, BlackOrWhite.BLACK], type = String, types=#[Integer, MyClass])
				class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass("myusercode.MyClass")
			val colorEnum = typeLookup.findTypeGlobally("myannotation.BlackOrWhite") as EnumerationTypeDeclaration
			val annotation = clazz.annotations.head
			
			assertEquals(colorEnum.findDeclaredValue('BLACK'), annotation.getValue('color'))
			
			val colors =  annotation.getValue('colors') as Object[]
			assertEquals(2, colors.length)
			assertEquals(colorEnum.findDeclaredValue('BLACK'), colors.get(0))
			assertEquals(colorEnum.findDeclaredValue('WHITE'), colors.get(1))
			
			assertEquals(typeReferenceProvider.newTypeReference(clazz), annotation.getValue('type'))
			
			val types =  annotation.getValue('types') as Object[]
			assertEquals(1, types.length)
			assertEquals(typeReferenceProvider.primitiveBoolean, types.get(0))
			
		]
	}
	
	@Test def void testAccessAndModifyEnumerationValueDeclaration() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.CodeGenerationContext
				import org.eclipse.xtend.lib.macro.CodeGenerationParticipant
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
				import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration
				import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
				import org.eclipse.xtend.lib.macro.declaration.Visibility
				
				import static com.google.common.base.Preconditions.*
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor implements RegisterGlobalsParticipant<EnumerationTypeDeclaration>, TransformationParticipant<MutableEnumerationTypeDeclaration>, CodeGenerationParticipant<EnumerationTypeDeclaration> {
				
					override doGenerateCode(List<? extends EnumerationTypeDeclaration> annotatedSourceElements,
						extension CodeGenerationContext context) {
					}
				
					override doRegisterGlobals(List<? extends EnumerationTypeDeclaration> annotatedSourceElements,
						RegisterGlobalsContext context) {
						for (enumeration : annotatedSourceElements) {
							enumeration.checkState
						}
					}
				
					def checkState(EnumerationTypeDeclaration enumeration) {
						val values = enumeration.declaredValues
						checkState(values.size == 3, "enumeration.declaredValues.size != 3")
						enumeration.findDeclaredValue(values.get(0).simpleName).checkState("A", enumeration)
						enumeration.findDeclaredValue(values.get(1).simpleName).checkState("B", enumeration)
						enumeration.findDeclaredValue(values.get(2).simpleName).checkState("C", enumeration)
					}
				
					def checkState(EnumerationValueDeclaration value, String expectedSimpleName, TypeDeclaration expectedType) {
						checkState(value.simpleName == expectedSimpleName, "value.simpleName != expectedSimpleName")
						checkState(value.declaringType == expectedType, "value.declaringType != expectedType")
						checkState(value.visibility == Visibility.PUBLIC, "value.visibility != Visibility.PUBLIC")
						checkState(value.annotations.size == 0, "value.annotations.size != 0")
						checkState(value.findAnnotation(null) == null, "value.findAnnotation(null) != null")
					}

					override doTransform(List<? extends MutableEnumerationTypeDeclaration> annotatedTargetElements,
						extension TransformationContext context) {
						for (enumeration : annotatedTargetElements) {
							enumeration.checkState
							for (value : enumeration.declaredValues) {
								checkState(value.annotations.size == 0, value.annotations.size != 0)
								value.addAnnotation(Deprecated.newTypeReference.type)
								checkState(value.annotations.size == 1, value.annotations.size != 1)
							}
							enumeration.addValue("D") [
								addAnnotation(Deprecated.newTypeReference.type)
							]
						}
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnnotation
				
				@MyAnnotation
				enum UserCode {
					A, 
					B,
					C
				}
			'''
		) [
			val enumerationType = typeLookup.findEnumerationType("myusercode.UserCode")
			assertEquals(4, enumerationType.declaredValues.size)
			
			val deprecatedAnnotationType = typeReferenceProvider.newTypeReference(Deprecated).type
			for (value : enumerationType.declaredValues) {
				assertEquals(1, value.annotations.size)
				assertNotNull(value.findAnnotation(deprecatedAnnotationType))
			}
			assertEquals("D", enumerationType.declaredValues.last.simpleName)
			assertNotNull(enumerationType.findDeclaredValue("D"))
		]
	}
	
	@Test def void testModifyTypeParameters() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {
				
					override doTransform(List<? extends MutableTypeParameterDeclarator> annotatedTargetElements,
						extension TransformationContext context) {
						for (annotatedTargetElement : annotatedTargetElements) {
							doTransform(annotatedTargetElement, context)
						}
					}
				
					def doTransform(MutableTypeParameterDeclarator it, extension TransformationContext context) {
						if (typeParameters.size != 0) {
							throw new IllegalStateException("Before: typeParameters.size != 0")
						}
						addTypeParameter("T", String.newTypeReference)
						if (typeParameters.size != 1) {
							throw new IllegalStateException("After: typeParameters.size != 1")
						}
						val typeParameter = typeParameters.head
						if (!typeParameter.simpleName.equals("T")) {
							throw new IllegalStateException("After: expected type name: 'T', actual type name: '" + typeParameter.simpleName + "'")
						}
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnnotation
				
				@MyAnnotation
				class MyClass {
				
					@MyAnnotation
					new() {
					}
				
				}
				
				@MyAnnotation
				interface MyInterface {
				
					@MyAnnotation
					abstract def void foo();
				
				}
			'''
		) [
			val (MutableTypeParameterDeclarator)=>void assertMyAnnotationChanges = [
				assertEquals(1, typeParameters.size)
			
				val typeParameter = typeParameters.head
				assertEquals("T", typeParameter.simpleName)
				assertEquals(1, typeParameter.upperBounds.size)
				assertEquals("java.lang.String", typeParameter.upperBounds.head.name)
			]
			
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertMyAnnotationChanges.apply(clazz)
			assertMyAnnotationChanges.apply(clazz.declaredConstructors.head)
			
			val myInterface = typeLookup.findInterface('myusercode.MyInterface')
			assertMyAnnotationChanges.apply(myInterface)
			assertMyAnnotationChanges.apply(myInterface.declaredMethods.head)
		]
	}
	
	@Test def void testRemoveTypeParameters() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {
				
					override doTransform(List<? extends MutableTypeParameterDeclarator> annotatedTargetElements,
						extension TransformationContext context) {
						for (annotatedTargetElement : annotatedTargetElements) {
							doTransform(annotatedTargetElement, context)
						}
					}
				
					def doTransform(MutableTypeParameterDeclarator it, extension TransformationContext context) {
						typeParameters.head.remove
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnnotation
				
				@MyAnnotation
				class MyClass<T extends String> {
				}
				
				@MyAnnotation
				interface MyInterface<T extends String> {
				
					@MyAnnotation
					abstract def <T extends String> void foo();
				
				}
			'''
		) [
			val (MutableTypeParameterDeclarator)=>void assertMyAnnotationChanges = [
				assertEquals(0, typeParameters.size)
			]
			
			assertMyAnnotationChanges.apply(typeLookup.findClass('myusercode.MyClass'))
			
			val myInterface = typeLookup.findInterface('myusercode.MyInterface')
			assertMyAnnotationChanges.apply(myInterface)
			assertMyAnnotationChanges.apply(myInterface.declaredMethods.head)
		]
	}
	
	@Test def void testSetUpperBoundsForMutableTypeParameterDeclaration() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {
				
					override doTransform(List<? extends MutableTypeParameterDeclarator> annotatedTargetElements,
						extension TransformationContext context) {
						for (annotatedTargetElement : annotatedTargetElements) {
							doTransform(annotatedTargetElement, context)
						}
					}
				
					def doTransform(MutableTypeParameterDeclarator it, extension TransformationContext context) {
						typeParameters.head.upperBounds = #[String.newTypeReference]
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnnotation
				
				@MyAnnotation
				class MyClass<T extends CharSequence> {
				}
				
				@MyAnnotation
				interface MyInterface<T extends CharSequence> {
				
					@MyAnnotation
					abstract def <T extends CharSequence> void foo();
				
				}
			'''
		) [
			val (MutableTypeParameterDeclarator)=>void assertMyAnnotationChanges = [
				assertEquals(1, typeParameters.size)
				
				val typeParameter = typeParameters.head
				assertEquals(1, typeParameter.upperBounds.size)
				assertEquals("java.lang.String", typeParameter.upperBounds.head.name)
			]
			
			assertMyAnnotationChanges.apply(typeLookup.findClass('myusercode.MyClass'))
			
			val myInterface = typeLookup.findInterface('myusercode.MyInterface')
			assertMyAnnotationChanges.apply(myInterface)
			assertMyAnnotationChanges.apply(myInterface.declaredMethods.head)
		]
	}

	@Test def void testRemoveAnnotation() {
		assertProcessing(
			'myannotation/RemoveAnnotation.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(RemoveAnnotationProcessor))
				annotation RemoveAnnotation{ }
				class RemoveAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.findAnnotation(RemoveAnnotation.newTypeReference.type).remove
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				/**
				 * MAKE ME LOWER CASE!
				 */
				@myannotation.RemoveAnnotation class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals(0, clazz.annotations.size)
		]
	}

	@Test def void testChangeJavaDoc() {
		assertProcessing(
			'myannotation/ChangeDocAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(ChangeDocProcessor))
				annotation ChangeDoc{ }
				class ChangeDocProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.docComment = clazz.docComment.toLowerCase
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				/**
				 * MAKE ME LOWER CASE!
				 */
				@myannotation.ChangeDoc class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals("make me lower case!", clazz.docComment)
		]
	}

	@Test def void testAddConstructor() {
		assertProcessing(
			'myannotation/AddConstructorAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(AddConstructorProcessor))
				annotation AddConstructor{ }
				class AddConstructorProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.addConstructor [
							addParameter("foo", string)
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddConstructor class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals(1, clazz.declaredConstructors.size)
			assertEquals('foo', clazz.declaredConstructors.head.parameters.head.simpleName)
		]
	}

	@Test def void testAddDefaultConstructor() {
		assertProcessing(
			'myannotation/AddConstructorAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(AddConstructorProcessor))
				annotation AddConstructor{ }
				class AddConstructorProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.addConstructor [
							body=['System.out.println("Hello World");']
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddConstructor class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals(1, clazz.declaredConstructors.size)
			assertTrue(clazz.declaredConstructors.head.parameters.isEmpty)
		]
	}
	
	@Test def void testAddDefaultConstructorWithTemplate() {
		assertProcessing(
			'myannotation/AddConstructorAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(AddConstructorProcessor))
				annotation AddConstructor{ }
				class AddConstructorProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.addConstructor [
							body=«"'''"»System.out.println("Hello World");«"'''"»
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddConstructor class MyClass {
				}
			'''
		) [
			compilationUnit
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals(1, clazz.declaredConstructors.size)
			assertTrue(clazz.declaredConstructors.head.parameters.isEmpty)
		]
	}

	@Test def void testSwapExpressions() {
		assertProcessing(
			'myannotation/SwapAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
				
				@Active(typeof(SwapProcessor))
				annotation Swap{ }
				class SwapProcessor implements TransformationParticipant<MutableMethodDeclaration> {
					
					override doTransform(List<? extends MutableMethodDeclaration> methods, extension TransformationContext context) {
						val b1 = methods.get(0).body
						val b2 = methods.get(1).body
						methods.get(0).body = b2
						methods.get(1).body = b1
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					@myannotation.Swap def foo(String a) {
						return b
					}
					@myannotation.Swap def bar(String b) {
						return a
					}
				}
			'''
		) [
			// no compile errors
		]
	}

	@Test def void testSwapExpressions_01() {
		assertProcessing(
			'myannotation/SwapAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				
				@Active(typeof(SwapProcessor))
				annotation Swap{ }
				class SwapProcessor implements TransformationParticipant<MutableFieldDeclaration> {
					
					override doTransform(List<? extends MutableFieldDeclaration> fields, extension TransformationContext context) {
						val b1 = fields.get(0).initializer
						val b2 = fields.get(1).initializer
						fields.get(0).initializer = b2
						fields.get(1).initializer = b1
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					@myannotation.Swap String a = 42
					@myannotation.Swap int b = 'foo'
				}
			'''
		) [
			// no compile errors
		]
	}

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

	@Test def void testParameterAnnotation() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration
				
				@Active(typeof(ParamProcessor))
				annotation Param { }
				class ParamProcessor implements TransformationParticipant<MutableParameterDeclaration> {
					
					override doTransform(List<? extends MutableParameterDeclaration> params, extension TransformationContext context) {
						params.forEach[
							simpleName = simpleName+'foo'
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					def void foo(@myannotation.Param String a, @myannotation.Param String b) {
					}
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertTrue(clazz.declaredMethods.head.parameters.forall[simpleName.endsWith('foo')])
		]
	}

	@Test def void testSetDocumentation() {
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
							docComment = docComment.toCharArray.reverse.join
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				/**
				 * dlroW olleH
				 */
				@myannotation.Abstract
				class MyClass {
					
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertEquals('Hello World', clazz.docComment)
		]
	}

	@Test def void testAddAnnotationValue() {
		assertProcessing(
			'myannotation/AddAnnotationValue.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget
				
				@Active(AddAnnotationValueProcessor)
				annotation AddAnnotationValue { }
				
				class AddAnnotationValueProcessor implements TransformationParticipant<MutableAnnotationTarget> {
					
					override doTransform(List<? extends MutableAnnotationTarget> annotationTargets, extension TransformationContext context) {
						annotationTargets.forEach [
							addAnnotation(typeof(MyAnnotation).findTypeGlobally) => [
								set(null, 'foo','bar','baz')
								set('singleValue', 'foo')
								set('booleans', true, false, true)
								set('singleBoolean', true)
«««								DEACTIVATED because of a compiler bug in Galileo's JDT
«««								set('numbers', 1,2,3)
«««								set('singleNumber', 1)
							]
						]
					}
					
				}
				annotation MyAnnotation {
					String[] value
					String singleValue
					boolean[] booleans
					boolean singleBoolean
«««					CHANGED because of a compiler bug in Galileo's JDT
«««					int[] numbers
«««					int singleNumber
					int[] numbers = #[1,2,3]
					int singleNumber = 1
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddAnnotationValue
				class MyClass {
					
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			val annotation = clazz.findAnnotation(
				typeReferenceProvider.newTypeReference('myannotation.MyAnnotation').type)
			assertArrayEquals(#['foo', 'bar', 'baz'], annotation.getValue('value') as Object[])
			assertEquals('foo', annotation.getValue('singleValue'))
			val booleans = annotation.getValue('booleans') as boolean[]
			assertTrue(booleans.get(2))
			assertEquals(true, annotation.getValue('singleBoolean'))
			assertArrayEquals(#[1, 2, 3], annotation.getValue('numbers') as int[])
			assertEquals(1, annotation.getValue('singleNumber'))
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
						parameters.head.type.type.qualifiedName
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
									return this.«field.simpleName»;
								''']
							]
							declaringType.addMethod('set'+field.simpleName.toFirstUpper) [
								addParameter(field.simpleName, field.type)
								body = ['''
									this.«field.simpleName» = «field.simpleName»;
								''']
							]
						]
					}
					
					def private String getterName(MutableFieldDeclaration field) {
						return 'get'+field.simpleName.toFirstUpper
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
			assertEquals('getMyField', getter.simpleName)
			assertEquals('String', getter.returnType.toString)
			val setter = clazz.findDeclaredMethod('setMyField', getter.returnType)
			assertEquals('setMyField', setter.simpleName)
			assertEquals('void', setter.returnType.toString)
			assertEquals('myField', setter.parameters.head.simpleName)
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
			assertEquals('A', method.typeParameters.head.simpleName)
			assertEquals('myParam', method.parameters.head.simpleName)
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
							context.registerClass(clazz.qualifiedName+".InnerClass")
							context.registerInterface(clazz.qualifiedName+"Interface")
							context.registerEnumerationType(clazz.qualifiedName+"Enum")
							context.registerAnnotationType(clazz.qualifiedName+"Annotation")
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

	@Test def void testIntroduceNewTypeAndWorkWithIt() {
		assertProcessing(
			'myannotation/NewTypesAddingAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				
				@Active(typeof(NewTypesAddingAnnotationProcessor))
				annotation NewTypesAddingAnnotation { }
				class NewTypesAddingAnnotationProcessor implements RegisterGlobalsParticipant<ClassDeclaration>, TransformationParticipant<MutableClassDeclaration> {
					
					override doRegisterGlobals(List<? extends ClassDeclaration> sourceClasses, RegisterGlobalsContext context) {
						for (clazz : sourceClasses) {
							context.registerClass(clazz.qualifiedName+"Derived")
						}
					}
					
					override doTransform(List<? extends MutableClassDeclaration> classes, extension TransformationContext context) {
						classes.forEach [ ele |
							val cl = context.findClass(ele.qualifiedName+"Derived")
							cl.extendedClass = newTypeReference(ele)
						]
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
			val declaredClass = typeLookup.findClass('myusercode.MyClass')
			assertNotNull(declaredClass)
			val clazz = typeLookup.findClass('myusercode.MyClassDerived')
			assertNotNull(clazz)
			assertEquals(declaredClass.qualifiedName, clazz.extendedClass.type.qualifiedName)
		]
	}

	val THREE_ANNOTATIONS = 'myannotation/three.xtend' -> '''
		package myannotation
		
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
					simpleName = simpleName + num()
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
		assertProcessing(
			THREE_ANNOTATIONS,
			'MyClass.xtend' -> '''
				import myannotation.*
				
				class MyClass {
					@_A @_B @_C String field
				}
			'''
		) [
			val myClass = typeLookup.findClass('MyClass')
			assertEquals('field_A_B_C', myClass.declaredFields.head.simpleName)
		]
	}

	@Test def void testDeterministicExecutionOrder_02() {

		// annotation processors are called in the order their annotations first occur in the file
		assertProcessing(
			THREE_ANNOTATIONS,
			'MyClass.xtend' -> '''
				import myannotation.*
				class MyClass {
					@_A @_B @_C String field1
					@_C @_B @_A String field2
				}
			'''
		) [
			val myClass = typeLookup.findClass('MyClass')
			assertEquals('field1_A_B_C', myClass.declaredFields.head.simpleName)
			assertEquals('field2_A_B_C', myClass.declaredFields.get(1).simpleName)
		]
	}

	def void assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile,
		(CompilationUnitImpl)=>void expectations)
		
	@Test def void testFileSystemSupport_01() {

		assertProcessing(
			'myannotation/FileSystemSupportTest.xtend' -> "
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				
				@Active(FileSystemUsingProcessor)
				annotation FileSystemSupportTest { }
				
				class FileSystemUsingProcessor extends AbstractClassProcessor {
	
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val path = annotatedClass.compilationUnit.filePath
						annotatedClass.docComment = '''
							Path '«path.toString»' {
								exists: «path.exists»
								isFolder: «path.isFolder»
								isFile: «path.isFile»
							}
							sourceFolder : «path.sourceFolder»
							targetFolder : «path.targetFolder»
							projectFolder: «path.projectFolder»
						'''
					}
					
				}
			",
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.FileSystemSupportTest
				class MyClass {
				}
			'''
		) [
			val declaredClass = typeLookup.findClass('myusercode.MyClass')
			assertEquals('''
				Path '/userProject/src/myusercode/UserCode.xtend' {
					exists: true
					isFolder: false
					isFile: true
				}
				sourceFolder : /userProject/src
				targetFolder : /userProject/xtend-gen
				projectFolder: /userProject
			'''.toString, declaredClass.docComment)
		]
	}
}

class FileSystemUsingProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		val path = annotatedClass.compilationUnit.filePath
		annotatedClass.docComment = '''
			Path "«path.toString»" {
				exists: «path.exists»
				isFolder: «path.isFolder»
				isFile: «path.isFile»
			}
			sourceFolder : «path.sourceFolder»
			targetFolder : «path.targetFolder»
			projectFolder: «path.projectFolder»
		'''
	}
	
}

