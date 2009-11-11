/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.Token;

/**
 * Abstraction for an object, that will continuously accept Antlr tokens. Implementations
 * should offer additional functionality like access to the previously accepted tokens based on a 
 * specialized public interface.
 * @see TokenAcceptor
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITokenAcceptor {
	
	void accept(Token token);
	
}