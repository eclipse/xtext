/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TestParser implements IParser {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.IParser#parse(java.io.InputStream, org.eclipse.xtext.parser.IElementFactory, org.eclipse.xtext.parser.IParseErrorHandler)
	 */
	public IParseResult parse(InputStream in, IElementFactory factory, IParseErrorHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.IParser#parse(java.io.InputStream, org.eclipse.xtext.parser.IElementFactory)
	 */
	public IParseResult parse(InputStream in, IElementFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.IParser#parse(java.io.InputStream)
	 */
	public IParseResult parse(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}


}
