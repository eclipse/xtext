package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractReusableActiveAnnotationTests {

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
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget
				
				@Active(typeof(AddAnnotationProcessor))
				annotation AddAnnotation { }
				class AddAnnotationProcessor implements TransformationParticipant<MutableAnnotationTarget> {
					
					override doTransform(List<? extends MutableAnnotationTarget> annotationTargets, extension TransformationContext context) {
						annotationTargets.forEach [
							addAnnotation(typeof(MyAnnotation).findTypeGlobally) => [
								set(null, 'foo','bar','baz')
								set('singleValue', 'foo')
								set('booleans', true, false, true)
								set('singleBoolean', true)
								set('numbers', 1,2,3)
								set('singleNumber', 1)
							]
						]
					}
					
				}
				annotation MyAnnotation {
					String[] value
					String singleValue
					boolean[] booleans
					boolean singleBoolean
					int[] numbers
					int singleNumber
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddAnnotation
				class MyClass {
					
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			val annotation = clazz.findAnnotation(
				typeReferenceProvider.newTypeReference('myannotation.MyAnnotation').type)
			assertEquals(#['foo', 'bar', 'baz'], annotation.getValue('value'))
			assertEquals('foo', annotation.getValue('singleValue'))
			assertEquals(#[true, false, true], annotation.getValue('booleans'))
			assertEquals(true, annotation.getValue('singleBoolean'))
			assertEquals(#[1, 2, 3], annotation.getValue('numbers'))
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
			val setter = clazz.findMethod('setMyField', getter.returnType)
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

	@Test def void testDeterministicExecutionOrder_03() {

		// annotation processors are called in the order their annotations first occur in the file
		assertProcessing(
			THREE_ANNOTATIONS,
			'MyClass.xtend' -> '''
				@_A @_B @_C class MyClass {
				}
			'''
		) [
			val myClass = typeLookup.findClass('MyClass_A_B_C')
			assertNotNull(myClass)
		]
	}

	def void assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile,
		(CompilationUnitImpl)=>void expectations)
}
