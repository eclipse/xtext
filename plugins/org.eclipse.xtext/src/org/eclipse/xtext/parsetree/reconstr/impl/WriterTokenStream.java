/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;

/**
 * @author koehnlein - Initial contribution and API
 */
public class WriterTokenStream extends AbstractTokenStream {

	private boolean allowClose;

	private Writer out;

	public WriterTokenStream(Writer out) {
		this(out, false);
	}

	public WriterTokenStream(Writer out, boolean allowClose) {
		super();
		this.out = out;
		this.allowClose = allowClose;
	}

	@Override
	public void close() throws IOException {
		out.flush();
		if (allowClose)
			out.close();
	}

	@Override
	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.write(value);
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.write(value);
	}

}
