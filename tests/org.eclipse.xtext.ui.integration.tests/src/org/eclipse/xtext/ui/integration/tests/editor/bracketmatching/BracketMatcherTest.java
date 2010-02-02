/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.integration.tests.editor.bracketmatching;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.bracketmatching.AbstractBracketMatcher;
import org.eclipse.xtext.ui.editor.bracketmatching.IBracketMatcher;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BracketMatcherTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new BmTestLanguageStandaloneSetup());
	}

	public void testMatchBracket() throws Exception {

		XtextResource resource = getResource(new StringInputStream("(foo 34 begin ( 45 ) end)"));
		CompositeNode node = NodeUtil.getRootNode(resource.getContents().get(0));
		EList<LeafNode> leafNodes = node.getLeafNodes();

		assertMatched(resource, leafNodes.get(0), leafNodes.get(14));
		
		assertMatched(resource, leafNodes.get(1), null);
		assertMatched(resource, leafNodes.get(2), null);
		assertMatched(resource, leafNodes.get(3), null);
		assertMatched(resource, leafNodes.get(4), null);
		assertMatched(resource, leafNodes.get(5), leafNodes.get(13));
		assertMatched(resource, leafNodes.get(6), null);
		assertMatched(resource, leafNodes.get(7), leafNodes.get(11));
		assertMatched(resource, leafNodes.get(8), null);
		assertMatched(resource, leafNodes.get(9), null);
		assertMatched(resource, leafNodes.get(10), null);
		assertMatched(resource, leafNodes.get(11), leafNodes.get(7));
		assertMatched(resource, leafNodes.get(13), leafNodes.get(5));
		assertMatched(resource, leafNodes.get(14), leafNodes.get(0));

	}
	
	public void testMatchParenthesized() throws Exception {
		XtextResource resource = getResource(new StringInputStream("[foo]"));
		CompositeNode node = NodeUtil.getRootNode(resource.getContents().get(0));
		EList<LeafNode> leafNodes = node.getLeafNodes();

		assertMatched(resource, leafNodes.get(0), leafNodes.get(2));
		assertMatched(resource, leafNodes.get(1), null);
		assertMatched(resource, leafNodes.get(2), leafNodes.get(0));
	}

	protected void assertMatched(XtextResource resource, LeafNode leafNode, LeafNode leafNode2) {
		IRegion region = getMatcher().computeMatchingRegion(resource, leafNode.getOffset() + leafNode.getLength());
		if (leafNode2 == null) {
			assertNull(region);
		} else {
			assertNotNull(region);
			assertEquals(leafNode2.getOffset(), region.getOffset());
			assertEquals(leafNode2.getLength(), region.getLength());
		}
	}

	private IBracketMatcher getMatcher() {
		return new AbstractBracketMatcher() {

			@Override
			public void configure(IBracketPairAcceptor acceptor) {
				List<Pair<Keyword, Keyword>> pairs2 = getGrammarAccess().findKeywordPairs("(", ")");
				for (Pair<Keyword, Keyword> pair : pairs2) {
					acceptor.accept(pair.getFirst(), pair.getSecond());
				}
				pairs2 = getGrammarAccess().findKeywordPairs("begin", "end");
				for (Pair<Keyword, Keyword> pair : pairs2) {
					acceptor.accept(pair.getFirst(), pair.getSecond());
				}
				pairs2 = getGrammarAccess().findKeywordPairs("[", "]");
				for (Pair<Keyword, Keyword> pair : pairs2) {
					acceptor.accept(pair.getFirst(), pair.getSecond());
				}
			}
		};
	}
}
