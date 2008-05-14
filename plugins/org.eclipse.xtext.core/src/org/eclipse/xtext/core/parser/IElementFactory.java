/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parser;

import org.antlr.runtime.TokenStream;


/**
 * @author svenefftinge
 *
 */
public interface IElementFactory {
	/**
	 * creates an instance of the given typename
	 * 
	 * @param typeName
	 * @return
	 */
	public Object create(String typeName);
	
	/**
	 * 
	 * sets the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 */
	public void set(Object _this, String feature, Object value);
	
	/**
	 * adds the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 */
	public void add(Object _this, String feature, Object value);
	
	/**
	 * Creates a new ParserNode as a child of the given parentParserNode.
	 * 
	 * @param input
	 * @param currentGrammarElement
	 * @param parentParserNode
	 * @return 
	 */
	public Object createParserNode(TokenStream input, Object currentGrammarElement, 
			Object parentParserNode);
	
	/**
	 * Associates the parserNode with the astElement
	 * @param parserNode
	 * @param astNode
	 */
	public void associate(Object parserNode, Object astNode);
}
