/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.outline;

import org.eclipse.xtend.ide.outline.ShowSyntheticMembersContribution;
import org.eclipse.xtend.ide.outline.SwitchOutlineModeContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
public class JvmOutlineTests extends AbstractOutlineTests {
	private OutlineFilterAndSorter sorter;

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

	@Inject
	void configure(ShowSyntheticMembersContribution filter, OutlineFilterAndSorter sorter) {
		sorter.addFilter(filter.getFilter());
		this.sorter = sorter;
	}

	@Test
	public void testDispatchMethod_1() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {" + " def dispatch foo(String x) {''}"
				+ " def dispatch foo(Object y) {''}" + " def dispatch bar(String x) {''}"
				+ " def dispatch bar(Object y) {''}" + "}");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(6);
		foo.leaf(0, "_foo(String) : String");
		foo.leaf(1, "_foo(Object) : String");
		foo.leaf(2, "_bar(String) : String");
		foo.leaf(3, "_bar(Object) : String");
		foo.leaf(4, "foo(Object) : String");
		foo.leaf(5, "bar(Object) : String");
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
	public void testEnum() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("enum Foo { BAR, BAZ }");
		AssertBuilder interfaze = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		interfaze.leaf(0, "BAR");
		interfaze.leaf(1, "BAZ");
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
		type.leaf(0, "foo() : String");
		type.leaf(1, "_createCache_foo : HashMap<ArrayList<?>, String>");
		type.leaf(2, "_init_foo(String) : void");
	}

	@Override
	@Test
	public void testCreateExtensionInfo_dispatch() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {  dispatch def create value : 'bar' foo(Integer it) {}  dispatch def create value : 'foo' foo(String it) {} }");
		AssertBuilder type = assertBuilder.numChildren(1).child(0, "Foo").numChildren(7);
		type.leaf(0, "_foo(Integer) : String");
		type.leaf(1, "_createCache_foo : HashMap<ArrayList<?>, String>");
		type.leaf(2, "_init_foo(String, Integer) : void");
		type.leaf(3, "_foo(String) : String");
		type.leaf(4, "_createCache_foo_1 : HashMap<ArrayList<?>, String>");
		type.leaf(5, "_init_foo_1(String, String) : void");
		type.leaf(6, "foo(Object) : String");
	}

	private void setJvmMode(boolean isJvmMode) {
		getPreferenceStoreAccess().getWritablePreferenceStore().setValue(SwitchOutlineModeContribution.PREFERENCE_KEY,
				isJvmMode);
	}

	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}

}
