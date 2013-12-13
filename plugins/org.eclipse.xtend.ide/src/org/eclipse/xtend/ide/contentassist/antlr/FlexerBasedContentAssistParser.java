/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.antlr;

import java.io.StringReader;
import java.util.Collection;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.ide.contentassist.antlr.internal.InternalXtendParser;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.InfiniteRecursion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexerBasedContentAssistParser extends XtendParser {

	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	@Inject
	private FlexerFactory flexerFactory;
	
	@Override
	protected InternalXtendParser createParser() {
		FlexerBasedInternalContentAssistParser result = new FlexerBasedInternalContentAssistParser(tokenDefProvider);
		result.setGrammarAccess(getGrammarAccess());
		return result;
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<FollowElement> getFollowElements(String input, boolean strict) {
		TokenSource tokenSource = flexerFactory.createTokenSource(new StringReader(input));
		AbstractInternalContentAssistParser parser = createParser();
		parser.setStrict(strict);
		ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(tokenSource, parser);
		tokens.setInitialHiddenTokens(getInitialHiddenTokens());
		parser.setTokenStream(tokens);
		IUnorderedGroupHelper helper = getUnorderedGroupHelper().get();
		parser.setUnorderedGroupHelper(helper);
		helper.initializeWith(parser);
		tokens.setListener(parser);
		try {
			return Lists.newArrayList(getFollowElements(parser));
		} catch(InfiniteRecursion infinite) {
			return Lists.newArrayList(parser.getFollowElements());
		}
	}
}
