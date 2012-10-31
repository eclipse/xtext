/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.util;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IssueFormatter implements Function<Object, String> {

	private final XtextResource resource;
	private final boolean showSeverity;

	public IssueFormatter(XtextResource resource, boolean showSeverity) {
		super();
		this.resource = resource;
		this.showSeverity = showSeverity;
	}

	@Override
	public String apply(Object input) {
		if (input instanceof Issue) {
			Issue issue = (Issue) input;
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
		} else if (input == null)
			return "null";
		return input.getClass() + ": " + input.toString();
	}

	protected String getIssueLocationText(Issue issue) {
		String text = resource.getParseResult().getRootNode().getText();
		String markertext = text.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
		return markertext.replace('\n', ' ').replace('\r', ' ');
	}

	public XtextResource getResource() {
		return resource;
	}

	public boolean isShowSeverity() {
		return showSeverity;
	}

}