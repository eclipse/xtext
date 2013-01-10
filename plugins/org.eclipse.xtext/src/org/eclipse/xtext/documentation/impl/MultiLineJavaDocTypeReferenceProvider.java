/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.List;

import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Lists;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 * @since 2.4
 */
public class MultiLineJavaDocTypeReferenceProvider implements IJavaDocTypeReferenceProvider {

	public List<ReplaceRegion> computeTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, "@link ", "}", "#");
		computeRegions(regions, leafNodes, "@see ", " " , "#");
		return regions;
	}

	public List<ReplaceRegion> computeParameterTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, "@param ", " ", "-");
		return regions;
	}

	protected void computeRegions(List<ReplaceRegion> regions, Iterable<ILeafNode> leafNodes, String start, String end, String optionalEnd) {
		for (ILeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			int offset = leafNode.getOffset();
			int position = text.indexOf(start);
			while (position != -1) {
				int beginIndex = position + start.length();
				int endLink = text.indexOf(optionalEnd, beginIndex);
				if(endLink == -1)
					endLink = text.indexOf(end, beginIndex);
				if (endLink == -1) { 
					break;
				} else {
					String simpleName = text.substring(beginIndex, endLink).trim();
					ReplaceRegion region = new ReplaceRegion(offset + beginIndex, simpleName.length(), simpleName);
					regions.add(region);
				} 
				position = text.indexOf(start, endLink);
			}
		}
	}
}
