/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.selection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.selection.AstSelectionProvider;
import org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AstSelectionProviderTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new OutlineTestLanguageStandaloneSetup());
	}
	
	public void testSelectEnclosing() throws Exception {
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
	
	public void testSelectNext() throws Exception {
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
	
	public void testSelectPrevious() throws Exception {
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
	
	public void testSelectComments() throws Exception {
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

	protected TextRegion region(String all, String part) {
		return new TextRegion(all.indexOf(part), part.length());
	}
}
