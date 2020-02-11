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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OneWhitespaceFormatter extends BaseFormatter {

	protected class OneWhitespaceFormatterStream extends BaseTokenStream {

		protected boolean hasStarted;

		protected boolean preserveWS;

		protected boolean wsWritten;

		public OneWhitespaceFormatterStream(ITokenStream out, boolean preserve) {
			super(out);
			this.hasStarted = false;
			this.wsWritten = false;
			this.preserveWS = preserve;
		}

		protected boolean isComment(EObject grammarElement, String value) {
			return grammarElement != getWSRule();
		}

		@Override
		public void writeHidden(EObject grammarElement, String value)
				throws IOException {
			boolean isCmt = isComment(grammarElement, value);
			if (preserveWS || isCmt) {
				if (isCmt) {
					writeSpaceIfNecessary();
					hasStarted = true;
				}
				out.writeHidden(grammarElement, value);
				wsWritten = !isCmt;
			}
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value)
				throws IOException {
			writeSpaceIfNecessary();
			hasStarted = true;
			out.writeSemantic(grammarElement, value);
			wsWritten = false;
		}

		protected void writeSpaceIfNecessary() throws IOException {
			if (hasStarted && !wsWritten) {
				out.writeHidden(getWSRule(), " ");
				wsWritten = true;
			}
		}

	}

	@Override
	public ITokenStream createFormatterStream(String initalIndentation,
			ITokenStream outputStream, boolean preserveWhitespaces) {
		return new OneWhitespaceFormatterStream(outputStream,
				preserveWhitespaces);
	}

}
