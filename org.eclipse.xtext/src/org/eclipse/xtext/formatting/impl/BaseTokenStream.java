/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITokenStreamExtension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class BaseTokenStream extends AbstractTokenStream {
	protected ITokenStream out;

	protected BaseTokenStream(ITokenStream out) {
		super();
		this.out = out;
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void init(ParserRule startRule) {
		if (out instanceof ITokenStreamExtension)
			((ITokenStreamExtension) out).init(startRule);
	}
}