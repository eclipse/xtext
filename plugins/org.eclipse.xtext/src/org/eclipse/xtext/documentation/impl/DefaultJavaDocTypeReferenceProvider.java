/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Lists;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class DefaultJavaDocTypeReferenceProvider implements IJavaDocTypeReferenceProvider {

	public List<ReplaceRegion> computeTypeReferenceRegions(Resource resource) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		if (resource instanceof XtextResource) {
			IParseResult parseResult = ((XtextResource) resource).getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				for (INode node : rootNode.getAsTreeIterable()) {
					if (node.getGrammarElement() instanceof TerminalRule) {
						TerminalRule tRule = (TerminalRule) node.getGrammarElement();
						if (tRule.getName().equals("ML_COMMENT")) {
							regions.addAll(searchAndCreateReplaceRegion(node));
						}
					}
				}
			}
		}
		return regions;
	}

	protected List<ReplaceRegion> searchAndCreateReplaceRegion(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		for (ILeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			int offset = leafNode.getOffset();
			int link = text.indexOf("@link ");
			while (link != -1) {
				int beginIndex = link + 6;
				int endLink = text.indexOf("}", beginIndex);
				if (endLink != -1) {
					String simpleName = text.substring(beginIndex, endLink);
					ReplaceRegion region = new ReplaceRegion(offset + beginIndex, endLink - beginIndex, simpleName);
					regions.add(region);
				}
				link = text.indexOf("@link ", endLink);
			}
		}
		return regions;
	}
}
