/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractParser implements IParser {

	public IParseResult parse(InputStream in, IElementFactory factory, IParseErrorHandler handler,
			IParsePostProcessor postProcessor) {
		try {
			IParseResult parseResult = (IParseResult) parse(new ANTLRInputStream(in), factory, handler);
			return postProcessor.postProcess(parseResult);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public IParseResult parse(InputStream in, IElementFactory factory, IParseErrorHandler handler) {
		return parse(in, factory, handler, getDefaultPostProcessor());
	}

	public IParseResult parse(InputStream in, IElementFactory factory) {
		return parse(in, factory, getDefaultHandler(), getDefaultPostProcessor());
	}

	public IParseResult parse(InputStream in) {
		return parse(in, getDefaultASTFactory(), getDefaultHandler(), getDefaultPostProcessor());
	}

	protected abstract IElementFactory getDefaultASTFactory();

	protected IParsePostProcessor getDefaultPostProcessor() {
		return new IParsePostProcessor() {
			public IParseResult postProcess(IParseResult parseResult) {
				// TODO: add code
				return parseResult;
			}
		};
	}

	protected IParseErrorHandler getDefaultHandler() {
		return new IParseErrorHandler() {
			public void handleParserError(IParseError error) {
				throw new ParseException(error);
			}
		};
	}

	protected abstract IParseResult parse(ANTLRInputStream in, IElementFactory factory, IParseErrorHandler handler);
}
