/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrContentAssistGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

import com.google.inject.Inject;

public class XtendContentAssistAntlrGrammarGenerator extends AntlrContentAssistGrammarGenerator {

	@Inject
	XtendAntlrGrammarGeneratorHelper helper;

	@Override
	protected String compileTokens(Grammar grammar, AntlrOptions options) {
		return helper.compileTokens(grammar, options);
	}
}
