/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugParsedTokenAcceptor implements IParsedTokenAcceptor {

	private static final Logger log = Logger.getLogger(DebugParsedTokenAcceptor.class);
	
	private final IParsedTokenAcceptor delegate;
	
	public DebugParsedTokenAcceptor(IParsedTokenAcceptor delegate) {
		this.delegate = delegate;
	}
	
	public void accept(AbstractParsedToken token) {
		if (log.isDebugEnabled()) {
			log.debug("accept(" + token + ")");
		}
		delegate.accept(token);
	}

}
