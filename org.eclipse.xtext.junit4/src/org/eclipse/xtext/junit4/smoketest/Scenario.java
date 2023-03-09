/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;

import com.google.common.collect.Iterables;

/**
 * Default scenarios that are used for permuting smoke tests.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 * @deprecated Use org.eclipse.xtext.testing.smoketest.Scenario instead
 */
@Deprecated(forRemoval = true)
public enum Scenario {
	/**
	 * Simulates typing from the first to the last character.
	 */
	SkipLastCharacters {
		@Override
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
			String data = "";
			tester.processFile(input, data, 0, 0, "");
			for(int i = 0; i < input.length(); i++) {
				data = tester.processFile(input, data, data.length(), 0, input.charAt(i));
			}
		}
	},
	/**
	 * Simulates deletion from the first to the last character.
	 */
	SkipFirstCharacters {
		@Override
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
			String data = input;
			tester.processFile(input, data, 0, 0, "");
			for(int i = 0; i < input.length(); i++) {
				data = tester.processFile(input, data, 0, 1, "");
			}
		}
	},
	/**
	 * Simulates removal of a single character.
	 */
	SkipCharacterInBetween {
		@Override
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
			if (input.length() > 1) {
				String data = input.substring(1);
				for(int i = 0; i < input.length() - 1; i++) {
					data = tester.processFile(input, data, i, 1, input.charAt(i));
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
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
			XtextResource resource = tester.get(XtextResource.class);
			resource.setURI(URI.createURI("dummy.uri"));
			try {
				resource.load(new StringInputStream(input, "UTF-8"), Collections.singletonMap(XtextResource.OPTION_ENCODING, "UTF-8"));
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			for(ILeafNode token: rootNode.getLeafNodes()) {
				int start = token.getTotalOffset();
				int length = token.getTotalLength();
				if (length > 1 && length != 3) {
					tester.processFile(input, input, start, length, "");
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
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
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
							tester.processFile(input, input, offset, length, "");
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
		public void processInput(String input, DeltaScenarioProcessor tester) throws Exception {
			if (input.length() > 3) {
				String data = input.substring(3);
				tester.processFile(input, data, 0, 0, "");
				for(int i = 0; i < input.length() - 3; i++) {
					data = tester.processFile(input, data, i, 1, input.charAt(i));
				}
			}
		}
	};
	
	/**
	 * Create permutations of the input document and pass that to the given tester.
	 */
	public void processInput(String input, ScenarioProcessor tester) throws Exception {
		if (tester instanceof DeltaScenarioProcessor) {
			processInput(input, (DeltaScenarioProcessor) tester);
		} else {
			processInput(input, new DeltaScenarioProcessor.Adapter(tester));
		}
	}
	
	/**
	 * Create permutations of the input document and pass that to the given tester.
	 * 
	 * @since 2.8
	 */
	public abstract void processInput(String input, DeltaScenarioProcessor tester) throws Exception;
}