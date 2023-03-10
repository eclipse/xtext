/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.jface.text.ITextViewer;

/**
 * An action to handle emacs-like marked regions.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextViewerMarkAction extends TextViewerAction {

	/** Sets the mark. */
	public static final int SET_MARK = 0;
	/** Clears the mark. */
	public static final int CLEAR_MARK = 1;
	/** Swaps the mark and the cursor position. */
	public static final int SWAP_MARK = 2;

	/** The mark action type. */
	private final int fType;
	private MarkRegionTargetWithoutStatusline markRegionTarget;

	/**
	 * Constructor for MarkAction.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text editor
	 * @param type
	 *            the mark action type, must be one of <code>SET_MARK</code>, <code>CLEAR_MARK</code> or
	 *            <code>SWAP_MARK</code>.
	 */
	public TextViewerMarkAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int type) {
		super(bundle, prefix, viewer);
		fType = type;
	}

	@Override
	public void run() {
		ITextViewer editor = getTextViewer();
		if (editor == null || markRegionTarget == null)
			return;

		switch (fType) {
			case SET_MARK:
				markRegionTarget.setMarkAtCursor(true);
				break;

			case CLEAR_MARK:
				markRegionTarget.setMarkAtCursor(false);
				break;

			case SWAP_MARK:
				markRegionTarget.swapMarkAndCursor();
				break;
		}
	}

	@Override
	public void setViewer(ITextViewer viewer) {
		super.setViewer(viewer);
		if (viewer != null) {
			markRegionTarget = new MarkRegionTargetWithoutStatusline(viewer);
		} else {
			markRegionTarget = null;
		}
	}
}
