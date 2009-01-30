/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetectorExtension;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetectorExtension2;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class DelegatingHyperlinkDetector implements IHyperlinkDetector, IHyperlinkDetectorExtension, IHyperlinkDetectorExtension2 {

	@Inject(optional=true)
	private IHyperlinkDetector delegate;

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		if (delegate==null)
			return null;
		return delegate.detectHyperlinks(textViewer, region, canShowMultipleHyperlinks);
	}

	public void dispose() {
		if (delegate instanceof IHyperlinkDetectorExtension)
			((IHyperlinkDetectorExtension)delegate).dispose();
	}

	public int getStateMask() {
		if (delegate instanceof IHyperlinkDetectorExtension2)
			return ((IHyperlinkDetectorExtension2)delegate).getStateMask();
		return -1;
	}

	
}
