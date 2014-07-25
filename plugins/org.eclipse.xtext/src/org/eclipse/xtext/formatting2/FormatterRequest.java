/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;

/**
 * A Request tells the formatter what and how to format. Don't implement or extend this interface. Use
 * {@link FormatterRequest} instead.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterRequest {
	private boolean allowIdentityEdits;
	private boolean formatUndenfinedTokensOnly;
	private ITypedPreferenceValues preferenceValues;
	private IAcceptor<Exception> problemHandler;
	private Collection<ITextRegion> regions = Lists.newArrayList();
	private ITextRegionAccess tokens;

	public FormatterRequest addRegion(ITextRegion region) {
		this.regions.add(region);
		return this;
	}

	/**
	 * Allow the formatter to produce {@link ITextReplacement}s that replace regions with text equal to the text of the
	 * region. Since these TextReplacements don't change anything, one usually doens't want to have them in a production
	 * environment. However, they're useful to test of a formatter considers all significant regions, e.g. all
	 * HiddenRegions.
	 */
	public boolean allowIdentityEdits() {
		return allowIdentityEdits;
	}

	/**
	 * HiddenRegions are considers undefined when their whitespace/comments are unknown. This happens for HiddenRegions
	 * that emerged between programmatically created (not parsed!) model elements.
	 */
	public boolean formatUndefinedHiddenRegionsOnly() {
		return formatUndenfinedTokensOnly;
	}

	public ITypedPreferenceValues getPreferences() {
		return preferenceValues;
	}

	public IAcceptor<Exception> getProblemHandler() {
		if (problemHandler == null)
			return ExceptionAcceptor.LOGGING;
		return problemHandler;
	}

	/**
	 * The regions for which the formatter should produce {@link ITextReplacement}s.
	 */
	public Collection<ITextRegion> getRegions() {
		return regions;
	}

	/**
	 * The formatter uses {@link ITextRegionAccess } to map model elements and values to text regions.
	 */
	public ITextRegionAccess getTextRegionAccess() {
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

	public FormatterRequest setProblemHandler(IAcceptor<Exception> problemHandler) {
		this.problemHandler = problemHandler;
		return this;
	}

	public FormatterRequest setRegions(Collection<ITextRegion> regions) {
		this.regions = regions;
		return this;
	}

	public FormatterRequest setTokens(ITextRegionAccess tokens) {
		if (tokens.hasSyntaxError() && this.problemHandler == null)
			this.problemHandler = ExceptionAcceptor.NULL;
		this.tokens = tokens;
		return this;
	}
}
