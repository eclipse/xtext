/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.service.impl.BuiltInTokenTypeDef;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
// TODO refactor when BUG 236832 is fixed
public class TokenTypeDefTest extends AbstractServiceTest {
	private static final String MULTILINE_COMMENT = "/*\n*multiline comment\n*/";
	private static final String SINGLELINE_COMMENT = "//singleline comment\n";
	private static final String KEYWORD_SPIELPLATZ = "spielplatz";
	private static final String NUMBER_2 = "2";
	private static final String STRING = "\"Unser Spielplatz\"";
	private static final String EOF_COMMENT = "//EOF comment";

	private static final String MODEL = MULTILINE_COMMENT + "\n" + KEYWORD_SPIELPLATZ + " " + NUMBER_2 + " " + STRING
			+ " {\n" + SINGLELINE_COMMENT + "kind (jurgen 5)\nspielzeug (ente ROT)}\n" + EOF_COMMENT;
	private EList<LeafNode> leafNodes;
	private ITokenTypeDefProvider ttds;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IParser parser = getServiceForDefaultLanguage(IParser.class);
		IParseResult pr = parser.parse(new StringInputStream(MODEL));
		ttds = new BuiltInTokenTypeDef();
		leafNodes = pr.getRootNode().getLeafNodes();
	}

	public void testBuildInSlCommentDef() throws Exception {
		LeafNode comment = findLeafNodeByText(SINGLELINE_COMMENT);
		assertNotNull(comment);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, comment);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.SL_COMMENT_ID, ttd.getId());
	}

	public void testBuildInMlCommentDef() throws Exception {
		LeafNode comment = findLeafNodeByText(MULTILINE_COMMENT);
		assertNotNull(comment);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, comment);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.ML_COMMENT_ID, ttd.getId());
	}

	public void testBuildInKeywordDef() throws Exception {
		LeafNode keyword = findLeafNodeByText(KEYWORD_SPIELPLATZ);
		assertNotNull(keyword);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, keyword);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.KEYWORD_ID, ttd.getId());
	}

	public void testBuildInNumberDef() throws Exception {
		LeafNode node = findLeafNodeByText(NUMBER_2);
		assertNotNull(node);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, node);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.NUMBER_ID, ttd.getId());
	}

	public void testBuildInStringDef() throws Exception {
		LeafNode node = findLeafNodeByText(STRING);
		assertNotNull(node);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, node);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.STRING_ID, ttd.getId());
	}

	public void testBuildInEOFCommentDef() throws Exception {
		LeafNode node = findLeafNodeByText(EOF_COMMENT);
		assertNotNull(node);
		ITokenTypeDef ttd = findTokenTypeDef(ttds, node);
		assertNotNull(ttd);
		assertEquals(BuiltInTokenTypeDef.SL_COMMENT_ID, ttd.getId());
	}

	private ITokenTypeDef findTokenTypeDef(ITokenTypeDefProvider ttds, LeafNode leafNode) {
		for (ITokenTypeDef ttd : ttds.allTokenTypes()) {
			if (ttd.match(leafNode)) {
				return ttd;
			}
		}
		return null;
	}

	private LeafNode findLeafNodeByText(String string) {
		for (LeafNode current : leafNodes) {
			if (string.equals(current.getText())) {
				return current;
			}
		}
		return null;
	}

}
