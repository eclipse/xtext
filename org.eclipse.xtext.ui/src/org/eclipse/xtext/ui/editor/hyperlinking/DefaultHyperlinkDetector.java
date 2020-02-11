/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
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
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;

	@Override
	public IHyperlink[] detectHyperlinks(final ITextViewer textViewer, final IRegion region, final boolean canShowMultipleHyperlinks) {
		return xtextDocumentUtil.getXtextDocument(textViewer).tryReadOnly(new IUnitOfWork<IHyperlink[],XtextResource>() {
			@Override
			public IHyperlink[] exec(XtextResource resource) throws Exception {
				if (helper instanceof ISourceViewerAware && textViewer instanceof ISourceViewer) {
					((ISourceViewerAware) helper).setSourceViewer((ISourceViewer) textViewer);
				}
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
