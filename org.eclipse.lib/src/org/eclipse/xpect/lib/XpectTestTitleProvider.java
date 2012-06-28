package org.eclipse.xpect.lib;

import org.eclipse.xpect.xpect.XpectInvocation;
import org.eclipse.xpect.xpect.XpectPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class XpectTestTitleProvider implements IXpectTestTitleProvider {

	@Override
	public String getTitle(XpectTestRunner runner) {
		XpectInvocation invocation = runner.getInvocation();
		INode node = NodeModelUtils.findActualNodeFor(invocation);
		String document = node.getRootNode().getText();
		int lineStart = document.lastIndexOf("\n", node.getOffset());
		if (lineStart > 0) {
			String prefix = document.substring(lineStart + 1, node.getOffset());
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
		XpectFrameworkMethod method = runner.getMethod();
		if (method != null && method.getMethod() != null)
			return method.getMethod().getName();
		for (INode n : NodeModelUtils.findNodesForFeature(invocation, XpectPackage.Literals.XPECT_INVOCATION__ELEMENT))
			return NodeModelUtils.getTokenText(n);
		return "(error)";
	}

}
