/*******************************************************************************
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.formatter;

import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;

@Deprecated(forRemoval = true)
public class AssertingFormatterData {
	private MapBasedPreferenceValues config;

	public FormattingPreferenceValues getCfg() {
		return new FormattingPreferenceValues(config);
	}

	private CharSequence expectation;

	private CharSequence toBeFormatted;

	private String prefix;

	private String postfix;

	private boolean allowErrors;

	public MapBasedPreferenceValues getConfig() {
		return config;
	}

	public void setConfig(MapBasedPreferenceValues config) {
		this.config = config;
	}

	public CharSequence getExpectation() {
		return expectation;
	}

	public void setExpectation(CharSequence expectation) {
		this.expectation = expectation;
	}

	public CharSequence getToBeFormatted() {
		return toBeFormatted;
	}

	public void setToBeFormatted(CharSequence toBeFormatted) {
		this.toBeFormatted = toBeFormatted;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}

	public boolean isAllowErrors() {
		return allowErrors;
	}

	public void setAllowErrors(boolean allowErrors) {
		this.allowErrors = allowErrors;
	}
}
