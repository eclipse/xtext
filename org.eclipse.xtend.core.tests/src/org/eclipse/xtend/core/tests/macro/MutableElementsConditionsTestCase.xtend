/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import java.util.List
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtext.validation.ComposedChecks
import org.junit.Assert
import org.junit.Test

import static org.eclipse.xtend.core.tests.macro.MutableAssert.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class MutableElementsConditionsTestCase extends AbstractActiveAnnotationTest {

	@Test def void checkMutableClassDeclaration() {
		'''
			@«CheckMutableClassDeclaration.name» class Foo {}
		'''.assertCompilesTo(
			'''
				MULTIPLE FILES WERE GENERATED
				
				File 1 : /myProject/xtend-gen/Foo.java
				
				import «CheckMutableClassDeclaration.name»;
				
				@«CheckMutableClassDeclaration.simpleName»
				@SuppressWarnings("all")
				public class Foo<foo> {
				}
				
				File 2 : /myProject/xtend-gen/foo/Bar.java
				
				package foo;
				
				@SuppressWarnings("all")
				public class Bar {
				}
				
				File 3 : /myProject/xtend-gen/foo/Bar2.java
				
				package foo;
				
				public @interface Bar2 {
				}
				
				File 4 : /myProject/xtend-gen/foo/Bar3.java
				
				package foo;
				
				@SuppressWarnings("all")
				public enum Bar3 {
				}
				
				File 5 : /myProject/xtend-gen/foo/Bar4.java
				
				package foo;
				
				@SuppressWarnings("all")
				public interface Bar4 {
				}
				
			''')
	}

	@Test def void checkMutableInterfaceDeclaration() {
		'''
			@«CheckMutableInterfaceDeclaration.name» interface Foo {}
		'''.assertCompilesTo(
			'''
				import «CheckMutableInterfaceDeclaration.name»;
				
				@«CheckMutableInterfaceDeclaration.simpleName»
				@SuppressWarnings("all")
				public interface Foo {
				}
			''')
	}

	@Test def void checkMutableMethodDeclaration() {
		'''
			class Foo {
			
				@«CheckMutableMethodDeclaration.name» def void foo () {}
			
			}
		'''.assertCompilesTo(
			'''
				import «CheckMutableMethodDeclaration.name»;
				
				@SuppressWarnings("all")
				public class Foo {
				  @«CheckMutableMethodDeclaration.simpleName»
				  public void foo() {
				  }
				}
			''')
	}

	@Test def void checkMutableFieldDeclaration() {
		'''
			class Foo {
			
				@«CheckMutableFieldDeclaration.name» Object foo
			
			}
		'''.assertCompilesTo(
			'''
				import «CheckMutableFieldDeclaration.name»;
				
				@SuppressWarnings("all")
				public class Foo {
				  @«CheckMutableFieldDeclaration.simpleName»
				  private Object foo;
				}
			''')
	}

	@Test def void checkMutableParameterDeclaration() {
		'''
			class Foo {
			
				def void foo (@«CheckMutableParameterDeclaration.name» Object foo) {}
			
			}
		'''.assertCompilesTo(
			'''
				import «CheckMutableParameterDeclaration.name»;
				
				@SuppressWarnings("all")
				public class Foo {
				  public void foo(@«CheckMutableParameterDeclaration.simpleName» final Object foo) {
				  }
				}
			''')
	}

	@Test def void checkMutableEnumerationTypeDeclaration() {
		'''
			@«CheckMutableEnumerationTypeDeclaration.name»
			enum Foo {
			
			}
		'''.assertCompilesTo(
			'''
				import «CheckMutableEnumerationTypeDeclaration.name»;

				@«CheckMutableEnumerationTypeDeclaration.simpleName»
				@SuppressWarnings("all")
				public enum Foo {
				  A;
				}
			''')
	}

}

@Active(CheckMutableEnumerationTypeDeclarationProcessor)
annotation CheckMutableEnumerationTypeDeclaration {
}

class CheckMutableEnumerationTypeDeclarationProcessor implements RegisterGlobalsParticipant<EnumerationTypeDeclaration>, TransformationParticipant<MutableEnumerationTypeDeclaration>, CodeGenerationParticipant<EnumerationTypeDeclaration> {

