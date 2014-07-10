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
		String model = "package test " + "class Foo extends Super {Number baz}"
				+ " class Foo2 extends Super {Number baz} ";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(3);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		AssertBuilder sub2 = assertBuilder.child(2, "Foo2").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(3);

		sub = assertBuilder.child(1, "Foo - test").numChildren(15);
		checkExtendedMethods(sub, "Foo");
		sub2 = assertBuilder.child(2, "Foo2 - test").numChildren(15);
		checkExtendedMethods(sub2, "Foo2");
	}

	private void checkExtendedMethods(AssertBuilder sub, String parentName) {
		sub.child(0, "baz : Number - test." + parentName).numChildren(0).hasTextRegion(true);
		sub.nextChild("bar : String - test.Super").numChildren(0).hasTextRegion(false);
		sub.nextChild("foo : int - test.Super").numChildren(0).hasTextRegion(false);
		sub.nextChild("registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.nextChild("equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.nextChild("finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.nextChild("hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notify() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("toString() : String - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long, int) : void - java.lang.Object").hasTextRegion(false);
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
		String model = "package test " + "class Foo extends Super {"
				+ "  def Number baz() { null }  override toString(){super.toString()}" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(2).hasTextRegion(true);
		sub.child(0, "baz() : Number").numChildren(0).hasTextRegion(true);
		sub.child(1, "toString() : String").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo - test").numChildren(16);
		sub.child(0, "baz() : Number - test.Foo").numChildren(0).hasTextRegion(true);
		sub.nextChild("toString() : String - test.Foo").numChildren(0).hasTextRegion(true);
		sub.nextChild("bar() : String - test.Super").hasTextRegion(false);
		sub.nextChild("foo(String) : int - test.Super").hasTextRegion(false);
		sub.nextChild("registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.nextChild("equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.nextChild("finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.nextChild("hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notify() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("toString() : String - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long, int) : void - java.lang.Object").hasTextRegion(false);
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
		sub.nextChild("_foo(Number) : void - test.Foo").hasTextRegion(true);
		sub.nextChild("foo(Serializable) : void - test.Foo");
		sub.nextChild("_foo(String) : void - test.Super").numChildren(0).hasTextRegion(false);
		sub.nextChild("registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.nextChild("equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.nextChild("finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.nextChild("hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notify() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("toString() : String - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait() : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.nextChild("wait(long, int) : void - java.lang.Object").hasTextRegion(false);

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
		foo.nextChild("new()").numChildren(0);
		foo.nextChild("_bar(Object) : String");
		foo.nextChild("_bar(String) : String");
		foo.nextChild("_foo(Object) : String");
		foo.nextChild("_foo(String) : String");
		foo.nextChild("bar(Object) : String");
		foo.nextChild("baz() : Object").numChildren(0);
		foo.nextChild("foo(Object) : String");
	}

	@Test
	@Override
	public void testNestedTypes() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { int foo static class Bar { def bar() {} interface Baz {} enum FooBar{ X } } }");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		AssertBuilder bar = foo.child(0, "Bar").numChildren(3);
		foo.nextChild("foo : int").numChildren(0);
		bar.nextChild("Baz").numChildren(0);
		bar.nextChild("FooBar").numChildren(1);
		bar.nextChild("bar() : Object").numChildren(0);
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
