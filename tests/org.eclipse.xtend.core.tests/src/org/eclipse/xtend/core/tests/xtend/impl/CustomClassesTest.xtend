package org.eclipse.xtend.core.tests.xtend.impl

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtend.core.xtend.XtendField

class CustomClassesTest extends AbstractXtendTestCase {
	
	@Test def void testClassAbstractFinal() {
		assertFalse(clazz('''abstract final class Foo {}''').final)
		assertTrue(clazz('''abstract final class Foo {}''').^abstract)
		assertTrue(clazz('''final abstract class Foo {}''').final)
		assertFalse(clazz('''final abstract class Foo {}''').^abstract)
	}

	@Test def void testClassStatic() {
		assertFalse(clazz('''class Foo {}''').^static)
		assertTrue(clazz('''static class Foo {}''').^static)
	}

	@Test def void testClassVisibility() {
		assertEquals(JvmVisibility::PUBLIC, clazz('''class Foo {}''').visibility)
		assertEquals(JvmVisibility::PUBLIC, clazz('''public class Foo {}''').visibility)
		assertEquals(JvmVisibility::PROTECTED, clazz('''protected class Foo {}''').visibility)
		assertEquals(JvmVisibility::DEFAULT, clazz('''package class Foo {}''').visibility)
		assertEquals(JvmVisibility::PRIVATE, clazz('''private class Foo {}''').visibility)
	}
	
	@Test def void testInterfaceVisibility() {
		assertEquals(JvmVisibility::PUBLIC, interfaze('''interface Foo {}''').visibility)
		assertEquals(JvmVisibility::PUBLIC, interfaze('''public interface Foo {}''').visibility)
		assertEquals(JvmVisibility::PROTECTED, interfaze('''protected interface Foo {}''').visibility)
		assertEquals(JvmVisibility::DEFAULT, interfaze('''package interface Foo {}''').visibility)
		assertEquals(JvmVisibility::PRIVATE, interfaze('''private interface Foo {}''').visibility)
	}
	
	@Test def void testEnumVisibility() {
		assertEquals(JvmVisibility::PUBLIC, enumeration('''enum Foo {}''').visibility)
		assertEquals(JvmVisibility::PUBLIC, enumeration('''public enum Foo {}''').visibility)
		assertEquals(JvmVisibility::PROTECTED, enumeration('''protected enum Foo {}''').visibility)
		assertEquals(JvmVisibility::DEFAULT, enumeration('''package enum Foo {}''').visibility)
		assertEquals(JvmVisibility::PRIVATE, enumeration('''private enum Foo {}''').visibility)
	}
	
	@Test def void testInterfaceFinalAndStatic() {
		assertFalse(interfaze('''interface Foo {}''').final)
		assertTrue(interfaze('''interface Foo {}''').^static)
	}
	
	@Test def void testEnumFinalAndStatic() {
		assertTrue(enumeration('''enum Foo {}''').^static)
	}
	
	@Test def void testEnumLiteralDefaults() {
		val enumeration = enumeration('''enum Foo { BAR }''')
		val literal = enumeration.getMembers().get(0)
		assertTrue(literal.^static)
		assertTrue(literal.final)
		assertEquals(JvmVisibility::PUBLIC, literal.visibility)
	}

	@Test def void testFieldInInterfaceDefaults() {
		val field = interfaze('''interface Foo { int foo }''').members.get(0) as XtendField
		assertTrue(field.final)
		assertTrue(field.^static)
		assertEquals(JvmVisibility::PUBLIC, field.visibility)
	}
	
	@Test def void testFieldInAnnotationDefaults() {
		val field = annotationType('''annotation Foo { int foo }''').members.get(0) as XtendField
		assertTrue(field.final)
		assertTrue(field.^static)
		assertEquals(JvmVisibility::PUBLIC, field.visibility)
	}
	
	@Test def void testAnnotationTypeStaticAndFinal() {
		assertTrue(annotationType('''static annotation Foo {}''').^static)
		assertFalse(annotationType('''final annotation Foo {}''').final)
	}
	
	@Test def void testAnnotationTypeVisibility() {
		assertEquals(JvmVisibility::PUBLIC, annotationType('''annotation Foo {}''').visibility)
		assertEquals(JvmVisibility::PUBLIC, annotationType('''public annotation Foo {}''').visibility)
		assertEquals(JvmVisibility::PROTECTED, annotationType('''protected annotation Foo {}''').visibility)
		assertEquals(JvmVisibility::DEFAULT, annotationType('''package annotation Foo {}''').visibility)
		assertEquals(JvmVisibility::PRIVATE, annotationType('''private annotation Foo {}''').visibility)
	}
	
	@Test def void testXtendFieldVisibility() {
		assertEquals(JvmVisibility::PRIVATE, field('''int foo=42''').visibility)
		assertEquals(JvmVisibility::PUBLIC, field('''public int foo=42''').visibility)
		assertEquals(JvmVisibility::PROTECTED, field('''protected int foo=42''').visibility)
		assertEquals(JvmVisibility::DEFAULT, field('''package int foo=42''').visibility)
		assertEquals(JvmVisibility::PRIVATE, field('''private int foo=42''').visibility)
	}
	
	@Test def void testFieldExtension() {
		assertFalse(field('''int foo=42''').^extension)
		assertTrue(field('''extension int foo=42''').^extension)
	}
	
	@Test def void testFieldFinal() {
		assertFalse(field('''int foo=42''').final)
		assertTrue(field('''final int foo=42''').final)
		assertTrue(field('''val int foo=42''').final)
		assertFalse(field('''var int foo=42''').final)
		assertFalse(field('''var final int foo=42''').final)
	}
}