/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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