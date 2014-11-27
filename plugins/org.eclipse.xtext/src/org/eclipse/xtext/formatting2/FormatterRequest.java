/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;

import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A Request tells the formatter what and how to format.
 * 
 * When invoking the formatter, the request is passed into {@link IFormatter2#format(FormatterRequest)}.
 * 
 * @see #textRegionAccess - the to-be-formatted semantic model with text regions.
 * @see #preferences - provide for preferences key from e.g. {@link FormatterPreferenceKeys}.
 * @see #regions - restrict the text regions for which {@link ITextReplacement}s are produced.
 * @see #allowIdentityEdits - do not suppress text replacements that do not cause changes.
 * @see #formatUndenfinedTokensOnly - only format regions that have no whitespace information yet.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public class FormatterRequest {

	/**
	 * Restrict the formatter to produce {@link ITextReplacement}s inside the specified regions only. If no regions are
	 * specified, the whole document is formatted.
	 */
	private Collection<ITextRegion> regions = Lists.newArrayList();

	public FormatterRequest addRegion(ITextRegion region) {
		this.regions.add(region);
		return this;
	}

	public FormatterRequest setRegions(Collection<ITextRegion> regions) {
		this.regions = regions;
		return this;
	}

	public Collection<ITextRegion> getRegions() {
		return regions;
	}

	/**
	 * The formatters uses {@link ITextRegionAccess} to obtain text regions for model elements.
	 */
	private ITextRegionAccess textRegionAccess;

	public ITextRegionAccess getTextRegionAccess() {
		return textRegionAccess;
	}

	/**
	 * Sets the {@link #textRegionAccess}. If the region has syntax errors and no explicit
	 * {@link ExceptionAcceptor} is configured yet, the {@link ExceptionAcceptor#IGNORING ignoring acceptor}
	 * will be configured.
	 */
	public FormatterRequest setTextRegionAccess(ITextRegionAccess tokens) {
		if (tokens.hasSyntaxError() && this.exceptionHandler == null)
			this.exceptionHandler = ExceptionAcceptor.IGNORING;
		this.textRegionAccess = tokens;
		return this;
	}

	/**
	 * Allow the formatter to produce {@link ITextReplacement}s that replace regions with text equal to the text of the
	 * region. Since these TextReplacements do not cause text changes, one usually doens't want to have them in a
	 * production environment. However, they are useful to test if a formatter considers all significant regions, e.g.
	 * all {@link IHiddenRegion}s.
	 */
	private boolean allowIdentityEdits;

	public FormatterRequest setAllowIdentityEdits(boolean allowIdentityEdits) {
		this.allowIdentityEdits = allowIdentityEdits;
		return this;
	}

	public boolean allowIdentityEdits() {
		return allowIdentityEdits;
	}

	/**
	 * Values for the preference keys from {@link FormatterPreferenceKeys} and language-specific preferences.
	 */
	private ITypedPreferenceValues preferences;

	public FormatterRequest setPreferences(ITypedPreferenceValues preferenceValues) {
		this.preferences = preferenceValues;
		return this;
	}

	public ITypedPreferenceValues getPreferences() {
		if (preferences == null)
			preferences = new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap());
		return preferences;
	}

	/**
	 * {@link IHiddenRegion}s are considers undefined when their whitespace/comments are unknown. This happens for
	 * HiddenRegions that emerged between programmatically created (not parsed!) model elements.
	 * 
	 * Enable this options if, for example, you serialize a model after applying a quick fix, refactoring or have it
	 * edited in a graphical editor and you want to keep the whitespace-changes to a minimum.
	 */
	public boolean isFormatUndefinedHiddenRegionsOnly() {
		return formatUndenfinedTokensOnly;
	}

	private boolean formatUndenfinedTokensOnly;

	public FormatterRequest setFormatUndenfinedTokensOnly(boolean formatUndenfinedTokensOnly) {
		this.formatUndenfinedTokensOnly = formatUndenfinedTokensOnly;
		return this;
	}

	/**
	 * Exceptions that occur during formatting are passed to this handler. The handler may choose to throw them, log
	 * them, or ignore them. Formatting continues, unless the handler throws an exception.
	 * 
	 * Logging exceptions and continuing formatting is the default behavior.
	 * 
	 * Throwing exceptions is useful in unit tests.
	 * 
	 * Ignoring exceptions is useful when formatting a document with syntax errors.
	 * 
	 * Defaults to the {@link ExceptionAcceptor#LOGGING Logging Acceptor}
	 * 
	 * @see ExceptionAcceptor#LOGGING
	 * @see ExceptionAcceptor#THROWING
	 * @see ExceptionAcceptor#IGNORING
	 */
	private IAcceptor<Exception> exceptionHandler;

	public IAcceptor<Exception> getExceptionHandler() {
		if (exceptionHandler == null)
			return ExceptionAcceptor.LOGGING;
		return exceptionHandler;
	}

	public FormatterRequest setExceptionHandler(IAcceptor<Exception> problemHandler) {
		this.exceptionHandler = problemHandler;
		return this;
	}
}
