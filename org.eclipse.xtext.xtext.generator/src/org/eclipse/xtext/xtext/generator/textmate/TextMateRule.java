/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import com.google.gson.annotations.Expose;

/**
 * Minimal TextMate rule.
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public abstract class TextMateRule {
	@Expose private String name;
	
	private String terminalRule;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerminalRule() {
		return terminalRule;
	}

	public void setTerminalRule(String terminalRule) {
		this.terminalRule = terminalRule;
	}
	
}