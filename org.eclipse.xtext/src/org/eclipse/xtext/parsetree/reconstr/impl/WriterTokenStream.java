/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class WriterTokenStream extends AbstractTokenStream {

	private Writer out;

	public WriterTokenStream(Writer out) {
		super();
		this.out = out;
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void writeHidden(EObject grammarElement, String value) throws IOException {
		if (value != null && value.length() > 0)
			out.write(value);
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value) throws IOException {
		if (value != null && value.length() > 0)
			out.write(value);
	}

}
