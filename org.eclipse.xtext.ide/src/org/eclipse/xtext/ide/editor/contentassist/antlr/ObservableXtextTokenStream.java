/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

/**
 * @since 2.9
 */
public class ObservableXtextTokenStream extends XtextTokenStream {

	public interface StreamListener {
		void announceEof(int lookAhead);
		void announceConsume();
		void announceMark(int marker);
		void announceRewind(int marker);
	}
	
	private StreamListener listener;
	
	private boolean attemptedToConsumePastEof = false;
	
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
	public int mark() {
		int result = super.mark();
		if (getListener() != null)
			getListener().announceMark(result);
		return result;
	}
	
	@Override
	public void rewind(int marker) {
		if (marker != tokens.size())
			attemptedToConsumePastEof = false;
		if (getListener() != null)
			getListener().announceRewind(marker);
		super.rewind(marker);
	}
	
	@Override
	public void consume() {
		if (getListener() != null) {
			if (getFirstMarker() == -1 && getCurrentLookAhead() <= 1 && p >= tokens.size()) {
				if (!attemptedToConsumePastEof) {
					attemptedToConsumePastEof = true;
					getListener().announceConsume();
				}
			} else {
				getListener().announceConsume();
			}
		}
		super.consume();
	}

	public void setListener(StreamListener listener) {
		this.listener = listener;
	}

	public StreamListener getListener() {
		return listener;
	}

}
