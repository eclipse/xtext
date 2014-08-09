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

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Default scenarios that are used for permuting smoke tests.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
@Beta
public enum Scenario {
	/**
	 * Simulates typeing from the first to the last character.
	 */
	SkipLastCharacters {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
			for(int i = 0; i < input.length(); i++) {
				tester.processFile(input.substring(0, i));
			}
		}
	},
	/**
	 * Simulates deletion from the first to the last character.
	 */
	SkipFirstCharacters {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
			for(int i = 0; i < input.length(); i++) {
				tester.processFile(input.substring(i));
			}
		}
	},
	/**
	 * Simulates removal of a single character.
	 */
	SkipCharacterInBetween {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
			if (input.length() > 1) {
				for(int i = 0; i < input.length() - 1; i++) {
					tester.processFile(input.substring(0, i) + input.substring(i + 1));
				}
			}
		}
	},
	/**
	 * Simulates removal of a complete token. Tokens with length 1 or 3 are ignored.
	 * Those cases are covered by other scenarios.
	 * @see #SkipCharacterInBetween
	 * @see #SkipThreeCharactersInBetween
	 */
	SkipTokensInBetween {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
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
				if (length > 1 && length != 3) {
					tester.processFile(input.substring(0, start) + input.substring(start + length));
				}
			}
		}
	},
	/**
	 * Simulates removal of nodes. Nodes that cover exactly one token, have the length 1 or 3 are ignored.
	 * Those cases are covered by other scenarios.
	 * @see #SkipCharacterInBetween
	 * @see #SkipThreeCharactersInBetween
	 * @see #SkipTokensInBetween
	 */
	SkipNodesInBetween {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
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
						if (Iterables.size(node.getLeafNodes()) > 1 && length > 1 && length != 3) {
							StringBuilder builder = new StringBuilder(rootNode.getText());
							region.applyTo(builder);
							tester.processFile(builder.toString());
						}
					}
				}
			}
		}
	},
	/**
	 * Skips three characters of the input document. Usually a nice range in test data, especially
	 * for expression languages, where variable names often have only a single char in tests (will
	 * skip {@code x =} in {@code var x = 3}), or where the name has three chars ({@code foo, bar}).
	 */
	SkipThreeCharactersInBetween {
		@Override
		public void processInput(String input, ScenarioProcessor tester) throws Exception {
			if (input.length() > 1) {
				for(int i = 0; i < input.length() - 3; i++) {
					tester.processFile(input.substring(0, i) + input.substring(i + 3));
				}
			}
		}
	};
	
	/**
	 * Create permutations of the input document and pass that to the given tester.
	 */
	public abstract void processInput(String input, ScenarioProcessor tester) throws Exception;
}