/*******************************************************************************
 * Copyright (c) 2009, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.Collection;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.BaseContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.EofListener;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.BaseInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * This class if effectively deprecated and clients should use the equivalent from the ide package instead.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser extends
		BaseContentAssistParser<FollowElement, LookAheadTerminal, AbstractInternalContentAssistParser> implements IContentAssistParser {

	@Inject
	@Named(LexerIdeBindings.CONTENT_ASSIST)
	private Provider<Lexer> lexerProvider;

	@Override
	protected TokenSource createLexer(CharStream stream) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(stream);
		return lexer;
	}
	
	/* Abstract override is necessary to be backwards compatible due to generic signature in super class */
	@Override
	protected abstract AbstractInternalContentAssistParser createParser();
	
	/* Delegating override is necessary to avoid synthetic method signatures in subtypes and thereby preserve binary compatibility in edge-cases */
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		return super.getFollowElements(parser);
	}

	/**
	 * @since 2.14
	 */
	protected static class MyEofListener extends EofListener implements AbstractInternalContentAssistParser.RecoveryListener {

		protected MyEofListener(BaseInternalContentAssistParser<?, ?> parser, AbstractElement elementToParse) {
			super(parser, elementToParse);
		}

	}

	/**
	 * @since 2.14
	 */
	@Override
	protected MyEofListener createEofListener(final AbstractInternalContentAssistParser parser, final AbstractElement elementToParse) {
		return new MyEofListener(parser, elementToParse);
	}

}
