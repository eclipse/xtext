/*******************************************************************************
 * Copyright (c) 2008-2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.antlr.IPartialParsingHelper;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parser.impl.Range;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * A customized partial parsing helper that falls eagerly back to a full parse
 * as soon as the new token sequence would be different from the old one.
 * This approach allows to benefit from partial parsing whenever a token content
 * is edited (e.g. the content of a comment, identifier or string literal)
 * while not producing bogus lookahead information.
 * 
 * Mostly copied and refactored from the default implementation.
 * 
 * @author Sebastian Zarnekow
 */
public class XtendPartialParsingHelper implements IPartialParsingHelper {

	@Inject
	private IReferableElementsUnloader unloader;
	
	@Inject
	private NodeModelBuilder nodeModelBuilder;
	
	@Inject
	private FlexerFactory flexerFactory;

	public IParseResult reparse(IParser parser, IParseResult previousParseResult, ReplaceRegion changedRegion) {
		if (isBrokenPreviousState(previousParseResult)) {
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		ICompositeNode oldRootNode = previousParseResult.getRootNode();
		Iterator<ILeafNode> leafNodes = oldRootNode.getLeafNodes().iterator();
		ILeafNode leftNode = getLeftNode(leafNodes, changedRegion.getOffset());
		if (leftNode == null) {
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		ILeafNode rightNode = getRightNode(leafNodes, changedRegion.getEndOffset());
		if (rightNode == null) {
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		String originalText = oldRootNode.getText().substring(leftNode.getTotalOffset(), rightNode.getTotalEndOffset());
		StringBuilder newTextBuilder = new StringBuilder(originalText);
		changedRegion.shiftBy(-leftNode.getTotalOffset()).applyTo(newTextBuilder);
		String newText = newTextBuilder.toString();
		if (originalText.equals(newText)) {
			// nothing to do
			return previousParseResult;
		}
		if (!isSameTokenSequence(originalText, newText)) {
			// different token sequence, cannot perform a partial parse run
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(oldRootNode, leftNode, rightNode);
		ICompositeNode replaceMe = getReplacedNode(parsingPointers);
		if (replaceMe == null || replaceMe == oldRootNode || replaceMe.getOffset() == 0 && replaceMe.getEndOffset() == oldRootNode.getLength()) {
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		String reparseRegion = insertChangeIntoReplaceRegion(replaceMe, changedRegion);
		
		EObject oldSemanticElement = getOldSemanticElement(replaceMe, parsingPointers);
		if (oldSemanticElement == null)
			return fullyReparse(parser, previousParseResult, changedRegion);
		if (oldSemanticElement == replaceMe.getParent().getSemanticElement()) {
			throw new IllegalStateException("oldParent == oldElement");
		}
		
		IParseResult newParseResult = doParseRegion(parser, parsingPointers, replaceMe, reparseRegion);
		if (newParseResult == null) {
			throw new IllegalStateException("Could not perform a partial parse operation");
		}
		
		replaceOldSemanticElement(oldSemanticElement, previousParseResult, newParseResult);
		nodeModelBuilder.replaceAndTransferLookAhead(replaceMe, newParseResult.getRootNode());
		((ParseResult) newParseResult).setRootNode(oldRootNode);
		StringBuilder builder = new StringBuilder(oldRootNode.getText());
		changedRegion.applyTo(builder);
		nodeModelBuilder.setCompleteContent(oldRootNode, builder.toString());
		return newParseResult;
	}
	
	/**
	 * Returns true if the previous document state was completely broken, e.g. the parser did not recover at all.
	 * This may happen for documents like
	 * <pre>import static class C {}</pre>
	 * where the class keyword is consumed as an invalid token in the import declaration and everything thereafter
	 * is unrecoverable.
	 */
	private boolean isBrokenPreviousState(IParseResult previousParseResult) {
		if (previousParseResult.hasSyntaxErrors()) {
			BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) previousParseResult.getRootNode()).basicIterator();
			while(iterator.hasPrevious()) {
				AbstractNode previous = iterator.previous();
				if (previous.getGrammarElement() == null) {
					return true;
				}
				if (previous instanceof ILeafNode) {
					break;
				}
			}
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void replaceOldSemanticElement(EObject oldElement, IParseResult previousParseResult,
			IParseResult newParseResult) {
		EObject oldSemanticParentElement = oldElement.eContainer();
		if (oldSemanticParentElement != null) {
			EStructuralFeature feature = oldElement.eContainingFeature();
			if (feature.isMany()) {
				List featureValueList = (List) oldSemanticParentElement.eGet(feature);
				int index = featureValueList.indexOf(oldElement);
				unloadSemanticObject(oldElement);
				featureValueList.set(index, newParseResult.getRootASTElement());
			} else {
				unloadSemanticObject(oldElement);
				oldSemanticParentElement.eSet(feature, newParseResult.getRootASTElement());
			}
			((ParseResult) newParseResult).setRootASTElement(previousParseResult.getRootASTElement());
		} else {
			unloadSemanticObject(oldElement);
		}
	}

	private EObject getOldSemanticElement(ICompositeNode replaceMe, PartialParsingPointers parsingPointers) {
		EObject oldSemanticElement = null;
		if (replaceMe.hasDirectSemanticElement()) {
			oldSemanticElement = replaceMe.getSemanticElement();
		} else {
			List<ICompositeNode> nodesEnclosingRegion = parsingPointers.getNodesEnclosingRegion();
			for (int i = nodesEnclosingRegion.size() - 1; i >= 0; --i) {
				ICompositeNode enclosingNode = nodesEnclosingRegion.get(i);
				if (enclosingNode == replaceMe) {
					break;
				}
				if (enclosingNode.hasDirectSemanticElement())
					oldSemanticElement = enclosingNode.getSemanticElement();
			}
		}
		return oldSemanticElement;
	}

	private ICompositeNode getReplacedNode(PartialParsingPointers parsingPointers) {
		List<ICompositeNode> validReplaceRootNodes = parsingPointers.getValidReplaceRootNodes();
		ICompositeNode replaceMe = null;
		for (int i = validReplaceRootNodes.size() - 1; i >= 0; --i) {
			replaceMe = validReplaceRootNodes.get(i);
			if (!(replaceMe instanceof SyntheticCompositeNode)) {
				break;	
			}
		}
		return replaceMe;
	}

	private IParseResult doParseRegion(IParser parser, PartialParsingPointers parsingPointers,
			ICompositeNode replaceMe, String reparseRegion) {
		EObject entryRuleOrRuleCall = parsingPointers.findEntryRuleOrRuleCall(replaceMe);
		IParseResult newParseResult = null;
		try {
			if (entryRuleOrRuleCall instanceof RuleCall)
				newParseResult = parser.parse((RuleCall)entryRuleOrRuleCall, new StringReader(reparseRegion), replaceMe.getLookAhead());
			else
				newParseResult = parser.parse((ParserRule)entryRuleOrRuleCall, new StringReader(reparseRegion));
		} catch (ParseException exc) {
		}
		return newParseResult;
	}
	
	private boolean isSameTokenSequence(String originalText, String newText) {
		try {
			InternalFlexer originalSequence = flexerFactory.createFlexer(new StringReader(originalText));
			InternalFlexer newSequence = flexerFactory.createFlexer(new StringReader(newText));
			int token = originalSequence.advance();
			while(token != Token.EOF) {
				if (token != newSequence.advance()) {
					return false;
				}
				token = originalSequence.advance();
			}
			return newSequence.advance() == Token.EOF;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	private ILeafNode getLeftNode(Iterator<ILeafNode> leafNodes, int offset) {
		while(leafNodes.hasNext()) {
			ILeafNode leaf = leafNodes.next();
			if (leaf.getTotalEndOffset() >= offset) {
				if (leaf.getSyntaxErrorMessage() != null) {
					return null;
				}
				return leaf;
			}
		}
		return null;
	}
	
	private ILeafNode getRightNode(Iterator<ILeafNode> leafNodes, int offset) {
		while(leafNodes.hasNext()) {
			ILeafNode leaf = leafNodes.next();
			if (leaf.getSyntaxErrorMessage() != null) {
				return null;
			}
			if (leaf.getTotalEndOffset() > offset) {
				return leaf;
			}
		}
		return null;
	}

	protected IParseResult fullyReparse(IParser parser, IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		unloadSemanticObject(previousParseResult.getRootASTElement());
		String reparseRegion = insertChangeIntoReplaceRegion(previousParseResult.getRootNode(), replaceRegion);
		return parser.parse(new StringReader(reparseRegion));
	}

	private void unloadSemanticObject(EObject object) {
		if (unloader != null && object != null)
			unloader.unloadRoot(object);
	}

	private String insertChangeIntoReplaceRegion(ICompositeNode rootNode, ReplaceRegion region) {
		final StringBuilder builder = new StringBuilder(rootNode.getText());
		region.shiftBy(0-rootNode.getTotalOffset()).applyTo(builder);
		return builder.toString();
	}

	private PartialParsingPointers calculatePartialParsingPointers(ICompositeNode oldRoot, ILeafNode left, ILeafNode right) {
		ICompositeNode result = right.getParent();
		while(result.getTotalOffset() > left.getTotalOffset()) {
			result = result.getParent();
		}
		List<ICompositeNode> nodesEnclosingRegion = getAllParents(result);
		Range range = new Range(left.getTotalOffset(), right.getTotalEndOffset());
		List<ICompositeNode> validReplaceRootNodes = internalFindValidReplaceRootNodeForChangeRegion(nodesEnclosingRegion, 
				range);

		filterInvalidRootNodes(result, validReplaceRootNodes);

		if (validReplaceRootNodes.isEmpty()) {
			validReplaceRootNodes = Collections.singletonList(oldRoot);
		}
		return new PartialParsingPointers(oldRoot, range.getOffset(), range.getLength(), validReplaceRootNodes, nodesEnclosingRegion);
	}

	private List<ICompositeNode> getAllParents(ICompositeNode node) {
		List<ICompositeNode> list = Lists.newArrayList(node);
		node = node.getParent();
		while(node != null) {
			list.add(node);
			node = node.getParent();
		}
		return Lists.reverse(list);
	}

	private void filterInvalidRootNodes(ICompositeNode oldRootNode, List<ICompositeNode> validReplaceRootNodes) {
		ListIterator<ICompositeNode> iter = validReplaceRootNodes.listIterator(validReplaceRootNodes.size());
		while (iter.hasPrevious()) {
			ICompositeNode candidate = iter.previous();
			if (isInvalidRootNode(oldRootNode, candidate))
				iter.remove();
			else
				return;
		}
	}

	private boolean isInvalidRootNode(ICompositeNode rootNode, ICompositeNode candidate) {
		if (candidate instanceof SyntheticCompositeNode)
			return true;
		if (candidate.getGrammarElement() instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) candidate.getGrammarElement()).getRule();
			if (!(rule instanceof ParserRule) || GrammarUtil.isDatatypeRule((ParserRule) rule))
				return true;
		}
		if (candidate.getGrammarElement() instanceof Action) {
			return true;
		}
		return false;
	}

	/**
	 * Investigates the composite nodes containing the changed region and collects a list of nodes which could possibly
	 * replaced by a partial parse. Such a node has a parent that consumes all his current lookahead tokens and all of
	 * these tokens are located before the changed region.
	 */
	private List<ICompositeNode> internalFindValidReplaceRootNodeForChangeRegion(
			List<ICompositeNode> nodesEnclosingRegion, Range range) {
		List<ICompositeNode> result = new ArrayList<ICompositeNode>();
		boolean mustSkipNext = false;
		for (int i = 0; i < nodesEnclosingRegion.size(); i++) {
			ICompositeNode node = nodesEnclosingRegion.get(i);
			if (node.getGrammarElement() != null) {
				if (!mustSkipNext) {
					result.add(node);
					if (isActionNode(node)) {
						mustSkipNext = true;
					}
				} else {
					mustSkipNext = isActionNode(node);
				}
			}
		}
		return result;
	}

	private boolean isActionNode(ICompositeNode node) {
		return node.getGrammarElement() != null && node.getGrammarElement().eClass() == XtextPackage.Literals.ACTION;
	}
	
}