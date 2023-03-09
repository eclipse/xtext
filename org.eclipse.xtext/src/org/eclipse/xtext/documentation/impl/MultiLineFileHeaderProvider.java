/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@Singleton
public class MultiLineFileHeaderProvider extends AbstractMultiLineCommentProvider implements IFileHeaderProvider {

	protected String findFileHeader(Resource resource) {
		String returnValue = null;
		List<INode> fileHeaderNodes = getFileHeaderNodes(resource);
		if (!fileHeaderNodes.isEmpty()) {
			return fileHeaderNodes.get(0).getText();
		}
		return returnValue;
	}
	
	/**
	 * Returns the first non-whitespace leaf node in the file if it is a multi-line comment node.
	 * 
	 * @since 2.3
	 * @return a list with exactly one node or an empty list if there is no header is undocumented.
	 */
	/* @NonNull */
	@Override
	public List<INode> getFileHeaderNodes(Resource resource) {
		if (resource instanceof XtextResource) {
			IParseResult parseResult = ((XtextResource) resource).getParseResult();
			if(parseResult != null) {
				for(ILeafNode leafNode: parseResult.getRootNode().getLeafNodes()) {
					EObject grammarElement = leafNode.getGrammarElement();
					if(grammarElement instanceof TerminalRule) {
						String terminalRuleName = ((TerminalRule) grammarElement).getName();
						if (ruleName.equalsIgnoreCase(terminalRuleName)) {
							return singletonList((INode) leafNode);
						} else if(wsRuleName.equals(terminalRuleName)) {
							continue;
						}
					}
					break;
				}
			}
		}
		return Collections.emptyList();
	}

	@Override
	public String getFileHeader(Resource resource) {
		String returnValue = findFileHeader(resource);
		return getTextFromMultilineComment(returnValue);
	}
}
