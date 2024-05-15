/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.selection;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.selection.AstSelectionProvider;
import org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AstSelectionProviderTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new OutlineTestLanguageStandaloneSetup());
	}
	
	@Test public void testSelectEnclosing() throws Exception {
		String zonk = "zonk{}";
		String zink = "zink{}";
		String baz = "baz{"+zonk+zink+"}";
		String bar = "bar{}";
		String all = "foo(baz){"+bar+baz+"}";
		EObject model = super.getModel(all);
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final XtextResource res = (XtextResource) model.eResource();
		
		int indexOfZonk = all.indexOf(zonk);
		ITextRegion selection = provider.selectEnclosing(res, new TextRegion(indexOfZonk,0));
		assertEquals(region(all, "zonk"), selection);
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all, zonk), selection);
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all,baz), selection);
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all,all), selection);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectEnclosing(res, selection));
	}
	
	@Test public void testSelectNext() throws Exception {
		String zonk = "zonk{}";
		String zink = "zink{}";
		String baz = "baz{"+zonk+zink+"}";
		String bar = "bar{}";
		String all = "foo(baz){"+bar+baz+"}";
		EObject model = super.getModel(all);
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final XtextResource res = (XtextResource) model.eResource();
		
		int indexOfZonk = all.indexOf(zonk);
		ITextRegion selection = provider.selectNext(res, new TextRegion(indexOfZonk,0));
		assertEquals(region(all, "zonk"), selection);
		
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all, zonk), selection);
		
		selection = provider.selectNext(res, selection);
		assertEquals(region(all,zonk+zink), selection);
		
		selection = provider.selectNext(res, selection);
		assertEquals(region(all,baz), selection);
		
		selection = provider.selectNext(res, selection);
		assertEquals(region(all,all), selection);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectNext(res, selection));
	}
	
	@Test public void testSelectPrevious() throws Exception {
		String zonk = "zonk{}";
		String zink = "zink{}";
		String baz = "baz{"+zonk+zink+"}";
		String bar = "bar{}";
		String all = "foo(baz){"+bar+baz+"}";
		EObject model = super.getModel(all);
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final XtextResource res = (XtextResource) model.eResource();
		
		int indexOfZonk = all.indexOf(zonk);
		ITextRegion selection = provider.selectPrevious(res, new TextRegion(indexOfZonk,0));
		assertEquals(region(all, "zonk"), selection);
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all, zonk), selection);
		
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,bar+baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,all), selection);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectPrevious(res, selection));
	}
	
	@Test public void testSelectComments() throws Exception {
		String zonk = "/* my coment \n*/\nzonk{}";
		String zink = "zink{}";
		String baz = "baz{\n"+zonk+zink+"}";
		String bar = "bar{}";
		String all = "foo(baz){"+bar+baz+"}";
		EObject model = super.getModel(all);
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final XtextResource res = (XtextResource) model.eResource();
		
		int indexOfZonk = all.indexOf("zonk");
		final TextRegion currentEditorSelection = new TextRegion(indexOfZonk,1);
		ITextRegion selection = provider.selectPrevious(res, currentEditorSelection);
		assertEquals(region(all, "zonk"), selection);
		selection = provider.selectEnclosing(res, selection);
		assertEquals(region(all, zonk), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,bar+baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,all), selection);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectPrevious(res, selection));
	}
	
	@Test public void testSelectLast() throws Exception {
		String zonk = "/* my coment \n*/\nzonk{}";
		String zink = "zink{}";
		String baz = "baz{\n"+zonk+zink+"}";
		String bar = "bar{}";
		String all = "foo(baz){"+bar+baz+"}";
		EObject model = super.getModel(all);
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final XtextResource res = (XtextResource) model.eResource();
		
		int indexOfZonk = all.indexOf("zonk");
		Stack<ITextRegion> selections = new Stack<ITextRegion>();
		final TextRegion currentEditorSelection = new TextRegion(indexOfZonk,1);
		ITextRegion selection = provider.selectPrevious(res, currentEditorSelection);
		selections.push(selection);
		assertEquals(region(all, "zonk"), selection);
		selection = provider.selectEnclosing(res, selection);
		selections.push(selection);
		assertEquals(region(all, zonk), selection);
		
		selection = provider.selectPrevious(res, selection);
		selections.push(selection);
		assertEquals(region(all,baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		selections.push(selection);
		assertEquals(region(all,bar+baz), selection);
		
		selection = provider.selectPrevious(res, selection);
		assertEquals(region(all,all), selection);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectPrevious(res, selection));
		
		while (!selections.isEmpty()) {
			ITextRegion previous = selections.pop();
			assertEquals(previous, provider.selectLast(res, selection));
			selection = previous;
		}
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectLast(res, currentEditorSelection));
	}
	
	@Test public void testBug515055_1() throws Exception {
		XtextResource res = getResource(getAsStream("    "));
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final TextRegion currentEditorSelection = new TextRegion(2,0);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectEnclosing(res, currentEditorSelection));
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectEnclosing(res, currentEditorSelection));
	}
	
	@Test public void testBug515055_2() throws Exception {
		XtextResource res = getResource(getAsStream(""));
		AstSelectionProvider provider = get(AstSelectionProvider.class);
		final TextRegion currentEditorSelection = new TextRegion(0,0);
		assertEquals(ITextRegion.EMPTY_REGION, provider.selectEnclosing(res, currentEditorSelection));
	}

	protected TextRegion region(String all, String part) {
		return new TextRegion(all.indexOf(part), part.length());
	}
}
