/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenStringBuffer extends AbstractTokenStream {

	private StringBuffer out = new StringBuffer();

	@Override
	public void flush() throws IOException {
	}

	@Override
	public String toString() {
		return out.toString();
	}

	@Override
	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.append(value);
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		if (value != null && value.length() > 0)
			out.append(value);
	}

}
