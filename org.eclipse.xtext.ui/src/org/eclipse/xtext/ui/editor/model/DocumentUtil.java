/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentUtil {
	
	/**
	 * searches backwards for the given string within the same partition type
	 * @return the region of the match or <code>null</code> if no match were found
	 */
	public IRegion searchBackwardsInSamePartition(String toFind, IDocument document, int endOffset) throws BadLocationException {
		return searchBackwardsInSamePartition(toFind, document.get(), document, endOffset);
	}
	
	/**
	 * searches backwards for the given string within the same partition type
	 * @return the region of the match or <code>null</code> if no match were found
	 * @since 2.4
	 */
	public IRegion searchBackwardsInSamePartition(String toFind, String documentText, IDocument document, int endOffset) throws BadLocationException {
		if (endOffset < 0) {
			return null;
		}
		int length = toFind.length();
		String text = preProcessSearchString(documentText);
		ITypedRegion partition = document.getPartition(endOffset);
		int indexOf = text.lastIndexOf(toFind, endOffset - length);
		while (indexOf >= 0) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf, length);
			}
			indexOf = text.lastIndexOf(toFind, partition2.getOffset() - length);
		}
		String trimmed = toFind.trim();
		if (trimmed.length() > 0 && trimmed.length() != length) {
			return searchBackwardsInSamePartition(trimmed, documentText, document, endOffset);
		}
		return null;
	}
	
	protected String preProcessSearchString(String string) {
		return string;
	}

	/**
	 * searches for the given string within the same partition type
	 * @return the region of the match or <code>null</code> if no match were found
	 */
	public IRegion searchInSamePartition(String toFind, IDocument document, int startOffset) throws BadLocationException {
		return searchInSamePartition(toFind, document.get(), document, startOffset);
	}
	
	/**
	 * searches for the given string within the same partition type
	 * 
	 * @return the region of the match or <code>null</code> if no match were found
	 * @since 2.4
	 */
	public IRegion searchInSamePartition(String toFind, String documentText, IDocument document, int startOffset)
			throws BadLocationException {
		if (startOffset >= document.getLength()) {
			return null;
		}
		String text = preProcessSearchString(documentText);
		ITypedRegion partition = document.getPartition(startOffset);
		
		int indexOf = text.indexOf(toFind, getOffset(toFind, startOffset));
		while (indexOf >= 0 && indexOf < document.getLength()) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf, toFind.length());
			}
			indexOf = text.indexOf(toFind, partition2.getOffset() + partition2.getLength());
		}
		String trimmed = toFind.trim();
		if (trimmed.length() > 0 && trimmed.length() != toFind.length()) {
			return searchInSamePartition(trimmed, documentText, document, startOffset);
		}
		return null;
	}

	private int getOffset(String toFind, int startOffset) {
		int whitespacesCount = getWhitespacesCount(toFind);
		return Math.max(startOffset - whitespacesCount, 0);
	}

	private int getWhitespacesCount(String toFind) {
		int whitespacesCount = 0;
		while (toFind.length() > whitespacesCount && Character.isWhitespace(toFind.charAt(whitespacesCount))) {
			whitespacesCount++;
		}
		return whitespacesCount;
	}

	public boolean isSameLine(IDocument doc, int offset, int offset2) throws BadLocationException {
		return doc.getLineOfOffset(offset)==doc.getLineOfOffset(offset2);
	}
	
	public int findNextOffSetInPartition(IDocument doc, int partitionOffSet, int minIndex) throws BadLocationException {
		ITypedRegion partition = doc.getPartition(partitionOffSet);
		ITypedRegion partition2 = doc.getPartition(minIndex);
		if (partition.getType().equals(partition2.getType()) || partition2.getLength() == 0) {
			return minIndex;
		} else {
			return findNextOffSetInPartition(doc, partitionOffSet, minIndex + partition2.getLength());
		}
	}
}
