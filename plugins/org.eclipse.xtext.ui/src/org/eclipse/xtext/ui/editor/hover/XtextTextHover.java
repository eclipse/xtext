/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.service.IHoverInfo;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTextHover extends DefaultTextHover implements ITextHoverExtension, ITextHoverExtension2 {
	/**
	 * 
	 */
	private IEditorModelProvider editorModelProvider;

	private IHoverInfo hoverInfo;

	/**
	 * @param sourceViewer
	 * @param editorModelProvider
	 */
	public XtextTextHover(ISourceViewer sourceViewer, IEditorModelProvider editorModelProvider, IHoverInfo hoverInfo) {
		super(sourceViewer);
		this.editorModelProvider = editorModelProvider;
		this.hoverInfo = hoverInfo;
	}

	/*
	 * @see org.eclipse.jface.text.ITextHoverExtension#getHoverControlCreator()
	 */
	public IInformationControlCreator getHoverControlCreator() {
		return new IInformationControlCreator() {
			public IInformationControl createInformationControl(Shell parent) {
				return new XtextInformationControl(parent, EditorsUI.getTooltipAffordanceString(), hoverInfo);
			}
		};
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		return new Region(offset, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.ITextHoverExtension2#getHoverInfo2(org.eclipse
	 * .jface.text.ITextViewer, org.eclipse.jface.text.IRegion)
	 */
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		return hoverInfo.getHoverInfo(textViewer, hoverRegion, editorModelProvider);
	}

}