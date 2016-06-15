/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.ui.Activator;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlineTreeProviderTest extends AbstractXtextTests {

	private XtextOutlineTreeProvider treeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Injector injector = Activator.getDefault().getInjector("org.eclipse.xtext.Xtext");
		with(new ISetup() {
			@Override
			public Injector createInjectorAndDoEMFRegistration() {
				return injector;
			}
		});
		treeProvider = get(XtextOutlineTreeProvider.class);
		setShowInherited(false);
	}

	@Test public void testNoNPEs() throws Exception {
		assertNoException("grammar Foo generate foo 'Foo' terminal framgment : ;");
		assertNoException("grammar Foo generate foo 'Foo' terminal : ;");
	}
	
	@Test public void testNonInheritMode() throws Exception{
		IOutlineNode node = assertNoException("grammar Foo with org.eclipse.xtext.common.Terminals " +
				"generate foo 'Foo' " +
				"Foo: 'foo'; " +
				"Bar: 'bar';");
		assertEquals(1, node.getChildren().size());
		IOutlineNode grammar = node.getChildren().get(0);
		assertNode(grammar, "grammar Foo", 3);
		assertNode(grammar.getChildren().get(0), "generate foo", 0);
		assertNode(grammar.getChildren().get(1), "Foo", 0);
		assertNode(grammar.getChildren().get(2), "Bar", 0);
	}

	@Test public void testInheritMode() throws Exception{
		setShowInherited(true);
		String model = "grammar Foo with org.eclipse.xtext.common.Terminals " +
				"generate foo 'Foo' " +
				"Foo: 'foo'; " +
				"Bar: 'bar';";
		IOutlineNode node = assertNoException(model);
		assertEquals(1, node.getChildren().size());
		IOutlineNode grammar = node.getChildren().get(0);
		assertNode(grammar, "grammar Foo", 10);
		assertNode(grammar.getChildren().get(0), "generate foo", 0);
		IOutlineNode foo = grammar.getChildren().get(1);
		assertNode(foo, "Foo", 0);
		assertEquals(model.lastIndexOf("Foo"), foo.getFullTextRegion().getOffset());
		assertEquals(11, foo.getFullTextRegion().getLength());
		assertEquals(model.lastIndexOf("Foo"), foo.getSignificantTextRegion().getOffset());
		assertEquals(3, foo.getSignificantTextRegion().getLength());
		assertNode(grammar.getChildren().get(2), "Bar", 0);
		IOutlineNode id = grammar.getChildren().get(3);
		assertNode(id, "ID (org.eclipse.xtext.common.Terminals)", 0);
		assertNull(id.getSignificantTextRegion());
		assertEquals(ITextRegion.EMPTY_REGION, id.getFullTextRegion());
		assertNode(grammar.getChildren().get(4), "INT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(5), "STRING (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(6), "ML_COMMENT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(7), "SL_COMMENT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(8), "WS (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(9), "ANY_OTHER (org.eclipse.xtext.common.Terminals)", 0);	
	}
	
	@Test public void testInheritModeWithOverride() throws Exception{
		setShowInherited(true);
		String model = "grammar Foo with org.eclipse.xtext.common.Terminals " +
				"generate foo 'Foo' " +
				"Foo: 'foo'; " +
				"terminal ID: 'bar';";
		IOutlineNode node = assertNoException(model);
		assertEquals(1, node.getChildren().size());
		IOutlineNode grammar = node.getChildren().get(0);
		assertNode(grammar, "grammar Foo", 10);
		assertNode(grammar.getChildren().get(0), "generate foo", 0);
		IOutlineNode foo = grammar.getChildren().get(1);
		assertNode(foo, "Foo", 0);
		assertEquals(model.lastIndexOf("Foo"), foo.getFullTextRegion().getOffset());
		assertEquals(11, foo.getFullTextRegion().getLength());
		assertEquals(model.lastIndexOf("Foo"), foo.getSignificantTextRegion().getOffset());
		assertEquals(3, foo.getSignificantTextRegion().getLength());
		assertNode(grammar.getChildren().get(2), "ID", 0);
		IOutlineNode id = grammar.getChildren().get(3);
		assertNode(id, "ID (org.eclipse.xtext.common.Terminals)", 0);
		assertNull(id.getSignificantTextRegion());
		assertEquals(ITextRegion.EMPTY_REGION, id.getFullTextRegion());
		assertNode(grammar.getChildren().get(4), "INT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(5), "STRING (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(6), "ML_COMMENT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(7), "SL_COMMENT (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(8), "WS (org.eclipse.xtext.common.Terminals)", 0);
		assertNode(grammar.getChildren().get(9), "ANY_OTHER (org.eclipse.xtext.common.Terminals)", 0);	
	}

	protected void assertNode(IOutlineNode node, String text, int numChildren) {
		assertEquals(numChildren, node.getChildren().size());
		assertEquals(text, node.getText().toString());
	}
	
	protected void setShowInherited(boolean isShowInherited) {
		List<OutlineMode> outlineModes = treeProvider.getOutlineModes();
		treeProvider.setCurrentMode(outlineModes.get(isShowInherited ? 1 : 0));
	}
	
	protected IOutlineNode assertNoException(String model) throws Exception {
		try {
			XtextResource resource = getResourceAndExpect(new StringInputStream(model), UNKNOWN_EXPECTATION);
			XtextDocument document = get(XtextDocument.class);
			document.setInput(resource);
			IOutlineNode root = treeProvider.createRoot(document);
			traverseChildren(root);
			return root;
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Exception in outline tree construction");
		}
		return null; // unreachable
	}
	

	private void traverseChildren(IOutlineNode node) {
		for (IOutlineNode child : node.getChildren()) {
			traverseChildren(child);
		}
	}

}
