/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.mwe2.runtime.Mandatory;

import com.google.gson.annotations.Expose;

/**
 * See the <a href="https://macromates.com/manual/en/language_grammars#rule_keys">TextMate specification</a>.
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class MatchRule extends TextMateRule {

	@Expose private String match;
	@Expose private Map<Integer, Capture> captures;

	@Mandatory
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	public String getMatch() {
		return match;
	}

	@Mandatory
	public void setMatch(String match) {
		this.match = match;
	}
	
	public void addCapture(Capture c) {
		if (captures == null) {
			captures = new TreeMap<>();
		}
		captures.put(c.getGroup(), c);
	}
	
	
}