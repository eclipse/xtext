/**
 * Copyright (c) 2019, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.tests.xmleditor.tests.XmlInjectorProvider;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@RunWith(XtextRunner.class)
@InjectWith(XmlInjectorProvider.class)
public class XmlLexerTests extends AbstractXmlLexerTest {
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer lexer;

	@Override
	public org.antlr.runtime.Lexer lexer() {
		return lexer;
	}
}
