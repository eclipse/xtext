/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

import com.google.inject.Inject;

/**
 * Represents an implementation of interface {@link IHyperlinkDetector} to find
 * and convert {@link CrossReference elements}, at a given location, to
 * <code>IHyperlink</code>.
 *
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector
 * @see org.eclipse.jface.text.hyperlink.IHyperlink
 */
public class DefaultHyperlinkDetector extends org.eclipse.core.commands.AbstractHandler implements IHyperlinkDetector {

	private final HyperlinkHelper helper;

	@Inject
	public DefaultHyperlinkDetector(HyperlinkHelper helper) {
		super();
		this.helper = helper;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion, boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, final boolean canShowMultipleHyperlinks) {
		return ((IXtextDocument)textViewer.getDocument()).readOnly(new IUnitOfWork<IHyperlink[],XtextResource>() {
			public IHyperlink[] exec(XtextResource resource) throws Exception {
				return helper.createHyperlinksByOffset(resource, region.getOffset(), canShowMultipleHyperlinks);
			}
		});
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor activeEditor = (XtextEditor) HandlerUtil.getActiveEditor(event);
		final IXtextDocument document = activeEditor.getDocument();
		final int offset = ((StyledText) activeEditor.getAdapter(Control.class)).getCaretOffset();
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				OpenDeclarationAction action = helper.getOpenDeclarationAction(resource, offset);
				action.run();
			}
		});
		return this;
	}

}
