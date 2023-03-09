/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.LineAndColumn;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;

/**
 * A CompletionPrefixProvider specialization that is capable of handling synthetic
 * BEGIN and END tokens. Their unique property of being a leafnode with a length
 * zero can be exploited to match the indentation stack when invoking content assist. * 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.13
 */
public class IndentationAwareCompletionPrefixProvider extends CompletionPrefixProvider {
	
	/**
	 * Returns the input to parse including the whitespace left to the cursor position since
	 * it may be relevant to the list of proposals for whitespace sensitive languages. 
	 */
	@Override
	public String getInputToParse(String completeInput, int offset, int completionOffset) {
		int fixedOffset = getOffsetIncludingWhitespace(completeInput, offset, Math.min(completeInput.length(), completionOffset));
		return super.getInputToParse(completeInput, fixedOffset, completionOffset);
	}
	
	protected int getOffsetIncludingWhitespace(String input, int startOffset, int max) {
		int result = startOffset;
		while(result < max && Character.isWhitespace(input.charAt(result))) {
			result++;
		}
		return result;
	}
	
	@Override
	public INode getLastCompleteNodeByOffset(INode node, int offset, int completionOffset) {
		INode result = getLastCompleteNodeByOffset(node, offset);
		if (result.getTotalLength() == 0) {
			// likely a dedent / end token - find the EObject with the respective open token
			// and return the best guessed dedent token
			int completionColumn = NodeModelUtils.getLineAndColumn(node, completionOffset).getColumn();
			INode bestResult = findBestEndToken(node, result, completionColumn, true);
			return bestResult;
		} else if (result.getTotalEndOffset() < completionOffset) {
			int completionColumn = NodeModelUtils.getLineAndColumn(node, completionOffset).getColumn();
			INode bestResult = findBestEndToken(node, result, completionColumn, false);
			return bestResult;
		}
		return result;
	}
	
	protected INode findBestEndToken(INode root, INode candidate, int completionColumn, boolean candidateIsEndToken) {
		LinkedList<ILeafNode> sameGrammarElement = Lists.newLinkedList();
		PeekingIterator<ILeafNode> iterator = createReversedLeafIterator(root, candidate, sameGrammarElement);
		if (!iterator.hasNext()) {
			return candidate;
		}
		// collect all candidates that belong to the same offset
		LinkedList<ILeafNode> sameOffset = candidateIsEndToken ? collectLeafsWithSameOffset((ILeafNode)candidate, iterator) : Lists.newLinkedList();
		// continue until we find a paired leaf with length 0 that is at the correct offset
		EObject grammarElement = tryGetGrammarElementAsRule(candidateIsEndToken || sameGrammarElement.isEmpty() ? candidate : sameGrammarElement.getLast()); 
		ILeafNode result = candidateIsEndToken ? null : (ILeafNode) candidate;
		int sameOffsetSize = sameOffset.size();
		while(iterator.hasNext()) {
			ILeafNode next = iterator.next();
			if (result == null || result.isHidden()) {
				result = next;
			}
			if (next.getTotalLength() == 0) {
				// potential indentation token
				EObject rule = tryGetGrammarElementAsRule(next);
				if (rule != grammarElement) {
					LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(root, next.getTotalOffset());
					if (lineAndColumn.getColumn() <= completionColumn) {
						return result;
					} else {
						if (sameOffset.isEmpty()) {
							if (sameGrammarElement.isEmpty()) {
								result = null;	
							} else {
								result = sameGrammarElement.removeLast();
							}
							
						} else {
							if (sameOffsetSize >= sameOffset.size()) {
								result = sameOffset.removeLast();	
							} else {
								sameOffset.removeLast();
							}
						}
					}
				} else {
					sameOffset.add(next);
				}
			}
		}
		return candidate;
	}

	private PeekingIterator<ILeafNode> createReversedLeafIterator(INode root, INode candidate, LinkedList<ILeafNode> sameGrammarElement) {
		EObject grammarElement = null;
		PeekingIterator<ILeafNode> iterator = Iterators.peekingIterator(Iterators.filter(root.getAsTreeIterable().reverse().iterator(), ILeafNode.class));
		// traverse until we find the current candidate
		while(iterator.hasNext()) {
			ILeafNode next = iterator.next();
			if (candidate.equals(next)) {
				break;
			} else if (next.getTotalLength() == 0) {
				EObject otherGrammarElement = tryGetGrammarElementAsRule(next);
				if (grammarElement == null) {
					grammarElement = otherGrammarElement;
				}
				if (otherGrammarElement.equals(grammarElement)) {
					sameGrammarElement.add(next);
				} else {
					sameGrammarElement.removeLast();
				}
			}
		}
		return iterator;
	}

	private LinkedList<ILeafNode> collectLeafsWithSameOffset(ILeafNode candidate, PeekingIterator<ILeafNode> iterator) {
		LinkedList<ILeafNode> sameOffset = Lists.newLinkedList();
		sameOffset.add(candidate);
		int offset = candidate.getTotalOffset();
		while(iterator.hasNext()) {
			ILeafNode peek = iterator.peek();
			if (peek.getTotalOffset() == offset) {
				sameOffset.add(peek);
				iterator.next();
			} else {
				break;
			}
		}
		return sameOffset;
	}

	protected EObject tryGetGrammarElementAsRule(INode candidate) {
		EObject grammarElement = candidate.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			grammarElement = ((RuleCall) grammarElement).getRule();
		}
		return grammarElement;
	}

	protected INode getLastCompleteNodeByOffset(INode node, int offset) {
		BidiTreeIterator<INode> iterator = node.getRootNode().getAsTreeIterable().iterator();
		INode result = node;
		ITextRegion candidateTextRegion = node.getTextRegion();
		while (iterator.hasNext()) {
			INode candidate = iterator.next();
			ITextRegion textRegion = candidate.getTextRegion();
			if (textRegion.getOffset() >= offset && !(textRegion.getOffset() == offset && textRegion.getLength() == 0)) {
				if (!candidateTextRegion.equals(textRegion) && candidate instanceof ILeafNode && textRegion.getLength() + textRegion.getOffset() >= offset) {
					break;
				}
			} 
			if ((candidate instanceof ILeafNode) &&
					   (candidate.getGrammarElement() == null ||
							   candidate.getGrammarElement() instanceof AbstractElement ||
							   candidate.getGrammarElement() instanceof ParserRule)) {
				if (textRegion.getLength() == 0) {
					if (candidateTextRegion.getOffset() + candidateTextRegion.getLength() < offset || candidateTextRegion.getLength() == 0 && candidateTextRegion.getOffset() <= offset) {
						result = candidate;
						candidateTextRegion = candidate.getTextRegion();
					}
				} else {
					result = candidate;
					candidateTextRegion = candidate.getTextRegion();
				}
			}
		}
		return result;
	}
}
