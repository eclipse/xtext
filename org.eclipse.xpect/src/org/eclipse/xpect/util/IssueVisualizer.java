package org.eclipse.xpect.util;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class IssueVisualizer {
	protected String issueToString(Issue issue) {
		StringBuffer result = new StringBuffer();
		result.append(issue.getSeverity().toString().toLowerCase());
		result.append(" - ");
		result.append(issue.getMessage().replace("\n", "\\n"));
		return result.toString();
	}

	/**
	 * ... because string.split() ignores trailing whitespace (wtf!)
	 */
	protected List<String> splitIntoLines(String document) {
		List<String> result = Lists.newArrayList();
		int index, lastIndex = 0;
		while ((index = document.indexOf('\n', lastIndex)) >= 0) {
			result.add(document.substring(lastIndex, index));
			lastIndex = index + 1;
		}
		result.add(document.substring(lastIndex, document.length()));
		return result;
	}

	public String visualize(String document, List<Issue> issues) {
		@SuppressWarnings("unchecked")
		List<Issue>[] mapped = new List[document.length()];
		List<Issue> unmapped = Lists.newArrayList();
		for (Issue issue : issues) {
			if (issue.getOffset() >= 0 && issue.getOffset() < document.length() && issue.getLength() > 0) {
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
				result.append("\n");
			result.append(issueToString(issue));
		}
		boolean first = true;
		int offset = 0;
		for (String line : splitIntoLines(document)) {
			if (first)
				first = false;
			else
				result.append("\n");
			result.append(line);
			boolean lineHasIssue = false;
			for (int i = offset; i < offset + line.length(); i++)
				if (mapped[i] != null)
					lineHasIssue = true;
			if (lineHasIssue) {
				result.append("\n");
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
					result.append("\n");
					result.append(id);
					result.append(": ");
					result.append(issueToString(issue));
				}
			}
			offset += line.length() + 1;
		}
		return result.toString();
	}

}
