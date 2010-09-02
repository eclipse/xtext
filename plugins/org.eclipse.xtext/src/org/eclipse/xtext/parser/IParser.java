/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.Reader;

import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(IParser.NullImpl.class)
public interface IParser {
	
	IParseResult parse(Reader reader);
	
	IParseResult parse(String ruleName, Reader reader);
	
	IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change);
	
	static class NullImpl implements IParser {

		public IParseResult parse(Reader reader) {
			return null;
		}

		public IParseResult parse(String ruleName, Reader reader) {
			return null;
		}

		public IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
			return null;
		}
		
	}

}
