/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.Collection;

import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterRequest implements IFormatterRequest {
	private boolean allowIdentityEdits;
	private boolean formatUndenfinedTokensOnly;
	private ITypedPreferenceValues preferenceValues;
	private FormatterProblemReporter problemHandler;
	private Collection<ITextRegion> regions = Lists.newArrayList();
	private ITextRegionAccess tokens;

	public FormatterRequest addRegion(ITextRegion region) {
		this.regions.add(region);
		return this;
	}

	public boolean allowIdentityEdits() {
		return allowIdentityEdits;
	}

	public boolean formatUndefinedGapsOnly() {
		return formatUndenfinedTokensOnly;
	}

	public ITypedPreferenceValues getPreferences() {
		return preferenceValues;
	}

	public FormatterProblemReporter getProblemHandler() {
		if (problemHandler == null)
			return new LoggingFormatterProblemHandler();
		return problemHandler;
	}

	public Collection<ITextRegion> getRegions() {
		return regions;
	}

	public ITextRegionAccess getTokens() {
		return tokens;
	}

	public FormatterRequest setAllowIdentityEdits(boolean allowIdentityEdits) {
		this.allowIdentityEdits = allowIdentityEdits;
		return this;
	}

	public FormatterRequest setFormatUndenfinedTokensOnly(boolean formatUndenfinedTokensOnly) {
		this.formatUndenfinedTokensOnly = formatUndenfinedTokensOnly;
		return this;
	}

	public FormatterRequest setPreferenceValues(ITypedPreferenceValues preferenceValues) {
		this.preferenceValues = preferenceValues;
		return this;
	}

	public FormatterRequest setProblemHandler(FormatterProblemReporter problemHandler) {
		this.problemHandler = problemHandler;
		return this;
	}

	public FormatterRequest setRegions(Collection<ITextRegion> regions) {
		this.regions = regions;
		return this;
	}

	public FormatterRequest setTokens(ITextRegionAccess tokens) {
		this.tokens = tokens;
		return this;
	}
}
