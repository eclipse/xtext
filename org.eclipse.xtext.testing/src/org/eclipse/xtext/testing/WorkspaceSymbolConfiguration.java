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

import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkspaceSymbolConfiguration extends TextDocumentConfiguration {
	private String query = "";

	private String expectedSymbols = "";

	private Procedure1<? super List<? extends SymbolInformation>> assertSymbols = null;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getExpectedSymbols() {
		return expectedSymbols;
	}

	public void setExpectedSymbols(String expectedSymbols) {
		this.expectedSymbols = expectedSymbols;
	}

	public Procedure1<? super List<? extends SymbolInformation>> getAssertSymbols() {
		return assertSymbols;
	}

	public void setAssertSymbols(Procedure1<? super List<? extends SymbolInformation>> assertSymbols) {
		this.assertSymbols = assertSymbols;
	}
}
