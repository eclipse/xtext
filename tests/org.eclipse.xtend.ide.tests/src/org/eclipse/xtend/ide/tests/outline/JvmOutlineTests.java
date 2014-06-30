/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.outline;

import static com.google.common.collect.Lists.*;

import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.outline.ShowSyntheticMembersContribution;
import org.eclipse.xtend.ide.outline.SwitchOutlineModeContribution;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.util.Files;
import org.junit.Test;

import com.google.common.collect.Iterables;
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

	@Test
	public void testActiveAnnotation() throws Exception {
		InputStream inputStream = JvmOutlineTests.class.getResourceAsStream("TestAA.txt");
		String model = Files.readStreamIntoString(inputStream);
		XtendFile aaXtendFile = getWorkbenchTestHelper().xtendFile("aatest/TestAA.xtend", model);
		WorkbenchTestHelper.addExportedPackages(getWorkbenchTestHelper().getProject(), "aatest");
		AssertBuilder aaFile = newAssertBuilder(aaXtendFile).numChildren(4);
		aaFile.child(0, "aatest");
		aaFile.child(1, "import declarations");
		aaFile.child(2, "TestAAnnotation");
		aaFile.child(3, "TestAAProcessor");
		List<String> deps = newArrayList(WorkbenchTestHelper.DEFAULT_REQ_BUNDLES);
		deps.add(WorkbenchTestHelper.TESTPROJECT_NAME);
		final IProject clientProj = WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME
				+ "-client", Iterables.toArray(deps, String.class));
		XtendFile xtendFile = getWorkbenchTestHelper().xtendFile(clientProj, "clienttest/TestAAClient.xtend",
				"package clienttest @aatest.TestAAnnotation class AAOutlineTest { override void myPublicMethod() {}}");
		AssertBuilder clientAAFile = newAssertBuilder(xtendFile).numChildren(3);
		clientAAFile.leaf(0, "clienttest");
		clientAAFile.child(1, "AAOutlineTest").leaf(0, "myPublicMethod() : void");
		StyledString styledString = new StyledString("AAOutlineTestInterface", StyledString.QUALIFIER_STYLER)
				.append(new StyledString(" - clienttest.test", StyledString.DECORATIONS_STYLER));
		AssertBuilder createdtype = clientAAFile.child(2, styledString).numChildren(1);
		createdtype.child(0, new StyledString("myPublicMethod() : void", StyledString.QUALIFIER_STYLER));
		WorkbenchTestHelper.deleteProject(clientProj);
	}

	private void setJvmMode(boolean isJvmMode) {
		getPreferenceStoreAccess().getWritablePreferenceStore().setValue(SwitchOutlineModeContribution.PREFERENCE_KEY,
				isJvmMode);
		getPreferenceStoreAccess().getWritablePreferenceStore().setValue(SortOutlineContribution.PREFERENCE_KEY, false);
	}

	@Override
	protected OutlineFilterAndSorter getSorter() {
		return sorter;
	}

}
