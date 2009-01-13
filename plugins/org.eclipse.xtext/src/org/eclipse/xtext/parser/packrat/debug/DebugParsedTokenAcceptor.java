/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugParsedTokenAcceptor implements IParsedTokenAcceptor {

	private final IParsedTokenAcceptor delegate;
	
	public DebugParsedTokenAcceptor(IParsedTokenAcceptor delegate) {
		this.delegate = delegate;
	}
	
	public void accept(AbstractParsedToken token) {
		delegate.accept(token);
	}

}
