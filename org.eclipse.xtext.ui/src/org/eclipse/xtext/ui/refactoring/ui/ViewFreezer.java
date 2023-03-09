/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * Renders the current editor to a picture that hides the nifty details going on in the documents when the refactoring
 * changes are applied. Same mechanism as in JDT.
 * 
 * @author Holger Schill - Initial contribution and API
 */
public class ViewFreezer {

	protected ISourceViewer sourceViewer;
	protected Image image = null;
	protected Label label = null;

	public ViewFreezer(ISourceViewer viewer) {
		this.sourceViewer = viewer;
	}

	public void freeze() {
		release();
		if (sourceViewer instanceof SourceViewer) {
			Control viewerControl = ((SourceViewer) sourceViewer).getControl();
			if (viewerControl instanceof Composite) {
				Composite composite = (Composite) viewerControl;
				Display display = composite.getDisplay();

				// Flush pending redraw requests:
				while (!display.isDisposed() && display.readAndDispatch()) {
				}

				// Copy editor area:
				GC gc = new GC(composite);
				Point size;
				try {
					size = composite.getSize();
					image = new Image(gc.getDevice(), size.x, size.y);
					gc.copyArea(image, 0, 0);
				} finally {
					gc.dispose();
					gc = null;
				}

				// Persist editor area while executing refactoring:
				label = new Label(composite, SWT.NONE);
				label.setImage(image);
				label.setBounds(0, 0, size.x, size.y);
				label.moveAbove(null);
			}
		}
	}

	public void release() {
		if (label != null)
			label.dispose();
		if (image != null)
			image.dispose();
	}

}
