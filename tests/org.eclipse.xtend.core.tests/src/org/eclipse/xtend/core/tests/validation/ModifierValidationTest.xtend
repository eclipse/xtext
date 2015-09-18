/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class ModifierValidationTest extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper
	
	@Test def void testClassAllowedModifiers() {
		clazz('''private class Foo{}''').assertError(XTEND_CLASS, INVALID_MODIFIER)
		clazz('''package class Foo{}''').assertNoErrors
		clazz('''protected class Foo{}''').assertError(XTEND_CLASS, INVALID_MODIFIER)
		clazz('''public class Foo{}''').assertNoErrors
		clazz('''static class Foo{}''').assertError(XTEND_CLASS, INVALID_MODIFIER)
		clazz('''abstract class Foo{}''').assertNoErrors
		clazz('''dispatch class Foo{}''').assertError(XTEND_CLASS, INVALID_MODIFIER)
		clazz('''final class Foo{}''').assertNoErrors
	}
	
	@Test def void testNestedClassAllowedModifiers() {
		clazz('''private class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''package class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''protected class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''public class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''static class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''abstract class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
		clazz('''dispatch class Foo{}'''.toNestedType).assertError(XTEND_CLASS, INVALID_MODIFIER)
		clazz('''final class Foo{}'''.toNestedType).assertNoErrors(INVALID_MODIFIER)
	}
	
	@Test def void testNestedClass() {
		clazz('''class Foo { class Bar {} }''').assertError(XTEND_CLASS, MISSING_STATIC_MODIFIER)
		clazz('''class Foo { static class Bar {} }''').assertNoErrors
		interfaze('''interface Foo { class Bar {} }''').assertNoErrors
		annotationType('''annotation Foo { class Bar {} }''').assertNoErrors
	}
	
	@Test def void testInterfaceAllowedModifiers() {
		interfaze('''private interface Foo{}''').assertError(XTEND_INTERFACE, INVALID_MODIFIER)
		interfaze('''package interface Foo{}''').assertNoErrors
		interfaze('''protected interface Foo{}''').assertError(XTEND_INTERFACE, INVALID_MODIFIER)
		interfaze('''public interface Foo{}''').assertNoErrors
		interfaze('''static interface Foo{}''').assertError(XTEND_INTERFACE, INVALID_MODIFIER)
		interfaze('''abstract interface Foo{}''').assertNoErrors
		interfaze('''dispatch interface Foo{}''').assertError(XTEND_INTERFACE, INVALID_MODIFIER)
		interfaze('''final interface Foo{}''').assertError(XTEND_INTERFACE, INVALID_MODIFIER)
	}
	
	@Test def void testNestedInterfaceAllowedModifiers() {
		clazz('''private interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''package interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''protected interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''public interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''static interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''abstract interface Foo{}'''.toNestedType).assertNoErrors
		clazz('''dispatch interface Foo{}'''.toNestedType).assertError(XTEND_INTERFACE, INVALID_MODIFIER)
		clazz('''final interface Foo{}'''.toNestedType).assertError(XTEND_INTERFACE, INVALID_MODIFIER)
	}
	
	@Test def void testEnumAllowedModifiers() {
		enumeration('''private enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
		enumeration('''package enum Foo{}''').assertNoErrors
		enumeration('''protected enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
		enumeration('''public enum Foo{}''').assertNoErrors
		enumeration('''static enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
		enumeration('''abstract enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
		enumeration('''dispatch enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
		enumeration('''final enum Foo{}''').assertError(XTEND_ENUM, INVALID_MODIFIER)
	}
	
	@Test def void testNestedEnumAllowedModifiers() {
		clazz('''private enum Foo{}'''.toNestedType).assertNoErrors
		clazz('''package enum Foo{}'''.toNestedType).assertNoErrors
		clazz('''protected enum Foo{}'''.toNestedType).assertNoErrors
		clazz('''public enum Foo{}'''.toNestedType).assertNoErrors
		clazz('''static enum Foo{}'''.toNestedType).assertNoErrors
		clazz('''abstract enum Foo{}'''.toNestedType).assertError(XTEND_ENUM, INVALID_MODIFIER)
		clazz('''dispatch enum Foo{}'''.toNestedType).assertError(XTEND_ENUM, INVALID_MODIFIER)
		clazz('''final enum Foo{}'''.toNestedType).assertError(XTEND_ENUM, INVALID_MODIFIER)
	}
	
	@Test def void testAnnotationTypeAllowedModifiers() {
		annotationType('''private annotation Foo{}''').assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
		annotationType('''package annotation Foo{}''').assertNoErrors
		annotationType('''protected annotation Foo{}''').assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
		annotationType('''public annotation Foo{}''').assertNoErrors
		annotationType('''static annotation Foo{}''').assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
		annotationType('''abstract annotation Foo{}''').assertNoErrors
		annotationType('''dispatch annotation Foo{}''').assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
		annotationType('''final annotation Foo{}''').assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
	}
	
	@Test def void testNestedAnnotationTypeAllowedModifiers() {
		clazz('''private annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''package annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''protected annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''public annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''static annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''abstract annotation Foo{}'''.toNestedType).assertNoErrors
		clazz('''dispatch annotation Foo{}'''.toNestedType).assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
		clazz('''final annotation Foo{}'''.toNestedType).assertError(XTEND_ANNOTATION_TYPE, INVALID_MODIFIER)
	}
	
	@Test def void testMethodAllowedModifiers() {
		function('''private def foo() {}''').assertNoErrors
		function('''package def foo() {}''').assertNoErrors
		function('''protected def foo() {}''').assertNoErrors
		function('''public def foo() {}''').assertNoErrors
		function('''static def foo() {}''').assertNoErrors
		function('''abstract def foo()''').assertNoError(INVALID_MODIFIER)	
		function('''dispatch def foo (int i){}''').assertNoErrors
		function('''final def foo() {}''').assertNoErrors
	}

	@Test def void testMethodInInterfaceAllowedModifiers() {
		memberInInterface('''private def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''package def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''protected def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''public def foo() {}''').assertNoError(INVALID_MODIFIER)
		memberInInterface('''override def foo() {}''').assertNoError(INVALID_MODIFIER)
		memberInInterface('''static def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)	
		memberInInterface('''abstract def int foo()''').assertNoErrors	
		memberInInterface('''dispatch def foo (int i){}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''final def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''strictfp def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''synchronized def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
	}
	
	@Test def void testConstructorAllowedModifiers() {
		constructor('''private new() {}''').assertNoErrors
		constructor('''package new() {}''').assertNoErrors
		constructor('''protected new() {}''').assertNoErrors
		constructor('''public new() {}''').assertNoErrors
		constructor('''static new() {}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
		constructor('''abstract new() {}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
		constructor('''dispatch new (){}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
		constructor('''final new() {}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
		constructor('''strictfp new() {}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
		constructor('''synchronized new() {}''').assertError(XTEND_CONSTRUCTOR, INVALID_MODIFIER)
	}
	
	@Test def void testFieldAllowedModifiers() {
		field('''private int foo''').assertNoErrors
		field('''package int foo''').assertNoErrors
		field('''protected int foo''').assertNoErrors
		field('''public int foo''').assertNoErrors
		field('''static int foo''').assertNoErrors
		field('''abstract int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''dispatch int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''final int foo = 42''').assertNoErrors
		field('''extension Integer foo''').assertNoErrors
		field('''final volatile int foo = 42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''volatile transient int foo''').assertNoErrors
		field('''private transient volatile int foo''').assertNoErrors
	}
	
	@Test def void testFieldInInterfaceAllowedModifiers() {
		memberInInterface('''private int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''package int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''protected int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''public int foo = 42''').assertNoErrors
		memberInInterface('''static int foo = 42''').assertNoErrors
		memberInInterface('''abstract int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''dispatch int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''final int foo = 42''').assertNoErrors
		memberInInterface('''extension int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''transient int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''volatile int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''strictfp int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInInterface('''synchronized int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
	}
	
	@Test def void testFieldInAnnotationAllowedModifiers() {
		memberInAnnotation('''private int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''package int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''protected int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''public int foo''').assertNoErrors
		memberInAnnotation('''static int foo''').assertNoErrors
		memberInAnnotation('''abstract int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''dispatch int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''final int foo = 42''').assertNoErrors
		memberInAnnotation('''transient int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''volatile int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''strictfp int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		memberInAnnotation('''synchronized int foo''').assertError(XTEND_FIELD, INVALID_MODIFIER)
	}
	
	@Test def void testDuplicateModifier() {
		function('''private private def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''package package def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''protected protected def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''public public def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''static static def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''abstract abstract def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''dispatch dispatch def foo (int i){}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''final final def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''strictfp strictfp def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''synchronized synchronized def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
	}

	@Test def void testDuplicateVisibility() {
		function('''private package def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''package protected def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''protected public def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''public private def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		
	}

	@Test def void testStaticVsAbstract() {
		field('''abstract static int foo=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''static abstract int foo=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
	}

	@Test def void testFinalVsAbstract() {
		function('''abstract final def foo() ''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''final abstract def foo() ''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
	}
	
	@Test def void testAbstractVsNoBody() {
		function('''abstract def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''abstract def foo()''').assertNoError(INVALID_MODIFIER)
	}
	
	@Test def void testNativeVsNoBody() {
		function('''native def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''native def foo()''').assertNoError(INVALID_MODIFIER)
	}
	
	@Test def void testStaticVsNative() {
		field('''native static int foo=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''static native int foo=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
	}

	@Test def void testFinalVsNative() {
		function('''native final def foo() ''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''final native def foo() ''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
	}
	
	@Test def void testFinalVsNoBody() {
		function('''final def foo()''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		function('''final def foo() {}''').assertNoErrors
	}
	
	@Test def void testFinalValVsVar() {
		field('''final var int i=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''var final int i=42''').assertError(XTEND_FIELD, INVALID_MODIFIER)
		field('''final val int i=42''').assertNoErrors
		field('''val final int i=42''').assertNoErrors
	}
	
	def protected memberInInterface(String model) {
		interfaze('''interface Foo { «model» }''').members.get(0)
	}
	
	def protected memberInAnnotation(String model) {
		annotationType('''annotation Foo { «model» }''').members.get(0)
	}
	
	def private String toNestedType(CharSequence input) '''
		class C {
			«input»
		}
	'''
}

