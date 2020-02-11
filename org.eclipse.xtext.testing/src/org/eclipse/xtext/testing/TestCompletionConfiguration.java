/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.CompletionList;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class TestCompletionConfiguration extends TextDocumentPositionConfiguration {
	private String expectedCompletionItems = "";

	private Procedure1<? super CompletionList> assertCompletionList = null;

	public String getExpectedCompletionItems() {
		return expectedCompletionItems;
	}

	public void setExpectedCompletionItems(String expectedCompletionItems) {
		this.expectedCompletionItems = expectedCompletionItems;
	}

	public Procedure1<? super CompletionList> getAssertCompletionList() {
		return assertCompletionList;
	}

	public void setAssertCompletionList(Procedure1<? super CompletionList> assertCompletionList) {
		this.assertCompletionList = assertCompletionList;
	}
}
