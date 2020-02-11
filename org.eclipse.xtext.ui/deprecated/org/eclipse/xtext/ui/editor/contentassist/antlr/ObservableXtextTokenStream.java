/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ObservableXtextTokenStream extends org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream {

	public interface StreamListener extends org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener {
	}
	
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
	public void setListener(org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener listener) {
		if (!(listener instanceof StreamListener)) {
			throw new IllegalArgumentException();
		}
		super.setListener(listener);
	}

	public void setListener(StreamListener listener) {
		super.setListener(listener);
	}

	@Override
	public StreamListener getListener() {
		return (StreamListener) super.getListener();
	}

}
