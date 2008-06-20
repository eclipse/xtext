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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
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

	@SuppressWarnings("unchecked")
	public static IParseResult partiallyReparse(IParser parser, CompositeNode rootNode, int originalOffset,
			int originalLength, String changedRegion) {
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(rootNode, originalOffset,
				originalLength);
		List<CompositeNode> validReplaceRootNodes = parsingPointers.getValidReplaceRootNodes();
		CompositeNode replaceNode = null;
		String reparseRegion ="";
		for(int i=validReplaceRootNodes.size()-1; i>=0; --i) {
			replaceNode = validReplaceRootNodes.get(i);
			reparseRegion = insertChangeIntoReplaceRegion(replaceNode, originalOffset, originalLength, changedRegion);
			if(!"".equals(reparseRegion)) {
				break;
			}
		}
		if(replaceNode == null || reparseRegion.equals("")) {
			// no replaceNode -> no rule to call
			// If region is empty, any entryRule is likely to fail.
			// Let parser decide whether empty model is valid
			return parser.parse(new StringInputStream(""));
		}
		String entryRuleName = parsingPointers.findEntryRuleName(replaceNode);
		ParseResult parseResult = (ParseResult) parser.parse(entryRuleName, new StringInputStream(reparseRegion));
		if (replaceNode != rootNode) {
			CompositeNode replaceNodeParent = replaceNode.getParent();
			EList<AbstractNode> replaceNodeSiblings = replaceNodeParent.getChildren();
			int nodeChildIndex = replaceNodeSiblings.indexOf(replaceNode);
			replaceNodeSiblings.set(nodeChildIndex, parseResult.getRootNode());
			parseResult.setRootNode(rootNode);
		}
		EObject replaceAstElement = parsingPointers.findASTReplaceElement(replaceNode);
		EObject astParentElement = parsingPointers.findASTParentElement(replaceNode);
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
			parseResult.setRootASTElement(NodeUtil.getASTElementForRootNode(parseResult.getRootNode()));
		}
		return parseResult;
	}

	/**
	 * @param replaceRootNode
	 * @param originalOffset
	 * @param originalLength
	 */
	public static String insertChangeIntoReplaceRegion(CompositeNode replaceRootNode, int originalOffset,
			int originalLength, String changedRegion) {
		String originalRegion = replaceRootNode.serialize();
		int changeOffset = originalOffset - replaceRootNode.offset();
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(changedRegion);
		reparseRegion.append(originalRegion.substring(changeOffset + originalLength));
		return reparseRegion.toString();
	}

	public static PartialParsingPointers calculatePartialParsingPointers(CompositeNode rootNode, int offset, int length) {
		List<CompositeNode> nodesEnclosingRegion = new ArrayList<CompositeNode>();
		collectNodesEnclosingChangeRegion(rootNode, offset, length, nodesEnclosingRegion);

		List<CompositeNode> validReplaceRootNodes = internalFindValidReplaceRootNodeForChangeRegion(
				nodesEnclosingRegion, offset, length);
		if (validReplaceRootNodes.isEmpty()) {
			validReplaceRootNodes = Collections.<CompositeNode> singletonList(rootNode);
		}
		return new PartialParsingPointers(rootNode, offset, length, validReplaceRootNodes, nodesEnclosingRegion);
	}

	/**
	 * Collects a list of all nodes containing the change region
	 */
	private static void collectNodesEnclosingChangeRegion(CompositeNode parent, int offset, int length,
			List<CompositeNode> nodesEnclosingRegion) {
		nodesEnclosingRegion.add(parent);
		for (AbstractNode child : parent.getChildren()) {
			if (child instanceof CompositeNode) {
				CompositeNode childCompositeNode = (CompositeNode) child;
				if (nodeEnclosesRegion(childCompositeNode, offset, length)) {
					collectNodesEnclosingChangeRegion(childCompositeNode, offset, length, nodesEnclosingRegion);
				}
			}
		}
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
		int numConsumedLookaheadTokens = 0;
		List<CompositeNode> validReplaceRootNodes = new ArrayList<CompositeNode>();

		for (CompositeNode node : nodesEnclosingRegion) {
			List<LeafNode> parentsLookaheadNodes = getParentsLookaheadNodes(node);
			if (!parentsLookaheadNodes.isEmpty()) {
				int index = lookaheadNodes.indexOf(parentsLookaheadNodes.get(0));
				if (index >= 0) {
					// remove lookahead nodes common with grandpa
					while (lookaheadNodes.size() > index) {
						lookaheadNodes.remove(index);
					}
				}
				lookaheadNodes.addAll(parentsLookaheadNodes);
			}
			if (node.getLookaheadConsumed() > 0) {
				// parent has consumed lookahead tokens.
				numConsumedLookaheadTokens += node.getLookaheadConsumed();
				if (numConsumedLookaheadTokens == lookaheadNodes.size()) {
					// parent has consumed all current lookahead tokens
					LeafNode leafNode = lookaheadNodes.get(numConsumedLookaheadTokens - 1);
					if (nodeIsBeforeRegion(leafNode, offset)) {
						// last lookahead token is before changed region
						//NodeUtil.dumpCompositeNodeInfo("Possible entry node: "
						// , node);
						validReplaceRootNodes.add(node);
					}
				}
			}
		}
		return validReplaceRootNodes;
	}

	private static boolean nodeIsBeforeRegion(LeafNode leafNode, int offset) {
		return leafNode.offset() + leafNode.length() <= offset;
	}

	private static boolean nodeEnclosesRegion(CompositeNode node, int offset, int length) {
		return node.offset() <= offset && node.offset() + node.length() >= offset + length;
	}

	private static List<LeafNode> getParentsLookaheadNodes(CompositeNode child) {
		int lookaheadFromParent = child.getLookahead();
		if (lookaheadFromParent != 0) {
			List<LeafNode> lookaheadNodes = new ArrayList<LeafNode>();
			int consumedByParent = child.getLookaheadConsumed();
			if (consumedByParent > 0) {
				// some lookahead nodes are consumed by parent
				CompositeNode parent = child.getParent();
				EList<AbstractNode> children = parent.getChildren();
				int index = children.indexOf(child);
				int count = consumedByParent;
				for (int i = index - 1; i >= 0 && count > 0; --i) {
					AbstractNode tempChild = children.get(i);
					if (tempChild instanceof LeafNode && !((LeafNode) tempChild).isHidden()) {
						lookaheadNodes.add((LeafNode) tempChild);
						--count;
					}
				}
			}
			if (lookaheadFromParent - consumedByParent > 0) {
				// remaining lookahead nodes consumed by child
				EList<LeafNode> leafNodes = child.getLeafNodes();
				int leafIndex = 0;
				LeafNode tempChild;
				for (int i = 0; i < lookaheadFromParent - consumedByParent; ++i) {
					do {
						if (leafIndex >= leafNodes.size()) {
							return null;
						}
						tempChild = leafNodes.get(leafIndex++);
					} while (tempChild.isHidden());
					lookaheadNodes.add(tempChild);
				}
			}
			return lookaheadNodes;
		}
		else {
			return Collections.<LeafNode> emptyList();
		}
	}

}
