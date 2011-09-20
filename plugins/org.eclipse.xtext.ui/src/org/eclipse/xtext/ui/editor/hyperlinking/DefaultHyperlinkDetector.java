/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * Represents an implementation of interface {@link IHyperlinkDetector} to find
 * and convert {@link org.eclipse.xtext.CrossReference elements}, at a given location, to
 * <code>IHyperlink</code>.
 *
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector
 * @see org.eclipse.jface.text.hyperlink.IHyperlink
 */
public class DefaultHyperlinkDetector implements IHyperlinkDetector {

	@Inject
	private IHyperlinkHelper helper;

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, final boolean canShowMultipleHyperlinks) {
		return ((IXtextDocument)textViewer.getDocument()).readOnly(new IUnitOfWork<IHyperlink[],XtextResource>() {
			public IHyperlink[] exec(XtextResource resource) throws Exception {
				return helper.createHyperlinksByOffset(resource, region.getOffset(), canShowMultipleHyperlinks);
			}
		});
	}

	public void setHelper(IHyperlinkHelper helper) {
		this.helper = helper;
	}

	public IHyperlinkHelper getHelper() {
		return helper;
	}

}
