/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.bug419429;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.AbstractPartialParserTest;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Wrapper;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug419429Test extends AbstractPartialParserTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug419429StandaloneSetup.class);
	}
	
	@Test public void test_01() throws Exception {
		String model = "SomeID";
		replaceAndReparse(model, 4, 0, "Unused", "SomeUnusedID");
	}
	
	@Test public void test_02() throws Exception {
		String model = "";
		replaceAndReparse(model, 0, 0, "SomeID", "SomeID");
	}
	
	@Test public void test_03() throws Exception {
		String model = "SomeID";
		replaceAndReparse(model, 0, 6, "", "");
	}
	
	protected void replaceAndReparse(String model, int offset, int length, String change, String expectedReparseRegion)
			throws Exception {
		IParseResult parseResult = getParseResultAndExpect(model, UNKNOWN_EXPECTATION);
		PartialParsingPointers parsingPointers = getPartialParser().calculatePartialParsingPointers(parseResult, offset,
				length);
		String reparseRegion = getPartialParser().insertChangeIntoReplaceRegion(parsingPointers
				.getDefaultReplaceRootNode(), new ReplaceRegion(offset, length, change));
		assertEquals(expectedReparseRegion, reparseRegion);
		final Wrapper<Boolean> unloaded = Wrapper.wrap(Boolean.FALSE);
		getPartialParser().setUnloader(new IReferableElementsUnloader() {
			public void unloadRoot(EObject root) {
				unloaded.set(Boolean.TRUE);
			}
		});
		IParseResult partiallyReparse = reparse(parseResult, offset, length, change);
		assertTrue("unloaded", unloaded.get());
		String expectedReparseModel = model.substring(0, offset) + change + model.substring(offset + length);
		assertEquals(expectedReparseModel, partiallyReparse.getRootNode().getText());
		
		compareWithFullParse(model, offset, length, change);
	}
	
	protected void compareWithFullParse(String model, int offset, int length, String newText) throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(model, UNKNOWN_EXPECTATION);
		resource.update(offset, length, newText);
		String text = resource.getParseResult().getRootNode().getText();
		XtextResource newResource = getResourceFromStringAndExpect(text, UNKNOWN_EXPECTATION);
		assertEquals(text, resource.getContents().size(), newResource.getContents().size());
		EcoreUtil.resolveAll(resource);
		EcoreUtil.resolveAll(newResource);
		for(int i = 0; i < resource.getContents().size(); i++) {
			assertEquals(text, EmfFormatter.objToStr(newResource.getContents().get(i)), EmfFormatter.objToStr(resource.getContents().get(i)));
		}
		
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		ICompositeNode newRootNode = newResource.getParseResult().getRootNode();
		Iterator<INode> iterator = rootNode.getAsTreeIterable().iterator();
		Iterator<INode> newIterator = newRootNode.getAsTreeIterable().iterator();
		while(iterator.hasNext()) {
			assertTrue(newIterator.hasNext());
			assertEqualNodes(text, iterator.next(), newIterator.next());
		}
		assertFalse(iterator.hasNext());
		assertFalse(newIterator.hasNext());
	}

	protected void assertEqualNodes(String text, INode node, INode other) {
		assertEquals(text, node.getClass(), other.getClass());
		assertEquals(text, node.getTotalOffset(), other.getTotalOffset());
		assertEquals(text, node.getTotalLength(), other.getTotalLength());
		assertEquals(text, node.getGrammarElement(), other.getGrammarElement());
		assertEquals(text, node.hasDirectSemanticElement(), other.hasDirectSemanticElement());
		assertEquals(text, node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage());
		if (node instanceof ICompositeNode) {
			assertEquals(text, ((ICompositeNode)node).getLookAhead(), ((ICompositeNode) other).getLookAhead());
		}
	}
	
}
