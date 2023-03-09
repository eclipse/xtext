/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SignatureHelpConfiguration extends TextDocumentPositionConfiguration {
	private String expectedSignatureHelp = "";

	private Procedure1<? super SignatureHelp> assertSignatureHelp = null;

	public String getExpectedSignatureHelp() {
		return expectedSignatureHelp;
	}

	public void setExpectedSignatureHelp(String expectedSignatureHelp) {
		this.expectedSignatureHelp = expectedSignatureHelp;
	}

	public Procedure1<? super SignatureHelp> getAssertSignatureHelp() {
		return assertSignatureHelp;
	}

	public void setAssertSignatureHelp(Procedure1<? super SignatureHelp> assertSignatureHelp) {
		this.assertSignatureHelp = assertSignatureHelp;
	}
}
