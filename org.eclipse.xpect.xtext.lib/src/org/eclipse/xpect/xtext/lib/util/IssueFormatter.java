package org.eclipse.xpect.xtext.lib.util;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;

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