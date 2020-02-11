/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class OpenDeclarationHandler extends AbstractHandler {
	
	@Inject
	private IHyperlinkDetector detector;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			ITextSelection selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
	
			IRegion region = new Region(selection.getOffset(), selection.getLength());
	
			ISourceViewer internalSourceViewer = xtextEditor.getInternalSourceViewer();
	
			IHyperlink[] hyperlinks = getDetector().detectHyperlinks(internalSourceViewer, region, false);
			if (hyperlinks != null && hyperlinks.length > 0) {
				IHyperlink hyperlink = hyperlinks[0];
				hyperlink.open();
			}
		}		
		return null;
	}

	public void setDetector(IHyperlinkDetector detector) {
		this.detector = detector;
	}

	public IHyperlinkDetector getDetector() {
		return detector;
	}

}
