/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.formatter;

import java.util.LinkedHashMap;

import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @deprecated Use org.eclipse.xtext.testing.formatter.FormatterTestRequest instead
 */
@Deprecated(forRemoval = true)
public class FormatterTestRequest {
	private boolean allowSyntaxErrors = false;
	private boolean allowUnformattedWhitespace = true; // TODO: default should be false
	private CharSequence expectation;
	private FormatterRequest request;
	private CharSequence toBeFormatted;
	private boolean useNodeModel = true;
	private boolean useSerializer = true;
	
	public boolean isAllowUnformattedWhitespace() {
		return allowUnformattedWhitespace;
	}
	
	public FormatterTestRequest setAllowUnformattedWhitespace(boolean allowUnformattedWhitespace) {
		this.allowUnformattedWhitespace = allowUnformattedWhitespace;
		return this;
	}

	public boolean isUseNodeModel() {
		return useNodeModel;
	}

	public boolean isUseSerializer() {
		return useSerializer;
	}

	public FormatterTestRequest setUseNodeModel(boolean useNodeModel) {
		this.useNodeModel = useNodeModel;
		return this;
	}

	public FormatterTestRequest setUseSerializer(boolean useSerializer) {
		this.useSerializer = useSerializer;
		return this;
	}

	// make all HiddenRegions as 'unknown' aka "ignoreOldHiddens"
	// boolean allowReplacementsAcrossTokens = false;

	public CharSequence getExpectation() {
		return expectation;
	}

	public CharSequence getExpectationOrToBeFormatted() {
		if (expectation != null)
			return expectation;
		return toBeFormatted;
	}

	public MapBasedPreferenceValues getOrCreateMapBasedPreferences() {
		ITypedPreferenceValues preferences = request.getPreferences();
		if (preferences instanceof MapBasedPreferenceValues)
			return (MapBasedPreferenceValues) preferences;
		LinkedHashMap<String, String> newMap = Maps.<String, String> newLinkedHashMap();
		MapBasedPreferenceValues result = new MapBasedPreferenceValues(preferences, newMap);
		request.setPreferences(result);
		return result;
	}

	public FormatterRequest getRequest() {
		return request;
	}

	public CharSequence getToBeFormatted() {
		return toBeFormatted;
	}

	public boolean isAllowSyntaxErrors() {
		return allowSyntaxErrors;
	}

	public FormatterTestRequest preferences(Procedures.Procedure1<MapBasedPreferenceValues> preferences) {
		MapBasedPreferenceValues map = getOrCreateMapBasedPreferences();
		preferences.apply(map);
		return this;
	}

	public FormatterTestRequest setAllowSyntaxErrors(boolean allowSyntaxErrors) {
		this.allowSyntaxErrors = allowSyntaxErrors;
		return this;
	}

	public FormatterTestRequest setExpectation(CharSequence expectation) {
		this.expectation = expectation;
		return this;
	}

	@Inject
	public FormatterTestRequest setRequest(FormatterRequest request) {
		this.request = request;
		return this;
	}

	public FormatterTestRequest setToBeFormatted(CharSequence toBeFormatted) {
		this.toBeFormatted = toBeFormatted;
		return this;
	}

}