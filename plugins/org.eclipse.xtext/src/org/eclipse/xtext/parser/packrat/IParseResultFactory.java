/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ParseResultFactory.class)
public interface IParseResultFactory {

	IParseResult createParseResult(AbstractParsedToken token, CharSequence input);
	
	public class NullParseResultFactory implements IParseResultFactory {

		public static IParseResultFactory INSTANCE = new NullParseResultFactory();
		
		public IParseResult createParseResult(AbstractParsedToken tokens, CharSequence input) {
			return new ParseResult();
		}
		
	}
	
}
