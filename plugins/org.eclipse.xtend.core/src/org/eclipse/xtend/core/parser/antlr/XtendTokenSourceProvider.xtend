/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr

import java.io.Reader
import org.eclipse.xtend.core.parser.ReaderCharStream
import org.eclipse.xtext.parser.antlr.AbstractAntlrParserBasedTokenSourceProvider
import com.google.inject.Singleton

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class XtendTokenSourceProvider extends AbstractAntlrParserBasedTokenSourceProvider {

	protected override getCharStream(Reader reader) {
		new ReaderCharStream(reader)
	}

}