	override doRegisterGlobals(List<? extends EnumerationTypeDeclaration> annotatedSourceElements,
		RegisterGlobalsContext context) {
	}

	override doTransform(List<? extends MutableEnumerationTypeDeclaration> annotatedTargetElements,
		extension TransformationContext context) {
		for (enumeration : annotatedTargetElements) {
			assertValidJavaIdentifier("name") [ String identifier |
				enumeration.addValue(identifier) [].remove
			]
			assertThrowable(IllegalArgumentException, "initializer cannot be null") [ |
				enumeration.addValue("foo", null)
			]
			assertThrowable(UnsupportedOperationException, "It is not possible to change visibility of enumeration value.") [ |
				enumeration.addValue("A") [].setVisibility(Visibility.PRIVATE)
			]
		}
	}

	override doGenerateCode(List<? extends EnumerationTypeDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
	}

}

@Active(CheckMutableParameterDeclarationProcessor)
annotation CheckMutableParameterDeclaration {
}

class CheckMutableParameterDeclarationProcessor implements RegisterGlobalsParticipant<ParameterDeclaration>, TransformationParticipant<MutableParameterDeclaration>, CodeGenerationParticipant<MutableParameterDeclaration> {

	override doRegisterGlobals(List<? extends ParameterDeclaration> annotatedSourceElements,
		RegisterGlobalsContext context) {
	}

	override doTransform(List<? extends MutableParameterDeclaration> annotatedTargetElements,
		extension TransformationContext context) {
		for (annotatedTargetElement : annotatedTargetElements) {
			assertValidJavaIdentifier("name") [ String identifier |
				annotatedTargetElement.simpleName = identifier
			]
		}
	}

	override doGenerateCode(List<? extends MutableParameterDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
	}

}

@Active(CheckMutableFieldDeclarationProcessor)
annotation CheckMutableFieldDeclaration {
}

class CheckMutableFieldDeclarationProcessor extends AbstractFieldProcessor {

	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		assertThrowable(IllegalArgumentException, "initializer cannot be null") [ |
			annotatedField.initializer = null as CompilationStrategy
		]
		assertThrowable(IllegalArgumentException, "type cannot be null") [ |
			annotatedField.type = null
		]
	}

}

@Active(CheckMutableMethodDeclarationProcessor)
annotation CheckMutableMethodDeclaration {
}

class CheckMutableMethodDeclarationProcessor extends AbstractMethodProcessor {

	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedMethod.addTypeParameter(identifier).remove
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot be null") [ |
			annotatedMethod.addTypeParameter("T", null as TypeReference[])
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot contain null") [ |
			annotatedMethod.addTypeParameter("T", #[null])
		]
		annotatedMethod.addTypeParameter("T", emptyList).remove
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedMethod.addParameter(identifier, String.newTypeReference).remove
		]
		assertThrowable(IllegalArgumentException, "type cannot be null") [ |
			annotatedMethod.addParameter("foo", null)
		]
		assertThrowable(IllegalArgumentException, "returnType cannot be null") [ |
			annotatedMethod.returnType = null
		]
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedMethod.simpleName = identifier
		]
		assertThrowable(IllegalArgumentException, "exceptions cannot be null") [ |
			annotatedMethod.exceptions = null
		]
		assertThrowable(IllegalArgumentException, "exceptions cannot contain null") [ |
			annotatedMethod.exceptions = #[null]
		]
		annotatedMethod.exceptions = emptyList
	}

}

@Active(CheckMutableClassDeclarationProcessor)
annotation CheckMutableClassDeclaration {
}

class CheckMutableClassDeclarationProcessor extends AbstractClassProcessor {

