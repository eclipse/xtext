/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.Hover;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class HoverTestConfiguration extends TextDocumentPositionConfiguration {
	private String expectedHover = "";

	private Procedure1<? super Hover> assertHover = null;

	public String getExpectedHover() {
		return expectedHover;
	}

	public void setExpectedHover(String expectedHover) {
		this.expectedHover = expectedHover;
	}

	public Procedure1<? super Hover> getAssertHover() {
		return assertHover;
	}

	public void setAssertHover(Procedure1<? super Hover> assertHover) {
		this.assertHover = assertHover;
	}
}
