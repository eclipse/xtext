/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public enum Scenario {
	SkipLastCharacters {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			for(int i = 0; i < input.length(); i++) {
				tester.processFile(input.substring(0, i));
			}
		}
	},
	SkipFirstCharacters {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			for(int i = 0; i < input.length(); i++) {
				tester.processFile(input.substring(i));
			}
		}
	},
	SkipCharacterInBetween {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			if (input.length() > 1) {
				for(int i = 0; i < input.length() - 1; i++) {
					tester.processFile(input.substring(0, i) + input.substring(i + 1));
				}
			}
		}
	},
	SkipTokensInBetween {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			List<CommonToken> tokenList = Lists.newArrayList();
			{
				Lexer lexer = tester.get(Lexer.class);
				lexer.setCharStream(new ANTLRStringStream(input));
				Token token = lexer.nextToken();
				while(token != Token.EOF_TOKEN) {
					tokenList.add((CommonToken) token);
					token = lexer.nextToken();
				}
			}
			for(CommonToken token: tokenList) {
				int start = token.getStartIndex();
				int length = token.getText().length();
				tester.processFile(input.substring(0, start) + input.substring(start + length));
			}
		}
	},
	SkipNodesInBetween {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			XtextResource resource = tester.get(XtextResource.class);
			resource.setURI(URI.createURI("dummy.uri"));
			try {
				resource.load(new StringInputStream(input, "UTF-8"), Collections.singletonMap(XtextResource.OPTION_ENCODING, "UTF-8"));
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			ReplaceRegion region = null;
			for(INode node: rootNode.getAsTreeIterable()) {
				int offset = node.getTotalOffset();
				int length = node.getTotalLength();
				if (length != 0) {
					if (region == null || region.getOffset() != offset || region.getLength() != length) {
						region = new ReplaceRegion(offset, length, "");
						StringBuilder builder = new StringBuilder(rootNode.getText());
						region.applyTo(builder);
						tester.processFile(builder.toString());
					}
				}
			}
		}
	},
	SkipThreeCharactersInBetween {
		@Override
		void processInput(String input, ScenarioProcessor tester) throws Exception {
			if (input.length() > 1) {
				for(int i = 0; i < input.length() - 3; i++) {
					tester.processFile(input.substring(0, i) + input.substring(i + 3));
				}
			}
		}
	};
	
	abstract void processInput(String input, ScenarioProcessor tester) throws Exception;
}