	override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
		assertValidQualifiedName("qualifiedName", "foo.Bar") [ String qualifiedName |
			registerClass(qualifiedName)
		]
		assertThrowable(IllegalArgumentException, "The type 'foo.Bar' has already been registered.") [ |
			registerClass("foo.Bar")
		]
		assertValidQualifiedName("qualifiedName", "foo.Bar2") [ String qualifiedName |
			registerAnnotationType(qualifiedName)
		]
		assertThrowable(IllegalArgumentException, "The type 'foo.Bar2' has already been registered.") [ |
			registerAnnotationType("foo.Bar2")
		]
		assertValidQualifiedName("qualifiedName", "foo.Bar3") [ String qualifiedName |
			registerEnumerationType(qualifiedName)
		]
		assertThrowable(IllegalArgumentException, "The type 'foo.Bar3' has already been registered.") [ |
			registerEnumerationType("foo.Bar3")
		]
		assertValidQualifiedName("qualifiedName", "foo.Bar4") [ String qualifiedName |
			registerInterface(qualifiedName)
		]
		assertThrowable(IllegalArgumentException, "The type 'foo.Bar4' has already been registered.") [ |
			registerInterface("foo.Bar4")
		]
	}

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		assertThrowable(IllegalArgumentException, "superIntefaces cannot be null") [ |
			annotatedClass.implementedInterfaces = null
		]
		assertThrowable(IllegalArgumentException, "superIntefaces cannot contain null") [ |
			annotatedClass.implementedInterfaces = #[null]
		]
		annotatedClass.implementedInterfaces = emptyList
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedClass.addTypeParameter(identifier).remove
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot be null") [ |
			annotatedClass.addTypeParameter("T", null as TypeReference[])
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot contain null") [ |
			annotatedClass.addTypeParameter("T", #[null])
		]
		val typeParameter = annotatedClass.addTypeParameter("T")
		assertValidJavaIdentifier("name") [ String identifier |
			typeParameter.simpleName = identifier
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot be null") [ |
			typeParameter.upperBounds = null
		]
		assertThrowable(IllegalArgumentException, "upperBounds cannot contain null") [ |
			typeParameter.upperBounds = #[null]
		]
		typeParameter.upperBounds = emptyList
		assertThrowable(UnsupportedOperationException, "The type cannot be renamed.") [ |
			annotatedClass.simpleName = null
		]
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedClass.addField(identifier) [
				type = String.newTypeReference
			].remove
		]
		assertThrowable(IllegalArgumentException, "initializer cannot be null") [ |
			annotatedClass.addField("foo", null)
		]
		assertValidJavaIdentifier("name") [ String identifier |
			annotatedClass.addMethod(identifier)[].remove
		]
		assertThrowable(IllegalArgumentException, "initializer cannot be null") [ |
			annotatedClass.addMethod("foo", null)
		]
		assertThrowable(IllegalArgumentException, "initializer cannot be null") [ |
			annotatedClass.addConstructor(null)
		]

		val method = annotatedClass.addMethod("foo")[]
		annotatedClass.findDeclaredMethod(null)
		annotatedClass.findDeclaredMethod("foo")
		assertThrowable(IllegalArgumentException, "parameterTypes cannot be null") [ |
			annotatedClass.findDeclaredMethod("foo", null as TypeReference[])
		]
		assertThrowable(IllegalArgumentException, "parameterTypes cannot contain null") [ |
			annotatedClass.findDeclaredMethod("foo", #[null])
		]
		annotatedClass.findDeclaredMethod("foo", emptyList)
		method.remove

		assertThrowable(IllegalArgumentException, "parameterTypes cannot be null") [ |
			annotatedClass.findDeclaredConstructor(null as TypeReference[])
		]
		assertThrowable(IllegalArgumentException, "parameterTypes cannot contain null") [ |
			annotatedClass.findDeclaredConstructor(#[null])
		]
		annotatedClass.findDeclaredConstructor(emptyList)
	}

}

@Active(CheckMutableInterfaceDeclarationProcessor)
annotation CheckMutableInterfaceDeclaration {
}

class CheckMutableInterfaceDeclarationProcessor implements RegisterGlobalsParticipant<InterfaceDeclaration>, TransformationParticipant<MutableInterfaceDeclaration>, CodeGenerationParticipant<MutableInterfaceDeclaration> {

	override doRegisterGlobals(List<? extends InterfaceDeclaration> annotatedSourceElements,
		RegisterGlobalsContext context) {
	}

