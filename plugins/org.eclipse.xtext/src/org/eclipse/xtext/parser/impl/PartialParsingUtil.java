/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PartialParsingUtil {

	private static final Logger log = Logger.getLogger(PartialParsingUtil.class);

	@SuppressWarnings("unchecked")
	public static IParseResult reparse(IParser parser, CompositeNode rootNode, int offset, int replacedTextLength,
			String newText) {
		if (offset + replacedTextLength > rootNode.getLength()) {
			log.error("Invalid replace region offset=" + offset + " length=" + replacedTextLength + " originalLength="
					+ rootNode.getLength());
			return fullyReparse(parser, rootNode, offset, replacedTextLength, newText);
		}
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(rootNode, offset, replacedTextLength);
		List<CompositeNode> validReplaceRootNodes = parsingPointers.getValidReplaceRootNodes();
		CompositeNode replaceNode = null;
		String reparseRegion = "";
		for (int i = validReplaceRootNodes.size() - 1; i >= 0; --i) {
			replaceNode = validReplaceRootNodes.get(i);
			reparseRegion = insertChangeIntoReplaceRegion(replaceNode, offset, replacedTextLength, newText);
			if (!"".equals(reparseRegion)) {
				break;
			}
		}
		if (replaceNode == null || reparseRegion.equals("")) {
			// no replaceNode -> no rule to call
			// If region is empty, any entryRule is likely to fail.
			// Let parser decide whether empty model is valid
			return parser.parse(new StringInputStream(""));
		}
		String entryRuleName = parsingPointers.findEntryRuleName(replaceNode);
		ParseResult parseResult = null;
		try {
			parseResult = (ParseResult) ((AbstractParser) parser).parse(entryRuleName, new StringInputStream(
					reparseRegion));
		}
		catch (ParseException exc) {
		}
		if (parseResult == null || parseResult.getParseErrors() != null && !parseResult.getParseErrors().isEmpty()) {
			// on error fully reparse
			return fullyReparse(parser, rootNode, offset, replacedTextLength, newText);
		}
		EObject astParentElement = parsingPointers.findASTParentElement(replaceNode);
		EObject replaceAstElement = parsingPointers.findASTReplaceElement(replaceNode);
		if (astParentElement != null) {
			String featureName = parsingPointers.findASTContainmentFeatureName(replaceNode);
			EClass astParentEClass = astParentElement.eClass();
			EStructuralFeature feature = astParentEClass.getEStructuralFeature(featureName);
			if (feature.isMany()) {
				List featureValueList = (List) astParentElement.eGet(feature);
				int astElementChildIndex = featureValueList.indexOf(replaceAstElement);
				featureValueList.set(astElementChildIndex, parseResult.getRootASTElement());
			}
			else {
				astParentElement.eSet(feature, parseResult.getRootASTElement());
			}
			parseResult.setRootASTElement(NodeUtil.getASTElementForRootNode(rootNode));
		}
		if (replaceNode != rootNode) {
			CompositeNode replaceNodeParent = replaceNode.getParent();
			EList<AbstractNode> replaceNodeSiblings = replaceNodeParent.getChildren();
			int nodeChildIndex = replaceNodeSiblings.indexOf(replaceNode);
			replaceNodeSiblings.set(nodeChildIndex, parseResult.getRootNode());
			parseResult.setRootNode(rootNode);
		}
		return parseResult;
	}

	private static IParseResult fullyReparse(IParser parser, CompositeNode rootNode, int offset,
			int replacedTextLength, String newText) {
		String reparseRegion;
		reparseRegion = insertChangeIntoReplaceRegion(rootNode, offset, replacedTextLength, newText);
		return parser.parse(new StringInputStream(reparseRegion));
	}

	/**
	 * @param replaceRootNode
	 * @param offset
	 * @param replacedTextLength
	 */
	public static String insertChangeIntoReplaceRegion(CompositeNode replaceRootNode, int offset,
			int replacedTextLength, String newText) {
		String originalRegion = replaceRootNode.serialize();
		int changeOffset = offset - replaceRootNode.getOffset();
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(newText);
		// TODO: rausragende region
		reparseRegion.append(originalRegion.substring(changeOffset + replacedTextLength));
		return reparseRegion.toString();
	}

	public static PartialParsingPointers calculatePartialParsingPointers(CompositeNode rootNode, int offset,
			int replacedTextLength) {
		if (offset == rootNode.getLength() && offset != 0) {
			// newText is appended, so look for the last original character instead 
			--offset;
			replacedTextLength = 1;
		}
		List<CompositeNode> nodesEnclosingRegion = collectNodesEnclosingChangeRegion(rootNode, offset,
				replacedTextLength);
		List<CompositeNode> validReplaceRootNodes = internalFindValidReplaceRootNodeForChangeRegion(
				nodesEnclosingRegion, offset, replacedTextLength);
		if (validReplaceRootNodes.isEmpty()) {
			validReplaceRootNodes = Collections.<CompositeNode> singletonList(rootNode);
		}
		return new PartialParsingPointers(rootNode, offset, replacedTextLength, validReplaceRootNodes,
				nodesEnclosingRegion);
	}

	/**
	 * Collects a list of all nodes containing the change region
	 */
	private static List<CompositeNode> collectNodesEnclosingChangeRegion(CompositeNode parent, int offset, int length) {
		List<CompositeNode> nodesEnclosingRegion = new ArrayList<CompositeNode>();
		if (nodeEnclosesRegion(parent, offset, length)) {
			collectNodesEnclosingChangeRegion(parent, offset, length, nodesEnclosingRegion);
		}
		return nodesEnclosingRegion;
	}

	private static void collectNodesEnclosingChangeRegion(CompositeNode parent, int offset, int length,
			List<CompositeNode> nodesEnclosingRegion) {
		nodesEnclosingRegion.add(parent);
		EList<AbstractNode> children = parent.getChildren();
		// Hack: iterate children backward, so we evaluate the node.length()
		// function less often
		for (int i = children.size() - 1; i >= 0; --i) {
			AbstractNode child = children.get(i);
			if (child instanceof CompositeNode) {
				CompositeNode childCompositeNode = (CompositeNode) child;
				if (nodeEnclosesRegion(childCompositeNode, offset, length)) {
					collectNodesEnclosingChangeRegion(childCompositeNode, offset, length, nodesEnclosingRegion);
					break;
				}
			}
		}
	}

	private static boolean nodeEnclosesRegion(CompositeNode node, int offset, int length) {
		return node.getOffset() <= offset && node.getOffset() + node.getLength() >= offset + length;
	}

	/**
	 * Investigates the composite nodes containing the changed region and
	 * collects a list of nodes which could possibly replaced by a partial
	 * parse. Such a node has a parent that consumes all his current lookahead
	 * tokens and all of these tokens are located before the changed region.
	 * 
	 * @param nodesEnclosingRegion
	 * @param offset
	 * @param length
	 * @return
	 */
	private static List<CompositeNode> internalFindValidReplaceRootNodeForChangeRegion(
			List<CompositeNode> nodesEnclosingRegion, int offset, int length) {
		List<LeafNode> lookaheadNodes = new ArrayList<LeafNode>();
		List<CompositeNode> validReplaceRootNodes = new ArrayList<CompositeNode>();

		boolean lookaheadChanged = false;
		for (CompositeNode node : nodesEnclosingRegion) {
			EList<LeafNode> parentsLookaheadNodes = node.getLookaheadLeafNodes();
			if (!parentsLookaheadNodes.isEmpty()) {
				int index = lookaheadNodes.indexOf(parentsLookaheadNodes.get(0));
				if (index > 0) {
					// remove lookahead nodes common with grandpa
					while (lookaheadNodes.size() > index) {
						lookaheadNodes.remove(index);
					}
				}
				lookaheadNodes.addAll(parentsLookaheadNodes);
				lookaheadChanged = true;
			}
			if (lookaheadChanged) {
				LeafNode lastLookaheadLeafNode = lookaheadNodes.get(lookaheadNodes.size() - 1);
				if (nodeIsBeforeRegion(lastLookaheadLeafNode, offset)) {
					// last lookahead token is before changed region
					// and parent has consumed all current lookahead tokens
					NodeUtil.dumpCompositeNodeInfo("Possible entry node: ", node);
					validReplaceRootNodes.add(node);
					lookaheadChanged = false;
				}
			}
		}
		return validReplaceRootNodes;
	}

	private static boolean nodeIsBeforeRegion(LeafNode node, int offset) {
		return node.getOffset() + node.getLength() <= offset;
	}

}