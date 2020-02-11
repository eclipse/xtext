/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;

import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * <p>
 * A request tells the formatter what and how to format.
 * </p>
 * 
 * <p>
 * When invoking the formatter, the request is passed into {@link IFormatter2#format(FormatterRequest)}.
 * </p>
 * 
 * <p>
 * A request carries information about:
 * <p>
 * <ul>
 * <li>The {@link #textRegionAccess} which allows to obtain the to-be-formatted semantic model with text regions.</li>
 * <li>{@link #preferences Preferences} with keys from e.g. {@link FormatterPreferenceKeys}.</li>
 * <li>{@link #regions} that describe how to restrict the text regions for which {@link ITextReplacement replacements}
 * are produced.</li>
 * <li>An option to {@link #allowIdentityEdits()} which will disable automated suppression of text replacements that do
 * not cause changes.</li>
 * <li>A setting for green-field formatting ({@link #formatUndefinedHiddenRegionsOnly}): only format regions that have
 * no whitespace information yet.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public class FormatterRequest {

	/**
	 * Restrict the formatter to produce {@link ITextReplacement replacements} inside the specified regions only. If no
	 * regions are specified, the whole document is formatted.
	 */
	private Collection<ITextRegion> regions = Lists.newArrayList();

	/**
	 * @see #regions
	 */
	public FormatterRequest addRegion(ITextRegion region) {
		this.regions.add(region);
		return this;
	}

	/**
	 * @see #regions
	 */
	public FormatterRequest setRegions(Collection<ITextRegion> regions) {
		this.regions = regions;
		return this;
	}

	/**
	 * @see #regions
	 */
	public Collection<ITextRegion> getRegions() {
		return regions;
	}

	/**
	 * The formatters uses {@link ITextRegionAccess} to obtain text regions for model elements.
	 */
	private ITextRegionAccess textRegionAccess;

	/**
	 * @see #textRegionAccess
	 */
	public ITextRegionAccess getTextRegionAccess() {
		return textRegionAccess;
	}

	/**
	 * Sets the {@link #textRegionAccess}. If the region has syntax errors and no explicit {@link ExceptionAcceptor} is
	 * configured yet, the {@link ExceptionAcceptor#IGNORING ignoring acceptor} will be configured.
	 */
	public FormatterRequest setTextRegionAccess(ITextRegionAccess tokens) {
		if (tokens.hasSyntaxError() && this.exceptionHandler == null)
			this.exceptionHandler = ExceptionAcceptor.IGNORING;
		this.textRegionAccess = tokens;
		return this;
	}

	/**
	 * Allow the formatter to produce {@link ITextReplacement replacements} that replace regions with text equal to the
	 * text of the region. Since these replacements do not cause text changes, one usually doens't want to have them in
	 * a production environment. However, they are useful to test if a formatter considers all significant regions, e.g.
	 * all {@link IHiddenRegion hidden regions}.
	 */
	private boolean allowIdentityEdits;

	/**
	 * @see #allowIdentityEdits
	 */
	public FormatterRequest setAllowIdentityEdits(boolean allowIdentityEdits) {
		this.allowIdentityEdits = allowIdentityEdits;
		return this;
	}

	/**
	 * @see #allowIdentityEdits
	 */
	public boolean allowIdentityEdits() {
		return allowIdentityEdits;
	}

	/**
	 * Values for the preference keys from {@link FormatterPreferenceKeys} and language-specific preferences.
	 */
	private ITypedPreferenceValues preferences;

	/**
	 * @see #preferences
	 */
	public FormatterRequest setPreferences(ITypedPreferenceValues preferenceValues) {
		this.preferences = preferenceValues;
		return this;
	}

	/**
	 * @see #preferences
	 */
	public ITypedPreferenceValues getPreferences() {
		if (preferences == null)
			preferences = new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap());
		return preferences;
	}

	/**
	 * {@link IHiddenRegion Hidden regions} are considered undefined when their whitespace/comments are unknown. This
	 * happens for regions that emerged between programmatically created (not parsed!) model elements.
	 * 
	 * Enable this options if, for example, you serialize a model after applying a quick fix, refactoring or have it
	 * edited in a graphical editor and you want to keep the whitespace-changes to a minimum.
	 */
	private boolean formatUndefinedHiddenRegionsOnly;

	/**
	 * @see #formatUndefinedHiddenRegionsOnly
	 */
	public boolean isFormatUndefinedHiddenRegionsOnly() {
		return formatUndefinedHiddenRegionsOnly;
	}

	/**
	 * @see #formatUndefinedHiddenRegionsOnly
	 */
	public FormatterRequest setFormatUndefinedHiddenRegionsOnly(boolean formatUndefinedHiddenRegionsOnly) {
		this.formatUndefinedHiddenRegionsOnly = formatUndefinedHiddenRegionsOnly;
		return this;
	}

	/**
	 * <p>
	 * Exceptions that occur during formatting are passed to this handler. The handler may choose to throw them, log
	 * them, or ignore them. Formatting continues, unless the handler throws an exception.
	 * </p>
	 * 
	 * <p>
	 * Logging exceptions and continuing formatting is the default behavior.
	 * </p>
	 * 
	 * <p>
	 * Throwing exceptions is useful in unit tests.
	 * </p>
	 * 
	 * <p>
	 * Ignoring exceptions is useful when formatting a document with syntax errors.
	 * </p>
	 * 
	 * <p>
	 * Defaults to the {@link ExceptionAcceptor#LOGGING Logging Acceptor}
	 * </p>
	 * 
	 * @see ExceptionAcceptor#LOGGING
	 * @see ExceptionAcceptor#THROWING
	 * @see ExceptionAcceptor#IGNORING
	 */
	private IAcceptor<Exception> exceptionHandler;

	/**
	 * @see #exceptionHandler
	 */
	public IAcceptor<Exception> getExceptionHandler() {
		if (exceptionHandler == null)
			return ExceptionAcceptor.LOGGING;
		return exceptionHandler;
	}
	
	public IAcceptor<Exception> getExplicitExceptionHandler() {
		return exceptionHandler;
	}

	/**
	 * @see #exceptionHandler
	 */
	public FormatterRequest setExceptionHandler(IAcceptor<Exception> problemHandler) {
		this.exceptionHandler = problemHandler;
		return this;
	}
	
	/**
	 * Enable creation of Java stack traces to diagnose conflicting formatting
	 * instructions.
	 * 
	 * This option is disabled for performance reasons. It is safe to leave it
	 * disabled, because in case a conflict happens, the formatter will
	 * automatically enable this flag and format again. The second pass of the
	 * formatter will then lead to the desired debug information.
	 **/
	private boolean enableDebugTracing = false;

	public boolean isEnableDebugTracing() {
		return enableDebugTracing;
	}

	public void setEnableDebugTracing(boolean enableDebugTracing) {
		this.enableDebugTracing = enableDebugTracing;
	}
}
