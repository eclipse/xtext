/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;

/**
 * @author Patrick Schoenbach - Initial API and implementation
 */
public abstract class AbstractHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2, ISourceViewerAware {

	protected ISourceViewer sourceViewer;

	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;		
	}

	public IDocument getDocument() {
		return sourceViewer.getDocument();
	}


	/**
	 *@deprecated Use {@link #getHoverInfo2(ITextViewer, IRegion)} instead
	 */
	@Override
	@Deprecated
	public String getHoverInfo(final ITextViewer textViewer, final IRegion hoverRegion) {
		Object o = getHoverInfo2(textViewer, hoverRegion);
		if (o!=null)
			return o.toString();
		return null;
	}

	public int getLineNumber (final ITextViewer textViewer, final IRegion hoverRegion) throws BadLocationException {
		return textViewer.getDocument().getLineOfOffset(hoverRegion.getOffset());
	}


	@Override
	public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		final Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y)
			return new Region(selection.x, selection.y);
		return new Region(offset, 0);
	}
	
	/*
	 * @see ITextHoverExtension#getHoverControlCreator()
	 * @since 3.0
	 */
	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return new IInformationControlCreator() {
			@Override
			public IInformationControl createInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, EditorsUI.getTooltipAffordanceString());
			}
		};
	}

}
