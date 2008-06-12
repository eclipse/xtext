/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.IPreferenceStoreService;
import org.eclipse.xtext.ui.service.impl.BuildInSyntaxColorer;
import org.eclipse.xtext.ui.tokentype.BuildInTokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BISyntaxColorerTest extends AbstractServiceTest {

	private BuildInSyntaxColorer colorer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		colorer = new BuildInSyntaxColorer();
		colorer.setLanguageDescriptor(createMock(ILanguageDescriptor.class, new InvocationHandlerImpl()));
		colorer.setTokenTypeDefService(new BuildInTokenTypeDef());
		colorer.setPreferenceStoreService(createMock(IPreferenceStoreService.class, new InvocationHandlerImpl()));
	}

	public void testTextDefaultStyle() throws Exception {
		LeafNode leafNode = createLeafNode();
		leafNode.setText("nothing");
		TextStyle textStyle = colorer.color(leafNode);
		assertNotNull(textStyle);
	}

	public void testKnownTokenTypeStyle() throws Exception {
		LeafNode leafNode = createLeafNode();
		Grammar grammar = new XtextBuiltinGrammarAccess().getGrammar();
		LexerRule lr = (LexerRule) GrammarUtil.findRuleForName(grammar, "SL_COMMENT");
		leafNode.setGrammarElement(lr);
		leafNode.setText("//single line comment\n");
		TextStyle textStyle = colorer.color(leafNode);
		assertNotNull(textStyle);
	}
}
