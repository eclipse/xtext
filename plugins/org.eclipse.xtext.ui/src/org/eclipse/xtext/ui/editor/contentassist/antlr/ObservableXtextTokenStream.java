/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ObservableXtextTokenStream extends XtextTokenStream {

	public interface StreamListener {
		void announceEof(int lookAhead);
		void announceConsume();
		void announceMark(int marker);
		void announceRewind(int marker);
	}
	
	private StreamListener listener;
	
	public ObservableXtextTokenStream() {
		super();
	}

	public ObservableXtextTokenStream(TokenSource tokenSource, int channel) {
		super(tokenSource, channel);
	}

	public ObservableXtextTokenStream(TokenSource tokenSource, ITokenDefProvider tokenDefProvider) {
		super(tokenSource, tokenDefProvider);
	}

	@Override
	public int LA(int i) {
		Token lookaheadToken = LT(i);
		int result = lookaheadToken.getType();
		if (result == Token.EOF && getListener() != null)
			getListener().announceEof(i);
		return result;
	}
	
	@Override
	protected List<Token> createLookAheadTokenList() {
		return Collections.<Token>emptyList();
	}
	
	@Override
	public int mark() {
		int result = super.mark();
		if (getListener() != null)
			getListener().announceMark(result);
		return result;
	}
	
	@Override
	public void rewind(int marker) {
		if (getListener() != null)
			getListener().announceRewind(marker);
		super.rewind(marker);
	}
	
	@Override
	public void consume() {
		if (getListener() != null)
			getListener().announceConsume();
		super.consume();
	}

	public void setListener(StreamListener listener) {
		this.listener = listener;
	}

	public StreamListener getListener() {
		return listener;
	}

}
