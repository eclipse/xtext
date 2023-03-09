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

import org.eclipse.lsp4j.Location;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ReferenceTestConfiguration extends TextDocumentPositionConfiguration {
	private boolean includeDeclaration = false;

	private String expectedReferences = "";

	private Procedure1<? super List<? extends Location>> assertReferences = null;

	public boolean isIncludeDeclaration() {
		return includeDeclaration;
	}

	public void setIncludeDeclaration(boolean includeDeclaration) {
		this.includeDeclaration = includeDeclaration;
	}

	public String getExpectedReferences() {
		return expectedReferences;
	}

	public void setExpectedReferences(String expectedReferences) {
		this.expectedReferences = expectedReferences;
	}

	public Procedure1<? super List<? extends Location>> getAssertReferences() {
		return assertReferences;
	}

	public void setAssertReferences(Procedure1<? super List<? extends Location>> assertReferences) {
		this.assertReferences = assertReferences;
	}
}
