/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.regex.Pattern;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class AbstractMultiLineCommentProvider {

	public final static String RULE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.ruleName";
	public final static String WS_RULE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.wsRuleName";
	public final static String START_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.startTag";
	public final static String END_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.endTag";
	public final static String LINE_PREFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePrefix";
	public final static String LINE_POSTFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePostfix";
	public final static String WHITESPACE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.whitespace";

	/**
	 * @since 2.5
	 */
	protected static class MultiLineCommentProviderProperties {

		@Inject(optional = true)
		@Named(START_TAG)
		protected String startTag; // regular expression

		@Inject(optional = true)
		@Named(END_TAG)
		protected String endTag; // regular expression

		@Inject(optional = true)
		@Named(LINE_PREFIX)
		protected String linePrefix; // regular expression

		@Inject(optional = true)
		@Named(LINE_POSTFIX)
		protected String linePostfix; // regular expression

		@Inject(optional = true)
		@Named(WHITESPACE)
		protected String whitespace; // regular expression

	}

	@Inject(optional = true)
	@Named(RULE)
	protected String ruleName = "ML_COMMENT";

	@Inject(optional = true)
	@Named(WS_RULE)
	protected String wsRuleName = "WS";

	protected String startTag = "/\\*\\*?"; // regular expression

	protected String endTag = "\\*/"; // regular expression

	protected String linePrefix = "\\** ?"; // regular expression

	protected String linePostfix = "\\**"; // regular expression

	protected String whitespace = "( |\\t)*"; // regular expression

	/**
	 * @since 2.5
	 */
	protected Pattern startTagRegex;

	/**
	 * @since 2.5
	 */
	protected Pattern endTagRegex;

	/**
	 * @since 2.5
	 */
	protected Pattern linePrefixRegex;

	/**
	 * @since 2.5
	 */
	protected Pattern linePostfixRegex;
	
	/**
	 * @since 2.5
	 */
	protected Pattern tagsAndPrefixRegex;

	protected String getTextFromMultilineComment(String returnValue) {
		if (returnValue != null) {
			returnValue = startTagRegex.matcher(returnValue).replaceAll("");
			returnValue = endTagRegex.matcher(returnValue).replaceAll("");
			returnValue = linePrefixRegex.matcher(returnValue).replaceAll("");
			returnValue = linePostfixRegex.matcher(returnValue).replaceAll("");
			return returnValue.trim();
		} else
			return null;
	}

	/**
	 * @since 2.5
	 */
	@Inject
	public void injectProperties(MultiLineCommentProviderProperties properties) {
		this.startTag = properties.startTag != null ? properties.startTag : this.startTag;
		this.endTag = properties.endTag != null ? properties.endTag : this.endTag;
		this.linePrefix = properties.linePrefix != null ? properties.linePrefix : this.linePrefix;
		this.linePostfix = properties.linePostfix != null ? properties.linePostfix : this.linePostfix;
		this.whitespace = properties.whitespace != null ? properties.whitespace : this.whitespace;
		this.startTagRegex = Pattern.compile("\\A" + startTag);
		this.endTagRegex = Pattern.compile(endTag + "\\z");
		this.linePrefixRegex = Pattern.compile("(?m)^" + whitespace + linePrefix);
		this.linePostfixRegex = Pattern.compile("(?m)" + whitespace + linePostfix + whitespace + "$");
	}

}
