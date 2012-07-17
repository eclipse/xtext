package org.eclipse.xpect.runner;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.XpectPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class XpectTestTitleProvider implements IXpectTestTitleProvider {

	@Override
	public String getTitle(XpectTestRunner runner) {
		XpectInvocation invocation = runner.getInvocation();
		INode node = NodeModelUtils.findActualNodeFor(invocation);
		String document = node.getRootNode().getText();
		String title = findTitle(document, node.getOffset());
		if (title != null && title.startsWith("XPECT"))
			title = null;
		String method = findMethodName(runner);
		if (title != null && method != null)
			return method + ": " + title;
		if (title != null)
			return title;
		if (method != null)
			return method;
		return "(error)";
	}

	protected String findMethodName(XpectTestRunner runner) {
		XpectFrameworkMethod method = runner.getMethod();
		if (method != null && method.getMethod() != null)
			return method.getMethod().getName();
		for (INode n : NodeModelUtils.findNodesForFeature(runner.getInvocation(), XpectPackage.Literals.XPECT_INVOCATION__ELEMENT))
			return NodeModelUtils.getTokenText(n);
		return null;
	}

	protected String findTitle(String document, int offset) {
		int lineStart = document.lastIndexOf("\n", offset);
		if (lineStart > 0) {
			String prefix = document.substring(lineStart + 1, offset);
			String trimmedPrefix = prefix.trim();
			if (trimmedPrefix.length() > 0)
				for (int i = 0; i < trimmedPrefix.length(); i++) {
					char c = trimmedPrefix.charAt(i);
					if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
						return trimmedPrefix;
				}
			int prevLine = document.lastIndexOf("\n", lineStart - 1);
			if (prevLine >= 0) {
				String prevPrefix = document.substring(prevLine + 1, prevLine + 1 + prefix.length());
				if (prefix.equals(prevPrefix)) {
					String title = document.substring(prevLine + prefix.length(), lineStart).trim();
					if (title.length() > 0)
						return title;
				}
			}
		}
		return null;
	}

}
