/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
