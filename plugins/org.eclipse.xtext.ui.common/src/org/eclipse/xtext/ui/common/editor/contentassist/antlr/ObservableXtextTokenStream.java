/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

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
		int result = super.LA(i);
		if (result == Token.EOF && getListener() != null)
			getListener().announceEof(i);
		return result;
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
