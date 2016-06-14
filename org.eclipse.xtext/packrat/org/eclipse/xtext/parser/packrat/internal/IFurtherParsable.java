/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenSource;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IFurtherParsable<Token extends ParsedToken> {

	boolean canParseFurther();

	Token getToken();

	Source<Token> getSource();

	interface Source<Token extends ParsedToken> extends IParsedTokenSource {
		int parseFurther(IFurtherParsable<Token> token) throws Exception;
	}
}
