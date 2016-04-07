package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.compiler.XtendGenerator
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl
import org.eclipse.xtend.core.macro.declaration.MutableJvmClassDeclarationImpl
import org.eclipse.xtend.core.macro.declaration.MutableJvmFieldDeclarationImpl
import org.eclipse.xtend.core.macro.declaration.MutableJvmMethodDeclarationImpl
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractReusableActiveAnnotationTests {
	
	@Inject XtendGenerator generator
	@Inject IGeneratorConfigProvider generatorConfigProvider
	@Inject ValidationTestHelper validator
	@Inject ILogicalContainerProvider logicalContainerProvider
	
	@Test def void testBug453273() {
		assertProcessing(
			'myannotation/AddNestedTypes.xtend' -> '''
				package myannotation
				
				import java.lang.annotation.ElementType
				import java.lang.annotation.Target
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				
				@Target(ElementType.TYPE)
				@Active(AddNestedTypesProcessor)
				annotation AddNestedTypes {
				}
				
				class AddNestedTypesProcessor extends AbstractClassProcessor {
				   override doRegisterGlobals(ClassDeclaration it, RegisterGlobalsContext registerGlobalsContext) {
				      registerGlobalsContext.registerClass(qualifiedName + ".NestedType")
				      registerGlobalsContext.registerClass(qualifiedName + ".NestedType.NestedType2")
				      registerGlobalsContext.registerClass(packageName + ".OtherTopLevelClass")
				      registerGlobalsContext.registerClass(packageName + ".OtherTopLevelClass.NestedType")
				   }
				   
				   def String getPackageName(ClassDeclaration it) {
				   	  qualifiedName.substring(0,qualifiedName.lastIndexOf('.'))
				   }
				}
			''',
			'my/client/UserCode.xtend' -> '''
				package my.client
				
				@myannotation.AddNestedTypes
				class TopLevelClass {
				}
			'''
		) [
			validator.assertNoErrors(xtendFile)
			assertNotNull(typeLookup.findClass("my.client.TopLevelClass"))
			assertNotNull(typeLookup.findClass("my.client.TopLevelClass.NestedType"))
			assertNotNull(typeLookup.findClass("my.client.TopLevelClass.NestedType.NestedType2"))
			assertNotNull(typeLookup.findClass("my.client.OtherTopLevelClass"))
			assertNotNull(typeLookup.findClass("my.client.OtherTopLevelClass.NestedType"))
		]
	}
	
	@Test def void testBug441081() {
		assertProcessing(
			'bug441081/Bug441081.xtend' -> '''
				package bug441081

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				interface GenericInterface {
					def <T> T m()
				}
				
				@Active(Bug441081Processor)
				annotation Bug441081 {
				}
				
				class Bug441081Processor extends AbstractClassProcessor {
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						annotatedClass.implementedInterfaces = annotatedClass.implementedInterfaces + #[findTypeGlobally(GenericInterface).newTypeReference]
						annotatedClass.addMethod("m") [
							returnType = addTypeParameter("T", object).newTypeReference
							body = '«»''return null;'«»''
							primarySourceElement = annotatedClass
						]
					}
				}
			''',
			'Bug441081Client.xtend' -> '''
				import bug441081.Bug441081
				
				@Bug441081
				class Bug441081Client {
				}
			'''
		) [
			val c = typeLookup.findClass("Bug441081Client")
			val typeParam = c.findDeclaredMethod('m').returnType.type as TypeParameterDeclaration
			assertFalse(typeParam.upperBounds.empty)
			validator.assertNoIssues(xtendFile)
		]
	}
	
	@Test def void testInferredMethodReturnType() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor extends AbstractMethodProcessor {
				
					override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
						annotatedMethod.declaringType.addField(annotatedMethod.simpleName + '_field') [
							type = annotatedMethod.returnType
						]
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnnotation
				
				class Client {
				
					@MyAnnotation
					def bar() {
						1
					}
				
					@MyAnnotation
					def create new Integer(1) foo() {
					}
				
				}
			'''
		) [
			val foo = typeLookup.findClass("myusercode.Client")
			
			val barType = foo.findDeclaredField('bar_field').type
			assertSameType(barType, typeReferenceProvider.primitiveInt)
			assertSameType(barType, foo.findDeclaredMethod('bar').returnType)
			
			val fooType = foo.findDeclaredField('foo_field').type
			assertSameType(fooType, typeReferenceProvider.newTypeReference(Integer))
			assertSameType(fooType, foo.findDeclaredMethod('foo').returnType)
		]
	}
	
	@Test def void testTracing() {
		assertProcessing(
			'myannotation/Getters.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(GettersProcessor)
				annotation Getters {
				}
				
				class GettersProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
						cls.declaredFields.filter[isThePrimaryGeneratedJavaElement].forEach [field|
							cls.addMethod("get" + field.simpleName.toFirstUpper) [
								primarySourceElement = field
								returnType = field.type
								body = ["return this." + field.simpleName + ";"]
								field.markAsRead
							]
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.Getters
				
				@Getters
				class Client {
				
					val int bar = 1
				
					def create new Integer(1) foo() {
					}
				
				}
			'''
		) [
			val cls = typeLookup.findClass("myusercode.Client")
			val barField = cls.findDeclaredField("bar")
			val getters = cls.declaredMethods.filter[simpleName.startsWith("get")]
			assertEquals(1, getters.size)
			val getBar = getters.head
			assertEquals("getBar", getBar.simpleName)
			
			val barJvmField = (barField as MutableJvmFieldDeclarationImpl).delegate
			val getBarJvmMethod = (getBar as MutableJvmMethodDeclarationImpl).delegate
			val elementsAssociatedWithBarField = jvmModelAssociations.getJvmElements(jvmModelAssociations.getPrimarySourceElement(barJvmField))
			
			assertEquals(2, elementsAssociatedWithBarField.size)
			assertEquals(barJvmField, elementsAssociatedWithBarField.get(0))
			assertEquals(getBarJvmMethod, elementsAssociatedWithBarField.get(1))
		]
	}

	@Test def void testTracing2() {
		assertProcessing(
			'myannotation/MyAnno.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.Active
				
				@Active(MyAnnoProcessor)
				annotation MyAnno {}
				
				class MyAnnoProcessor extends AbstractClassProcessor {
					override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
						cls.addMethod("foo") [
							primarySourceElement = cls.typeParameters.head
							body = ["return;"]
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnno
				
				@MyAnno
				class Client<A> {}
			'''
		) [
			val cls = typeLookup.findClass("myusercode.Client")
			val fooMethod = cls.findDeclaredMethod("foo")
			val typeParameter = tracability.getPrimarySourceElement(cls.typeParameters.head)
			assertEquals(typeParameter, tracability.getPrimarySourceElement(fooMethod))
		]
	}

	@Test def void testTracing3() {
		assertProcessing(
			'myannotation/MyAnno.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.Active
				
				@Active(MyAnnoProcessor)
				annotation MyAnno {}
				
				class MyAnnoProcessor extends AbstractClassProcessor {
					override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
						cls.addMethod("foo") [
							primarySourceElement = cls.extendedClass
							body = ["return;"]
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnno
				
				@MyAnno
				class Client extends Object{}
			'''
		) [
			val cls = typeLookup.findClass("myusercode.Client")
			val fooMethod = cls.findDeclaredMethod("foo")
			val extendsClause = tracability.getPrimarySourceElement(cls.extendedClass)
			assertTrue(extendsClause instanceof TypeReference)
			assertEquals(extendsClause, tracability.getPrimarySourceElement(fooMethod as Element))
		]
	}

	@Test def void testTracing4() {
		assertProcessing(
			'myannotation/MyAnno.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.Active
				
				@Active(MyAnnoProcessor)
				annotation MyAnno {}
				
				class MyAnnoProcessor extends AbstractClassProcessor {
					override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
						cls.addMethod("foo") [
							primarySourceElement = cls.annotations.head
							body = ["return;"]
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.MyAnno
				
				@MyAnno
				class Client extends Object{}
			'''
		) [
			val cls = typeLookup.findClass("myusercode.Client")
			val fooMethod = cls.findDeclaredMethod("foo")
			val anno = tracability.getPrimarySourceElement(cls.annotations.head)
			assertTrue(anno instanceof AnnotationReference)
			assertEquals(anno, tracability.getPrimarySourceElement(fooMethod as Element))
		]
	}
	
	@Test def void testValidationPhase() {
		assertProcessing(
			'myannotation/ValidatingAnnotation.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.ValidationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				
				@Active(ValidatingProcessor)
				annotation ValidatingAnnotation {
					
				}
				
				class ValidatingProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
						cls.addWarning("Foo")
						cls.addWarning("Bar")
					}
					
					override doValidate(ClassDeclaration cls, extension ValidationContext context) {
						cls.addWarning("Baz")
						cls.addWarning("There were " + cls.problems.size + " problems")
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@ValidatingAnnotation
				class Foo {
				}
			'''
		)[
			val cls = typeLookup.findClass("myusercode.Foo")
			val problems = problemSupport.getProblems(cls)
			assertEquals(4, problems.size)
			assertEquals("Foo", problems.get(0).message)
			assertEquals("Bar", problems.get(1).message)
			assertEquals("Baz", problems.get(2).message)
			assertEquals("There were 3 problems", problems.get(3).message)
		]
	}
	
	@Test def void testValidateLater() {
		assertProcessing(
			'myannotation/ValidateLater.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				
				@Active(ValidateLaterProcessor)
				annotation ValidateLater {
				}
				
				class ValidateLaterProcessor extends AbstractFieldProcessor {
				
					override doTransform(MutableFieldDeclaration it, extension TransformationContext context) {
						validateLater[ |
							if (type == primitiveBoolean)
								addWarning("The type was inferred and boolean")
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				class Foo {
					@ValidateLater val foo = true
				}
			'''
		)[
			val cls = typeLookup.findClass("myusercode.Foo")
			val problems = problemSupport.getProblems(cls.declaredFields.head)
			assertEquals(1, problems.size)
			assertEquals("The type was inferred and boolean", problems.get(0).message)
		]
	}
	
	@Test
	def void testNoMutationInValidationPhase() {
		assertProcessing(
			'myannotation/EvilAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.ValidationParticipant
				import org.eclipse.xtend.lib.macro.ValidationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.TransformationContext
				
				@Active(EvilProcessor)
				annotation EvilAnnotation {
					
				}
				
				class EvilProcessor implements TransformationParticipant<MutableClassDeclaration>, ValidationParticipant<MutableClassDeclaration> {
					
					override doTransform(List<? extends MutableClassDeclaration> classes, extension TransformationContext context) {
						classes.forEach[
							final = false
						]
					}
					
					override doValidate(List<? extends MutableClassDeclaration> classes, extension ValidationContext context) {
						classes.forEach[
							final = true
						]
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import myannotation.*
				
				@EvilAnnotation
				class Foo {
				}
			'''
		)[
			xtendFile.eResource.errors.exists[message.contains('cannot be modified')]
		]
	}
	
	@Test def void testSetEmptyListAsAnnotationValue() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
					
				}
				
				annotation Values {
					int[] intValue
					long[] longValue
					short[] shortValue
					double[] doubleValue
					float[] floatValue
					byte[] byteValue
					boolean[] booleanValue
					char[] charValue
					String[] stringValue
					Class<?>[] classValue
					Enum1[] enumValue
					Annotation2[] annotationValue
				}
				
				enum Enum1 {}
				annotation Annotation2 {}

				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
						removeAnnotation(annotations.head)
						addAnnotation(Values.newAnnotationReference [
							setIntValue('intValue', emptyList)
							setLongValue('longValue', emptyList)
							setShortValue('shortValue', emptyList)
							setDoubleValue('doubleValue', emptyList)
							setFloatValue('floatValue', emptyList)
							setByteValue('byteValue', emptyList)
							setBooleanValue('booleanValue', emptyList)
							setCharValue('charValue', emptyList)
							setStringValue('stringValue', emptyList)
							setClassValue('classValue', emptyList)
							setEnumValue('enumValue', emptyList)
							setAnnotationValue('annotationValue', emptyList)
						])
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@MyAnnotation
				class Foo {
				}
			'''
		) [
			val foo = typeLookup.findClass("myusercode.Foo")
			val annotationType = typeLookup.findTypeGlobally("myannotation.Values")
			val values = foo.findAnnotation(annotationType)
			assertEquals(0, values.getIntArrayValue('intValue').size)
			assertEquals(0, values.getLongArrayValue('longValue').size)
			assertEquals(0, values.getShortArrayValue('shortValue').size)
			assertEquals(0, values.getDoubleArrayValue('doubleValue').size)
			assertEquals(0, values.getFloatArrayValue('floatValue').size)
			assertEquals(0, values.getByteArrayValue('byteValue').size)
			assertEquals(0, values.getBooleanArrayValue('booleanValue').size)
			assertEquals(0, values.getCharArrayValue('charValue').size)
			assertEquals(0, values.getStringArrayValue('stringValue').size)
			assertEquals(0, values.getClassArrayValue('classValue').size)
			assertEquals(0, values.getEnumArrayValue('enumValue').size)
			assertEquals(0, values.getAnnotationArrayValue('annotationValue').size)
		]
	}
	
	@Test def void testInferredTypeReferences() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
					Class<?> value
				}
				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
						for (field : declaredFields) {
							addMethod(field.simpleName) [
								returnType = field.type
								body = ['return 1;']
							]
						}
				
						val myAnnotation = findAnnotation(MyAnnotation.findTypeGlobally)
						val type = myAnnotation.getClassValue("value").type as ClassDeclaration
						for (field : type.declaredFields) {
							addMethod(field.simpleName) [
								returnType = field.type
								body = ['return 1;']
							]
						}
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@MyAnnotation(Bar)
				class Foo {
					val y = 1
				}
				
				class Bar {
					val x = 1
				}
			'''
		) [
			val foo = typeLookup.findClass("myusercode.Foo")
			val bar = typeLookup.findClass("myusercode.Bar")
			
			assertSameType(foo.findDeclaredField('y').type, foo.findDeclaredMethod('y').returnType)
			assertSameType(bar.findDeclaredField('x').type, foo.findDeclaredMethod('x').returnType)
		]
	}
	
	@Test def void testAnnotationValueSetting_1() {
		assertProcessing(
			'myannotation/ConfigurableAnnotation.xtend' -> '''
				package myannotation

				import java.util.List
				import org.eclipse.xtend.lib.macro.*
				import org.eclipse.xtend.lib.macro.declaration.*
				
				@Active(ConfigurableAnnotationProcessor)
				annotation ConfigurableAnnotation {
					BlackOrWhite color
					BlackOrWhite[] colors
					Class<?> type
					Class<?>[] types
					SomeAnnotation annotation
					SomeAnnotation[] annotations
				}

				annotation SomeAnnotation {
					boolean value
				}
				
				enum BlackOrWhite {
					BLACK, WHITE
				}
				
				class ConfigurableAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val anno = annotatedClass.annotations.head
						val someAnnotationType = findTypeGlobally(SomeAnnotation)
						val enumType = findTypeGlobally('myannotation.BlackOrWhite') as EnumerationTypeDeclaration
						val white = enumType.findDeclaredValue('WHITE')
						val black = enumType.findDeclaredValue('BLACK')
						
						val existingValue = anno.getValue('color')
						if (existingValue != white)
							throw new AssertionError("color")
						
						val annoWithColor = annotatedClass.addAnnotation(newAnnotationReference(anno) [
							setEnumValue('color', black)
						])
						annotatedClass.removeAnnotation(anno)
						
						val existingColorsValue = annoWithColor.getValue('colors') as Object[]
						if (existingColorsValue.get(0) != white && existingColorsValue.get(1) != black && existingColorsValue.length != 2)
							throw new AssertionError("colors")
						
						val annoWithColors = annotatedClass.addAnnotation(newAnnotationReference(annoWithColor) [
							setEnumValue('colors', black, white)
						])
						annotatedClass.removeAnnotation(annoWithColor)
						
						val existingType = annoWithColors.getValue('type')
						if (existingType != string)
							throw new AssertionError("type")
						
						val annoWithType = annotatedClass.addAnnotation(newAnnotationReference(annoWithColors) [
							setClassValue('type', annotatedClass.newTypeReference)
						])
						annotatedClass.removeAnnotation(annoWithColors)
						
						val existingTypes = annoWithType.getValue('types') as Object[]
						if (existingTypes.get(0) != primitiveInt && existingTypes.get(1) != annotatedClass.newTypeReference && existingTypes.length != 2)
							throw new AssertionError("types")
						
						val annoWithTypes = annotatedClass.addAnnotation(newAnnotationReference(annoWithType) [
							setClassValue('types', primitiveBoolean)
						])
						annotatedClass.removeAnnotation(annoWithType)
						
						val annotationReference = annoWithTypes.getAnnotationValue('annotation')
						if (someAnnotationType != annotationReference.annotationTypeDeclaration)
							throw new AssertionError("someAnnotationType != annotationReference.annotationTypeDeclaration")
						
						val annoWithAnnotation = annotatedClass.addAnnotation(newAnnotationReference(annoWithTypes) [
							setAnnotationValue('annotation', 
								newAnnotationReference(someAnnotationType) [
									setBooleanValue('value', false)
								]
							)
						])
						annotatedClass.removeAnnotation(annoWithTypes)
						
						val annotationReferences = annoWithAnnotation.getAnnotationArrayValue('annotations')
						if (annotationReferences.size != 2)
							throw new AssertionError("annotationReferences.size != 2")
						
						annotationReferences.forEach [
							if (someAnnotationType != annotationTypeDeclaration)
								throw new AssertionError("someAnnotationType != annotationTypeDeclaration")
						]
						
						annotatedClass.addAnnotation(newAnnotationReference(annoWithAnnotation) [
							setAnnotationValue('annotations', 
								newAnnotationReference(someAnnotationType) [
									setBooleanValue('value', false)
								],
								newAnnotationReference(someAnnotationType) [
									setBooleanValue('value', false)
								]
							)
						])
						annotatedClass.removeAnnotation(annoWithAnnotation)
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@ConfigurableAnnotation(
					color=BlackOrWhite.WHITE, 
					colors=#[BlackOrWhite.WHITE, BlackOrWhite.BLACK], 
					type = String, 
					types=#[Integer, MyClass],
					annotation=@SomeAnnotation(true),
					annotations=#[@SomeAnnotation(true), @SomeAnnotation(true)]
				)
				class MyClass {
				}
			'''
		) [
			val clazz = typeLookup.findClass("myusercode.MyClass")
			val colorEnum = typeLookup.findTypeGlobally("myannotation.BlackOrWhite") as EnumerationTypeDeclaration
			val annotationType = typeLookup.findTypeGlobally("myannotation.ConfigurableAnnotation")
			val annotation = clazz.findAnnotation(annotationType)
			
			assertEquals(colorEnum.findDeclaredValue('BLACK'), annotation.getValue('color'))
			
			val colors = annotation.getValue('colors') as Object[]
			assertEquals(2, colors.length)
			assertEquals(colorEnum.findDeclaredValue('BLACK'), colors.get(0))
			assertEquals(colorEnum.findDeclaredValue('WHITE'), colors.get(1))
			
			assertEquals(typeReferenceProvider.newTypeReference(clazz), annotation.getValue('type'))
			
			val types = annotation.getClassArrayValue('types')
			assertEquals(1, types.length)
			assertEquals(typeReferenceProvider.primitiveBoolean, types.get(0))
			
			val someAnnotationType = typeLookup.findTypeGlobally('myannotation.SomeAnnotation')
			val annotationValue = annotation.getAnnotationValue('annotation')
			assertNotNull(annotationValue)
			assertEquals(someAnnotationType, annotationValue.annotationTypeDeclaration)
			assertFalse(annotationValue.getBooleanValue('value'))
			
			val annotationsValue = annotation.getAnnotationArrayValue('annotations')
			assertNotNull(annotationsValue)
			assertEquals(2, annotationsValue.size)
			for (it : annotationsValue) {
				assertEquals(someAnnotationType, annotationValue.annotationTypeDeclaration)
				assertFalse(annotationValue.getBooleanValue('value'))
			}
		]
	}
	
	@Test def void testAnnotationValueSetting_2() {
		assertProcessing(
			'myannotation/ConfigurableAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.*
				import org.eclipse.xtend.lib.macro.declaration.*
				
				@Active(ConfigurableAnnotationProcessor)
				annotation ConfigurableAnnotation {
					int someValue
				}
				
				class Constants {
					public static val int MYCONSTANT = Integer.MAX_VALUE - 42
				}
				
				class ConfigurableAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val anno = annotatedClass.annotations.head
						
						val existingValue = anno.getValue('someValue')
						
						annotatedClass.docComment = ''+existingValue
					}
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode

				import myannotation.*
				
				@ConfigurableAnnotation(someValue=MoreConstants.MY_CONSTANT * 1)
				class MyClass {
				}
				
				class MoreConstants {
					public static val int MY_CONSTANT = myannotation.Constants.MYCONSTANT - Integer.MAX_VALUE + 42 * 2
				}
			'''
		) [
			val clazz = typeLookup.findClass("myusercode.MyClass")
			assertEquals("42",clazz.docComment)
		]
	}
	
	@Test def void testAnnotationValueSetting_3() {
		assertProcessing(
			'myannotation/MoveValues.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MoveAnnotationValuesProcessor)
				annotation MoveValues {}
				
				class MoveAnnotationValuesProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val classAnnotation = annotatedClass.annotations.head
						
						val field = annotatedClass.declaredFields.head
						val fieldAnnotation = field.annotations.head
						field.removeAnnotation(fieldAnnotation)
						
						field.addAnnotation(fieldAnnotation.annotationTypeDeclaration.qualifiedName.newAnnotationReference [
							set('booleanValue', classAnnotation.getValue('booleanValue'))
							set('intValue', classAnnotation.getValue('intValue'))
							set('longValue', classAnnotation.getValue('longValue'))
							set('stringValue', classAnnotation.getValue('stringValue'))
							set('booleanArrayValue', classAnnotation.getValue('booleanArrayValue'))
							set('intArrayValue', classAnnotation.getValue('intArrayValue'))
							set('longArrayValue', classAnnotation.getValue('longArrayValue'))
							set('stringArrayValue', classAnnotation.getValue('stringArrayValue'))
							set('typeValue', classAnnotation.getValue('typeValue'))
							set('typeArrayValue', classAnnotation.getValue('typeArrayValue'))
							set('annotation2Value', classAnnotation.getValue('annotation2Value'))
							set('annotation2ArrayValue', classAnnotation.getValue('annotation2ArrayValue'))
							set('enumValue', classAnnotation.getValue('enumValue'))
							set('enumArrayValue', classAnnotation.getValue('enumArrayValue'))
						])
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import test.Annotation
				import test.Annotation2
				import myannotation.MoveValues
				
				@Annotation(
					intValue = 2 / 2 + 2 * 3 - 4 % 1,
					longValue = 42 + 4 + 6 * 42 - 4 / 45,
					stringValue = 'foo' + 'baz',
					booleanArrayValue = #[true, false],
					intArrayValue = #[ -1, 34 + 45, 2 - 6 ],
					longArrayValue = #[42, 5 * -3],
					stringArrayValue = #['foo', 'bla' + 'buzz'],
					typeValue = String,
					typeArrayValue = #[String, Integer],
					annotation2Value = @Annotation2('foo' + 'wuppa'),
					annotation2ArrayValue = #[@Annotation2, @Annotation2('foo'+'wuppa')],
					enumValue = test.Enum1.YELLOW,
					enumArrayValue = #[test.Enum1.YELLOW, test.Enum1.RED]
				)
				@MoveValues 
				class UserCode {
					@Annotation() String foo
				}
			'''
		) [
			val clazz = typeLookup.findClass("myusercode.UserCode")
			val annoRef = clazz.declaredFields.head.annotations.head
			
			assertEquals(2 / 2 + 2 * 3 - 4 % 1, annoRef.getValue("intValue"))
			assertEquals((42 + 4 + 6 * 42 - 4 / 45) as long, annoRef.getValue("longValue"))
			assertEquals('foobaz', annoRef.getValue("stringValue"))
			
			val bools = annoRef.getValue("booleanArrayValue") as boolean[]
			assertTrue(bools.get(0))
			assertFalse(bools.get(1))
			
			assertArrayEquals(#[ -1, 34 + 45, 2 - 6 ], annoRef.getValue("intArrayValue") as int[])
			
			val type = annoRef.getValue('typeArrayValue') as TypeReference[]
			
			assertEquals(typeReferenceProvider.newTypeReference(Integer), type.get(1)) 
			
			val anno = annoRef.getValue('annotation2Value') as AnnotationReference
			assertEquals('foowuppa', anno.getValue('value'))
			
			val annoArray = annoRef.getValue('annotation2ArrayValue') as AnnotationReference[]
			assertEquals("HUBBA BUBBA!", annoArray.get(0).getValue('value'))
			
			val enum1 = annoRef.getValue('enumValue') as EnumerationValueDeclaration
			assertEquals('YELLOW', enum1.simpleName)
			
			val enumArray = annoRef.getValue('enumArrayValue') as EnumerationValueDeclaration[]
			assertEquals("YELLOW", enumArray.head.simpleName)
		]
	}
	
	@Test def void testAnnotationArrayValueGetting_01() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
					boolean[] value
				}
				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doRegisterGlobals(ClassDeclaration it, extension RegisterGlobalsContext context) {
						check
					}
				
					override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
						check
					}
				
					def check(ClassDeclaration it) {
						switch qualifiedName {
							case 'myusercode.UserCode',
							case 'myusercode.UserCode2',
							case 'myusercode.UserCode4': {
								val value = annotations.head.getBooleanArrayValue("value")
								if (value.size != 1) {
									throw new AssertionError("value.size != 1")
								}
								if (!value.head) {
									throw new AssertionError("!value.head")
								}
								try {
									annotations.head.getBooleanValue("value")
									throw new AssertionError('annotations.head.getBooleanValue("value")')
								} catch (Exception e) {
								}
							}
							case 'myusercode.UserCode3',
							case 'myusercode.UserCode5': {
								val value = annotations.head.getBooleanArrayValue("value")
								if (value.size != 2) {
									throw new AssertionError("value.size != 2")
								}
								if (!value.head) {
									throw new AssertionError("!value.head")
								}
								if (value.last) {
									throw new AssertionError("value.last")
								}
								try {
									annotations.head.getBooleanValue("value")
									throw new AssertionError('annotations.head.getBooleanValue("value")')
								} catch (Exception e) {
								}
							}
							default:
								throw new AssertionError('Unexpected type: ' + qualifiedName)
						}
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import myannotation.MyAnnotation
				
				@MyAnnotation(true)
				class UserCode {}
				
				@MyAnnotation(#[true])
				class UserCode2 {}
				
				@MyAnnotation(true, false)
				class UserCode3 {}
				
				@MyAnnotation(value=true)
				class UserCode4 {
				}
				
				@MyAnnotation(value=#[true, false])
				class UserCode5 {
				}
			'''
		) []
	}
	
	@Test def void testAnnotationArrayValueGetting_02() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
					Class<?>[] value
				}
				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doRegisterGlobals(ClassDeclaration it, extension RegisterGlobalsContext context) {
						check
					}
				
					override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
						check
					}
				
					def check(ClassDeclaration it) {
						switch qualifiedName {
							case 'myusercode.UserCode',
							case 'myusercode.UserCode2',
							case 'myusercode.UserCode4': {
								val value = annotations.head.getClassArrayValue("value")
								if (value.size != 1) {
									throw new AssertionError("value.size != 1")
								}
								if (value.head.name != 'java.lang.String') {
									throw new AssertionError("value.head.name != 'java.lang.String'")
								}
								try {
									annotations.head.getClassValue("value")
									throw new AssertionError('annotations.head.getClassValue("value")')
								} catch (Exception e) {
								}
							}
							case 'myusercode.UserCode3',
							case 'myusercode.UserCode5': {
								val value = annotations.head.getClassArrayValue("value")
								if (value.size != 2) {
									throw new AssertionError("value.size != 2")
								}
								if (value.head.name != 'java.lang.String') {
									throw new AssertionError("value.head.name != 'java.lang.String'")
								}
								if (value.last.name != 'java.lang.Integer') {
									throw new AssertionError("value.last.name != 'java.lang.Integer'")
								}
								try {
									annotations.head.getClassValue("value")
									throw new AssertionError('annotations.head.getClassValue("value")')
								} catch (Exception e) {
								}
							}
							default:
								throw new AssertionError('Unexpected type: ' + qualifiedName)
						}
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import myannotation.MyAnnotation
				
				@MyAnnotation(String)
				class UserCode {}
				
				@MyAnnotation(#[String])
				class UserCode2 {}
				
				@MyAnnotation(String, Integer)
				class UserCode3 {}
				
				@MyAnnotation(value=String)
				class UserCode4 {
				}
				
				@MyAnnotation(value=#[String, Integer])
				class UserCode5 {
				}
			'''
		) []
	}
	
	@Ignore("Setting annotation values of type Expression is not possible")
	@Test def void testAnnotationValueSetting_AsExpression() {
		assertProcessing(
			'myannotation/MoveValues.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				
				@Active(MoveAnnotationValuesProcessor)
				annotation MoveValues {}
				
				class MoveAnnotationValuesProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val classAnnotation = annotatedClass.annotations.head
						
						val field = annotatedClass.declaredFields.head
						val fieldAnnotation = field.annotations.head
						field.removeAnnotation(fieldAnnotation)
						
						field.addAnnotation(fieldAnnotation.annotationTypeDeclaration.qualifiedName.newAnnotationReference [
							set('booleanValue', classAnnotation.getExpression('booleanValue'))
							set('intValue', classAnnotation.getExpression('intValue'))
							set('longValue', classAnnotation.getExpression('longValue'))
							set('stringValue', classAnnotation.getExpression('stringValue'))
							set('booleanArrayValue', classAnnotation.getExpression('booleanArrayValue'))
							set('intArrayValue', classAnnotation.getExpression('intArrayValue'))
							set('longArrayValue', classAnnotation.getExpression('longArrayValue'))
							set('stringArrayValue', classAnnotation.getExpression('stringArrayValue'))
							set('typeValue', classAnnotation.getExpression('typeValue'))
							set('typeArrayValue', classAnnotation.getExpression('typeArrayValue'))
							set('annotation2Value', classAnnotation.getExpression('annotation2Value'))
							set('annotation2ArrayValue', classAnnotation.getExpression('annotation2ArrayValue'))
							set('enumValue', classAnnotation.getExpression('enumValue'))
							set('enumArrayValue', classAnnotation.getExpression('enumArrayValue'))
						])
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import test.Annotation
				import test.Annotation2
				import myannotation.MoveValues
				
				@Annotation(
					intValue = 2 / 2 + 2 * 3 - 4 % 1,
					longValue = 42 + 4 + 6 * 42 - 4 / 45,
					stringValue = 'foo' + 'baz',
					booleanValue = true,
					booleanArrayValue = #[true, false],
					intArrayValue = #[ -1, 34 + 45, 2 - 6 ],
					longArrayValue = #[42, 5 * -3],
					stringArrayValue = #['foo', 'bla' + 'buzz'],
					typeValue = String,
					typeArrayValue = #[String, Integer],
					annotation2Value = @Annotation2('foo' + 'wuppa'),
					annotation2ArrayValue = #[@Annotation2, @Annotation2('foo'+'wuppa')],
					enumValue = test.Enum1.YELLOW,
					enumArrayValue = #[test.Enum1.YELLOW, test.Enum1.RED]
				)
				@MoveValues 
				class UserCode {
					@Annotation() String foo
				}
			'''
		) [
			val clazz = typeLookup.findClass("myusercode.UserCode")
			val annoRef = clazz.declaredFields.head.annotations.head
			
			assertEquals(2 / 2 + 2 * 3 - 4 % 1, annoRef.getValue("intValue"))
			assertEquals((42 + 4 + 6 * 42 - 4 / 45) as long, annoRef.getValue("longValue"))
			assertEquals('foobaz', annoRef.getValue("stringValue"))
			
			assertTrue(annoRef.getValue("booleanValue") as Boolean)
			val bools = annoRef.getValue("booleanArrayValue") as boolean[]
			assertTrue(bools.get(0))
			assertFalse(bools.get(1))
			
			assertArrayEquals(#[ -1, 34 + 45, 2 - 6 ], annoRef.getValue("intArrayValue") as int[])
			
			val type = annoRef.getValue('typeArrayValue') as TypeReference[]
			
			assertEquals(typeReferenceProvider.newTypeReference(Integer), type.get(1)) 
			
			val anno = annoRef.getValue('annotation2Value') as AnnotationReference
			assertEquals('foowuppa', anno.getValue('value'))
			
			val annoArray = annoRef.getValue('annotation2ArrayValue') as AnnotationReference[]
			assertEquals("HUBBA BUBBA!", annoArray.get(0).getValue('value'))
			
			val enum1 = annoRef.getValue('enumValue') as EnumerationValueDeclaration
			assertEquals('YELLOW', enum1.simpleName)
			
			val enumArray = annoRef.getValue('enumArrayValue') as EnumerationValueDeclaration[]
			assertEquals("YELLOW", enumArray.head.simpleName)
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
								value.addAnnotation(Deprecated.newAnnotationReference)
								checkState(value.annotations.size == 1, value.annotations.size != 1)
							}
							enumeration.addValue("D") [
								addAnnotation(Deprecated.newAnnotationReference)
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
						val annotationReference = clazz.findAnnotation(RemoveAnnotation.newTypeReference.type)
						clazz.removeAnnotation(annotationReference)
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
			assertEquals(1, clazz.annotations.size)
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
	
	@Test def void testMarkAsDeprecated() {
		assertGeneratedCode(
			'myannotation/AddDispatchCaseAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.Visibility
				
				@Active(MarkAsDeprecatedProcessor)
				annotation MarkAsDeprecated{ }
				class MarkAsDeprecatedProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.deprecated = true
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.MarkAsDeprecated class MyClass {
				}
			''',
			'''
				package myusercode;
				
				import myannotation.MarkAsDeprecated;
				
				@MarkAsDeprecated
				@Deprecated
				@SuppressWarnings("all")
				public class MyClass {
				}
			'''
		)
	}
	
	@Test def void testMarkAsDeprecated_02() {
		assertGeneratedCode(
			'myannotation/AddDispatchCaseAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.Visibility
				
				@Active(UnmarkDeprecatedProcessor)
				annotation UnmarkDeprecated{ }
				class UnmarkDeprecatedProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.deprecated = false
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.UnmarkDeprecated @Deprecated class MyClass {
				}
			''',
			'''
				package myusercode;
				
				import myannotation.UnmarkDeprecated;
				
				@UnmarkDeprecated
				@SuppressWarnings("all")
				public class MyClass {
				}
			'''
		)
	}

	@Test def void testAddDispatchCase() {
		assertGeneratedCode(
			'myannotation/AddDispatchCaseAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.Visibility
				
				@Active(AddDispatchCaseProcessor)
				annotation AddDispatchCase{ }
				class AddDispatchCaseProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						clazz.addMethod('_m') [
							addParameter("foo", string)
							visibility = Visibility.PROTECTED
							returnType = string
							body = '«»''return null;''«»'
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AddDispatchCase class MyClass {
					def dispatch m(Integer i) { return null }
				}
			''',
			'''
				package myusercode;
				
				import java.util.Arrays;
				import myannotation.AddDispatchCase;
				
				@AddDispatchCase
				@SuppressWarnings("all")
				public class MyClass {
				  protected String _m(final Integer i) {
				    return null;
				  }
				  
				  public String m(final Object i) {
				    if (i instanceof Integer) {
				      return _m((Integer)i);
				    } else if (i instanceof String) {
				      return _m((String)i);
				    } else {
				      throw new IllegalArgumentException("Unhandled parameter types: " +
				        Arrays.<Object>asList(i).toString());
				    }
				  }
				  
				  protected String _m(final String foo) {
				    return null;
				  }
				}
			'''
		)
	}
	
	@Test def void testChangeDispatchHierachy() {
		assertGeneratedCode(
			'myannotation/AddDispatchCaseAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(MyDeriveParticipant)
				annotation MyDerive {}
				class MyDeriveParticipant extends AbstractClassProcessor {
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						annotatedClass.setExtendedClass(newTypeReference(Base))
					}
				}
				class Base {
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class Derived1 extends myannotation.Base {
				}
				@myannotation.MyDerive
				class Derived2 {
				}
				@myannotation.MyDerive
				class Derived3 {
				}
				class D1 {
					def dispatch void m(myannotation.Base b) {
					}
				}
				class D2 extends D1 {
					def dispatch m(Derived1 d) {
					}
					def dispatch m(Derived2 d) {
					}
					def dispatch m(Derived3 d) {
					}
				}
			''',
			'''
				package myusercode;
				
				import myannotation.Base;
				
				@SuppressWarnings("all")
				public class Derived1 extends Base {
				}
			''',
			'''
				package myusercode;
				
				import myannotation.Base;
				import myannotation.MyDerive;
				
				@MyDerive
				@SuppressWarnings("all")
				public class Derived2 extends Base {
				}
			''',
			'''
				package myusercode;
				
				import myannotation.Base;
				import myannotation.MyDerive;
				
				@MyDerive
				@SuppressWarnings("all")
				public class Derived3 extends Base {
				}
			''',
			'''
				package myusercode;
				
				import myannotation.Base;
				
				@SuppressWarnings("all")
				public class D1 {
				  protected void _m(final Base b) {
				  }
				  
				  public void m(final Base b) {
				    _m(b);
				    return;
				  }
				}
			''',
			'''
				package myusercode;
				
				import java.util.Arrays;
				import myannotation.Base;
				import myusercode.D1;
				import myusercode.Derived1;
				import myusercode.Derived2;
				import myusercode.Derived3;
				
				@SuppressWarnings("all")
				public class D2 extends D1 {
				  protected void _m(final Derived1 d) {
				  }
				  
				  protected void _m(final Derived2 d) {
				  }
				  
				  protected void _m(final Derived3 d) {
				  }
				  
				  public void m(final Base d) {
				    if (d instanceof Derived1) {
				      _m((Derived1)d);
				      return;
				    } else if (d instanceof Derived2) {
				      _m((Derived2)d);
				      return;
				    } else if (d instanceof Derived3) {
				      _m((Derived3)d);
				      return;
				    } else if (d != null) {
				      _m(d);
				      return;
				    } else {
				      throw new IllegalArgumentException("Unhandled parameter types: " +
				        Arrays.<Object>asList(d).toString());
				    }
				  }
				}
			'''
		)
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
	
	@Test def void testConstantExpressionEvaluation() {
		assertProcessing(
			'annotations/MyAnnotation.xtend' -> '''
				package annotations
				
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.Visibility
				
				@Active(Processor)
				annotation MyAnnotation {
					String value
				}
				
				class Processor extends AbstractClassProcessor {
					
					override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
						val value = annotatedClass.annotations.head.getValue('value') as String
						registerClass(annotatedClass.qualifiedName+'.'+value)
					}
					
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						val value = annotatedClass.annotations.head.getValue('value') as String
						val newClass = findClass(annotatedClass.qualifiedName+'.'+value)
						for (method : annotatedClass.declaredMethods) {
							method.addParameter(value, newClass.newTypeReference)
						}
						newClass.addField(value) [
							type = string
							visibility = Visibility.PUBLIC
							initializer = '«»''"FOO"'«»''
						]
					}
					
				}
			''',
			'application/MyAnnotation.xtend' -> '''
				package application
				
				import annotations.MyAnnotation
				
				@MyAnnotation("FOO") class MyClient {
					def myMethod() {
						FOO.FOO
					}
				}
			'''
		) [
			val clazz = typeLookup.findClass('application.MyClient.FOO')
			assertEquals("FOO",clazz.declaredFields.head.simpleName)
			
			val clazz2 = typeLookup.findClass('application.MyClient')
			assertEquals("FOO",clazz2.declaredMethods.head.parameters.head.simpleName)
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
	
	@Test def void testAnnotationDefaultValuesBug463161() {
		assertProcessing(
			'myannotation/AnnotationDefaultValues.xtend' -> '''
				package myannotation
				
				import java.util.List
				import java.lang.annotation.RetentionPolicy
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(AnnotationDefaultValuesProcessor)
				annotation AnnotationDefaultValues { }
				
				class AnnotationDefaultValuesProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration mutableClass, extension TransformationContext context) {
						val annotationRef = mutableClass.findAnnotation(findTypeGlobally(MyAnnotation))
						mutableClass.addField(annotationRef.getExpression('value')?.toString ?: 'wasNull') [
							type = string
						]
					}
					
				}
				annotation MyAnnotation {
					int value = 1
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AnnotationDefaultValues
				@myannotation.MyAnnotation
				class MyClass {}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			val field = clazz.declaredFields.head
			assertEquals('wasNull', field.simpleName)
		]
	}
	
	@Test def void testAnnotationDefaultValues_01() {
		assertProcessing(
			'myannotation/AnnotationDefaultValues.xtend' -> '''
				package myannotation
				
				import java.util.List
				import java.lang.annotation.RetentionPolicy
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(AnnotationDefaultValuesProcessor)
				annotation AnnotationDefaultValues { }
				
				class AnnotationDefaultValuesProcessor implements TransformationParticipant<MutableClassDeclaration> {
					
					override doTransform(List<? extends MutableClassDeclaration> annotationTargets, extension TransformationContext context) {
						annotationTargets.forEach[ annotationTarget |
						val annotation = annotationTarget.findAnnotation(findTypeGlobally(MyAnnotation))
						val strings = annotation.getStringArrayValue('value').map[ toString ]
						strings.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val booleans = annotation.getBooleanArrayValue('booleans').map[ toString ]
						booleans.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val types = annotation.getClassArrayValue('types').map[ toString ]
						types.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val policies = annotation.getEnumArrayValue('policies').map[ toString ]
						policies.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val nested = annotation.getAnnotationArrayValue('nested').map[ toString ]
						nested.forEach [ annotationTarget.addField(it) [ type = string ] ]
						]
					}
					
				}
				annotation MyAnnotation {
					String[] value = #[]
					boolean[] booleans = #[]
					Class<?>[] types = #[]
					RetentionPolicy[] policies = #[]
					Active[] nested = #[]
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AnnotationDefaultValues
				@myannotation.MyAnnotation
				class MyClass {}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertTrue(clazz.declaredFields.isEmpty)
		]
	}
	
	@Test def void testAnnotationDefaultValues_02() {
		assertProcessing(
			'myannotation/AnnotationDefaultValues.xtend' -> '''
				package myannotation
				
				import java.util.List
				import java.lang.annotation.RetentionPolicy
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(AnnotationDefaultValuesProcessor)
				annotation AnnotationDefaultValues { }
				
				class AnnotationDefaultValuesProcessor implements TransformationParticipant<MutableClassDeclaration> {
					
					override doTransform(List<? extends MutableClassDeclaration> annotationTargets, extension TransformationContext context) {
						annotationTargets.forEach[ annotationTarget |
						val annotation = annotationTarget.findAnnotation(findTypeGlobally(MyAnnotation))
						val strings = annotation.getStringArrayValue('value').map[ toString ]
						strings.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val booleans = annotation.getBooleanArrayValue('booleans').map[ toString ]
						booleans.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val types = annotation.getClassArrayValue('types').map[ toString ]
						types.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val policies = annotation.getEnumArrayValue('policies').map[ toString ]
						policies.forEach [ annotationTarget.addField(it) [ type = string ] ]
						
						val nested = annotation.getAnnotationArrayValue('nested').map[ toString ]
						nested.forEach [ annotationTarget.addField(it) [ type = string ] ]
						]
					}
					
				}
				annotation MyAnnotation {
					String[] value = #[]
					boolean[] booleans = #[]
					Class<?>[] types = #[]
					RetentionPolicy[] policies = #[]
					Active[] nested = #[]
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AnnotationDefaultValues
				@myannotation.MyAnnotation(
					value = #[],
					booleans = #[],
					types = #[],
					policies = #[],
					nested = #[]
				)
				class MyClass {}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			assertTrue(clazz.declaredFields.isEmpty)
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
							addAnnotation(
								MyAnnotation.findTypeGlobally.newAnnotationReference [
									set('value', #['foo', 'bar', 'baz'] as String[])
									set('singleValue', 'foo')
									set('booleans', #[true, false, true] as boolean[])
									set('singleBoolean', true)
									set('numbers', #[1, 2, 3] as int[])
									set('singleNumber', 1)
								])
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
				
				@myannotation.AddAnnotationValue
				class MyClass {}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.MyClass')
			val annotation = clazz.findAnnotation(
				typeReferenceProvider.newTypeReference('myannotation.MyAnnotation').type)
			assertArrayEquals(#['foo', 'bar', 'baz'] as String[], annotation.getValue('value') as String[])
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
	
	@Test def void testMarkReadAndInitialized() {
		assertProcessing(
			'myannotation/InitAnnotation.xtend' -> "
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				@Active(InitProcessor)
				annotation Init { }
				class InitProcessor implements TransformationParticipant<MutableFieldDeclaration> {
					
					override doTransform(List<? extends MutableFieldDeclaration> annotatedTargetFields, extension TransformationContext context) {
						val ctor = annotatedTargetFields.head.declaringType.addConstructor [
							primarySourceElement = declaringType
							body = ['''
								«FOR f : annotatedTargetFields»
									this.«f.simpleName» = \"foo\";
								«ENDFOR»
							''']
						]
						annotatedTargetFields.forEach [ field |
							field.setFinal(true)
							field.markAsRead
							field.markAsInitializedBy(ctor)
						]
					}
				}
			",
			'myusercode/MyClass.xtend' -> '''
				package myusercode
				
				class MyClass {
					
					@myannotation.Init String myField
				}
			'''
		) [
			val clazz = (typeLookup.findClass('myusercode.MyClass') as MutableJvmClassDeclarationImpl).delegate
			validator.assertNoIssues(clazz)
		]
	}
	
	@Test def void testMarkReadAndInitialized2() {
		assertProcessing(
			'myannotation/InitAnnotation.xtend' -> "
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

				@Active(InitProcessor)
				annotation Init { }
				class InitProcessor implements TransformationParticipant<MutableFieldDeclaration> {
					
					override doTransform(List<? extends MutableFieldDeclaration> annotatedTargetFields, extension TransformationContext context) {
						val ctor = annotatedTargetFields.head.declaringType.addConstructor [
							primarySourceElement = declaringType
							body = ['''
								«FOR f : annotatedTargetFields»
									this.«f.simpleName» = \"foo\";
								«ENDFOR»
							''']
						]
						annotatedTargetFields.forEach [ field |
							field.setFinal(true)
						]
					}
				}
			",
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					
					@myannotation.Init String myField
				}
			'''
		) [
			xtendFile.eResource.errors.exists[message.contains('myField may not have been initialized')]
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
	
	@Test def void testMovingComputedTypes() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
				
				@Active(Field2MethodProcessor)
				annotation Field2Method { }
				class Field2MethodProcessor implements TransformationParticipant<MutableFieldDeclaration> {
					
					override doTransform(List<? extends MutableFieldDeclaration> annotatedFields, extension TransformationContext context) {
						annotatedFields.forEach [ field |
							field.declaringType.addMethod(field.simpleName) [
								returnType = field.type
								body = field.initializer
							]
							field.remove
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					val foo = 'foo'
					@myannotation.Field2Method
					val x = foo
					@myannotation.Field2Method
					val y = x
				}
			'''
		) [
			val type = typeLookup.findClass('myusercode.MyClass')
			val method = type.declaredMethods.get(1)
			assertEquals('java.lang.String', method.returnType.name)
		]
	}
	
	@Test def void testMovingComputedTypes_02() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
				
				@Active(Method2FieldProcessor)
				annotation Method2Field { }
				class Method2FieldProcessor implements TransformationParticipant<MutableMethodDeclaration> {
					
					override doTransform(List<? extends MutableMethodDeclaration> annotatedMethods, extension TransformationContext context) {
						annotatedMethods.forEach [ method |
							method.declaringType.addField(method.simpleName) [
								type = method.returnType
								initializer = method.body
							]
							method.remove
						]
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				class MyClass {
					val foo = 'foo'
					@myannotation.Method2Field
					def x() { foo }
					@myannotation.Method2Field
					def y() { x }
				}
			'''
		) [
			val type = typeLookup.findClass('myusercode.MyClass')
			val field = type.declaredFields.get(1)
			assertEquals('java.lang.String', field.type.name)
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
	
	@Test def void testImportFromTypeReference_01() {
		assertGeneratedCode(
			'myannotation/AnnotationImportFromTypeReference.xtend' -> "
				package myannotation
				
				import java.text.DateFormat
				import java.text.SimpleDateFormat
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(AnnotationImportFromTypeReferenceProcessor)
				annotation AnnotationImportFromTypeReference { }
				class AnnotationImportFromTypeReferenceProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						annotatedClass.addField('myDateFormat') [
							type = DateFormat.newTypeReference
							initializer = '''new «SimpleDateFormat.newTypeReference»()'''
						]
					}
				}
			",
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.AnnotationImportFromTypeReference
				class MyClass {
				}
			''',
			'''
				package myusercode;
				
				import java.text.DateFormat;
				import java.text.SimpleDateFormat;
				import myannotation.AnnotationImportFromTypeReference;
				
				@AnnotationImportFromTypeReference
				@SuppressWarnings("all")
				public class MyClass {
				  private DateFormat myDateFormat = new SimpleDateFormat();
				}
			'''
		)
	}
	
	@Test def void testImportFromTypeReference_02() {
		assertGeneratedCode(
			'myannotation/AnnotationImportFromTypeReference.xtend' -> "
				package myannotation
				
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(AnnotationImportFromTypeReferenceProcessor)
				annotation AnnotationImportFromTypeReference { }
				class AnnotationImportFromTypeReferenceProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						annotatedClass.declaredFields.forEach [
							initializer = '''new «type.type»()'''
						]
					}
				}
			",
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import java.util.Timer
				
				@myannotation.AnnotationImportFromTypeReference
				class MyClass {
					Timer t
					MyClass child
				}
			''',
			'''
				package myusercode;
				
				import java.util.Timer;
				import myannotation.AnnotationImportFromTypeReference;
				
				@AnnotationImportFromTypeReference
				@SuppressWarnings("all")
				public class MyClass {
				  private Timer t = new Timer();
				  
				  private MyClass child = new MyClass();
				}
			'''
		)
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

	def void assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile, (CompilationUnitImpl)=>void expectations)
		
	def void assertGeneratedCode(Pair<String, String> macroFile, Pair<String, String> clientFile, String... compiledClientFiles) {
		assertProcessing(macroFile, clientFile) [
			val clientFilesAsSet = compiledClientFiles.map[LineDelimiters.toUnix(it)].toSet
			assertEquals(clientFilesAsSet.size, compiledClientFiles.length)
			val resource = it.xtendFile.eResource
			val jvmTypes = resource.contents.tail
			
			for (it : jvmTypes) {
				if (it instanceof JvmDeclaredType) {
					val generated = String.valueOf(generator.generateType(it, generatorConfigProvider.get(it)))
					if (!clientFilesAsSet.remove(generated)) {
						assertEquals('', 'Unexpected compiled code:\n' + generated + '\nExpected :\n' + clientFilesAsSet.join('\n'))
					}
				} else {
					throw new IllegalArgumentException(String.valueOf(it))
				}
			}
			if (!clientFilesAsSet.empty) {
				fail('Missing compiled code. Expected :\n' + clientFilesAsSet.join('\n'))
			}
		]
	}
		
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
	
	@Test def void testRemove() {
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation

				import com.google.common.base.Preconditions
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
				import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor implements TransformationParticipant<MutableNamedElement> {
				
					override doTransform(List<? extends MutableNamedElement> annotatedTargetElements,
						extension TransformationContext context) {
						for (annotatedTargetElement : annotatedTargetElements) {
							remove(annotatedTargetElement, context)
						}
					}
				
					def dispatch void remove(MutableNamedElement annotatedTargetElement, extension TransformationContext context) {
						val sourceElement = annotatedTargetElement.primarySourceElement
						Preconditions.checkState(sourceElement != null,
							'«»''a source element should not be null before removing, but: «'«'»sourceElement«'»'»'«»'')
						Preconditions.checkState(sourceElement.primaryGeneratedJavaElement == annotatedTargetElement,
							'«»''expected: «'«'»annotatedTargetElement«'»'», but: «'«'»sourceElement.primaryGeneratedJavaElement«'»'»'«»'')
				
						annotatedTargetElement.remove
				
						Preconditions.checkState(annotatedTargetElement.primarySourceElement == null,
							'«»''a source element should be null after removing, but: «'«'»annotatedTargetElement.primarySourceElement«'»'»'«»'')
						Preconditions.checkState(sourceElement.primaryGeneratedJavaElement == null,
							'«»''a target element should be null after removing, but: «'«'»sourceElement.primaryGeneratedJavaElement«'»'»'«»'')
				
						try {
							annotatedTargetElement.remove
							Preconditions.checkState(false, '«»''«'«'»IllegalArgumentException«'»'» is expected'«»'')
						} catch (IllegalStateException e) {
							Preconditions.checkState(e.message.startsWith("This element has already been removed: "),
								'«»''Wrong error message: «'«'»e.message«'»'»'«»'')
						}
					}
				
					def dispatch void remove(MutableTypeDeclaration annotatedTargetElement, extension TransformationContext context) {
						try {
							annotatedTargetElement.remove
							Preconditions.checkState(false, '«»''«'«'»UnsupportedOperationException«'»'» is expected'«»'')
						} catch (UnsupportedOperationException e) {
							Preconditions.checkState(e.message == "The type cannot be removed.", ''«»'Wrong error message: «'«'»e.message«'»'»'«»'')
						}
					}
				
				}

			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				import myannotation.MyAnnotation

				@MyAnnotation
				class UserClass {
				
					@MyAnnotation
					String fieldToRemove
				
					@MyAnnotation
					new(String arg) {
					}
				
					new(@MyAnnotation Integer argToRemove) {
					}
				
					@MyAnnotation
					def methodToRemove() {
					}
				
					@MyAnnotation
					static class NestedClass {
					}
				
					@MyAnnotation
					static interface NestedInteface {
					}
				
					@MyAnnotation
					static annotation NestedAnnotation {
					}
				
					@MyAnnotation
					static enum NestedEnum {
					}
				
				}
				
				@MyAnnotation
				enum UserEnum {
				}
				
				@MyAnnotation
				interface UserInterface {
					@MyAnnotation
					def String methodToRemove();
				}
				
				@MyAnnotation
				annotation UserAnnotation {
					@MyAnnotation
					String fieldToRemove
				}
			'''
		) [
			val clazz = typeLookup.findClass('myusercode.UserClass')
			assertNotNull(clazz)
			assertEquals(5, clazz.declaredMembers.size)
			
			val constructor = clazz.declaredConstructors.head
			assertNotNull(clazz)
			assertEquals(0, constructor.parameters.size)
			
			assertEquals(1, clazz.declaredMembers.filter(ClassDeclaration).size)
			assertEquals(1, clazz.declaredMembers.filter(InterfaceDeclaration).size)
			assertEquals(1, clazz.declaredMembers.filter(EnumerationTypeDeclaration).size)
			assertEquals(1, clazz.declaredMembers.filter(AnnotationTypeDeclaration).size)
			
			val enum = typeLookup.findEnumerationType('myusercode.UserEnum')
			assertNotNull(enum)
			
			val interface = typeLookup.findInterface('myusercode.UserInterface')
			assertNotNull(interface)
			assertEquals(0, interface.declaredMembers.size)
			
			val annotation = typeLookup.findAnnotationType('myusercode.UserAnnotation')
			assertNotNull(annotation)
			assertEquals(0, annotation.declaredMembers.size)
			
			val removedMethod= (tracability.getPrimarySourceElement(clazz) as ClassDeclaration).findDeclaredMethod('methodToRemove')
			val expression = (removedMethod.body as ExpressionImpl).delegate
			assertNull(logicalContainerProvider.getLogicalContainer(expression))
		]
	}
	
	@Test def void testMoveExpressionToTypeParameterDeclarator() {
		assertProcessing(
			'myannotation/AbstractAnnotation.xtend' -> '''
				package myannotation
				
				import java.lang.annotation.ElementType
				import java.lang.annotation.Target
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Target(ElementType.TYPE)
				@Active(SomeAnnotationProcessor)
				annotation SomeAnnotation {
				}
				
				class SomeAnnotationProcessor extends AbstractClassProcessor {
				
					static def copyMethod(MutableClassDeclaration clazz, MethodDeclaration method, extension TransformationContext context) {
				
						val methodDeclaration = clazz.addMethod(method.simpleName) [
							it.abstract = method.abstract
							it.docComment = method.docComment
							it.visibility = method.visibility
							it.synchronized = method.synchronized
							it.deprecated = method.deprecated
							it.static = method.static
							it.exceptions = method.exceptions
							it.varArgs = method.varArgs
							it.strictFloatingPoint = method.strictFloatingPoint
						]
				
						for (t : method.typeParameters) {
							val result = methodDeclaration.addTypeParameter(t.simpleName, t.upperBounds)
							result.primarySourceElement = t
						}
				
						methodDeclaration.returnType = method.returnType
				
						for (p : method.parameters) {
							methodDeclaration.addParameter(p.simpleName, p.type)
						}
				
						return methodDeclaration
				
					}
				
					override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
						
						for (m : annotatedClass.declaredMethods) {
							
							val newMethod = annotatedClass.copyMethod(m, context)
							newMethod.simpleName = newMethod.simpleName + "_copiedMethod"
							newMethod.body = m.body
							m.body = ''«»'// new method''«»'
							
						}
						
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.SomeAnnotation
				class SomeAnnotationTest {
					
					def <T> void myMethod() {
						var T myObj = null;
					}
				
				}
			'''
		) [
			validator.assertNoErrors(xtendFile)
		]
	}
	
	def void assertSameType(TypeReference first, TypeReference second) {
		if (first != second) {
			fail('''«first» does not refer to the same type as «second»''')
		}
	}
}

