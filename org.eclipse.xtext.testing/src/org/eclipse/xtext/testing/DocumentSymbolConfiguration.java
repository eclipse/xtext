/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import java.util.List;

import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DocumentSymbolConfiguration extends TextDocumentConfiguration {
	private String expectedSymbols = "";

	private Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> assertSymbols = null;

	public String getExpectedSymbols() {
		return expectedSymbols;
	}

	public void setExpectedSymbols(String expectedSymbols) {
		this.expectedSymbols = expectedSymbols;
	}

	public Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> getAssertSymbols() {
		return assertSymbols;
	}

	public void setAssertSymbols(Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> assertSymbols) {
		this.assertSymbols = assertSymbols;
	}
}
