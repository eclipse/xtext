package org.xpect.parameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.runner.XpectTestRunner;
import org.xpect.util.IRegion;
import org.xpect.util.Region;

public class AbstractExpectationParser {
	private Pattern pattern = Pattern.compile("((---)|(-->)|(\n))");

	public IRegion claimRegion(XpectTestRunner invocation, int paramIndex) {
		INode node = NodeModelUtils.getNode(invocation.getInvocation());
		String document = node.getRootNode().getText();
		Matcher matcher = pattern.matcher(document);
		if (matcher.find(node.getOffset() + node.getLength())) {
			int end = -1;
			int start = -1;
			if (matcher.group().equals("---")) {
				start = document.indexOf("\n", matcher.end()) + 1;
				end = document.indexOf("---", matcher.end());
				end = document.lastIndexOf("\n", end);
			} else if (matcher.group().equals("-->")) {
				start = matcher.end();
				if (Character.isWhitespace(document.charAt(start)))
					start++;
				end = document.indexOf("\n", matcher.end());
			}
			if (start >= 0) {
				if (end <= 0)
					end = document.length();
				return new Region(start, end - start);
			}
		}
		return null;
	}

}
