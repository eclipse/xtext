/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractParser implements IParser {
	
	public EObject parse(InputStream in) {
		return parse(in, getDefaultASTFactory());
	}

	protected abstract IElementFactory getDefaultASTFactory();

	public EObject parse(InputStream in, IElementFactory factory,
			IParseErrorHandler handler) {
		try {
			return (EObject) parse(new ANTLRInputStream(in),factory,handler);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public EObject parse(InputStream in, IElementFactory factory) {
		try {
			return (EObject) parse(new ANTLRInputStream(in),factory,getDefaultHandler());
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	
	protected IParseErrorHandler getDefaultHandler() {
		return new IParseErrorHandler() {

			public void handleParserError(int line, int offset, int length, int tokenType, String text,
					String message, Object context) {
				throw new ParseException(offset,length,text,message);
			}};
	}

	protected abstract Object parse(ANTLRInputStream in, IElementFactory factory, IParseErrorHandler handler);
}
