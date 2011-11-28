/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.outline;

import junit.framework.Test;

import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineTests extends AbstractOutlineTests {

	public static Test suite() {
		return WorkbenchTestHelper.suite(OutlineTests.class);
	}

	@Inject 
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Inject
	private OutlineFilterAndSorter sorter;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setSorting(false);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		setSorting(false);
	}
	
	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}
	
	public void testImport() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("import java.lang.* class Foo {}");
		assertBuilder.numChildren(2).child(0, "import declarations").numChildren(1).child(0, "java.lang.*").numChildren(0);
		assertBuilder.child(1, "Foo").numChildren(0);
	}
	
	public void testDispatchMethod_1() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def dispatch foo(String x) {''} def dispatch foo(Object y) {''} }");
		AssertBuilder dispatcher = assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(Object) : String").numChildren(2);
		dispatcher.child(0, "foo(String) : String").numChildren(0);
		dispatcher.child(1, "foo(Object) : String").numChildren(0);
	}
	
	public void testDispatchMethod_2() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {" +
				" def dispatch foo(String x) {''}" +
				" def dispatch foo(Object y) {''}" +
				" def dispatch bar(String x) {''}" +
				" def dispatch bar(Object y) {''}" +
				"}");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		foo.child(0, "foo(Object) : String").numChildren(2);
		foo.child(1, "bar(Object) : String").numChildren(2);
	}
	
	public void testMixedMethods_Order() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {" +
				" def baz() {null}" +
				" def dispatch foo(String x) {''}" +
				" def dispatch bar(String x) {''}" +
				" def dispatch bar(Object y) {''}" +
				" def dispatch foo(Object y) {''}" +
				" String fooBar" + 
				" new() {}" +
				" def static void s() {}" +
				" static String ss" +
				"}");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(7);
		foo.child(0, "foo(Object) : String").numChildren(2);
		foo.child(1, "bar(Object) : String").numChildren(2);
		foo.child(2, "baz() : Object").numChildren(0);
		foo.child(3, "fooBar : String").numChildren(0);
		foo.child(4, "new()").numChildren(0);
		foo.child(5, "s() : void").numChildren(0);
		foo.child(6, "ss : String").numChildren(0);
	} 
	
	public void testMixmethods_Sorting() throws Exception {
		setSorting(true);
		AssertBuilder assertBuilder = newAssertBuilder("package test import java.lang.* class Foo {" +
				" def baz() {null}" +
				" def dispatch foo(String x) {''}" +
				" def dispatch bar(String x) {''}" +
				" def dispatch bar(Object y) {''}" +
				" def dispatch foo(Object y) {''}" +
				" String fooBar" + 
				" new() {}" +
				" def static void s() {}" +
				" static String ss" +
				"}").numChildren(3);
		assertBuilder.child(0, "test").numChildren(0);
		assertBuilder.child(1, "import declarations").numChildren(1);
		AssertBuilder foo = assertBuilder.child(2, "Foo").numChildren(7);
		foo.child(0, "ss : String").numChildren(0);
		foo.child(1, "s() : void").numChildren(0);
		foo.child(2, "fooBar : String").numChildren(0);
		foo.child(3, "new()").numChildren(0);
		foo.child(4, "bar(Object) : String").numChildren(2).child(0, "bar(Object) : String");
		foo.child(5, "foo(Object) : String").numChildren(2).child(0, "foo(Object) : String");
		foo.child(6, "baz() : Object").numChildren(0);
	}
	
	protected void setSorting(boolean isSorting) {
		preferenceStoreAccess.getWritablePreferenceStore().setValue(SortOutlineContribution.PREFERENCE_KEY, isSorting);
	}
	
}
