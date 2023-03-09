/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.jface.text.IMarkRegionTarget;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.swt.graphics.Point;

/**
 * Implementation of <code>IMarkRegionTarget</code> using <code>ITextViewer</code>.
 * 
 * This class was initially copied from {@link org.eclipse.ui.texteditor.MarkRegionTarget}.
 * 
 * @since 2.3
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MarkRegionTargetWithoutStatusline implements IMarkRegionTarget {

	/** The text viewer. */
	private final ITextViewer fViewer;

	/**
	 * Creates a MarkRegionTargetWithoutStatusline.
	 * 
	 * @param viewer
	 *            the text viewer
	 */
	public MarkRegionTargetWithoutStatusline(ITextViewer viewer) {
		fViewer = viewer;
	}

	@Override
	public void setMarkAtCursor(boolean set) {

		if (!(fViewer instanceof ITextViewerExtension))
			return;

		ITextViewerExtension viewerExtension = ((ITextViewerExtension) fViewer);

		if (set) {
			Point selection = fViewer.getSelectedRange();
			viewerExtension.setMark(selection.x);
		} else {
			viewerExtension.setMark(-1);
		}
	}

	@Override
	public void swapMarkAndCursor() {

		if (!(fViewer instanceof ITextViewerExtension))
			return;

		ITextViewerExtension viewerExtension = ((ITextViewerExtension) fViewer);

		int markPosition = viewerExtension.getMark();
		if (markPosition == -1) {
			return;
		}

		if (!isVisible(fViewer, markPosition)) {
			return;
		}

		Point selection = fViewer.getSelectedRange();
		viewerExtension.setMark(selection.x);

		fViewer.setSelectedRange(markPosition, 0);
		fViewer.revealRange(markPosition, 0);
	}

	/**
	 * Tells whether the given offset is visible in the given text viewer.
	 * 
	 * @param viewer
	 *            the text viewer
	 * @param offset
	 *            the offset to check
	 * @return <code>true</code> if the given offset is visible in the given text viewer
	 */
	protected boolean isVisible(ITextViewer viewer, int offset) {
		if (viewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5) viewer;
			return extension.modelOffset2WidgetOffset(offset) >= 0;
		}
		IRegion region = viewer.getVisibleRegion();
		int vOffset = region.getOffset();
		return (vOffset <= offset && offset <= vOffset + region.getLength());
	}
}
