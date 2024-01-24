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

	private JvmGenericTypeValidatorTestLangModel parse(CharSequence programText) throws Exception {
		return parseHelper.parse(programText);
	}
}
