/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Introduced FoldedPosition
 */
public class DefaultFoldingRegionAcceptor implements IFoldingRegionAcceptorExtension<ITextRegion> {
	private static final Logger log = Logger.getLogger(DefaultFoldingRegionAcceptor.class);
	private Collection<FoldedPosition> result;
	private IXtextDocument xtextDocument;

	public DefaultFoldingRegionAcceptor(IXtextDocument document, Collection<FoldedPosition> result) {
		this.result = result;
		this.xtextDocument = document;
	}

	/**
	 * @since 2.8
	 */
	@Override
	public void accept(int offset, int length, boolean initiallyFolded, ITextRegion significantRegion) {
		IRegion position = getLineRegion(offset, length);
		try {
			if (xtextDocument != null && significantRegion != null) {
				int firstLine = xtextDocument.getLineOfOffset(significantRegion.getOffset());
				int lastLine = xtextDocument.getLineOfOffset(significantRegion.getOffset()+significantRegion.getLength());
				if (firstLine != lastLine) {
					int endOffset = xtextDocument.getLineOffset(firstLine)+xtextDocument.getLineLength(firstLine);
					significantRegion = new TextRegion(significantRegion.getOffset(), endOffset - significantRegion.getOffset());
				}
			}
		} catch (BadLocationException e) {
		}
		FoldedPosition foldingRegion = newFoldedPosition(position, significantRegion);
		if (foldingRegion != null) {
			if (foldingRegion instanceof DefaultFoldedPosition) {
				((DefaultFoldedPosition) foldingRegion).setInitiallyFolded(initiallyFolded);
			}
			result.add(foldingRegion);
		}
	}
	
	@Override
	public void accept(int offset, int length, ITextRegion significantRegion) {
		accept(offset, length, false, significantRegion);
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public void accept(int offset, int length, boolean initiallyFolded) {
		accept(offset, length, initiallyFolded, null);
	}
	
	@Override
	public void accept(int offset, int length) {
		accept(offset, length, false, null);
	}

	protected IRegion getLineRegion(int offset, int length) {
		IRegion position = null;
		try {
			int startLine = xtextDocument.getLineOfOffset(offset);
			int endLine = xtextDocument.getLineOfOffset(offset + length);
			if (startLine < endLine) {
				int start = xtextDocument.getLineOffset(startLine);
				int end = xtextDocument.getLineOffset(endLine) + xtextDocument.getLineLength(endLine);
				position = new Region(start, end - start);
			}
		} catch (BadLocationException e) {
			if (log.isInfoEnabled())
				log.info(e.getMessage(), e);
		}
		return position;
	}

	/**
	 * @return a freshly created {@link FoldedPosition}
	 */
	protected FoldedPosition newFoldedPosition(IRegion region, ITextRegion significantRegion) {
		return newFoldedPosition(region, significantRegion, false);
	}
	
	/**
	 * @return a freshly created {@link FoldedPosition}
	 * 
	 * @since 2.8
	 * @deprecated use / override {@link #newFoldedPosition(IRegion, ITextRegion)} instead
	 */
	@Deprecated
	protected FoldedPosition newFoldedPosition(IRegion region, ITextRegion significantRegion, boolean initiallyFolded) {
		if (region == null)
			return null;
		if (significantRegion != null)
			return new DefaultFoldedPosition(region.getOffset(), region.getLength(), significantRegion.getOffset() - region.getOffset(), significantRegion.getLength(), initiallyFolded);
		return new DefaultFoldedPosition(region.getOffset(), region.getLength(), DefaultFoldedPosition.UNSET, DefaultFoldedPosition.UNSET, initiallyFolded);
	}

}
