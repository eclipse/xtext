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
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IParseErrorHandler;
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

	@SuppressWarnings("unchecked")
	public static IParseResult reparse(IParser parser, CompositeNode rootNode, int originalOffset, int originalLength,
			String changedRegion, IParseErrorHandler handler) {
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(rootNode, originalOffset,
				originalLength);
		List<CompositeNode> validReplaceRootNodes = parsingPointers.getValidReplaceRootNodes();
		CompositeNode replaceNode = null;
		String reparseRegion = "";
		for (int i = validReplaceRootNodes.size() - 1; i >= 0; --i) {
			replaceNode = validReplaceRootNodes.get(i);
			reparseRegion = insertChangeIntoReplaceRegion(replaceNode, originalOffset, originalLength, changedRegion);
			if (!"".equals(reparseRegion)) {
				break;
			}
		}
		if (replaceNode == null || reparseRegion.equals("")) {
			// no replaceNode -> no rule to call
			// If region is empty, any entryRule is likely to fail.
			// Let parser decide whether empty model is valid
			return parser.parse(new StringInputStream(""), handler);
		}
		String entryRuleName = parsingPointers.findEntryRuleName(replaceNode);
		ParseResult parseResult = null;
		try {
			parseResult = (ParseResult) ((AbstractParser) parser).parse(entryRuleName, new StringInputStream(
					reparseRegion), handler);
		}
		catch (ParseException exc) {
		}
		if (parseResult == null || parseResult.getParseErrors() != null && !parseResult.getParseErrors().isEmpty()) {
			// on error fully reparse
			reparseRegion = insertChangeIntoReplaceRegion(rootNode, originalOffset, originalLength, changedRegion);
			return parser.parse(new StringInputStream(reparseRegion), handler);
		}
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
		List<NodeWithCachedOffset> nodesEnclosingRegion = collectNodesEnclosingChangeRegion(rootNode, offset, length);
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
	private static List<NodeWithCachedOffset> collectNodesEnclosingChangeRegion(CompositeNode parent, int offset,
			int length) {
		EnclosingCompositeNodeFinder enclosingCompositeNodeFinder = new EnclosingCompositeNodeFinder(parent, offset,
				length);
		return enclosingCompositeNodeFinder.getNodesEnclosingRegion();
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
			List<NodeWithCachedOffset> nodesEnclosingRegion, int offset, int length) {
		List<NodeWithCachedOffset> lookaheadNodes = new ArrayList<NodeWithCachedOffset>();
		int numConsumedLookaheadTokens = 0;
		List<CompositeNode> validReplaceRootNodes = new ArrayList<CompositeNode>();

		for (NodeWithCachedOffset node : nodesEnclosingRegion) {
			List<NodeWithCachedOffset> parentsLookaheadNodes = getParentsLookaheadNodes(node);
			if (!parentsLookaheadNodes.isEmpty()) {
				mergeLookaheadNodes(lookaheadNodes, parentsLookaheadNodes);
			}
			if (((CompositeNode) node.getNode()).getLookaheadConsumed() > 0) {
				// parent has consumed lookahead tokens.
				numConsumedLookaheadTokens += ((CompositeNode) node.getNode()).getLookaheadConsumed();
				if (numConsumedLookaheadTokens == lookaheadNodes.size()) {
					// parent has consumed all current lookahead tokens
					NodeWithCachedOffset leafNode = lookaheadNodes.get(numConsumedLookaheadTokens - 1);
					if (nodeIsBeforeRegion(leafNode, offset)) {
						// last lookahead token is before changed region
						//NodeUtil.dumpCompositeNodeInfo("Possible entry node: "
						// , node);
						validReplaceRootNodes.add((CompositeNode) node.getNode());
					}
				}
			}
		}
		return validReplaceRootNodes;
	}

	private static void mergeLookaheadNodes(List<NodeWithCachedOffset> lookaheadNodes,
			List<NodeWithCachedOffset> parentsLookaheadNodes) {
		NodeWithCachedOffset firstParentLookaheadNode = parentsLookaheadNodes.get(0);
		int index;
		for(index=0; index < lookaheadNodes.size(); ++index) {
			if(lookaheadNodes.get(index).getNode().equals(firstParentLookaheadNode.getNode())) {
				break;
			}
		}
		if (index < lookaheadNodes.size()) {
			// remove lookahead nodes common with grandpa
			while (lookaheadNodes.size() > index) {
				lookaheadNodes.remove(index);
			}
		}
		lookaheadNodes.addAll(parentsLookaheadNodes);
	}

	private static boolean nodeIsBeforeRegion(NodeWithCachedOffset leafNode, int offset) {
		return leafNode.getChachedOffset() + leafNode.getNode().length() <= offset;
	}

	private static List<NodeWithCachedOffset> getParentsLookaheadNodes(NodeWithCachedOffset child) {
		int lookaheadFromParent = ((CompositeNode) child.getNode()).getLookahead();
		if (lookaheadFromParent != 0) {
			List<NodeWithCachedOffset> lookaheadNodes = new ArrayList<NodeWithCachedOffset>();
			int consumedByParent = ((CompositeNode) child.getNode()).getLookaheadConsumed();
			if (consumedByParent > 0) {
				// some lookahead nodes are consumed by parent
				NodeWithCachedOffset tempLeaf = child;
				for (int i = 0; i < consumedByParent; ++i) {
					tempLeaf = previousUnhiddenLeaf(tempLeaf.getNode(), tempLeaf.getChachedOffset());
					lookaheadNodes.add(tempLeaf);
				}
			}
			if (lookaheadFromParent - consumedByParent > 0) {
				// remaining lookahead nodes consumed by child
				NodeWithCachedOffset tempLeaf = child;
				for (int i = 0; i < lookaheadFromParent - consumedByParent; ++i) {
					tempLeaf = nextUnhiddenLeaf(tempLeaf.getNode(), tempLeaf.getChachedOffset());
					lookaheadNodes.add(tempLeaf);
				}
			}
			return lookaheadNodes;
		}
		else {
			return Collections.<NodeWithCachedOffset> emptyList();
		}
	}

	private static NodeWithCachedOffset nextUnhiddenLeaf(AbstractNode node, int currentOffset) {
		if (node instanceof CompositeNode) {
			NodeWithCachedOffset firstLeaf = firstLeaf((CompositeNode) node, currentOffset);
			if (firstLeaf != null) {
				return firstLeaf;
			}
		}
		CompositeNode parent = node.getParent();
		EList<AbstractNode> siblings = parent.getChildren();
		int childIndex = siblings.indexOf(node);
		while (++childIndex < siblings.size()) {
			AbstractNode sibling = siblings.get(childIndex);
			if (sibling instanceof LeafNode) {
				if (!((LeafNode) sibling).isHidden()) {
					return new NodeWithCachedOffset(currentOffset, sibling);
				}
				currentOffset += sibling.length();
			}
			else if (sibling instanceof CompositeNode) {
				return nextUnhiddenLeaf(sibling, currentOffset);
			}
		}
		return nextUnhiddenLeaf(parent, currentOffset);
	}

	private static NodeWithCachedOffset firstLeaf(CompositeNode node, int currentOffset) {
		EList<AbstractNode> children = node.getChildren();
		for (AbstractNode child : children) {
			if (child instanceof LeafNode) {
				if (!((LeafNode) child).isHidden()) {
					return new NodeWithCachedOffset(currentOffset, child);
				}
				currentOffset += child.length();
			}
			else if (child instanceof CompositeNode) {
				NodeWithCachedOffset leafFromChild = firstLeaf((CompositeNode) child, currentOffset);
				if (leafFromChild != null) {
					return leafFromChild;
				}
			}
		}
		return null;
	}

	private static NodeWithCachedOffset previousUnhiddenLeaf(AbstractNode node, int currentOffset) {
		CompositeNode parent = node.getParent();
		EList<AbstractNode> siblings = parent.getChildren();
		int childIndex = siblings.indexOf(node);
		while (--childIndex >= 0) {
			AbstractNode sibling = siblings.get(childIndex);
			if (sibling instanceof LeafNode) {
				currentOffset -= sibling.length();
				if(!((LeafNode) sibling).isHidden()) {
					return new NodeWithCachedOffset(currentOffset, sibling);
				}
			}
			else {
				NodeWithCachedOffset leafFromComposite = lastUnhiddenLeaf((CompositeNode) sibling, currentOffset);
				if (leafFromComposite != null) {
					return leafFromComposite;
				}
			}
		}
		return previousUnhiddenLeaf(parent, currentOffset);
	}

	private static NodeWithCachedOffset lastUnhiddenLeaf(CompositeNode node, int currentOffset) {
		EList<AbstractNode> children = node.getChildren();
		for (int i = children.size() - 1; i >= 0; --i) {
			AbstractNode child = children.get(i);
			if (child instanceof LeafNode) {
				currentOffset -= child.length();
				if(!((LeafNode) child).isHidden()) {
					return new NodeWithCachedOffset(currentOffset, child);
				}
			}
			else if (child instanceof CompositeNode) {
				NodeWithCachedOffset leafFromChild = lastUnhiddenLeaf((CompositeNode) child, currentOffset);
				if (leafFromChild != null) {
					return leafFromChild;
				}
			}
		}
		return null;
	}
}
