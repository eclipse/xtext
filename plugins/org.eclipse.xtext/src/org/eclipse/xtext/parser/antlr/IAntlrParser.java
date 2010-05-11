/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.InputStream;
import java.io.Reader;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(IAntlrParser.NullParser.class)
public interface IAntlrParser extends IParser {
	
	@Deprecated
	IParseResult parse(String ruleName, InputStream in);

	IParseResult parse(String ruleName, Reader reader);
	
	static class NullParser implements IAntlrParser {

		@SuppressWarnings("deprecation")
		public IParseResult parse(InputStream in) {
			throw new UnsupportedOperationException("Nullparser");
		}

		public IParseResult parse(Reader reader) {
			throw new UnsupportedOperationException("Nullparser");
		}

		public IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
			throw new UnsupportedOperationException("Nullparser");
		}

		@SuppressWarnings("deprecation")
		public IParseResult parse(String ruleName, InputStream in) {
			throw new UnsupportedOperationException("Nullparser");
		}

		public IParseResult parse(String ruleName, Reader reader) {
			throw new UnsupportedOperationException("Nullparser");
		}
		
	}
}
