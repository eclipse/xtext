/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The default implementation of the documentation provider for {@link EObject emf objects} based
 * on Xtext languages.
 * 
 * It uses a single ML_COMMENT token by default to return the contained text as the documentation.
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
@Singleton
public class MultiLineCommentDocumentationProvider extends AbstractMultiLineCommentProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {

	/**
	 * @since 2.5
	 */
	protected Pattern commentStartTagRegex;

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
	/* @NonNull */
	@Override
	public List<INode> getDocumentationNodes(/* @NonNull */ EObject object) {
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
					if (commentStartTagRegex.matcher(comment).matches()) {
						result = Collections.<INode>singletonList(leafNode);
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public String getDocumentation(EObject o) {
		String returnValue = findComment(o);
		return getTextFromMultilineComment(returnValue);
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	@Inject
	public void injectProperties(MultiLineCommentProviderProperties properties) {
		super.injectProperties(properties);
		this.commentStartTagRegex = Pattern.compile("(?s)" + startTag + ".*");
	}
}
