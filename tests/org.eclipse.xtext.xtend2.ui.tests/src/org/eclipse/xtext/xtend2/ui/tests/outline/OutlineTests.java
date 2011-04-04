/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.outline;

import junit.framework.Test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineTests extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(OutlineTests.class);
	}

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Inject
	private IOutlineTreeProvider treeProvider;
	
	@Inject 
	private XtextDocumentProvider documentProvider;
	
	@Inject 
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Inject
	private OutlineFilterAndSorter sorter;
	
	@Inject
	private OutlineFilterAndSorter.IComparator comparator;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sorter.setComparator(comparator);
		setSorting(false);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		setSorting(false);
		workbenchTestHelper.tearDown();
	}
	public void testSimpleClass() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo {}");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(0);
	}

	public void testPackage() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("package test class Foo {}");
		assertBuilder.numChildren(2).child(0, "test").numChildren(0);
		assertBuilder.child(1, "Foo").numChildren(0);
	}
	
	public void testImport() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("import java.lang.* class Foo {}");
		assertBuilder.numChildren(2).child(0, "import declarations").numChildren(1).child(0, "java.lang.*").numChildren(0);
		assertBuilder.child(1, "Foo").numChildren(0);
	}
	
	public void testTypeParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo <T extends Object> {}");
		assertBuilder.numChildren(1).child(0, "Foo<T>").numChildren(0);
	}

	public void testSimpleMethod() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testMethodWithParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { foo(int bar) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(int) : Object").numChildren(0);
	}
	
	public void testMethodWithParameters() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { foo(int bar, java.lang.Object x) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(int, Object) : Object").numChildren(0);
	}
	
	public void testMethodWithReturnType() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { java.lang.Object foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testMethodWithTypeParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { <T> foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testDispatchMethod() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { dispatch foo(String x) {''} dispatch foo(Object y) {''} }");
		AssertBuilder dispatcher = assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(Object) : String").numChildren(2);
		dispatcher.child(0, "foo(String) : String").numChildren(0);
		dispatcher.child(1, "foo(Object) : String").numChildren(0);
	}
	
	public void testDispatchMethod_1() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { dispatch foo(Object x) {''} dispatch foo(String y) {''} }");
		AssertBuilder dispatcher = assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(Object) : String").numChildren(2);
		dispatcher.child(0, "foo(Object) : String").numChildren(0);
		dispatcher.child(1, "foo(String) : String").numChildren(0);
	}
	
	public void testDispatchMethods() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { dispatch foo(String x) {''} dispatch foo(Object y) {''} dispatch bar(String x) {''} dispatch bar(Object y) {''}}");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(2);
		foo.child(0, "foo(Object) : String").numChildren(2);
		foo.child(1, "bar(Object) : String").numChildren(2);
	}
	
	public void testMixedMethods_Order() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { baz() {null} dispatch foo(String x) {''} dispatch bar(String x) {''} dispatch bar(Object y) {''} dispatch foo(Object y) {''}}");
		AssertBuilder foo = assertBuilder.numChildren(1).child(0, "Foo").numChildren(3);
		foo.child(0, "foo(Object) : String").numChildren(2);
		foo.child(1, "bar(Object) : String").numChildren(2);
		foo.child(2, "baz() : Object").numChildren(0);
	}
	
	public void testMixmethods_Sorting() throws Exception {
		setSorting(true);
		AssertBuilder assertBuilder = newAssertBuilder("package test import java.lang.* class Foo { baz() {null} dispatch foo(String x) {''} dispatch bar(String x) {''} dispatch bar(Object y) {''} dispatch foo(Object y) {''}}").numChildren(3);
		assertBuilder.child(0, "test").numChildren(0);
		assertBuilder.child(1, "import declarations").numChildren(1);
		AssertBuilder foo = assertBuilder.child(2, "Foo").numChildren(3);
		foo.child(0, "bar(Object) : String").numChildren(2).child(0, "bar(Object) : String");
		foo.child(1, "foo(Object) : String").numChildren(2).child(0, "foo(Object) : String");
		foo.child(2, "baz() : Object").numChildren(0);
	}
	
	protected void setSorting(boolean isSorting) {
		preferenceStoreAccess.getWritablePreferenceStore().setValue(SortOutlineContribution.PREFERENCE_KEY, isSorting);
	}
	
	protected AssertBuilder newAssertBuilder(String model) throws Exception, CoreException {
		IFile file = workbenchTestHelper.createFile("Foo", model);
		FileEditorInput editorInput = new FileEditorInput(file);
		documentProvider.connect(editorInput);
		XtextDocument document = (XtextDocument) documentProvider.getDocument(editorInput);
		IOutlineNode root = treeProvider.createRoot(document);
		AssertBuilder assertBuilder = new AssertBuilder(root);
		return assertBuilder;
	}
	
	public class AssertBuilder {
		
		private final IOutlineNode node;

		AssertBuilder(IOutlineNode node) {
			this.node = node;
		}
		
		AssertBuilder(IOutlineNode node, String text) {
			this(node);
			assertEquals(text, node.getText().toString());
		}
		
		AssertBuilder numChildren(int num) {
			assertEquals("Wrong number of children", num, node.getChildren().size());
			return this;
		}
		
		AssertBuilder child(int index, String text) {
			IOutlineNode[] sortedChildren = sorter.filterAndSort(node.getChildren());
			if(sortedChildren.length <= index)
				fail("Missing child node " + index);
			return new AssertBuilder(sortedChildren[index], text);
		}
		
	}
}
