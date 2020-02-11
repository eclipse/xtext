/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConsumer {

	private final IParsedTokenAcceptor acceptor;
	private final ICharSequenceWithOffset input;

	protected AbstractConsumer(ICharSequenceWithOffset input, IParsedTokenAcceptor tokenAcceptor) {
		this.input = input;
		this.acceptor = tokenAcceptor;
	}

	protected final int getOffset() {
		return input.getOffset();
	}

	public IParsedTokenAcceptor getTokenAcceptor() {
		return acceptor;
	}

	public ICharSequenceWithOffset getInput() {
		return input;
	}

}