/*******************************************************************************
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.outline;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class QuickOutlineTests extends AbstractOutlineTests {

	@Inject
	private QuickOutlineFilterAndSorter sorter;

	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}

	@Test
	public void testNoImports() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("import java.lang.* class Foo {}");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(0);
	}

	@Test
	public void testSorting() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder(
				"package test import java.lang.* class Foo {" + " def baz() {null}"
						+ " def dispatch foo(String x) {''}" + " def dispatch bar(String x) {''}"
						+ " def dispatch bar(Object y) {''}" + " def dispatch foo(Object y) {''}" + " String fooBar"
						+ " new() {}" + "}").numChildren(2);
		assertBuilder.child(0, "test").numChildren(0);
		AssertBuilder foo = assertBuilder.child(1, "Foo").numChildren(5);
		foo.child(0, "fooBar : String").numChildren(0);
		foo.child(1, "new()").numChildren(0);
		foo.child(2, "bar(Object) : String").numChildren(2).child(0, "bar(Object) : String");
		foo.child(3, "foo(Object) : String").numChildren(2).child(0, "foo(Object) : String");
		foo.child(4, "baz() : Object").numChildren(0);
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

	@Test
	public void testFieldsFromSuper() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile("test/Super.java",
				"package test; " + "public class Super {" + "class SubOfFoo extends Foo {}  protected int foo;" + "  private String bar;" + "}");
		waitForBuild();
		String model = "package test " + "class Foo extends Super {" + "  Number baz" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		waitForBuild();
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		int numChildren = 16;
		if (JavaRuntimeVersion.isJava14OrLater()) {
			numChildren = 15;
		}
		if (JavaRuntimeVersion.isJava21OrLater()) {
			numChildren = 16; // wait0
		}
		sub = assertBuilder.child(1, "Foo - test").numChildren(numChildren);
		int counter = 0;
		sub.child(counter++, "baz : Number - Foo").numChildren(0).hasTextRegion(true);
		sub.child(counter++, "SubOfFoo - Super").hasTextRegion(false);
		sub.child(counter++, "bar : String - Super").numChildren(0).hasTextRegion(false);
		sub.child(counter++, "foo : int - Super").numChildren(0).hasTextRegion(false);
		if (!JavaRuntimeVersion.isJava14OrLater()) {
			sub.child(counter++, "registerNatives() : void - Object").hasTextRegion(false);
		}
		sub.child(counter++, "clone() : Object - Object").hasTextRegion(false);
		sub.child(counter++, "equals(Object) : boolean - Object").hasTextRegion(false);
		sub.child(counter++, "finalize() : void - Object").hasTextRegion(false);
		sub.child(counter++, "getClass() : Class<?> - Object").hasTextRegion(false);
		sub.child(counter++, "hashCode() : int - Object").hasTextRegion(false);
		sub.child(counter++, "notify() : void - Object").hasTextRegion(false);
		sub.child(counter++, "notifyAll() : void - Object").hasTextRegion(false);
		sub.child(counter++, "toString() : String - Object").hasTextRegion(false);
		sub.child(counter++, "wait() : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long) : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long, int) : void - Object").hasTextRegion(false);
	}

	@Test
	public void testMethodsFromSuper() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile(
				"test/Super.java",
				"package test; " + "public class Super {" + "  protected int foo(String x) { return 1; }"
						+ "  private String bar() { return null; }" + "}");
		waitForBuild();
		String model = "package test " + "class Foo extends Super {" + "  def Number baz() { null }" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz() : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		int numChildren = 15;
		if (JavaRuntimeVersion.isJava14OrLater()) {
			numChildren = 14;
		}
		if (JavaRuntimeVersion.isJava21OrLater()) {
			numChildren = 15; // wait0
		}
		sub = assertBuilder.child(1, "Foo - test").numChildren(numChildren);
		int counter = 0;
		sub.child(counter++, "baz() : Number - Foo").numChildren(0).hasTextRegion(true);
		sub.child(counter++, "bar() : String - Super").hasTextRegion(false);
		sub.child(counter++, "foo(String) : int - Super").hasTextRegion(false);
		if (!JavaRuntimeVersion.isJava14OrLater()) {
			sub.child(counter++, "registerNatives() : void - Object").hasTextRegion(false);
		}
		sub.child(counter++, "clone() : Object - Object").hasTextRegion(false);
		sub.child(counter++, "equals(Object) : boolean - Object").hasTextRegion(false);
		sub.child(counter++, "finalize() : void - Object").hasTextRegion(false);
		sub.child(counter++, "getClass() : Class<?> - Object").hasTextRegion(false);
		sub.child(counter++, "hashCode() : int - Object").hasTextRegion(false);
		sub.child(counter++, "notify() : void - Object").hasTextRegion(false);
		sub.child(counter++, "notifyAll() : void - Object").hasTextRegion(false);
		sub.child(counter++, "toString() : String - Object").hasTextRegion(false);
		sub.child(counter++, "wait() : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long) : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long, int) : void - Object").hasTextRegion(false);
	}
	
	@Test
	public void testMethodsFromSuper_02() throws Exception {
		setShowInherited(false);
		String model = "package pack.name class C { enum E { VAL } }";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "C").numChildren(1).hasTextRegion(true);
		sub.child(0, "E").numChildren(1).hasTextRegion(true);
		
		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		int numChildren = 13;
		if (JavaRuntimeVersion.isJava14OrLater()) {
			numChildren = 12;
		}
		if (JavaRuntimeVersion.isJava21OrLater()) {
			numChildren = 13; // wait0
		}
		sub = assertBuilder.child(1, "C - pack.name").numChildren(numChildren);
		int counter = 0;
		sub.child(counter++, "E - C").hasTextRegion(true);
		if (!JavaRuntimeVersion.isJava14OrLater()) {
			sub.child(counter++, "registerNatives() : void - Object").hasTextRegion(false);
		}
		sub.child(counter++, "clone() : Object - Object").hasTextRegion(false);
		sub.child(counter++, "equals(Object) : boolean - Object").hasTextRegion(false);
		sub.child(counter++, "finalize() : void - Object").hasTextRegion(false);
		sub.child(counter++, "getClass() : Class<?> - Object").hasTextRegion(false);
		sub.child(counter++, "hashCode() : int - Object").hasTextRegion(false);
		sub.child(counter++, "notify() : void - Object").hasTextRegion(false);
		sub.child(counter++, "notifyAll() : void - Object").hasTextRegion(false);
		sub.child(counter++, "toString() : String - Object").hasTextRegion(false);
		sub.child(counter++, "wait() : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long) : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long, int) : void - Object").hasTextRegion(false);
	}

	@Test
	public void testMixedDispatch_0() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile("test/Super.java",
				"package test; " + "public class Super {" + "  protected void _foo(String x) { }" + "}");
		waitForBuild();
		String model = "package test " + "class Foo extends Super {" + "  def dispatch void foo(Number x) { }" + "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "foo(Serializable) : void").numChildren(1).child(0, "foo(Number) : void").numChildren(0)
				.hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		int numChildren = 13;
		if (JavaRuntimeVersion.isJava14OrLater()) {
			numChildren = 12;
		}
		if (JavaRuntimeVersion.isJava21OrLater()) {
			numChildren = 13; // wait0
		}
		sub = assertBuilder.child(1, "Foo - test").numChildren(numChildren).hasTextRegion(true);
		AssertBuilder foo = sub.child(0, "foo(Serializable) : void - Foo").numChildren(2).hasTextRegion(true);
		int counter = 0;
		foo.child(counter++, "_foo(String) : void - Super").numChildren(0).hasTextRegion(false);
		foo.child(counter++, "foo(Number) : void - Foo").numChildren(0).hasTextRegion(true);
		counter = 1;
		if (!JavaRuntimeVersion.isJava14OrLater()) {
			sub.child(counter++, "registerNatives() : void - Object").hasTextRegion(false);
		}
		sub.child(counter++, "clone() : Object - Object").hasTextRegion(false);
		sub.child(counter++, "equals(Object) : boolean - Object").hasTextRegion(false);
		sub.child(counter++, "finalize() : void - Object").hasTextRegion(false);
		sub.child(counter++, "getClass() : Class<?> - Object").hasTextRegion(false);
		sub.child(counter++, "hashCode() : int - Object").hasTextRegion(false);
		sub.child(counter++, "notify() : void - Object").hasTextRegion(false);
		sub.child(counter++, "notifyAll() : void - Object").hasTextRegion(false);
		sub.child(counter++, "toString() : String - Object").hasTextRegion(false);
		sub.child(counter++, "wait() : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long) : void - Object").hasTextRegion(false);
		sub.child(counter++, "wait(long, int) : void - Object").hasTextRegion(false);

	}
	
	@Test
	public void testResolvedSignatures() throws Exception {
		setShowInherited(false);
		getWorkbenchTestHelper().createFile("test/Super.java",
				"package test; "
			  + "import java.util.*;"	
			  + "public class Super<T> {" 
			  + "  T a;"
			  + "  List<T> b;"
			  + "  Map<List<T>,T> c;"
			  + "  public Super(List<T> x) { }" 
			  + "  protected T foo(List<T> x) { return null; }" 
			  + "}");
		waitForBuild();
		String model = "package test " 
		+ "class Foo extends Super<String> {"
		+ " new() { super(null) }"
		+ "}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "new()").hasTextRegion(true);
		
		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		int numChildren = 18;
		if (JavaRuntimeVersion.isJava14OrLater()) {
			numChildren = 17;
		}
		if (JavaRuntimeVersion.isJava21OrLater()) {
			numChildren = 18; // wait0
		}
		sub = assertBuilder.child(1, "Foo - test").numChildren(numChildren).hasTextRegion(true);
		int i = 0;
		sub.child(i++, "new() - Foo").hasTextRegion(true);
		sub.child(i++, "a : String - Super<String>").hasTextRegion(false);
		sub.child(i++, "b : List<String> - Super<String>").hasTextRegion(false);
		sub.child(i++, "c : Map<List<String>, String> - Super<String>").hasTextRegion(false);
		sub.child(i++, "new(List<String>) - Super<String>").hasTextRegion(false);
		sub.child(i++, "foo(List<String>) : String - Super<String>").hasTextRegion(false);
		if (!JavaRuntimeVersion.isJava14OrLater()) {
			sub.child(i++, "registerNatives() : void - Object").hasTextRegion(false);
		}
		sub.child(i++, "clone() : Object - Object").hasTextRegion(false);
		sub.child(i++, "equals(Object) : boolean - Object").hasTextRegion(false);
		sub.child(i++, "finalize() : void - Object").hasTextRegion(false);
		sub.child(i++, "getClass() : Class<?> - Object").hasTextRegion(false);
		sub.child(i++, "hashCode() : int - Object").hasTextRegion(false);
		sub.child(i++, "notify() : void - Object").hasTextRegion(false);
		sub.child(i++, "notifyAll() : void - Object").hasTextRegion(false);
		sub.child(i++, "toString() : String - Object").hasTextRegion(false);
		sub.child(i++, "wait() : void - Object").hasTextRegion(false);
		sub.child(i++, "wait(long) : void - Object").hasTextRegion(false);
		sub.child(i++, "wait(long, int) : void - Object").hasTextRegion(false);
	}

}
