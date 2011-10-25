/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		if (endOffset<0)
			return null;
		ITypedRegion partition = document.getPartition(endOffset);
		int indexOf = preProcessSearchString(document.get(0, endOffset)).lastIndexOf(toFind);
		while (indexOf>=0) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf,toFind.length());
			} 
			indexOf=preProcessSearchString(document.get(0, partition2.getOffset())).lastIndexOf(toFind);
		}
		String trimmed = toFind.trim();
		if (trimmed.length() > 0 && trimmed.length() != toFind.length()) {
			return searchBackwardsInSamePartition(trimmed, document, endOffset);
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
		if (startOffset>=document.getLength())
			return null;
		ITypedRegion partition = document.getPartition(startOffset);
		int ignoredPrefix = startOffset;
		int subtractMe = 0;
		while(toFind.length() > subtractMe && Character.isWhitespace(toFind.charAt(subtractMe)))
			subtractMe++;
		ignoredPrefix = Math.max(ignoredPrefix - subtractMe, 0);
		int indexOf = preProcessSearchString(document.get().substring(ignoredPrefix)).indexOf(toFind);
		if (indexOf!=-1)
			indexOf+=ignoredPrefix;
		while (indexOf>=0 && indexOf<document.getLength()) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf,toFind.length());
			}
			ignoredPrefix = partition2.getOffset()+partition2.getLength();
			indexOf=preProcessSearchString(document.get().substring(ignoredPrefix)).indexOf(toFind);
			if (indexOf!=-1)
				indexOf+=ignoredPrefix;
		}
		String trimmed = toFind.trim();
		if (trimmed.length() > 0 && trimmed.length() != toFind.length()) {
			return searchInSamePartition(trimmed, document, startOffset);
		}
		return null;
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
