/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

public class DocumentHighlightConfiguration extends TextDocumentPositionConfiguration {
	private String expectedDocumentHighlight = "";

	public String getExpectedDocumentHighlight() {
		return expectedDocumentHighlight;
	}

	public void setExpectedDocumentHighlight(String expectedDocumentHighlight) {
		this.expectedDocumentHighlight = expectedDocumentHighlight;
	}
}
