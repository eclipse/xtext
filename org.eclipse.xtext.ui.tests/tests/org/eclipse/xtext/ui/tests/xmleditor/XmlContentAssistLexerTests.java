/**
 * Copyright (c) 2019, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@RunWith(XtextRunner.class)
@InjectWith(XmlUiInjectorProvider.class)
public class XmlContentAssistLexerTests extends AbstractXmlLexerTest {
	@Inject
	@Named(LexerUIBindings.CONTENT_ASSIST)
	private Lexer lexer;

	@Override
	public org.antlr.runtime.Lexer lexer() {
		return lexer;
	}

	@Override
	public void test022() throws Exception {
		String modelAsText = "<a b=\"/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				// The content assist lexer produces different tokens than the parser/highlighting lexer
				// 0 '\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(modelAsText, expectation);
	}
}
