/*******************************************************************************
 * Copyright (c) 2008-2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.antlr.IPartialParsingHelper;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingHelper implements IPartialParsingHelper {

	private static final Logger log = Logger.getLogger(PartialParsingHelper.class);

	@Inject
	private IReferableElementsUnloader unloader;
	
	@Inject
	private NodeModelBuilder nodeModelBuilder = new NodeModelBuilder();
	
	@Inject(optional=true)
	private TokenRegionProvider tokenRegionProvider;

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IParseResult reparse(IParser parser, IParseResult previousParseResult, ReplaceRegion changedRegion) {
		if (parser == null)
			throw new NullPointerException("parser may not be null");
		if (previousParseResult == null) {
			throw new NullPointerException("previousParseResult and previousParseResult.rootNode may not be null");
		}
		ICompositeNode oldRootNode = previousParseResult.getRootNode();
		if (changedRegion.getEndOffset() > oldRootNode.getTotalLength()) {
			log.error("Invalid " + changedRegion + " originalLength=" + oldRootNode.getTotalLength());
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		if (changedRegion.getOffset() >= oldRootNode.getTotalLength() && changedRegion.getText().trim().length() == 0) {
			return fullyReparse(parser, previousParseResult, changedRegion);
		}
		ReplaceRegion replaceRegion = tokenRegionProvider.getTokenReplaceRegion(insertChangeIntoReplaceRegion(oldRootNode, changedRegion), changedRegion);
		if (isNullEdit(oldRootNode, replaceRegion)) {
			return previousParseResult;
		}
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(previousParseResult, replaceRegion.getOffset(), replaceRegion.getLength());
		List<ICompositeNode> validReplaceRootNodes = parsingPointers.getValidReplaceRootNodes();
		ICompositeNode oldCompositeNode = null;
		String reparseRegion = "";
		for (int i = validReplaceRootNodes.size() - 1; i >= 0; --i) {
			oldCompositeNode = validReplaceRootNodes.get(i);
			if (!(oldCompositeNode instanceof SyntheticCompositeNode) && !isRangePartOfExceedingLookAhead((CompositeNode) oldCompositeNode, replaceRegion)) {
				boolean replaceAtEnd = oldCompositeNode.getTotalEndOffset() == replaceRegion.getEndOffset();
				reparseRegion = insertChangeIntoReplaceRegion(oldCompositeNode, replaceRegion);
				if (!"".equals(reparseRegion)) {
					if (!replaceAtEnd || !Character.isWhitespace(reparseRegion.charAt(reparseRegion.length() - 1))) {
						if (log.isDebugEnabled()) {
							log.debug("replace region: [" + oldCompositeNode.getTotalOffset() + " / length: " + oldCompositeNode.getTotalLength() + " of [" + oldRootNode.getTotalOffset() + " / lenght: " + oldRootNode.getTotalLength()+ "]");
						}
						break;	
					}
				}
			}
		}
		if (oldCompositeNode == null || reparseRegion.equals("") || oldCompositeNode == oldRootNode) {
			return fullyReparse(parser, previousParseResult, replaceRegion);
		}
		EObject entryRuleOrRuleCall = parsingPointers.findEntryRuleOrRuleCall(oldCompositeNode);
		IParseResult newParseResult = null;
		try {
			if (entryRuleOrRuleCall instanceof RuleCall)
				newParseResult = parser.parse((RuleCall)entryRuleOrRuleCall, new StringReader(reparseRegion), oldCompositeNode.getLookAhead());
			else
				newParseResult = parser.parse((ParserRule)entryRuleOrRuleCall, new StringReader(reparseRegion));
		} catch (ParseException exc) {
		}
		if (newParseResult == null || newParseResult.hasSyntaxErrors()) {
			// TODO: Should we reparse if the complete input was parsed?
			// on error fully reparse
			return fullyReparse(parser, previousParseResult, replaceRegion);
		}
		if (oldRootNode.equals(oldCompositeNode)) {
			unloadSemanticObject(previousParseResult.getRootASTElement());
			return newParseResult;
		}
		EObject oldSemanticParentElement = oldCompositeNode.getParent().getSemanticElement();
		EObject oldSemanticElement = null;
		if (oldCompositeNode.hasDirectSemanticElement()) {
			oldSemanticElement = oldCompositeNode.getSemanticElement();
		} else {
			List<ICompositeNode> nodesEnclosingRegion = parsingPointers.getNodesEnclosingRegion();
			for (int i = nodesEnclosingRegion.size() - 1; i >= 0; --i) {
				ICompositeNode enclosingNode = nodesEnclosingRegion.get(i);
				if (enclosingNode == oldCompositeNode) {
					break;
				}
				if (enclosingNode.hasDirectSemanticElement())
					oldSemanticElement = enclosingNode.getSemanticElement();
			}
			if (oldSemanticElement == null)
				return fullyReparse(parser, previousParseResult, replaceRegion);
		}
		if (oldSemanticElement == oldSemanticParentElement) {
			throw new IllegalStateException("oldParent == oldElement");
		}
		if (oldSemanticParentElement != null) {
			EStructuralFeature feature = oldSemanticElement.eContainingFeature();
			if (feature == null)
				return fullyReparse(parser, previousParseResult, replaceRegion);
			oldSemanticParentElement = oldSemanticElement.eContainer();
			if (feature.isMany()) {
				List featureValueList = (List) oldSemanticParentElement.eGet(feature);
				int index = featureValueList.indexOf(oldSemanticElement);
				unloadSemanticObject(oldSemanticElement);
				EObject newSemanticObject = newParseResult.getRootASTElement();
				if (newSemanticObject != null) {
					featureValueList.set(index, newParseResult.getRootASTElement());
				} else {
					featureValueList.remove(index);
				}
			} else {
				unloadSemanticObject(oldSemanticElement);
				oldSemanticParentElement.eSet(feature, newParseResult.getRootASTElement());
			}
			((ParseResult) newParseResult).setRootASTElement(previousParseResult.getRootASTElement());
		} else {
			unloadSemanticObject(oldSemanticElement);
		}
		if (oldCompositeNode != oldRootNode) {
			nodeModelBuilder.replaceAndTransferLookAhead(oldCompositeNode, newParseResult.getRootNode());
			((ParseResult) newParseResult).setRootNode(oldRootNode);
			StringBuilder builder = new StringBuilder(oldRootNode.getText());
			replaceRegion.applyTo(builder);
			nodeModelBuilder.setCompleteContent(oldRootNode, builder.toString());
		} 
		return newParseResult;
	}
	
	private boolean isRangePartOfExceedingLookAhead(CompositeNode node, ReplaceRegion replaceRegion) {
		TreeIterator<AbstractNode> iterator = node.basicIterator();
		int lookAhead = node.getLookAhead();
		if (lookAhead == 0) {
			return false;
		}
		while(iterator.hasNext()) {
			AbstractNode child = iterator.next();
			if (child instanceof CompositeNode) {
				if (child.getTotalOffset() < replaceRegion.getEndOffset())
					lookAhead = Math.max(((CompositeNode) child).getLookAhead(), lookAhead);
			} else if (!((ILeafNode) child).isHidden()) {
				lookAhead--;
				if (lookAhead == 0) {
					if (child.getTotalOffset() >= replaceRegion.getEndOffset())
						return false;
				}
			}
		}
		return lookAhead > 0;
	}
	
	private boolean isNullEdit(INode oldRootNode, ReplaceRegion replaceRegion) {
		if (replaceRegion.getLength() == replaceRegion.getText().length()) {
			String replacedText = oldRootNode.getText().substring(replaceRegion.getOffset(), replaceRegion.getEndOffset());
			if (replaceRegion.getText().equals(replacedText)) {
				return true;
			}
		}
		return false;
	}

	protected IParseResult fullyReparse(IParser parser, IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		unloadSemanticObject(previousParseResult.getRootASTElement());
		String reparseRegion = insertChangeIntoReplaceRegion(previousParseResult.getRootNode(), replaceRegion);
		return parser.parse(new StringReader(reparseRegion));
	}

	public void unloadNode(INode node) {
		if (node != null) {
			EObject semantic = node.getSemanticElement();
			unloadSemanticObject(semantic);
		}
	}

	public void unloadSemanticObject(EObject object) {
		if (unloader != null && object != null)
			unloader.unloadRoot(object);
	}

	public String insertChangeIntoReplaceRegion(ICompositeNode rootNode, ReplaceRegion region) {
		final StringBuilder builder = new StringBuilder(rootNode.getText());
		region.shiftBy(0-rootNode.getTotalOffset()).applyTo(builder);
		return builder.toString();
	}

	public PartialParsingPointers calculatePartialParsingPointers(IParseResult previousParseResult, final int offset,
			int replacedTextLength) {
		int myOffset = offset;
		int myReplacedTextLength = replacedTextLength;
		ICompositeNode oldRootNode = previousParseResult.getRootNode();
		if (myOffset == oldRootNode.getTotalLength() && myOffset != 0) {
			// newText is appended, so look for the last original character instead
			--myOffset;
			myReplacedTextLength = 1;
		}
		// include any existing parse errors
		Range range = new Range(myOffset, myReplacedTextLength + myOffset);
		if (previousParseResult.hasSyntaxErrors())
			range.mergeAllSyntaxErrors(oldRootNode);

		myOffset = range.getOffset();
		List<ICompositeNode> nodesEnclosingRegion = collectNodesEnclosingChangeRegion(oldRootNode, range);
		List<ICompositeNode> validReplaceRootNodes = internalFindValidReplaceRootNodeForChangeRegion(nodesEnclosingRegion, range);

		filterInvalidRootNodes(oldRootNode, validReplaceRootNodes);

		if (validReplaceRootNodes.isEmpty()) {
			validReplaceRootNodes = Collections.singletonList(oldRootNode);
		}
		return new PartialParsingPointers(oldRootNode, myOffset, myReplacedTextLength, validReplaceRootNodes, nodesEnclosingRegion);
	}

	protected void filterInvalidRootNodes(ICompositeNode oldRootNode, List<ICompositeNode> validReplaceRootNodes) {
		ListIterator<ICompositeNode> iter = validReplaceRootNodes.listIterator(validReplaceRootNodes.size());
		while (iter.hasPrevious()) {
			ICompositeNode candidate = iter.previous();
			if (isInvalidRootNode(oldRootNode, candidate))
				iter.remove();
			else
				return;
		}
	}

	protected boolean isInvalidRootNode(ICompositeNode rootNode, ICompositeNode candidate) {
		int endOffset = candidate.getTotalEndOffset();
		if (candidate instanceof SyntheticCompositeNode)
			return true;
		if (candidate.getGrammarElement() instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) candidate.getGrammarElement()).getRule();
			if (!(rule instanceof ParserRule))
				return true;
			ParserRule casted = (ParserRule) rule;
			if (GrammarUtil.isDatatypeRule(casted) || casted.isFragment() || !casted.getParameters().isEmpty()) {
				return true;
			}
			if (isInvalidDueToPredicates((AbstractElement) candidate.getGrammarElement()))
				return true;
		}
		if (candidate.getGrammarElement() instanceof Action) {
			return true;
		}
		if (endOffset == rootNode.getTotalEndOffset()) {
			INode lastChild = getLastChild(candidate);
			if (lastChild instanceof ICompositeNode) {
				INode lastLeaf = getLastLeaf(candidate);
				if (isInvalidLastChildNode(candidate, lastLeaf)) {
					return true;
				}
			}
			if (isInvalidLastChildNode(candidate, lastChild)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * @since 2.3
	 */
	protected boolean isInvalidDueToPredicates(AbstractElement element) {
//		if(element.isPredicated()) 
//			return true;
//		else if(element instanceof RuleCall) {
//			AbstractRule rule = ((RuleCall) element).getRule();
//			if(rule.getAlternatives() instanceof Group) {
//				boolean result = isInvalidDueToPredicates(((Group) rule.getAlternatives()).getElements().get(0));
//				return result;
//			}
//		}
		return false;
	}
	
	protected boolean isInvalidLastChildNode(ICompositeNode candidate, INode lastChild) {
		if (lastChild != null && lastChild.getSyntaxErrorMessage() != null) {
			EObject lastChildGrammarElement = lastChild.getGrammarElement();
			if (lastChildGrammarElement == null)
				return true;
			AbstractElement candidateElement = getCandidateElement(candidate.getGrammarElement());
			if (candidateElement != null) {
				if (isCalledBy(lastChildGrammarElement, candidateElement)) {
					while(candidate != null) {
						if (candidateElement != null && hasMandatoryFollowElements(candidateElement))
							return true;
						candidate = candidate.getParent();
						if (candidate != null)
							candidateElement = getCandidateElement(candidate.getGrammarElement());
					}
				}
				return true;
			}
		}
		return false;
	}

	private boolean isCalledBy(final EObject child, AbstractElement parent) {
		return new XtextSwitch<Boolean>() {
			private final Set<ParserRule> rules = new HashSet<ParserRule>(4);

			@Override
			public Boolean caseCompoundElement(CompoundElement object) {
				for (AbstractElement elem : object.getElements()) {
					if (doSwitch(elem))
						return true;
				}
				return false;
			}

			@Override
			public Boolean caseAbstractElement(AbstractElement object) {
				return object == child;
			}

			@Override
			public Boolean caseRuleCall(RuleCall object) {
				return object == child || doSwitch(object.getRule());
			}

			@Override
			public Boolean caseAbstractRule(AbstractRule object) {
				return object == child;
			}

			@Override
			public Boolean caseParserRule(ParserRule object) {
				return object == child || (rules.add(object) && doSwitch(object.getAlternatives()));
			}
		}.doSwitch(parent);
	}

	private boolean hasMandatoryFollowElements(AbstractElement lastParsedElement) {
		if (lastParsedElement.eContainer() instanceof AbstractElement) {
			AbstractElement directParent = (AbstractElement) lastParsedElement.eContainer();
			if (directParent instanceof Group) {
				Group group = (Group) directParent;
				int idx = group.getElements().indexOf(lastParsedElement) + 1;
				for (int i = idx; i < group.getElements().size(); i++) {
					if (isMandatory(group.getElements().get(i)))
						return true;
				}
			}
			return hasMandatoryFollowElements(directParent);
		}
		return false;
	}

	private boolean isMandatory(AbstractElement element) {
		return new XtextSwitch<Boolean>() {
			private final Set<ParserRule> rules = new HashSet<ParserRule>(4);

			@Override
			public Boolean caseAction(Action object) {
				return false;
			}

			@Override
			public Boolean caseCompoundElement(CompoundElement object) {
				if (GrammarUtil.isOptionalCardinality(object))
					return false;
				for (AbstractElement child : object.getElements()) {
					if (doSwitch(child)) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean caseAlternatives(Alternatives object) {
				if (GrammarUtil.isOptionalCardinality(object))
					return false;
				for (AbstractElement child : object.getElements()) {
					if (!doSwitch(child)) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean caseAbstractElement(AbstractElement object) {
				return !GrammarUtil.isOptionalCardinality(object);
			}

			@Override
			public Boolean caseRuleCall(RuleCall object) {
				return !GrammarUtil.isOptionalCardinality(object) || doSwitch(object.getRule());
			}

			@Override
			public Boolean caseAbstractRule(AbstractRule object) {
				return true;
			}

			@Override
			public Boolean caseParserRule(ParserRule object) {
				return rules.add(object) && doSwitch(object.getAlternatives());
			}
		}.doSwitch(element);
	}

	private AbstractElement getCandidateElement(EObject grammarElement) {
		if (grammarElement instanceof AbstractElement)
			return (AbstractElement) grammarElement;
		return null;
	}

	private INode getLastChild(ICompositeNode parent) {
		BidiTreeIterator<? extends INode> iterator = parent.getAsTreeIterable().iterator();
		while(iterator.hasPrevious()) {
			INode previous = iterator.previous();
			if (previous instanceof ILeafNode) {
				return previous;
			} else if (previous instanceof ICompositeNode) {
				if (!((ICompositeNode) previous).hasChildren())
					return previous;
			}
		}
		return parent;
	}
	
	private INode getLastLeaf(ICompositeNode parent) {
		BidiTreeIterator<? extends INode> iterator = parent.getAsTreeIterable().iterator();
		while(iterator.hasPrevious()) {
			INode previous = iterator.previous();
			if (previous instanceof ILeafNode) {
				return previous;
			} 
		}
		return null;
	}

	/**
	 * Collects a list of all nodes containing the change region
	 */
	private List<ICompositeNode> collectNodesEnclosingChangeRegion(ICompositeNode parent, Range range) {
		List<ICompositeNode> nodesEnclosingRegion = new ArrayList<ICompositeNode>();
		if (nodeEnclosesRegion(parent, range)) {
			collectNodesEnclosingChangeRegion(parent, range, nodesEnclosingRegion);
		}
		return nodesEnclosingRegion;
	}

	private void collectNodesEnclosingChangeRegion(ICompositeNode parent, Range range,
			List<ICompositeNode> nodesEnclosingRegion) {
		nodesEnclosingRegion.add(parent);
		BidiIterator<INode> iterator = parent.getChildren().iterator();
		while(iterator.hasPrevious()) {
			INode prev = iterator.previous();
			if (prev instanceof ICompositeNode) {
				if (nodeEnclosesRegion((ICompositeNode) prev, range)) {
					collectNodesEnclosingChangeRegion((ICompositeNode) prev, range, nodesEnclosingRegion);
					break;
				}
			}
		}
	}

	protected boolean nodeEnclosesRegion(ICompositeNode node, Range range) {
		boolean result = node.getTotalOffset() <= range.getOffset() && node.getTotalEndOffset() >= range.getEndOffset();
		return result;
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
		ICompositeNode previous = null;
		/*
		 * set to 'true' as soon as the lookahead of an enclosing
		 * exceeds the given range
		 */
		boolean done = false;  
		for (int i = 0; i < nodesEnclosingRegion.size() && !done; i++) {
			ICompositeNode node = nodesEnclosingRegion.get(i);
			if (node.getGrammarElement() != null) {
				if (!mustSkipNext) {
					boolean process = true;
					if (previous != null && !node.hasNextSibling()) {
						if (previous.getLookAhead() == node.getLookAhead() && previous.getLookAhead() == 0) {
							process = false;
						}
					}
					EObject semanticElement = NodeModelUtils.findActualSemanticObjectFor(node);
					if (semanticElement != null) {
						ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(semanticElement);
						if (actualNode != null && (actualNode.getTotalOffset() < node.getTotalOffset() || actualNode.getTotalEndOffset() > node.getTotalEndOffset()))
							process = false;
					}
					if (process) {
						int remainingLookAhead = node.getLookAhead();
						if (remainingLookAhead != 0) {
							Iterator<ILeafNode> iterator = node.getLeafNodes().iterator();
							while(iterator.hasNext() && remainingLookAhead > 0) {
								ILeafNode leaf = iterator.next();
								if (!leaf.isHidden()) {
									if (remainingLookAhead > 0)
										remainingLookAhead--;
									if (remainingLookAhead == 0) {
										if (leaf.getTotalEndOffset() <= range.getOffset()) {
											result.add(node);
											previous = node;
											if (isActionNode(node)) {
												mustSkipNext = true;
											}
											break;
										} else {
											// lookahead ends left of the range, don't dive into child nodes
											done = true;
										}
									}
								}
							}
							if (remainingLookAhead != 0) {
								done = true;
							}
						} else {
							result.add(node);
							previous = node;
							if (isActionNode(node)) {
								mustSkipNext = true;
							}
						}
					}
				} else { // !mustSkipNext
					mustSkipNext = isActionNode(node);
				}
			}
		}
		return result;
	}

	protected boolean isActionNode(ICompositeNode node) {
		return node.getGrammarElement() != null && node.getGrammarElement().eClass() == XtextPackage.Literals.ACTION;
	}
	
	public void setUnloader(IReferableElementsUnloader unloader) {
		this.unloader = unloader;
	}

	public IReferableElementsUnloader getUnloader() {
		return unloader;
	}
	
	/**
	 * @since 2.3
	 */
	public void setTokenRegionProvider(TokenRegionProvider tokenRegionProvider) {
		this.tokenRegionProvider = tokenRegionProvider;
	}

}