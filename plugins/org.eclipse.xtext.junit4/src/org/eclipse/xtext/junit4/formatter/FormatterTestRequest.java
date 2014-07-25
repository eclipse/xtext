/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.formatter;

import java.util.Map;

import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.TypedPreferenceKey;
import org.eclipse.xtext.preferences.TypedPreferenceValues;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Maps;

public class FormatterTestRequest {
	private CharSequence expectationOnInitialFormat;
	private CharSequence expectationOnReformat;
	private CharSequence postfix;
	private Map<String, String> preferences = Maps.newLinkedHashMap();
	private CharSequence prefix;
	private CharSequence toBeFormatted;

	// boolean allowSyntaxErrors = false
	// boolean allowUnformattedGaps = false
	// boolean allowReplacementsAcrossTokens = false;

	public CharSequence getExpectationOnInitialFormat() {
		return expectationOnInitialFormat;
	}

	public CharSequence getExpectationOnReformat() {
		return expectationOnReformat;
	}

	public CharSequence getPostfix() {
		return postfix;
	}

	public Map<String, String> getPreferences() {
		return preferences;
	}

	public ITypedPreferenceValues getPreferenceValues() {
		return new TypedPreferenceValues(new MapBasedPreferenceValues(preferences));
	}

	public CharSequence getPrefix() {
		return prefix;
	}

	public CharSequence getToBeFormatted() {
		return toBeFormatted;
	}

	public ITextRegion getRegionBetweenPreAndPostfix() {
		return new TextRegion(prefix != null ? prefix.length() : 0, toBeFormatted.length());
	}

	public FormatterTestRequest setExpectation(CharSequence expectation) {
		this.expectationOnInitialFormat = expectation;
		this.expectationOnReformat = expectation;
		return this;
	}

	public FormatterTestRequest setExpectationOnInitialFormat(CharSequence expectationOnInitialFormat) {
		this.expectationOnInitialFormat = expectationOnInitialFormat;
		return this;
	}

	public int getPrefixLenght() {
		return prefix == null ? 0 : prefix.length();
	}

	public int getPostfixLenght() {
		return postfix == null ? 0 : postfix.length();
	}

	public String getToBeFormattedDocument() {
		StringBuilder builder = new StringBuilder();
		if (prefix != null)
			builder.append(prefix);
		builder.append(toBeFormatted);
		if (postfix != null)
			builder.append(postfix);
		return builder.toString();
	}

	public FormatterTestRequest setExpectationOnReformat(CharSequence expectationOnReformat) {
		this.expectationOnReformat = expectationOnReformat;
		return this;
	}

	public FormatterTestRequest setPostfix(CharSequence postfix) {
		this.postfix = postfix;
		return this;
	}

	public <T> FormatterTestRequest setPreference(TypedPreferenceKey<T> key, T value) {
		this.preferences.put(key.getId(), key.toString(value));
		return this;
	}

	public FormatterTestRequest setPreferences(Map<String, String> preferences) {
		this.preferences = preferences;
		return this;
	}

	public FormatterTestRequest setPrefix(CharSequence prefix) {
		this.prefix = prefix;
		return this;
	}

	public FormatterTestRequest setToBeFormatted(CharSequence toBeFormatted) {
		this.toBeFormatted = toBeFormatted;
		return this;
	}

}