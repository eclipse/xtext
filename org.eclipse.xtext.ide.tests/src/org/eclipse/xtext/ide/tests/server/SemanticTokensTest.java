/*******************************************************************************
 * Copyright (c) 2022 Avaloq Group Ltd (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.SemanticTokensFullConfiguration;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author Rubén Porras Campo - Initial test
 * @author Jonathan Pollert - Adjust to LSP specification
 */
public class SemanticTokensTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testSemanticTokensFull() {
		testSemanticTokensFull((SemanticTokensFullConfiguration it) -> {
			String model =
					"type foo {\n" +
					"	\n" +
					"}\n" +
					"type bar extends foo {\n" +
					"	\n" +
					"}\n";
		it.setModel(model);
		
		List<List<Integer>> expectedTokens = new ArrayList<>(); 
		expectedTokens.add(ImmutableList.of(0,0,4,15,0));
		expectedTokens.add(ImmutableList.of(0,5,3,1,16));
		expectedTokens.add(ImmutableList.of(3,0,4,15,0));
		expectedTokens.add(ImmutableList.of(0,5,3,1,16));
		expectedTokens.add(ImmutableList.of(0,4,7,15,0));
		
		it.setExpected(expectedTokens.stream().flatMap(List::stream).collect(Collectors.toList()));
		});
	}
}
