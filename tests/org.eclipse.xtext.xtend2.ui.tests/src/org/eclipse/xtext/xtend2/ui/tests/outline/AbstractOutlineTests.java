/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.outline;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.xtend2.ui.outline.Xtend2OutlineTreeProvider;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractOutlineTests extends AbstractXtend2UITestCase {

	@Inject
	private Xtend2OutlineTreeProvider treeProvider;

	@Inject
	private Provider<XtextDocument> documentProvider;

	@Inject
	private WorkbenchTestHelper workbenchTestHelper;

	@Inject
	private OutlineFilterAndSorter.IComparator comparator;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getSorter().setComparator(comparator);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		workbenchTestHelper.tearDown();
	}
	
	protected Xtend2OutlineTreeProvider getTreeProvider() {
		return treeProvider;
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
	
	public void testTypeParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo <T extends Object> {}");
		assertBuilder.numChildren(1).child(0, "Foo<T>").numChildren(0);
	}
	
	public void testField() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { String bar }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "bar : String").numChildren(0);
	}
	
	public void testConstructor() throws Exception  {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { new(int foo) {} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "new(int)").numChildren(0);
	}

	public void testSimpleMethod() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testMethodWithParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def foo(int bar) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(int) : Object").numChildren(0);
	}
	
	public void testMethodWithParameters() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def foo(int bar, java.lang.Object x) {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(int, Object) : Object").numChildren(0);
	}
	
	public void testMethodWithReturnType() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def java.lang.Object foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testMethodWithTypeParameter() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def <T> foo() {null} }");
		assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo() : Object").numChildren(0);
	}
	
	public void testDispatchMethod() throws Exception {
		AssertBuilder assertBuilder = newAssertBuilder("class Foo { def dispatch foo(Object x) {''} def dispatch foo(String y) {''} }");
		AssertBuilder dispatcher = assertBuilder.numChildren(1).child(0, "Foo").numChildren(1).child(0, "foo(Object) : String").numChildren(2);
		dispatcher.child(0, "foo(Object) : String").numChildren(0);
		dispatcher.child(1, "foo(String) : String").numChildren(0);
	}

	protected AssertBuilder newAssertBuilder(String model) throws Exception, CoreException {
		XtendFile file = workbenchTestHelper.xtendFile("Foo", model);
		XtextDocument document = documentProvider.get();
		document.setInput((XtextResource) file.eResource());
		IOutlineNode root = treeProvider.createRoot(document);
		AssertBuilder assertBuilder = new AssertBuilder(root);
		return assertBuilder;
	}

	protected abstract OutlineFilterAndSorter getSorter();

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
			assertEquals("Wrong number of children", num, getSorter().filterAndSort(node.getChildren()).length);
			return this;
		}

		AssertBuilder child(int index, String text) {
			IOutlineNode[] sortedChildren = getSorter().filterAndSort(node.getChildren());
			if (sortedChildren.length <= index)
				fail("Missing child node " + index);
			return new AssertBuilder(sortedChildren[index], text);
		}

	}

}
