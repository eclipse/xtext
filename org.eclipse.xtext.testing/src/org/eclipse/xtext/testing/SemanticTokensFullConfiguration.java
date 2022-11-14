/**
 * Copyright (c) 2022 Avaloq Group Ltd (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import com.google.common.annotations.Beta;

/**
 * @author Rubén Porras Campo - Initial Contribution and API
 */
@Beta
public class SemanticTokensFullConfiguration extends TextDocumentConfiguration {
	private String expectedText = "";

	public String getExpectedText() {
		return expectedText;
	}

	public void setExpectedText(String expectedText) {
		this.expectedText = expectedText;
	}
}
