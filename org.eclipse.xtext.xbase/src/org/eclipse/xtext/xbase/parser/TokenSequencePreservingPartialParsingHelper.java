/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parser.antlr.TokenTool;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parser.impl.Range;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

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
 * @since 2.9
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 */
public class TokenSequencePreservingPartialParsingHelper implements IPartialParsingHelper {

	@Inject
	private IReferableElementsUnloader unloader;
	
	@Inject
	private NodeModelBuilder nodeModelBuilder;
	
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Provider<Lexer> lexerProvider;

	@Override
	public IParseResult reparse(IParser parser, IParseResult previousParseResult, ReplaceRegion changedRegion) {
		if (isBrokenPreviousState(previousParseResult, changedRegion.getOffset())) {
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
		while(leafNodes.hasNext()) {
			if (leafNodes.next().getSyntaxErrorMessage() != null) {
				return fullyReparse(parser, previousParseResult, changedRegion);
			}
		}
		String originalText = oldRootNode.getText().substring(leftNode.getTotalOffset());
		StringBuilder newTextBuilder = new StringBuilder(originalText);
		changedRegion.shiftBy(-leftNode.getTotalOffset()).applyTo(newTextBuilder);
		String newText = newTextBuilder.toString();
		if (originalText.equals(newText)) {
			// nothing to do
			return previousParseResult;
		}
		int originalLength = rightNode.getTotalEndOffset() - leftNode.getTotalOffset();
		int expectedLength = originalLength - changedRegion.getLength() + changedRegion.getText().length();
		if (!isSameTokenSequence(originalText.substring(0, originalLength), newText, expectedLength)) {
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
	 * This may happen e.g. in Xtend for documents like
	 * <pre>import static class C {}</pre>
	 * where the class keyword is consumed as an invalid token in the import declaration and everything thereafter
	 * is unrecoverable.
	 */
	protected boolean isBrokenPreviousState(IParseResult previousParseResult, int offset) {
		if (previousParseResult.hasSyntaxErrors()) {
			BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) previousParseResult.getRootNode()).basicIterator();
			while(iterator.hasPrevious()) {
				AbstractNode previous = iterator.previous();
				if (previous.getGrammarElement() == null) {
					return true;
				}
				if (previous instanceof ILeafNode && previous.getOffset() <= offset) {
					break;
				}
			}
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void replaceOldSemanticElement(EObject oldElement, IParseResult previousParseResult,
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

	protected EObject getOldSemanticElement(ICompositeNode replaceMe, PartialParsingPointers parsingPointers) {
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

	protected ICompositeNode getReplacedNode(PartialParsingPointers parsingPointers) {
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

	protected IParseResult doParseRegion(IParser parser, PartialParsingPointers parsingPointers,
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
	
	protected boolean isSameTokenSequence(String originalText, String newText, int expectedLength) {
		Lexer originalLexer = lexerProvider.get();
		Lexer newLexer = lexerProvider.get();
		originalLexer.setCharStream(new ANTLRStringStream(originalText));
		newLexer.setCharStream(new ANTLRStringStream(newText));
		return isSameTokenSequence(originalLexer, newLexer, expectedLength);
	}
	
	protected boolean isSameTokenSequence(TokenSource originalSource, TokenSource newSource, int expectedLength) {
		Token token = originalSource.nextToken();
		int newLength = 0;
		while(Token.EOF != token.getType()) {
			Token newToken = newSource.nextToken();
			if (token.getType() != newToken.getType()) {
				return false;
			}
			newLength += TokenTool.getLength(newToken);
			token = originalSource.nextToken();
		}
		return newLength == expectedLength;
	}

	protected ILeafNode getLeftNode(Iterator<ILeafNode> leafNodes, int offset) {
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
	
	protected ILeafNode getRightNode(Iterator<ILeafNode> leafNodes, int offset) {
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

	protected void unloadSemanticObject(EObject object) {
		if (unloader != null && object != null)
			unloader.unloadRoot(object);
	}

	protected String insertChangeIntoReplaceRegion(ICompositeNode rootNode, ReplaceRegion region) {
		final StringBuilder builder = new StringBuilder(rootNode.getText());
		region.shiftBy(0-rootNode.getTotalOffset()).applyTo(builder);
		return builder.toString();
	}

	protected PartialParsingPointers calculatePartialParsingPointers(ICompositeNode oldRoot, ILeafNode left, ILeafNode right) {
		ICompositeNode result = right.getParent();
		while(result.getTotalOffset() > left.getTotalOffset()) {
			result = result.getParent();
		}
		List<ICompositeNode> nodesEnclosingRegion = getAllParents(result);
		Range range = new Range(left.getTotalOffset(), right.getTotalEndOffset());
		List<ICompositeNode> validReplaceRootNodes = internalFindValidReplaceRootNodeForChangeRegion(nodesEnclosingRegion);

		filterInvalidRootNodes(validReplaceRootNodes);

		if (validReplaceRootNodes.isEmpty()) {
			validReplaceRootNodes = Collections.singletonList(oldRoot);
		}
		return new PartialParsingPointers(oldRoot, range.getOffset(), range.getLength(), validReplaceRootNodes, nodesEnclosingRegion);
	}

	protected List<ICompositeNode> getAllParents(ICompositeNode node) {
		List<ICompositeNode> list = Lists.newArrayList(node);
		node = node.getParent();
		while(node != null) {
			list.add(node);
			node = node.getParent();
		}
		return Lists.reverse(list);
	}

	protected void filterInvalidRootNodes(List<ICompositeNode> validReplaceRootNodes) {
		ListIterator<ICompositeNode> iter = validReplaceRootNodes.listIterator(validReplaceRootNodes.size());
		while (iter.hasPrevious()) {
			ICompositeNode candidate = iter.previous();
			if (isInvalidRootNode(candidate))
				iter.remove();
			else
				return;
		}
	}

	protected boolean isInvalidRootNode(ICompositeNode candidate) {
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
	protected List<ICompositeNode> internalFindValidReplaceRootNodeForChangeRegion(List<ICompositeNode> nodesEnclosingRegion) {
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

	protected boolean isActionNode(ICompositeNode node) {
		return node.getGrammarElement() != null && node.getGrammarElement().eClass() == XtextPackage.Literals.ACTION;
	}
	
}