/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.util;

import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IssueFormatter implements Function<Issue, String> {

	private final CharSequence document;
	private final boolean showSeverity;

	public IssueFormatter(CharSequence document, boolean showSeverity) {
		super();
		this.document = document;
		this.showSeverity = showSeverity;
	}

	public String apply(Issue issue) {
		if (issue == null)
			return "null";
		StringBuffer result = new StringBuffer();
		if (showSeverity) {
			result.append(issue.getSeverity().name());
			result.append(" ");
		}
		result.append('"');
		result.append(issue.getMessage());
		result.append('"');
		result.append(" at \"");
		result.append(getIssueLocationText(issue));
		result.append("\"");
		return result.toString();
	}

	public CharSequence getDocument() {
		return document;
	}

	protected String getIssueLocationText(Issue issue) {
		Integer offset = issue.getOffset();
		Integer length = issue.getLength();
		if (offset == null)
			return "(offset is null)";
		if (length == null)
			return "(length is null)";
		String markertext = document.subSequence(offset, offset + length).toString();
		return markertext.replace('\n', ' ').replace('\r', ' ');
	}

	public boolean isShowSeverity() {
		return showSeverity;
	}

}