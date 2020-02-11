/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public void accept(AbstractParsedToken token) {
		if (log.isDebugEnabled()) {
			log.debug("accept(" + token + ")");
		}
		delegate.accept(token);
	}

}
