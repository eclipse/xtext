/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GrammarNaming {
	@Inject
	private XtextGeneratorNaming xtextGeneratorNaming;

	public boolean isCombinedGrammar(Grammar it) {
		return CombinedGrammarMarker.findInEmfObject(it).isCombinedGrammar();
	}

	protected String getParserPackage(Grammar it) {
		return xtextGeneratorNaming.getRuntimeBasePackage(it) + ".parser.antlr";
	}

	protected String getInternalParserPackage(Grammar it) {
		return getParserPackage(it) + ".internal";
	}

	protected String getInternalLexerPackage(Grammar it) {
		return getParserPackage(it) + ".lexer";
	}

	public AntlrGrammar getParserGrammar(Grammar it) {
		StringBuilder builder = new StringBuilder();
		builder.append(getGrammarNamePrefix(it));
		builder.append("Internal");
		builder.append(GrammarUtil.getSimpleName(it));
		if (!isCombinedGrammar(it)) {
			builder.append("Parser");
		}
		return new AntlrGrammar(getInternalParserPackage(it), builder.toString());
	}

	public AntlrGrammar getLexerGrammar(Grammar it) {
		if (isCombinedGrammar(it)) {
			return getParserGrammar(it);
		} else {
			return new AntlrGrammar(getInternalLexerPackage(it),
					getGrammarNamePrefix(it) + "Internal" + GrammarUtil.getSimpleName(it) + "Lexer");
		}
	}

	protected String getGrammarNamePrefix(Grammar it) {
		return "";
	}

	public TypeReference getLexerClass(Grammar it) {
		StringBuilder builder = new StringBuilder();
		builder.append(getLexerGrammar(it).getSimpleName());
		if (isCombinedGrammar(it)) {
			builder.append("Lexer");
		}
		return new TypeReference(getLexerGrammar(it).getPackageName(), builder.toString());
	}

	public TypeReference getLexerSuperClass(Grammar it) {
		return new TypeReference("org.eclipse.xtext.parser.antlr.Lexer");
	}

	public TypeReference getParserClass(Grammar it) {
		return new TypeReference(getParserPackage(it), GrammarUtil.getSimpleName(it) + "Parser");
	}

	public TypeReference getParserSuperClass(Grammar it, boolean partialParsing) {
		return new TypeReference("org.eclipse.xtext.parser.antlr.AbstractAntlrParser");
	}

	public TypeReference getInternalParserClass(Grammar it) {
		StringBuilder builder = new StringBuilder();
		builder.append(getParserGrammar(it).getSimpleName());
		if (isCombinedGrammar(it)) {
			builder.append("Parser");
		}
		return new TypeReference(getParserGrammar(it).getPackageName(), builder.toString());
	}

	public TypeReference getInternalParserSuperClass(Grammar it) {
		return new TypeReference("org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser");
	}

	public TypeReference getAntlrTokenFileProviderClass(Grammar it) {
		return new TypeReference(getParserPackage(it), GrammarUtil.getSimpleName(it) + "AntlrTokenFileProvider");
	}

	public TypeReference getTokenSourceClass(Grammar it) {
		return new TypeReference(getParserPackage(it), GrammarUtil.getSimpleName(it) + "TokenSource");
	}
}
