/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing;

public class FoldingConfiguration extends TextDocumentConfiguration {

	private String expectedFoldings;

	public String getExpectedFoldings() {
		return expectedFoldings;
	}

	public void setExpectedFoldings(String expectedFoldings) {
		this.expectedFoldings = expectedFoldings;
	}
	
}
