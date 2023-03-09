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
import org.eclipse.jface.text.TextUtilities;

/**
 * <p>This {@link org.eclipse.jface.text.ITextDoubleClickStrategy strategy} treats partition boundaries 
 * in a special way. It allows to select a complete partition at once.</p>
 * <p>Implementors may override {@link #getSelectedRegion(IDocument, ITypedRegion)} to customize the
 * contents of the partition that should be selected.</p>
 * <p>The implementation was heavily adapted from <code>org.eclipse.jdt.internal.ui.text.java.PartitionDoubleClickSelector</code></p>
 * 
 * @see FixedCharCountPartitionDoubleClickSelector
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPartitionDoubleClickSelector extends AbstractWordAwareDoubleClickStrategy {

	private String fPartitioning;

	/**
	 * Creates a new partition double click selector for the given document partitioning.
	 * 
	 * @param partitioning the document partitioning
	 */
	protected AbstractPartitionDoubleClickSelector(String partitioning) {
		fPartitioning= partitioning;
	}

	/*
	 * @see org.eclipse.jface.text.DefaultTextDoubleClickStrategy#findExtendedDoubleClickSelection(org.eclipse.jface.text.IDocument, int)
	 */
	@Override
	protected IRegion findExtendedDoubleClickSelection(IDocument document, int offset) {
		IRegion match= super.findExtendedDoubleClickSelection(document, offset);
		if (match != null)
			return match;

		try {
			ITypedRegion region= TextUtilities.getPartition(document, fPartitioning, offset, true);
			if (offset == region.getOffset() + 1 || offset == region.getOffset() + region.getLength() - 1) {
				return getSelectedRegion(document, region);
			}
		} catch (BadLocationException e) {
			return null;
		}
		return null;
	}

	protected IRegion getSelectedRegion(IDocument document, ITypedRegion completePartition) throws BadLocationException {
		return completePartition;
	}
	
	
}
