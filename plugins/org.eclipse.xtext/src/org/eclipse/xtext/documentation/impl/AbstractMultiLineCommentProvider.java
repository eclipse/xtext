/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class AbstractMultiLineCommentProvider {
	
	public final static String RULE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.ruleName";
	public final static String WS_RULE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.ruleName";
	public final static String START_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.startTag";
	public final static String END_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.endTag";
	public final static String LINE_PREFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePrefix";
	public final static String LINE_POSTFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePostfix";
	public final static String WHITESPACE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.whitespace";

	@Inject(optional = true)
	@Named(RULE)
	protected String ruleName = "ML_COMMENT";

	@Inject(optional = true)
	@Named(WS_RULE)
	protected String wsRuleName = "WS";

	@Inject(optional = true)
	@Named(START_TAG)
	protected String startTag = "/\\*\\*?"; // regular expression

	@Inject(optional = true)
	@Named(END_TAG)
	protected String endTag = "\\*/"; // regular expression

	@Inject(optional = true)
	@Named(LINE_PREFIX)
	protected String linePrefix = "\\** ?"; // regular expression

	@Inject(optional = true)
	@Named(LINE_POSTFIX)
	protected String linePostfix = "\\**"; // regular expression

	@Inject(optional = true)
	@Named(WHITESPACE)
	protected String whitespace = "( |\\t)*"; // regular expression
	
	protected String getTextFromMultilineComment(String returnValue) {
		if (returnValue != null) {
			returnValue = returnValue.replaceAll("\\A" + startTag, "");
			returnValue = returnValue.replaceAll(endTag + "\\z", "");
			returnValue = returnValue.replaceAll("(?m)^"+ whitespace + linePrefix, "");
			returnValue = returnValue.replaceAll("(?m)" + whitespace + linePostfix + whitespace + "$", "");
			return returnValue.trim();
		} else
			return null;
	}

}
