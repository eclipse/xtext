/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.doubleClicking;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;

/**
 * <p>
 * Custom {@link AbstractPartitionDoubleClickSelector partition selector} that allows to strip a fixed set of characters
 * from the beginning and the end of a partition.
 * </p>
 * <p>
 * The implementation was heavily adapted from
 * <code>org.eclipse.jdt.internal.ui.text.java.PartitionDoubleClickSelector</code>
 * </p>
 * .
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
/* 
 * @see org.eclipse.jdt.internal.ui.text.java.PartitionDoubleClickSelector
 */
public class FixedCharCountPartitionDoubleClickSelector extends AbstractPartitionDoubleClickSelector {

	private int fLeftBorder;
	private int fRightBorder;

	/**
	 * Creates a new partition double click selector for the given document partitioning.
	 * 
	 * @param partitioning
	 *            the document partitioning
	 * @param leftBorder
	 *            number of characters to ignore from the left border of the partition
	 * @param rightBorder
	 *            number of characters to ignore from the right border of the partition
	 */
	public FixedCharCountPartitionDoubleClickSelector(String partitioning, int leftBorder, int rightBorder) {
		super(partitioning);
		fLeftBorder = leftBorder;
		fRightBorder = rightBorder;
	}

	@Override
	protected IRegion getSelectedRegion(IDocument document, ITypedRegion completePartition) throws BadLocationException {
		if (fLeftBorder == 0 && fRightBorder == 0)
			return completePartition;
		if (fRightBorder == -1) {
			String delimiter = document.getLineDelimiter(document.getLineOfOffset(completePartition.getOffset()
					+ completePartition.getLength() - 1));
			if (delimiter == null)
				fRightBorder = 0;
			else
				fRightBorder = delimiter.length();
		}
		return new Region(completePartition.getOffset() + fLeftBorder, completePartition.getLength() - fLeftBorder
				- fRightBorder);
	}
}
