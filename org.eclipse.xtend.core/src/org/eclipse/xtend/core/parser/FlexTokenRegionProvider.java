/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.Token;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.parser.impl.TokenRegionProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexTokenRegionProvider extends TokenRegionProvider {
	
	@Inject
	private FlexerFactory flexerFactory;

	@Override
	public ITextRegion getTokenRegion(String text, ITextRegion region) {
		try {
			InternalFlexer flexer = flexerFactory.createFlexer(new StringReader(text));
			int token = flexer.advance();
			int prevStart = 0;
			int nextStart = flexer.getTokenLength();
			
			final int regionStartOffset = region.getOffset();
			final int regionEnd = regionStartOffset + region.getLength();
			while (token != Token.EOF && nextStart <= regionStartOffset) {
				prevStart = nextStart;
				token = flexer.advance();
				nextStart += flexer.getTokenLength();
			}
			while (token != Token.EOF && nextStart < regionEnd) {
				token = flexer.advance();
				nextStart += flexer.getTokenLength();
			}
			return new TextRegion(prevStart, nextStart - prevStart);
		} catch(IOException e) {
			throw new RuntimeException(e); // cannot happen since StringReader doesn't throw IOException
		}
	}

}
