/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.Collection;

import org.eclipse.xtext.formatter.IFormatter.ProblemHandler;
import org.eclipse.xtext.formatter.IFormatter.Request;
import org.eclipse.xtext.formatter.ITokenAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterRequest implements Request {
	private boolean allowIdentityEdits;
	private boolean formatUndenfinedTokensOnly;
	private ITypedPreferenceValues preferenceValues;
	private ProblemHandler problemHandler;
	private Collection<ITextRegion> regions = Lists.newArrayList();
	private ITokenAccess tokens;

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

	public ProblemHandler getProblemHandler() {
		if (problemHandler == null)
			return new LoggingFormatterProblemHandler();
		return problemHandler;
	}

	public Collection<ITextRegion> getRegions() {
		return regions;
	}

	public ITokenAccess getTokens() {
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

	public FormatterRequest setProblemHandler(ProblemHandler problemHandler) {
		this.problemHandler = problemHandler;
		return this;
	}

	public FormatterRequest setRegions(Collection<ITextRegion> regions) {
		this.regions = regions;
		return this;
	}

	public FormatterRequest setTokens(ITokenAccess tokens) {
		this.tokens = tokens;
		return this;
	}
}
