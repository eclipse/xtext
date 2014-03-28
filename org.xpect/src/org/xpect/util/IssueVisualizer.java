/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.util;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.validation.Issue;
import org.xpect.text.Text;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IssueVisualizer {
	protected String issueToString(Issue issue) {
		StringBuffer result = new StringBuffer();
		result.append(issue.getSeverity().toString().toLowerCase());
		result.append(" - ");
		result.append(new Text(issue.getMessage()).escapeNewLines());
		return result.toString();
	}

	public String visualize(String documentString, List<Issue> issues) {
		Text document = new Text(documentString);
		@SuppressWarnings("unchecked")
		List<Issue>[] mapped = new List[document.length()];
		List<Issue> unmapped = Lists.newArrayList();
		for (Issue issue : issues) {
			if (issue.getOffset() != null && issue.getLength() != null && issue.getOffset() >= 0 && issue.getOffset() < document.length() && issue.getLength() > 0) {
				int max = Math.min(issue.getOffset() + issue.getLength(), document.length());
				for (int i = issue.getOffset(); i < max; i++) {
					if (mapped[i] == null)
						mapped[i] = Lists.newArrayList(issue);
					else
						mapped[i].add(issue);
				}
			} else
				unmapped.add(issue);
		}
		StringBuffer result = new StringBuffer();
		for (Issue issue : unmapped) {
			if (result.length() > 0)
				result.append(document.getNL());
			result.append(issueToString(issue));
		}
		boolean first = true;
		int offset = 0;
		for (String line : document.splitIntoLines()) {
			if (first)
				first = false;
			else
				result.append(document.getNL());
			result.append(line);
			boolean lineHasIssue = false;
			for (int i = offset; i < offset + line.length(); i++)
				if (mapped[i] != null)
					lineHasIssue = true;
			if (lineHasIssue) {
				result.append(document.getNL());
				Set<Issue> lineIssues = Sets.newLinkedHashSet();
				for (int i = offset; i < offset + line.length(); i++)
					if (mapped[i] != null) {
						int mark = 0;
						lineIssues.addAll(mapped[i]);
						for (Issue issue : mapped[i])
							mark += 1 << Iterables.indexOf(lineIssues, Predicates.equalTo(issue));
						result.append(Integer.toHexString(mark));
					} else
						result.append(document.charAt(i) == '\t' ? "\t" : " ");
				for (Issue issue : lineIssues) {
					int id = 1 << Iterables.indexOf(lineIssues, Predicates.equalTo(issue));
					result.append(document.getNL());
					result.append(id);
					result.append(": ");
					result.append(issueToString(issue));
				}
			}
			offset += line.length() + document.currentLineEndLenght(offset);
		}
		return result.toString();
	}

}
