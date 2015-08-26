/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import java.util.List;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 */
public class XtendPsiAntlrGrammarGenerator extends PsiAntlrGrammarGenerator {
	@Inject
	@Extension
	private TokenNames tokenNames;

	@Override
	protected String compileTokens(final Grammar grammar, final AntlrOptions options) {
		StringConcatenation builder = new StringConcatenation();
		builder.newLine();
		builder.append("tokens {");
		builder.newLine();
		List<String> tokens = this.tokenNames.getTokens(grammar, CollectionLiterals.<String> newHashSet());
		for (final String token : tokens) {
			builder.append("  ");
			builder.append(token, "  ");
			builder.append(" ;");
			builder.newLineIfNotEmpty();
		}
		builder.append("}");
		builder.newLine();
		return builder.toString();
	}
}
