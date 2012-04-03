/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
@Singleton
public class MultiLineCommentDocumentationProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {

	public final static String RULE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.ruleName";
	public final static String START_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.startTag";
	public final static String END_TAG = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.endTag";
	public final static String LINE_PREFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePrefix";
	public final static String LINE_POSTFIX = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.linePostfix";
	public final static String WHITESPACE = "org.eclipse.xtext.ui.editor.hover.MultiLineDocumentationProvider.whitespace";

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(RULE)
	protected String ruleName = "ML_COMMENT";

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(START_TAG)
	protected String startTag = "/\\*\\*?"; // regular expression

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(END_TAG)
	protected String endTag = "\\*/"; // regular expression

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(LINE_PREFIX)
	protected String linePrefix = "\\** ?"; // regular expression

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(LINE_POSTFIX)
	protected String linePostfix = "\\**"; // regular expression

	/**
	 * @since 2.3
	 */
	@Inject(optional = true)
	@Named(WHITESPACE)
	protected String whitespace = "( |\\t)*"; // regular expression
	
	protected String findComment(EObject o) {
		String returnValue = null;
		List<INode> documentationNodes = getDocumentationNodes(o);
		if (!documentationNodes.isEmpty()) {
			return documentationNodes.get(0).getText();
		}
		return returnValue;
	}
	
	/**
	 * Returns the nearest multi line comment node that precedes the given object.
	 * @since 2.3
	 * @return a list with exactly one node or an empty list if the object is undocumented.
	 */
	@NonNull
	public List<INode> getDocumentationNodes(@NonNull EObject object) {
		ICompositeNode node = NodeModelUtils.getNode(object);
		List<INode> result = Collections.emptyList();
		if (node != null) {
			// get the last multi line comment before a non hidden leaf node
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (!leafNode.isHidden())
					break;
				if (leafNode.getGrammarElement() instanceof TerminalRule
						&& ruleName.equalsIgnoreCase(((TerminalRule) leafNode.getGrammarElement()).getName())) {
					String comment = leafNode.getText();
					if (comment.matches("(?s)" + startTag + ".*")) {
						result = Collections.<INode>singletonList(leafNode);
					}
				}
			}
		}
		return result;
	}

	public String getDocumentation(EObject o) {
		String returnValue = findComment(o);
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
