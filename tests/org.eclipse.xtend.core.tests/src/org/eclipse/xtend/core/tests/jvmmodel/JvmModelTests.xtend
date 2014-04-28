package org.eclipse.xtend.core.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

class JvmModelTests extends AbstractXtendTestCase {
	
	@Inject extension IXtendJvmAssociations
	
	@Inject extension IBatchTypeResolver typeResolver
	
	@Test
	def testClassImplicitSuperType() {
		val inferred = '''
			class Foo {
			}
		'''.toString.clazz.inferredType
		assertEquals(1, inferred.superTypes.size)
		assertEquals('java.lang.Object', inferred.superTypes.head.identifier)
	}

	@Test
	def testInterfaceImplicitSuperType() {
		val inferred = '''
			interface Foo {
			}
		'''.toString.interfaze.inferredType
		assertEquals(1, inferred.superTypes.size)
		assertEquals('java.lang.Object', inferred.superTypes.head.identifier)
	}

	@Test
	def testAnnotationImplicitSuperType() {
		val inferred = '''
			annotation Foo {
			}
		'''.toString.annotationType.inferredAnnotationType
		assertEquals(1, inferred.superTypes.size)
		assertEquals('java.lang.annotation.Annotation', inferred.superTypes.head.identifier)
	}
	
	@Test
	def testEmptyListAsAnnotationValueDefault() {
		val inferred = '''
			annotation Foo {
				String[] bar = #[]
			}
		'''.toString.annotationType.inferredAnnotationType.members.head as JvmOperation
		assertEquals('java.lang.String[]', inferred.returnType.identifier)
		assertTrue(inferred.defaultValue instanceof JvmCustomAnnotationValue)
		assertTrue((inferred.defaultValue as JvmCustomAnnotationValue).values.head instanceof XListLiteral)
	}
	
	@Test
	def testAnnotationDefaultAssociatedWithJvmOperation() {
		val inferred = '''
			annotation Foo {
				val bar = ''
			}
		'''.toString.annotationType.inferredAnnotationType.members.head as JvmOperation
		val defaultValue = inferred.defaultValue
		assertSame(inferred, defaultValue.operation)
	}

	@Test
	def testEnumImplicitSuperType() {
		val inferred = '''
			enum Foo {
			}
		'''.toString.enumeration.inferredEnumerationType
		assertEquals(1, inferred.superTypes.size)
		assertEquals('java.lang.Enum<Foo>', inferred.superTypes.head.identifier)
	}

	@Test
	def testEnumLiteralIsStatic() {
		val inferred = '''
			enum Foo {
				BAR
			}
		'''.toString.enumeration.inferredEnumerationType.members.head as JvmEnumerationLiteral
		assertTrue(inferred.static)
	}

	@Test
	def testEnumArtificialMethods() {
		val inferred = '''
			package bar
			
			enum Foo {
			}
		'''.toString.enumeration.inferredEnumerationType.members
		assertEquals(2, inferred.size)
		val values = inferred.get(0) as JvmOperation
		assertEquals("bar.Foo.values()", values.identifier)
		assertTrue(values.static)
		assertEquals(JvmVisibility::PUBLIC, values.visibility)
		val valueOf = inferred.get(1) as JvmOperation
		assertEquals("bar.Foo.valueOf(java.lang.String)", valueOf.identifier)
		assertTrue(valueOf.static)
		assertEquals(JvmVisibility::PUBLIC, valueOf.visibility)
	}
	
	@Test
	def testAnonymousClass() {
		val operation = '''
			def foo() {
				new Runnable() {
					int field
					override run() {}
				}
			}
		'''.toString.function.directlyInferredOperation
		resolveTypes(operation.eResource)
		assertEquals(1, operation.localClasses.size)
		val anonymous = operation.localClasses.head
		assertTrue(anonymous.final)
		assertFalse(anonymous.static)
		assertTrue(anonymous.local)
		assertFalse(anonymous.anonymous) // additional member -> named local class
		assertEquals(JvmVisibility.DEFAULT, anonymous.visibility)
		assertEquals(1, anonymous.superTypes.size)
		assertEquals('java.lang.Runnable', anonymous.superTypes.head.qualifiedName)
		assertEquals(3, anonymous.members.size)
		val constructor = anonymous.members.head
		assertTrue(constructor instanceof JvmConstructor)
		assertEquals(0, (constructor as JvmConstructor).parameters.size)
		assertTrue(anonymous.members.get(1) instanceof JvmField)
		val overriding = anonymous.members.last
		assertTrue(overriding instanceof JvmOperation)
	}
	
	@Test
	def testAnonymousClass_2() {
		val operation = '''
			def foo() {
				new Runnable() {
					override run() {}
				}
			}
		'''.toString.function.directlyInferredOperation
		resolveTypes(operation.eResource)
		assertEquals(1, operation.localClasses.size)
		val anonymous = operation.localClasses.head
		assertTrue(anonymous.final)
		assertFalse(anonymous.static)
		assertTrue(anonymous.local)
		assertTrue(anonymous.anonymous)
		assertEquals(JvmVisibility.DEFAULT, anonymous.visibility)
		assertEquals(1, anonymous.superTypes.size)
		assertEquals('java.lang.Runnable', anonymous.superTypes.head.qualifiedName)
		assertEquals(2, anonymous.members.size)
		val constructor = anonymous.members.head
		assertTrue(constructor instanceof JvmConstructor)
		assertEquals(0, (constructor as JvmConstructor).parameters.size)
		val overriding = anonymous.members.last
		assertTrue(overriding instanceof JvmOperation)
	}
	
	@Test
	def testAnonymousClass_3() {
		val operation = '''
			def <T> foo() {
				new Iterable<T>() {
					override iterator() {}
				}
			}
		'''.toString.function.directlyInferredOperation
		resolveTypes(operation.eResource)
		assertEquals(1, operation.localClasses.size)
		val anonymous = operation.localClasses.head
		assertTrue(anonymous.final)
		assertFalse(anonymous.static)
		assertTrue(anonymous.local)
		assertTrue(anonymous.anonymous)
		assertEquals(0, anonymous.typeParameters.size)
		assertEquals(JvmVisibility.DEFAULT, anonymous.visibility)
		assertEquals(1, anonymous.superTypes.size)
		assertEquals('java.lang.Iterable<T>', anonymous.superTypes.head.qualifiedName)
		assertEquals(2, anonymous.members.size)
		val constructor = anonymous.members.head
		assertTrue(constructor instanceof JvmConstructor)
		assertEquals(0, (constructor as JvmConstructor).typeParameters.size)
		val overriding = anonymous.members.last
		assertTrue(overriding instanceof JvmOperation)
	}
	
}
