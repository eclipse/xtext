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

public class DefinitionTestConfiguration extends TextDocumentPositionConfiguration {
	private String expectedDefinitions = "";

	private Procedure1<? super List<? extends Location>> assertDefinitions = null;

	public String getExpectedDefinitions() {
		return expectedDefinitions;
	}

	public void setExpectedDefinitions(String expectedDefinitions) {
		this.expectedDefinitions = expectedDefinitions;
	}

	public Procedure1<? super List<? extends Location>> getAssertDefinitions() {
		return assertDefinitions;
	}

	public void setAssertDefinitions(Procedure1<? super List<? extends Location>> assertDefinitions) {
		this.assertDefinitions = assertDefinitions;
	}
}
