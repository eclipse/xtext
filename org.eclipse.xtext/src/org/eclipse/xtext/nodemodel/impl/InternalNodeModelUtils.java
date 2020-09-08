/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.LineAndColumn;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Internal base class for node model utilities with access to implementation details
 * of the node model.
 * 
 * It is intentional that the methods here are available to clients only with some
 * effort because they rely on internal semantics of the node model implementation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class InternalNodeModelUtils {
	/* 
	 * All methods in this class are supposed to be protected or private
	 * and access (to a subset of these) 
	 * should be provided via {@link NodeModelUtils}.
	 * 
	 * Clients that do want to access other methods of this class can extend
	 * it to use the protected members (at their own risk, no API guarantees are made).
	 */
	
	protected InternalNodeModelUtils() {
		throw new AssertionError();
	}
	
	/**
	 * Obtain the line breaks from the document and search / compute the line number
	 * and column number at the given document offset.
	 */
	protected static LineAndColumn getLineAndColumn(INode anyNode, int documentOffset) {
		INode rootNode = anyNode.getRootNode();
		int[] lineBreaks = getLineBreakOffsets(rootNode);
		String document = rootNode.getText();
		return getLineAndColumn(document, lineBreaks, documentOffset);
	}
	
	/**
	 * Obtain the parent node of the given node. Does not unfold {@link SyntheticCompositeNode synthetic}
	 * nodes. May return {@code null}.
	 * 
	 * @since 2.24
	 */
	protected static CompositeNode basicGetParent(AbstractNode node) {
		return node.basicGetParent();
	}
	
	/**
	 * Obtain the first child node of the given node. Does not unfold {@link SyntheticCompositeNode synthetic}
	 * nodes. May return {@code null}.
	 * 
	 * @since 2.24
	 */
	protected static AbstractNode basicGetFirstChild(CompositeNode node) {
		return node.basicGetFirstChild();
	}
	
	/**
	 * Obtain the last child node of the given node. Does not unfold {@link SyntheticCompositeNode synthetic}
	 * nodes. May return {@code null}.
	 * 
	 * @since 2.24
	 */
	protected static AbstractNode basicGetLastChild(CompositeNode node) {
		return node.basicGetLastChild();
	}
	
	/*
	 * TODO This should better be made available in org.eclipse.xtext.util.Strings but the contract of the given lineBreaks is too special
	 * for general purpose application of this logic.
	 * In other words: We should double check if we could change RootNode.basicGetLineBreakOffsets to return an array of offsets
	 * that point to the very first char in each line.
	 */
	protected static LineAndColumn getLineAndColumn(String text, int[] lineBreaks, int offset) {
		Preconditions.checkPositionIndex(offset, text.length());

		int idx = Arrays.binarySearch(lineBreaks, offset);
		if (idx >= 0) {
			/*
			 * We found an entry in the array. The offset is a line break.
			 * The line number is the index in the array, the column needs to be
			 * adjusted.
			 */
			return getLineAndColumnOfLineBreak(text, lineBreaks, idx, offset);
		} else {
			// if not found, the result of a binary search `-(insertion point) - 1`
			int insertionPoint = -(idx + 1);
			return getLineAndColumnNoExactLineBreak(text, lineBreaks, insertionPoint, offset);
		}
	}

	private static LineAndColumn getLineAndColumnNoExactLineBreak(String text, int[] lineBreaks, int insertionPoint, int offset) {
		int line, column;
		if (insertionPoint == 0) {
			// the insertionPoint would be before the first line break
			// so we are in
			line = 1;
			// at 
			column = offset + 1;
		} else {
			int lineBreakIdx = insertionPoint - 1;
			int leftLineBreak = lineBreaks[lineBreakIdx];
			if (leftLineBreak + 1 == offset) {
				// offset is immediately after an existing line break
				if (text.charAt(leftLineBreak) == '\r' && text.charAt(offset) == '\n') {
					// windows line break, the offset belongs to the previous line
					line = insertionPoint;
					if (lineBreakIdx > 0) {
						int prevLineBreak = lineBreaks[lineBreakIdx - 1];
						// check for windows line breaks here, too
						if (text.charAt(prevLineBreak) == '\r' && text.charAt(prevLineBreak + 1) == '\n') {
							column = offset - prevLineBreak - 1;
						} else {
							column = offset - prevLineBreak;
						}
					} else {
						column = offset + 1;
					}
				} else {
					line = insertionPoint + 1;
					column = offset - leftLineBreak;
				}
			} else {
				line = insertionPoint + 1;
				// check for windows line breaks here, too
				if (text.charAt(leftLineBreak) == '\r' && text.charAt(leftLineBreak + 1) == '\n') {
					column = offset - leftLineBreak - 1;
				} else {
					column = offset - leftLineBreak;
				}
			}
		}
		return LineAndColumn.from(line, column);
	}

	private static LineAndColumn getLineAndColumnOfLineBreak(String text, int[] lineBreaks, int lineBreakIdx, int offset) {
		int line, column;
		line = lineBreakIdx + 1;
		if (lineBreakIdx == 0) {
			column = offset + 1;
		} else {
			int lineBreak = lineBreaks[lineBreakIdx];
			int prevLineBreak = lineBreaks[lineBreakIdx - 1];
			if (prevLineBreak < lineBreak - 1 && text.charAt(prevLineBreak) == '\r' && text.charAt(prevLineBreak + 1) == '\n') {
				column = lineBreak - prevLineBreak - 1;
			} else {
				// we found two subsequent line breaks, e.g. \n\n
				// and the offset is the second line break.
				// the column number is 1 for that case.
				column = lineBreak - prevLineBreak;
			}
		}
		return LineAndColumn.from(line, column);
	}

	private static int[] getLineBreakOffsets(INode rootNode) {
		if (rootNode instanceof RootNode) {
			return ((RootNode) rootNode).basicGetLineBreakOffsets();
		} else {
			String text = rootNode.getText();
			return computeLineBreaks(text);
		}
	}
	
	/**
	 * <p>Computes the line breaks in the given text and returns an array of offsets.
	 * A line break is either <code>\r\n</code>, <code>\n</code>, or a single <code>\r</code>.</p>
	 * This implementation was heavily adapted from <code>org.eclipse.jface.text.DefaultLineTracker</code>.
	 * It follows the semantics of {@link LineNumberReader}.
	 * 
	 * The offsets in the returned array are the offset of the line break itself. If the line-break contains
	 * of two characters ('\r\n'), it's the offset of the first char ('\r').
	 * 
	 * @param text the text whose line-breaks should be computed. May not be <code>null</code>.
	 * @return the array of line-break offsets in the given text. May be empty but is never <code>null</code>.
	 */
	protected static int[] computeLineBreaks(String text) {
		// initially we assume an average of 20 chars per line
		List<Integer> list = Lists.newArrayListWithExpectedSize(text.length() / 20 + 1);
		char ch;
		int length= text.length();
		for (int i= 0; i < length; i++) {
			ch= text.charAt(i);
			if (ch == '\r') {
				list.add(i);
				if (i + 1 < length) {
					if (text.charAt(i + 1) == '\n') {
						i++;
					}
				}
			} else if (ch == '\n') {
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i).intValue();
		}
		return result;
	}
	
}
