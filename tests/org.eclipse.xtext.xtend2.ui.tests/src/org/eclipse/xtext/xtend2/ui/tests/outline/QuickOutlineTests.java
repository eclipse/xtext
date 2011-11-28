/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.outline;

import java.util.List;

import junit.framework.Test;

import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class QuickOutlineTests extends AbstractOutlineTests {

	public static Test suite() {
		return WorkbenchTestHelper.suite(QuickOutlineTests.class);
	}

	@Inject
	private QuickOutlineFilterAndSorter sorter;

	@Inject
	private WorkbenchTestHelper workbenchHelper;

	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}

	public void testNoImports() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("import java.lang.* class Foo {}");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(0);
	}

	public void testSorting() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder(
				"package test import java.lang.* class Foo {" + 
				" def baz() {null}" + 
				" def dispatch foo(String x) {''}" + 
				" def dispatch bar(String x) {''}" +
				" def dispatch bar(Object y) {''}" + 
				" def dispatch foo(Object y) {''}" + 
				" String fooBar" + 
				" new() {}" + 
				"}").numChildren(2);
		assertBuilder.child(0, "test").numChildren(0);
		AssertBuilder foo = assertBuilder.child(1, "Foo").numChildren(5);
		foo.child(0, "fooBar : String").numChildren(0);
		foo.child(1, "new()").numChildren(0);
		foo.child(2, "bar(Object) : String").numChildren(2).child(0, "bar(Object) : String");
		foo.child(3, "foo(Object) : String").numChildren(2).child(0, "foo(Object) : String");
		foo.child(4, "baz() : Object").numChildren(0);
	}

	public void testFieldsFromSuper() throws Exception {
		setShowInherited(false);
		workbenchHelper.createFile("test/Super.java", 
				"package test; " + 
				"public class Super {" + 
				"  protected int foo;" + 
				"  private String bar;" + 
				"}");
		waitForAutoBuild();
		String model =
				"package test " + 
				"class Foo extends Super {" + 
				"  Number baz" +
				"}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1);
		sub.child(0, "baz : Number").numChildren(0);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(15);
		sub.child(0, "baz : Number").numChildren(0);
		sub.child(1, "foo : int - test.Super").numChildren(0);
		sub.child(2, "new() - java.lang.Object");
		sub.child(3, "new() - test.Super");
		sub.child(4, "clone() : Object - java.lang.Object");
		sub.child(5, "equals(Object) : boolean - java.lang.Object");
		sub.child(6, "finalize() : void - java.lang.Object");
		sub.child(7, "getClass() : Class<?> - java.lang.Object");
		sub.child(8, "hashCode() : int - java.lang.Object");
		sub.child(9, "notify() : void - java.lang.Object");
		sub.child(10, "notifyAll() : void - java.lang.Object");
		sub.child(11, "toString() : String - java.lang.Object");
		sub.child(12, "wait() : void - java.lang.Object");
		sub.child(13, "wait(long) : void - java.lang.Object");
		sub.child(14, "wait(long, int) : void - java.lang.Object");
		// private field bar stays invisible
	}
	
	public void testMethodsFromSuper() throws Exception {
		setShowInherited(false);
		workbenchHelper.createFile("test/Super.java", 
				"package test; " + 
				"public class Super {" + 
				"  protected int foo(String x) { return 1; }" + 
				"  private String bar() { return null; }" + 
				"}");
		waitForAutoBuild();
		String model = 
				"package test " + 
				"class Foo extends Super {" + 
				"  def Number baz() { null }" +
				"}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1);
		sub.child(0, "baz() : Number").numChildren(0);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(15);
		sub.child(0, "new() - java.lang.Object");
		sub.child(1, "new() - test.Super");
		sub.child(2, "baz() : Number").numChildren(0);
		sub.child(3, "clone() : Object - java.lang.Object");
		sub.child(4, "equals(Object) : boolean - java.lang.Object");
		sub.child(5, "finalize() : void - java.lang.Object");
		sub.child(6, "foo(String) : int - test.Super").numChildren(0);
		sub.child(7, "getClass() : Class<?> - java.lang.Object");
		sub.child(8, "hashCode() : int - java.lang.Object");
		sub.child(9, "notify() : void - java.lang.Object");
		sub.child(10, "notifyAll() : void - java.lang.Object");
		sub.child(11, "toString() : String - java.lang.Object");
		sub.child(12, "wait() : void - java.lang.Object");
		sub.child(13, "wait(long) : void - java.lang.Object");
		sub.child(14, "wait(long, int) : void - java.lang.Object");
		// private method bar() stays invisible
	}
	
	public void testMixedDispatch_0() throws Exception {
		setShowInherited(false);
		workbenchHelper.createFile("test/Super.java", 
				"package test; " + 
				"public class Super {" + 
				"  protected void _foo(String x) { }" + 
				"}");
		waitForAutoBuild();
		String model = 
				"package test " + 
				"class Foo extends Super {" + 
				"  def dispatch void foo(Number x) { }" +
				"}";
		AssertBuilder assertBuilder = newAssertBuilder(model).numChildren(2);
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1);
		sub.child(0, "foo(Serializable) : void").numChildren(1).child(0, "foo(Number) : void").numChildren(0);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(14);
		sub.child(0, "new() - java.lang.Object");
		sub.child(1, "new() - test.Super");
		AssertBuilder foo = sub.child(2, "foo(Serializable) : void").numChildren(2);
		foo.child(0, "_foo(String) : void - test.Super").numChildren(0);
		foo.child(1, "foo(Number) : void").numChildren(0);
		sub.child(3, "clone() : Object - java.lang.Object");
		sub.child(4, "equals(Object) : boolean - java.lang.Object");
		sub.child(5, "finalize() : void - java.lang.Object");
		sub.child(6, "getClass() : Class<?> - java.lang.Object");
		sub.child(7, "hashCode() : int - java.lang.Object");
		sub.child(8, "notify() : void - java.lang.Object");
		sub.child(9, "notifyAll() : void - java.lang.Object");
		sub.child(10, "toString() : String - java.lang.Object");
		sub.child(11, "wait() : void - java.lang.Object");
		sub.child(12, "wait(long) : void - java.lang.Object");
		sub.child(13, "wait(long, int) : void - java.lang.Object");

	}

	protected void setShowInherited(boolean isShowInherited) {
		List<OutlineMode> modes = getTreeProvider().getOutlineModes();
		getTreeProvider().setCurrentMode((isShowInherited) ? modes.get(1) : modes.get(0));
	}

}
