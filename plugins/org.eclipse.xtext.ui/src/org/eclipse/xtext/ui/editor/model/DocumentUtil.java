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
		int indexOf = document.get(0, endOffset).lastIndexOf(toFind);
		while (indexOf>=0) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf,toFind.length());
			} 
			indexOf=document.get(0, partition2.getOffset()).lastIndexOf(toFind);
		}
		return null;
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
		int indexOf = document.get().substring(startOffset).indexOf(toFind);
		while (indexOf<document.getLength()) {
			ITypedRegion partition2 = document.getPartition(indexOf);
			if (partition2.getType().equals(partition.getType())) {
				return new Region(indexOf+ignoredPrefix,toFind.length());
			}
			ignoredPrefix = partition2.getOffset()+partition2.getLength();
			indexOf=document.get().substring(ignoredPrefix).indexOf(toFind);
		}
		return null;
	}

	public boolean isSameLine(IDocument doc, int offset, int offset2) throws BadLocationException {
		return doc.getLineOfOffset(offset)==doc.getLineOfOffset(offset2);
	}
}
