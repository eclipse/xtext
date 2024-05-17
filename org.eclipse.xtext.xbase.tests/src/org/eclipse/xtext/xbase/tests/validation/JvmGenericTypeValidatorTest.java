/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(JvmGenericTypeValidatorTestLangInjectorProviderCustom.class)
public class JvmGenericTypeValidatorTest {
	@Inject
	private ParseHelper<JvmGenericTypeValidatorTestLangModel> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	@Test public void testValidModel() throws Exception {
		var model = parse(
			"package mypackage\n"
			+ "import java.util.ArrayList\n"
			+ "import java.io.Serializable\n"
			+ "class MyClass extends ArrayList<String> implements Serializable {\n"
			+ "}\n"
			+ "class MyClass2 {\n"
			+ "}\n"
			+ "interface MyInterface extends Serializable {\n"
			+ "}"
			+ "interface MyInterface2 extends Override {\n"
			+ "}");
		validationHelper.assertNoErrors(model);
	}

	@Test public void testMissingConstructor() throws Exception {
		var source = "package mypackage\n"
			+ "import test.NoDefaultConstructor\n"
			+ "class MyClass extends NoDefaultConstructor {\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, MISSING_CONSTRUCTOR,
				source.indexOf("MyClass"), "MyClass".length(),
				"must define an explicit constructor");
	}

	@Test public void testMissingConstructorCall() throws Exception {
		var source = "package mypackage\n"
			+ "import test.NoDefaultConstructor\n"
			+ "class MyClass extends NoDefaultConstructor {\n"
			+ "  constructor() {}\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, MUST_INVOKE_SUPER_CONSTRUCTOR,
				source.indexOf("constructor() {}"), "constructor() {}".length(),
				"Another constructor must be invoked explicitly");
	}

	@Test public void testMissingConstructorCall_01() throws Exception {
		var source = "package mypackage\n"
			+ "import test.NoDefaultConstructor\n"
			+ "class MyClass extends NoDefaultConstructor {\n"
			+ "  constructor() { println() }\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, MUST_INVOKE_SUPER_CONSTRUCTOR,
				source.indexOf("constructor() { println() }"), "constructor() { println() }".length(),
				"Another constructor must be invoked explicitly");
	}

	@Test public void testSuperConstructorCall() throws Exception {
		var source = "package mypackage\n"
			+ "import test.NoDefaultConstructor\n"
			+ "class MyClass extends NoDefaultConstructor {\n"
			+ "  constructor() { super('test') }\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testSuperConstructorCall_01() throws Exception {
		var source = "package mypackage\n"
			+ "import test.NoDefaultConstructor\n"
			+ "class MyClass extends NoDefaultConstructor {\n"
			+ "  constructor(String s) { super(s) }\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testDuplicateFieldName() throws Exception {
		var source = "package mypackage\n"
			+ "class MyClass {\n"
			+ "  int foo String foo double foo\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_FIELD, DUPLICATE_FIELD,
				source.indexOf("foo"), "foo".length(),
				"foo", "duplicate");
		validationHelper.assertError(model, MY_FIELD, DUPLICATE_FIELD,
				source.indexOf("String foo") + "String ".length(), "foo".length(),
				"foo", "duplicate");
		validationHelper.assertError(model, MY_FIELD, DUPLICATE_FIELD,
				source.indexOf("double foo") + "double ".length(), "foo".length(),
				"foo", "duplicate");
	}

	@Test public void testNoDuplicateFieldName() throws Exception {
		var source = "package mypackage\n"
			+ "class MyClass {\n"
			+ "  int x String y double z\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testInvalidVoidInFieldType() throws Exception {
		var source = "class X { void v }";
		var model = parse(source);
		validationHelper.assertError(model, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE,
				source.indexOf("void"), "void".length());
	}

	@Test public void testDuplicateNestedTypes() throws Exception {
		var source = "package mypackage\n"
			+ "class MyClass {\n"
			+ "  class Nested {} class Nested {}\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, DUPLICATE_TYPE,
				source.indexOf("Nested"), "Nested".length(),
				"Duplicate nested type Nested");
		validationHelper.assertError(model, MY_CLASS, DUPLICATE_TYPE,
				source.lastIndexOf("Nested"), "Nested".length(),
				"Duplicate nested type Nested");
	}

	@Test public void testNoDuplicateNestedTypes() throws Exception {
		var source = "package mypackage\n"
			+ "class MyClass {\n"
			+ "  class Nested1 {} class Nested2 {}\n"
			+ "}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testInheritanceCycle() throws Exception {
		var source = "package test "
				+ "class Foo extends Bar {}"
				+ "class Bar extends Baz {}"
				+ "class Baz extends Foo {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CYCLIC_INHERITANCE,
				source.indexOf("Foo"), "Foo".length(),
				"hierarchy", "cycles");
		validationHelper.assertError(model, MY_CLASS, CYCLIC_INHERITANCE,
				source.lastIndexOf("Bar"), "Bar".length(),
				"hierarchy", "cycles");
		validationHelper.assertError(model, MY_CLASS, CYCLIC_INHERITANCE,
				source.lastIndexOf("Baz"), "Baz".length(),
				"hierarchy", "cycles");
	}

	@Test public void testClassImplementsClass() throws Exception {
		var source = "class Foo implements Object {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, INTERFACE_EXPECTED,
				source.indexOf("Object"), "Object".length(),
				"Implemented", "interface");
	}

	@Test public void testClassImplementsAnnotation() throws Exception {
		var source = "class Foo implements Override {}";
		var model = parse(source);
		// there's only the error: should be defined abstract, it should implement annotationType
		validationHelper.assertNoError(model, INTERFACE_EXPECTED);
	}

	@Test public void testAbstractClassImplementsAnnotation() throws Exception {
		var source = "abstract class Foo implements Override {}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testClassExtendsInterface() throws Exception {
		var source = "class Foo extends Cloneable {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CLASS_EXPECTED,
				source.indexOf("Cloneable"), "Cloneable".length(),
				"Superclass");
	}

	@Test public void testClassExtendsEnum() throws Exception {
		var source = "class Foo extends test.AnEnum {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CLASS_EXPECTED,
				source.indexOf("test.AnEnum"), "test.AnEnum".length(),
				"Superclass");
	}

	@Test public void testInterfaceExtendsClass() throws Exception {
		var source = "interface Foo extends Object {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_INTERFACE, INTERFACE_EXPECTED,
				source.indexOf("Object"), "Object".length(),
				"Extended", "interface");
	}

	@Test public void testDuplicateImplementedInterfaces() throws Exception {
		var source = "import java.io.Serializable\n"
				+ "class Foo implements "
				+ "Serializable, java.io.Serializable, Cloneable, Serializable {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, DUPLICATE_INTERFACE,
				source.lastIndexOf("java.io.Serializable"), "java.io.Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
		validationHelper.assertError(model, MY_CLASS, DUPLICATE_INTERFACE,
				source.lastIndexOf("Serializable"), "Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
	}

	@Test public void testDuplicateExtendedInterfaces() throws Exception {
		var source = "import java.io.Serializable\n"
				+ "interface Foo extends "
				+ "Serializable, java.io.Serializable, Cloneable, Serializable {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_INTERFACE, DUPLICATE_INTERFACE,
				source.lastIndexOf("java.io.Serializable"), "java.io.Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
		validationHelper.assertError(model, MY_INTERFACE, DUPLICATE_INTERFACE,
				source.lastIndexOf("Serializable"), "Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
	}

	@Test public void testDuplicateImplementedInterfacesWithImplicitInterface() throws Exception {
		// this class construct automatically has Serializable as a supertype
		var source = "import java.io.Serializable\n"
				+ "classWithSuperTypes Foo superTypes "
				+ "Object, java.io.Serializable, Cloneable, Serializable {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, DUPLICATE_INTERFACE,
				source.lastIndexOf("java.io.Serializable"), "java.io.Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, DUPLICATE_INTERFACE,
				source.lastIndexOf("Serializable"), "Serializable".length(),
				"Duplicate interface Serializable for the type Foo");
	}

	@Test public void testCheckSuperTypesWithClassWithSuperTypes() throws Exception {
		// the first supertype must be a class, and then the other ones interfaces
		var source = "classWithSuperTypes Foo superTypes Cloneable, Object {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, INTERFACE_EXPECTED,
				source.indexOf("Object"), "Object".length(),
				"Implemented", "interface");
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, CLASS_EXPECTED,
				source.indexOf("Cloneable"), "Cloneable".length(),
				"Superclass");
	}

	@Test public void testCheckSuperTypesWithClassWithSuperTypes_01() throws Exception {
		// the first supertype must be a class, and then the other ones interfaces
		// Serializable is an implicit super interface, but we check whether the explicit one has an error
		var source = "classWithSuperTypes Foo superTypes Serializable, Object {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, INTERFACE_EXPECTED,
				source.indexOf("Object"), "Object".length(),
				"Implemented", "interface");
		validationHelper.assertError(model, MY_CLASS_WITH_SUPER_TYPES, CLASS_EXPECTED,
				source.indexOf("Serializable"), "Serializable".length(),
				"Superclass");
	}

	@Test public void testCheckSuperTypesWithClassWithSuperTypes_02() throws Exception {
		// the first supertype must be a class, and then the other ones interfaces
		var source = "classWithSuperTypes Foo superTypes Object, Cloneable {}";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testOverrideFinalClass() throws Exception {
		var source = "class Foo extends String { }";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, OVERRIDDEN_FINAL,
				source.indexOf("String"), "String".length(),
				"override", "final");
	}

	@Test
	public void testWildcardSuperType() throws Exception {
		var source = "class Foo extends Bar<?>{}"
		+ "class Bar<T> {}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, WILDCARD_IN_SUPERTYPE,
				source.indexOf("Bar<?>"), "Bar<?>".length());
	}

	@Test public void testConstructorDuplicate() throws Exception {
		var source = "class K { constructor (Object o) {} constructor (Object o) {} }";
		var model = parse(source);
		var wrongPart = "constructor (Object o) {}";
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_METHOD,
				source.indexOf(wrongPart), wrongPart.length(),
				"Duplicate", "constructor");
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_METHOD,
				source.lastIndexOf(wrongPart), wrongPart.length(),
				"Duplicate", "constructor");
	}

	@Test public void testConstructorDuplicateErasure() throws Exception {
		var source = "class K { "
				+ "constructor (java.util.List<Object> o) {}"
				+ "constructor (java.util.List<String> o) {}"
				+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_METHOD,
				source.indexOf("constructor (java.util.List<Object> o) {}"),
				"constructor (java.util.List<Object> o) {}".length(),
				"erasure", "constructor", "List<Object>");
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_METHOD,
				source.indexOf("constructor (java.util.List<String> o) {}"),
				"constructor (java.util.List<String> o) {}".length(),
				"erasure", "constructor", "List<String>");
	}

	@Test public void testDuplicateMethod() throws Exception {
		var source = "class Foo {"
				+ "def boolean bar(int x) {true}"
				+ "def boolean bar(int x) {false}"
				+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.indexOf("bar"), "bar".length(),
				"duplicate", "method");
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.lastIndexOf("bar"), "bar".length(),
				"duplicate", "method");
	}

	@Test public void testDuplicateMethodErasure() throws Exception {
		var source = "class Foo {"
				+ "def boolean bar(java.util.List<Object> o) {true}"
				+ "def boolean bar(java.util.List<String> o) {false}"
				+ "}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.indexOf("bar"), "bar".length(),
				"erasure", "method", "List<Object>");
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.lastIndexOf("bar"), "bar".length(),
				"erasure", "method", "List<String>");
	}

	@Test public void testOverrideStaticMethod() throws Exception {
		var source = "class Foo extends testdata.Methods {  " +
				"def void staticMethod() {}"+
			"}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.indexOf("staticMethod"), "staticMethod".length(),
				"The instance method", "Methods",
				"cannot override the static method");
	}

	@Test public void testStaticMethodHidesInstanceMethod() throws Exception {
		var source = "class Foo extends test.Methods {" +
					"def static void method(int i) {}"+
					"}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.indexOf("method"), "method".length(),
				"The static method", "Methods",
				"cannot hide the instance method");
	}

	@Test public void testOverrideGenericMethod_10() throws Exception {
		var source = "class Foo extends test.GenericSuperTypeClass<String> {  " +
					"def <T extends String> void foo1() {}"+
					"}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_METHOD,
				source.indexOf("foo1"), "foo1".length(),
				"Name clash", "same erasure", "GenericSuperTypeClass",
				"does not override it");
	}

	@Test public void testConflictingDefaultMethods() throws Exception {
		var source = "class C implements "
				+ "test.InterfaceWithDefaultMethod1,"
				+ "test.InterfaceWithDefaultMethod2 { }";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CONFLICTING_DEFAULT_METHODS,
			source.indexOf("C"), 1,
			"The type C inherits multiple implementations of the method foo()"
			+ " from InterfaceWithDefaultMethod1 and InterfaceWithDefaultMethod2.");
	}

	@Test public void testConflictingDefaultMethods00() throws Exception {
		var source = "interface C extends "
				+ "test.InterfaceWithDefaultMethod1,"
				+ "test.InterfaceWithDefaultMethod2 { }";
		var model = parse(source);
		validationHelper.assertError(model, MY_INTERFACE, CONFLICTING_DEFAULT_METHODS,
			source.indexOf("C"), 1,
			"The type C inherits multiple implementations of the method foo()"
			+ " from InterfaceWithDefaultMethod1 and InterfaceWithDefaultMethod2.");
	}

	@Test public void testConflictingDefaultMethods01() throws Exception {
		var source = "class C implements "
				+ "test.InterfaceWithDefaultMethod1,"
				+ "test.InterfaceWithAbstractMethod { }";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CONFLICTING_DEFAULT_METHODS,
			source.indexOf("C"), 1,
			"The non-abstract method foo() inherited from "
			+ "InterfaceWithDefaultMethod1 conflicts with the method foo()"
			+ " inherited from InterfaceWithAbstractMethod.");
	}

	@Test public void testConflictingDefaultMethods02() throws Exception {
		var source = "class C implements "
				+ "test.InterfaceWithAbstractMethod,"
				+ "test.InterfaceWithDefaultMethod1 { }";
		var model = parse(source);
		validationHelper.assertError(model, MY_CLASS, CONFLICTING_DEFAULT_METHODS,
			source.indexOf("C"), 1,
			"The non-abstract method foo() inherited from "
			+ "InterfaceWithDefaultMethod1 conflicts with the method foo()"
			+ " inherited from InterfaceWithAbstractMethod.");
	}

	@Test public void testOverrideFinalMethod() throws Exception {
		var source = "class Foo extends test.ClassWithFinalMembers { def void foo() {} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, OVERRIDDEN_FINAL,
				source.indexOf("foo"), "foo".length(),
				"override", "final");
	}

	@Test public void testOverrideNonFinalMethod() throws Exception {
		var source = "class Foo extends test.SuperTypeClass { def void foo() {} }";
		var model = parse(source);
		validationHelper.assertNoErrors(model);
	}

	@Test public void testOverrideIncompatbileReturnType() throws Exception {
		var source = "class Foo extends test.SuperTypeClass { def Integer stringMethod() {null} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, INCOMPATIBLE_RETURN_TYPE,
				source.indexOf("Integer"), "Integer".length(),
				"incompatible", "stringMethod");
	}

	@Test public void testOverrideHides() throws Exception {
		var source = "class Foo extends test.SuperTypeClass { def private void foo() {} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, OVERRIDE_REDUCES_VISIBILITY,
				source.indexOf("foo"), "foo".length(),
				"reduce", "visibility");
	}

	@Test public void testIncompatibleThrowsClause() throws Exception {
		var source = "class Foo extends test.ExceptionThrowing {"
				+ "def void ioException() throws Exception {} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, INCOMPATIBLE_THROWS_CLAUSE,
				source.lastIndexOf("Exception"), "Exception".length(),
				"Exception", "is not", "compatible", "throws", "clause");
	}

	/**
	 * Two incompatible exceptions from three supertypes;
	 * the marker is set on the offending exceptions only.
	 * https://github.com/eclipse/xtext/issues/2912
	 */
	@Test public void testIncompatibleThrowsClauseFromMultipleSuperTypes() throws Exception {
		var source = "class Foo extends test.ExceptionThrowing "
				+ "implements test.ExceptionThrowingInterface, test.ExceptionThrowingInterface2 {"
				+ "def void nullPointerException() throws "
				+ "NullPointerException, java.io.IOException, java.io.FileNotFoundException {} "
				+ "}";
		var model = parse(source);
		var expectedSuffix = " is not compatible with the throws clause in "
				+ "ExceptionThrowing.nullPointerException(), ExceptionThrowingInterface.nullPointerException() and ExceptionThrowingInterface2.nullPointerException()";
		validationHelper.assertError(model, MY_METHOD, INCOMPATIBLE_THROWS_CLAUSE,
				source.indexOf("java.io.IOException"), "java.io.IOException".length(),
				"declared exception IOException",
				expectedSuffix);
		validationHelper.assertError(model, MY_METHOD, INCOMPATIBLE_THROWS_CLAUSE,
				source.indexOf("java.io.FileNotFoundException"), "java.io.FileNotFoundException".length(),
				"declared exception FileNotFoundException",
				expectedSuffix);
	}

	@Test public void testSynchronized_1() throws Exception{
		var source = "class Foo extends Bar { def int myMethod() {1} } "
				+ "class Bar { def synchronized int myMethod() {0} }";
		var model = parse(source);
		validationHelper.assertWarning(model, MY_METHOD, MISSING_SYNCHRONIZED,
				source.indexOf("myMethod"), "myMethod".length(),
				"The overridden method is synchronized, the current one is not synchronized");
	}

	@Test public void testSynchronized_2() throws Exception{
		var model = parse("class Foo extends Bar { def synchronized int myMethod() {1} } "
				+ "class Bar { def synchronized int myMethod() {0} }");
		validationHelper.assertNoWarnings(model, MY_METHOD, MISSING_SYNCHRONIZED);
	}

	@Test public void testDuplicateParameter() throws Exception {
		var source = "class Foo { def void foo(int x, int x) {} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_PARAMETER_NAME,
				source.indexOf("int x"), "int x".length(),
				"duplicate", "x");
		validationHelper.assertError(model, MY_METHOD, DUPLICATE_PARAMETER_NAME,
				source.lastIndexOf("int x"), "int x".length(),
				"duplicate", "x");
	}

	@Test public void testDuplicateConstructorParameter() throws Exception {
		var source = "class Foo { constructor(int x, int x) {null} }";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_PARAMETER_NAME,
				source.indexOf("int x"), "int x".length(),
				"duplicate", "x");
		validationHelper.assertError(model, MY_CONSTRUCTOR, DUPLICATE_PARAMETER_NAME,
				source.lastIndexOf("int x"), "int x".length(),
				"duplicate", "x");
	}

	@Test public void testInvalidVoidInMethodParameterType() throws Exception {
		var source = "class X { def void m(void v) {} }";
		var model = parse(source);
		validationHelper.assertError(model, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE,
				source.lastIndexOf("void"), "void".length());
	}

	@Test public void testInvalidVoidInConstructorParameterType() throws Exception {
		var source = "class X { constructor(void v) {} }";
		var model = parse(source);
		validationHelper.assertError(model, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE,
				source.indexOf("void"), "void".length());
	}

	@Test public void testConstructorThrownExceptionsOfTypeThrowable() throws Exception {
		var source = "class X { constructor () throws Integer { }}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, EXCEPTION_NOT_THROWABLE,
				source.indexOf("Integer"), "Integer".length(),
				"No", "can", "subclass", "Throwable");
	}
	
	@Test public void testFunctionThrownExceptionsOfTypeThrowable() throws Exception {
		var source = "class X { def void foo() throws Integer { } }";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, EXCEPTION_NOT_THROWABLE,
				source.indexOf("Integer"), "Integer".length(),
				"No", "can", "subclass", "Throwable");
	}

	@Test public void testExceptionsDeclaredTwiceOnConstructor() throws Exception {
		var source = "import java.io.IOException class X { constructor () throws IOException, IOException { }}";
		var model = parse(source);
		validationHelper.assertError(model, MY_CONSTRUCTOR, EXCEPTION_DECLARED_TWICE,
				source.lastIndexOf("IOException"), "IOException".length(),
				"IOException", "declared", "twice");
	}

	@Test public void testExceptionsDeclaredTwiceOnFunction() throws Exception {
		var source = "import java.io.IOException class X {def void foo() throws IOException, IOException { }}";
		var model = parse(source);
		validationHelper.assertError(model, MY_METHOD, EXCEPTION_DECLARED_TWICE,
				source.lastIndexOf("IOException"), "IOException".length(),
				"IOException", "declared", "twice");
	}

	@Test public void testCheckInferredTypePerPrimarySourceElementOnlyOnce_issue_3045() throws Exception {
		var source = "classWithWrongInferredInterface X {"
				+ " def void foo(String par) {  }"
				+ "}";
		var model = parse(source);
		// this one is detected during type computation because of the wrong
		// inferred interface's method with duplicate parameter
		// (see org.eclipse.xtext.xbase.testlanguages.jvmmodel.JvmGenericTypeValidatorTestLangJmvModelInferrer.inferClassAndWrongInterface(MyClassWithWrongAdditionalInferredInterface, IJvmDeclaredTypeAcceptor, boolean))
		validationHelper.assertError(model, TypesPackage.Literals.JVM_FORMAL_PARAMETER, VARIABLE_NAME_SHADOWING,
				source.indexOf("par"), "par".length(),
				"Duplicate local variable par");
		// but this one is not detected by the JvmGenericTypeValidator
		// because it doesn't check the inferred interface: its primary source element
		// is the inferred class, and a JvmGenericType is checked only once per primary source element
		validationHelper.assertNoError(model, DUPLICATE_PARAMETER_NAME);
	}

	private JvmGenericTypeValidatorTestLangModel parse(CharSequence programText) throws Exception {
		return parseHelper.parse(programText);
	}
}
