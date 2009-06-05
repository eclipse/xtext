/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatter.impl.AbstractTokenStream;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenOutputStream extends AbstractTokenStream {

	private boolean allowClose;

	private OutputStream out;

	public TokenOutputStream(OutputStream out) {
		this(out, false);
	}

	public TokenOutputStream(OutputStream out, boolean allowClose) {
		super();
		this.out = out;
		this.allowClose = allowClose;
	}

	@Override
	public void close() throws IOException {
		if (allowClose)
			out.close();
	}

	@Override
	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.write(value.getBytes());
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.write(value.getBytes());
	}

}
