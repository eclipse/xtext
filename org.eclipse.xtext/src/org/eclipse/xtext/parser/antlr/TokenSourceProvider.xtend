/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr

import com.google.inject.ImplementedBy
import java.io.Reader
import org.antlr.runtime.CharStream
import org.antlr.runtime.TokenSource

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@ImplementedBy(AbstractAntlrParserBasedTokenSourceProvider)
interface TokenSourceProvider {

	def TokenSource createTokenSource(CharSequence text)
	
	def TokenSource createTokenSource(Reader reader)
	
	def TokenSource createTokenSource(CharStream stream)

}
