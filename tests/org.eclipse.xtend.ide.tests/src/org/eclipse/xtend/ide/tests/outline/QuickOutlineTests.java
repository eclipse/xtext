/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.outline;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class QuickOutlineTests extends AbstractOutlineTests {

	@Inject
	private QuickOutlineFilterAndSorter sorter;

	@Inject
	private WorkbenchTestHelper workbenchHelper;

	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}

	@Test public void testNoImports() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("import java.lang.* class Foo {}");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(0);
	}

	@Test public void testSorting() throws Exception {
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

	
	@Test public void testFieldsFromSuper() throws Exception {
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
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(17);
		sub.child(0, "baz : Number").numChildren(0).hasTextRegion(true);
		sub.child(1, "bar : String - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(2, "foo : int - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(3, "new() - test.Super").numChildren(0).hasTextRegion(false);
		sub.child(4, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(5, "new() - java.lang.Object").hasTextRegion(false);
		sub.child(6, "clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.child(7, "equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.child(8, "finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.child(9, "getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.child(10, "hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.child(11, "notify() : void - java.lang.Object").hasTextRegion(false);
		sub.child(12, "notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.child(13, "toString() : String - java.lang.Object").hasTextRegion(false);
		sub.child(14, "wait() : void - java.lang.Object").hasTextRegion(false);
		sub.child(15, "wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.child(16, "wait(long, int) : void - java.lang.Object").hasTextRegion(false);
		// private field bar stays invisible
	}
	
	
	@Test public void testMethodsFromSuper() throws Exception {
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
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "baz() : Number").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(17);
		sub.child(0, "baz() : Number").numChildren(0).hasTextRegion(true);
		sub.child(1, "new() - test.Super").hasTextRegion(false);
		sub.child(2, "bar() : String - test.Super").hasTextRegion(false);
		sub.child(3, "foo(String) : int - test.Super").hasTextRegion(false);
		sub.child(4, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(5, "new() - java.lang.Object").hasTextRegion(false);
		sub.child(6, "clone() : Object - java.lang.Object").hasTextRegion(false);
		sub.child(7, "equals(Object) : boolean - java.lang.Object").hasTextRegion(false);
		sub.child(8, "finalize() : void - java.lang.Object").hasTextRegion(false);
		sub.child(9, "getClass() : Class<?> - java.lang.Object").hasTextRegion(false);
		sub.child(10, "hashCode() : int - java.lang.Object").hasTextRegion(false);
		sub.child(11, "notify() : void - java.lang.Object").hasTextRegion(false);
		sub.child(12, "notifyAll() : void - java.lang.Object").hasTextRegion(false);
		sub.child(13, "toString() : String - java.lang.Object").hasTextRegion(false);
		sub.child(14, "wait() : void - java.lang.Object").hasTextRegion(false);
		sub.child(15, "wait(long) : void - java.lang.Object").hasTextRegion(false);
		sub.child(16, "wait(long, int) : void - java.lang.Object").hasTextRegion(false);
		// private method bar() stays invisible
	}
	
	
	@Test public void testMixedDispatch_0() throws Exception {
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
		AssertBuilder sub = assertBuilder.child(1, "Foo").numChildren(1).hasTextRegion(true);
		sub.child(0, "foo(Serializable) : void").numChildren(1).child(0, "foo(Number) : void").numChildren(0).hasTextRegion(true);

		setShowInherited(true);
		assertBuilder = newAssertBuilder(model).numChildren(2);
		sub = assertBuilder.child(1, "Foo").numChildren(15).hasTextRegion(true);
		AssertBuilder foo = sub.child(0, "foo(Serializable) : void").numChildren(2).hasTextRegion(true);
		foo.child(0, "_foo(String) : void - test.Super").numChildren(0).hasTextRegion(false);
		foo.child(1, "foo(Number) : void").numChildren(0).hasTextRegion(true);
		sub.child(1, "new() - test.Super").hasTextRegion(false);
		sub.child(2, "registerNatives() : void - java.lang.Object").hasTextRegion(false);
		sub.child(3, "new() - java.lang.Object").hasTextRegion(false);
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
	
	protected void setShowInherited(boolean isShowInherited) {
		List<OutlineMode> modes = getTreeProvider().getOutlineModes();
		getTreeProvider().setCurrentMode((isShowInherited) ? modes.get(1) : modes.get(0));
	}

}