	override doTransform(List<? extends MutableInterfaceDeclaration> annotatedTargetElements,
		extension TransformationContext context) {
		for (MutableInterfaceDeclaration annotatedTargetElement : annotatedTargetElements) {
			assertValidJavaIdentifier("name") [ String identifier |
				annotatedTargetElement.addTypeParameter(identifier).remove
			]
			assertThrowable(IllegalArgumentException, "upperBounds cannot be null") [ |
				annotatedTargetElement.addTypeParameter("T", null as TypeReference[])
			]
			assertThrowable(IllegalArgumentException, "upperBounds cannot contain null") [ |
				annotatedTargetElement.addTypeParameter("T", #[null])
			]
			annotatedTargetElement.addTypeParameter("T", emptyList).remove
			assertThrowable(IllegalArgumentException, "superinterfaces cannot be null") [ |
				annotatedTargetElement.extendedInterfaces = null
			]
			assertThrowable(IllegalArgumentException, "superinterfaces cannot contain null") [ |
				annotatedTargetElement.extendedInterfaces = #[null]
			]
			annotatedTargetElement.extendedInterfaces = emptyList
			val annotationReference = annotatedTargetElement.addAnnotation(Deprecated.newAnnotationReference [
					assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, null)
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, "foo")
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					// TODO remove workaround (cast) below
					set(null, { val String[] array = #["foo"]; array })
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, true)
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, #[true] as boolean[])
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, 0)
				]
				assertThrowable(IllegalArgumentException, "name has to be a valid java identifier") [ |
					set(null, #[0] as int[])
				]
				assertThrowable(IllegalArgumentException, "The annotation property 'doesNotExist' is not declared on the annotation type 'java.lang.Deprecated'.") [ |
					set('doesNotExist', { val String[] array = #["foo"]; array })
				]
			])
			annotatedTargetElement.removeAnnotation(annotationReference)
			
			val otherAnnotationReference = annotatedTargetElement.addAnnotation(SuppressWarnings.newAnnotationReference [
				set('value', { val String[] array = #["foo"]; array })
				assertThrowable(IllegalArgumentException, 'int[] is not applicable at this location. Expected java.lang.String[]') [|
					set('value', { val int[] array = #[1]; array })
				]
			])
			annotatedTargetElement.removeAnnotation(otherAnnotationReference)
			
			val composedChecksReference = annotatedTargetElement.addAnnotation(ComposedChecks.newAnnotationReference [
				set('validators', <TypeReference>newArrayOfSize(0))
				// concrete class type is intentionally not checked since the hierarchy may still be incomplete
				set('validators', String.newTypeReference) 
				assertThrowable(IllegalArgumentException, 'java.lang.String[] is not applicable at this location. Expected org.eclipse.xtend.lib.macro.declaration.TypeReference[]') [|
					set('validators', <String>newArrayOfSize(0))
				]
				assertThrowable(IllegalArgumentException, 'Cannot set annotation values of type java.lang.Object[]') [|
					set('validators', <Object>newArrayOfSize(0))
				]
			])
			annotatedTargetElement.removeAnnotation(composedChecksReference)
		}
	}

	override doGenerateCode(List<? extends MutableInterfaceDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
	}

}

class MutableAssert extends Assert {

	def static assertValidQualifiedName(String name, String expectedQualifiedName, (String)=>void codeToTest) {
		val message = '''«name» has to be a valid qualified name'''
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply(null)
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("  ")
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("456")
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("foo. Bar ")
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("foo.456.Bar")
		]
		codeToTest.apply(expectedQualifiedName)
	}

	def static assertValidJavaIdentifier(String name, (String)=>void codeToTest) {
		val message = '''«name» has to be a valid java identifier'''
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply(null)
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("  ")
		]
		assertThrowable(IllegalArgumentException, message) [ |
			codeToTest.apply("456")
		]
		codeToTest.apply("foo")
	}

	def static <T extends Throwable> T assertThrowable(Class<T> clazz, String message, =>void codeToTest) {
		val t = assertThrowable(clazz, codeToTest)
		assertEquals(message, t.message)
		t
	}

	def static <T extends Throwable> T assertThrowable(Class<T> clazz, =>void codeToTest) {
		try {
			codeToTest.apply
		} catch (Throwable e) {
			assertEquals(e.message, clazz, e.class)
			return e as T
		}
		fail('''an instance of the «clazz.name» class had to be thrown''')
		null
	}

}
