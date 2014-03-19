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

	//TODO this does not work when opening a Unix-delimited file on a Windows machine
	protected String lineDelimiter = System.getProperty("line.separator");

	public List<ReplaceRegion> computeTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, LINK_TAG_WITH_SUFFIX, "#", " ", "}");
		computeRegions(regions, leafNodes, SEE_TAG_WITH_SUFFIX, "#" , " ", lineDelimiter);
		return regions;
	}

	public List<ReplaceRegion> computeParameterTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, "@param ", " ", "-", lineDelimiter);
		return regions;
	}

	/**
	 * Computes regions between a given string to search and different ends searched by their precedence
	 *
	 * @param regions - List to put new regions in
	 * @param leafNodes - nodes to search in
	 * @param toSearch - String to search
	 * @param end - end with highest precedence
	 * @param optionalEnd - end with lower precedence
	 * @param optionalEnd2 - end with lowest precedence
	 */
	protected void computeRegions(List<ReplaceRegion> regions, Iterable<ILeafNode> leafNodes, String toSearch, String end, String optionalEnd, String optionalEnd2) {
		for (ILeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			int offset = leafNode.getOffset();
			int position = text.indexOf(toSearch);
			int textLength = text.length();
			while (position != -1) {
				int beginIndex = position + toSearch.length();
				// Skip leading whitespaces
				if(Character.isWhitespace(text.charAt(beginIndex))){
					while(beginIndex < textLength && Character.isWhitespace(text.charAt(beginIndex))){
						beginIndex ++;
					}
				}
				int endLink = -1;
				if(end != null && endLink == -1)
					endLink = text.indexOf(end, beginIndex);
				if(optionalEnd != null && endLink == -1)
					endLink = text.indexOf(optionalEnd, beginIndex);
				if(optionalEnd2 != null){
					int lastEndLink = text.indexOf(optionalEnd2, beginIndex);
					if(lastEndLink != -1) {
						if(endLink != -1){
							if(endLink > lastEndLink)
								endLink = lastEndLink;
						} else {
							endLink = lastEndLink;
						}
					}
				}
				if (endLink == -1) { 
					break;
				} else {
					String simpleName = text.substring(beginIndex, endLink).replaceAll(" ", "");
					if(simpleName.length() > 0 && simpleName.matches("[0-9a-zA-Z\\.\\$_]*")){
						ReplaceRegion region = new ReplaceRegion(offset + beginIndex, simpleName.length(), simpleName);
						regions.add(region);
					}
				} 
				position = text.indexOf(toSearch, endLink);
			}
		}
	}
}
