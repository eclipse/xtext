/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr

import com.google.common.io.CharSource
import java.io.Reader
import org.antlr.runtime.ANTLRReaderStream
import org.antlr.runtime.CharStream

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractTokenSourceProvider implements TokenSourceProvider {

	protected def CharStream getCharStream(Reader reader) {
		new ANTLRReaderStream(reader)
	}

	protected def getReader(CharSequence text) {
		CharSource.wrap(text).openStream
	}

	override createTokenSource(CharSequence text) {
		text.reader.createTokenSource
	}

	override createTokenSource(Reader reader) {
		reader.charStream.createTokenSource
	}
	
}