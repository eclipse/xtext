/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @since 2.9
 */
public abstract class AbstractContentAssistParser
		extends BaseContentAssistParser<FollowElement, LookAheadTerminal, AbstractInternalContentAssistParser>
		implements IContentAssistParser, IPartialEditingContentAssistParser {

	@Inject
	@Named(LexerIdeBindings.CONTENT_ASSIST)
	private Provider<Lexer> lexerProvider;

	@Override
	protected TokenSource createLexer(CharStream stream) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(stream);
		return lexer;
	}

}
