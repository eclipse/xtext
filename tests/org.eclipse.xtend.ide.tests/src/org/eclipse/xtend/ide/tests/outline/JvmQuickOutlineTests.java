/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.outline;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class JvmQuickOutlineTests extends QuickOutlineTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		setJvmMode(true);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		setJvmMode(false);
	}

	@Override
	@Test
	public void testFieldsFromSuper() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile("test/Super.java",
				"package test; " + "public class Super {" + "  protected int foo;" + "  private String bar;" + "}");
		waitForAutoBuild();
		String model = "package test " + "class Foo extends Super {" + "  Number baz" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo - test").numChildren(15);
		sub.child(0, "baz : Number - test.Foo").numChildren(0).hasTextRegion(true);
		sub.child(1, "bar : String - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(2, "foo : int - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(3, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(4, "clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.child(5, "equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.child(6, "finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.child(7, "getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.child(8, "hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.child(9, "notify() : void - java.lang.Object").hasTextRegion(false);
		sub.child(10, "notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.child(11, "toString() : String - java.lang.Object").hasTextRegion(false);
		sub.child(12, "wait() : void - java.lang.Object").hasTextRegion(false);
		sub.child(13, "wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.child(14, "wait(long, int) : void - java.lang.Object").hasTextRegion(false);
	}

	@Override
	@Test
	public void testMethodsFromSuper() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile(
				"test/Super.java",
				"package test; " + "public class Super {" + "  protected int foo(String x) { return 1; }"
						+ "  private String bar() { return null; }" + "}");
		waitForAutoBuild();
		String model = "package test " + "class Foo extends Super {" + "  def Number baz() { null }" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz() : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo - test").numChildren(15);
		sub.child(0, "baz() : Number - test.Foo").numChildren(0).hasTextRegion(true);
		sub.child(1, "bar() : String - test.Super").hasTextRegion(false);
		sub.child(2, "foo(String) : int - test.Super").hasTextRegion(false);
		sub.child(3, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(4, "clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.child(5, "equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.child(6, "finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.child(7, "getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.child(8, "hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.child(9, "notify() : void - java.lang.Object").hasTextRegion(false);
		sub.child(10, "notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.child(11, "toString() : String - java.lang.Object").hasTextRegion(false);
		sub.child(12, "wait() : void - java.lang.Object").hasTextRegion(false);
		sub.child(13, "wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.child(14, "wait(long, int) : void - java.lang.Object").hasTextRegion(false);
	}

	@Override
	@Test
	public void testMixedDispatch_0() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile("test/Super.java",
				"package test; " + "public class Super {" + "  protected void _foo(String x) { }" + "}");
		waitForAutoBuild();
		String model = "package test " + "class Foo extends Super {" + "  def dispatch void foo(Number x) { }" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(2);
		sub.child(0, "_foo(Number) : void").numChildren(0).hasTextRegion(true);
		sub.child(1, "foo(Serializable) : void");

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo - test").numChildren(15).hasTextRegion(true);
		sub.child(0, "_foo(Number) : void - test.Foo").hasTextRegion(true);
		sub.child(1, "foo(Serializable) : void - test.Foo");
		sub.child(2, "_foo(String) : void - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(3, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(4, "clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.child(5, "equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.child(6, "finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.child(7, "getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.child(8, "hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.child(9, "notify() : void - java.lang.Object").hasTextRegion(false);
		sub.child(10, "notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.child(11, "toString() : String - java.lang.Object").hasTextRegion(false);
		sub.child(12, "wait() : void - java.lang.Object").hasTextRegion(false);
		sub.child(13, "wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.child(14, "wait(long, int) : void - java.lang.Object").hasTextRegion(false);

	}

	@Override
	@Test
	public void testSorting() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder(
				"package test import java.lang.* class Foo {" + " def baz() {null}"
						+ " def dispatch foo(String x) {''}" + " def dispatch bar(String x) {''}"
						+ " def dispatch bar(Object y) {''}" + " def dispatch foo(Object y) {''}" + " String fooBar"
						+ " new() {}" + "}").numChildren(2);
		assertBuilder.child(0, "test").numChildren(0);
		AssertBuilder foo = assertBuilder.child(1, "Foo").numChildren(9);
		foo.child(0, "fooBar : String").numChildren(0);
		foo.child(1, "new()").numChildren(0);
		foo.child(2, "_bar(Object) : String");
		foo.child(3, "_bar(String) : String");
		foo.child(4, "_foo(Object) : String");
		foo.child(5, "_foo(String) : String");
		foo.child(6, "bar(Object) : String");
		foo.child(7, "baz() : Object").numChildren(0);
		foo.child(8, "foo(Object) : String");
	}

	@Test
	@Override
	public void testNestedTypes() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { int foo static class Bar { def bar() {} interface Baz {} enum FooBar{ X } } }");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		AssertBuilder bar = foo.child(0, "Bar").numChildren(3);
		foo.child(1, "foo : int").numChildren(0);
		bar.child(0, "Baz").numChildren(0);
		bar.child(1, "FooBar").numChildren(1);
		bar.child(2, "bar() : Object").numChildren(0);
	}

	@Override
	@Test
	public void testCreateExtensionInfo_dispatch() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {  dispatch def create value : 'bar' foo(Integer it) {}  dispatch def create value : 'foo' foo(String it) {} }");
		AssertBuilder type = assertBuilder.numChildren(1).child(0, "Foo").numChildren(7);
		type.leaf(0, "_createCache_foo : HashMap<ArrayList<?>, String>");
		type.leaf(1, "_createCache_foo_1 : HashMap<ArrayList<?>, String>");
		type.leaf(2, "_foo(Integer) : String");
		type.leaf(3, "_foo(String) : String");
		type.leaf(4, "_init_foo(String, Integer) : void");
		type.leaf(5, "_init_foo_1(String, String) : void");
		type.leaf(6, "foo(Object) : String");
	}

	@Override
	@Test
	public void testAnnotationType() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) annotation Foo { int bar String foo = '' }");
		AssertBuilder annotationType = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		annotationType.leaf(0, "bar() : int");
		annotationType.leaf(1, "foo() : String");
	}

	@Override
	@Test
	public void testCreateExtensionInfo() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def create 'lalala' foo() {} }");
		AssertBuilder type = assertBuilder.numChildren(1).child(0, "Foo").numChildren(3);
		type.leaf(0, "_createCache_foo : HashMap<ArrayList<?>, String>");
		type.leaf(1, "_init_foo(String) : void");
		type.leaf(2, "foo() : String");
	}

	@Override
	@Test
	public void testOperatorDeclarationWithSymbol() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def java.lang.String !(Object o) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).leaf(0, "operator_not(Object) : String");
	}

	@Override
	@Test
	public void testOperatorDeclarationWithName() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def java.lang.String operator_not(Object o) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).leaf(0, "operator_not(Object) : String");
	}

	@Override
	@Test
	public void testDispatchMethod() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def dispatch foo(Object x) {''} def dispatch foo(String y) {''} }");
		AssertBuilder type = assertBuilder.numChildren(1).child(0, "Foo").numChildren(3);
		type.leaf(0, "_foo(Object) : String");
		type.leaf(1, "_foo(String) : String");
		type.leaf(2, "foo(Object) : String");
	}

	@Override
	@Test
	public void testTypeParameter1() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo <T> {}");
		assertBuilder.numChildren(1).child(0, "Foo<T extends Object>").numChildren(0);
	}

}
