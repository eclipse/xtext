/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parser;

/**
 * Define built-in token types.
 * 
 * @author koehnlein
 */
public interface ITokenTypes {

	public static final String ANYOTHER = "anyother";
	public static final String COMMENT = "comment";
	public static final String IDENTIFIER = "identifier";
	public static final String INTEGER = "integer";
	public static final String KEYWORD = "keyword";
	public static final String STRINGLITERAL = "stringliteral";
	public static final String WHITESPACE = "whitespace";
}
