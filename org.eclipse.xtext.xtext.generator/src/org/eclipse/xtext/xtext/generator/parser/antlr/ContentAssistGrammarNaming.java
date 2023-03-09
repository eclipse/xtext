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
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

import com.google.inject.Inject;

public class ContentAssistGrammarNaming extends GrammarNaming {
	@Inject
	private XtextGeneratorNaming xtextGeneratorNaming;

	@Override
	protected String getParserPackage(Grammar it) {
		return xtextGeneratorNaming.getGenericIdeBasePackage(it) + ".contentassist.antlr";
	}

	@Override
	public TypeReference getLexerSuperClass(Grammar it) {
		return new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer");
	}

	@Override
	public TypeReference getInternalParserSuperClass(Grammar it) {
		return new TypeReference(
				"org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser");
	}

	@Override
	public TypeReference getParserSuperClass(Grammar it, boolean partialParsing) {
		if (partialParsing) {
			return new TypeReference(
					"org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractPartialContentAssistParser");
		} else {
			return new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser");
		}
	}
}
