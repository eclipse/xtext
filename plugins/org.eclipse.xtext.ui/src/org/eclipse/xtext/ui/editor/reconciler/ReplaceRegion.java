/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.ui.editor.formatting.ContentFormatterFactory;

/**
 * Legacy class; should not be used any longer. Clients should use an {@link org.eclipse.xtext.util.ReplaceRegion}
 * instead. TODO: deprecate as soon as the {@link ContentFormatterFactory}'s API can be changed.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplaceRegion implements ITypedRegion {

	private static final Logger log = Logger.getLogger(ReplaceRegion.class);

	public static final String REPLACE = "__replace";
	private int offset;
	private int originalLength;
	private String text;

	/**
	 * @param offset
	 * @param originalLength
	 * @param text
	 */
	public ReplaceRegion(int offset, int originalLength, String text) {
		this.offset = offset;
		this.originalLength = originalLength;
		this.text = text;
	}

	public String getType() {
		return REPLACE;
	}

	public void mergeWith(ReplaceRegion next, Object textAfterNextChange) {
		try {
			// calculate new region to be replaced
			int mergedOffset = Math.min(offset, toOriginalIndex(next.offset));
			int mergedEnd = Math.max(offset + originalLength, toOriginalIndex(next.offset + next.originalLength));
			int mergedLength = mergedEnd - mergedOffset;
			
			// calculate new text
			int replacementOffset = Math.min(toReplacedIndex(offset), next.offset);
			int replacementEnd = Math.max(next.toReplacedIndex(offset + text.length()), next.offset + next.text.length());
			if (textAfterNextChange instanceof IDocument) {
				text = ((IDocument) textAfterNextChange).get(replacementOffset, replacementEnd - replacementOffset);
			}
			else {
				text = ((String) textAfterNextChange).substring(replacementOffset, replacementEnd);
			}
			offset = mergedOffset;
			originalLength = mergedLength;
		}
		catch (Exception e) {
			log.error("Cannot merge ReplaceRegions", e);
		}
	}

	protected int toOriginalIndex(int indexAfterReplace) {
		return toOriginalIndex(indexAfterReplace, offset, originalLength, text.length());
	}

	protected int toReplacedIndex(int originalIndex) {
		return toOriginalIndex(originalIndex, offset, text.length(), originalLength);
	}

	private static int toOriginalIndex(int indexAfterReplace, int offset, int originalLength, int replacementLength) {
		if (originalLength < replacementLength) {
			if (indexAfterReplace <= offset + originalLength) {
				return indexAfterReplace;
			}
			if (indexAfterReplace < offset + replacementLength) {
				return offset + originalLength;
			}
			return indexAfterReplace + (originalLength - replacementLength);
		}
		else if (originalLength > replacementLength) {
			if (indexAfterReplace <= offset + replacementLength) {
				return indexAfterReplace;
			}
			return indexAfterReplace + (originalLength - replacementLength);
		}
		return indexAfterReplace + (originalLength - replacementLength);
	}

	public int getOffset() {
		return offset;
	}

	public String getText() {
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.IRegion#getLength()
	 */
	public int getLength() {
		return originalLength;
	}

}
