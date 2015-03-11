/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import org.antlr.runtime.CharStream
import org.eclipse.xtext.parser.IParser

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@Singleton
class AbstractAntlrParserBasedTokenSourceProvider extends AbstractTokenSourceProvider {

	@Inject
	IParser parser

	override createTokenSource(CharStream stream) {
		if (parser instanceof AbstractAntlrParser) {
			return parser.createLexer(stream)
		}
		throw new IllegalStateException('''«parser.class.name» should be a subclass of «AbstractAntlrParser.name»''')
	}

}
