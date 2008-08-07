/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.utils.EditorModelUtil;
import org.eclipse.xtext.ui.service.IHyperlinkCreator;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextHyperlinkDetector extends AbstractHyperlinkDetector {

	private IEditorModel editorModel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(
	 * org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion,
	 * boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, boolean canShowMultipleHyperlinks) {
		Object adapter = getAdapter(IEditorModel.class);
		if (adapter instanceof IEditorModel) {
			editorModel = (IEditorModel) adapter;
			IHyperlinkCreator hyperLinkService = null;
			try {
				// FIXME create
				// ServiceRegistry.hasService(IServiceScope,IServiceInterface)
				hyperLinkService = ServiceRegistry.getService(editorModel.getLanguageDescriptor(),
						IHyperlinkCreator.class);
			}
			catch (Throwable t) {
			}
			if (hyperLinkService != null)
				return hyperLinkService.createHyperlinks(textViewer, region);
			// TODO remove this debug dummy
			else
				return new IHyperlink[] { new IHyperlink() {

					public IRegion getHyperlinkRegion() {
						AbstractNode currentNodeByOffset = EditorModelUtil.findLeafNodeAtOffset(
								(CompositeNode) editorModel.getParseTreeRootNode(), region.getOffset() + 1);
						if (currentNodeByOffset != null
								&& !(currentNodeByOffset.getGrammarElement() instanceof LexerRule && "WS"
										.equals(((LexerRule) currentNodeByOffset.getGrammarElement()).getName()))) {
							return new Region(currentNodeByOffset.getOffset(), currentNodeByOffset.getLength());
						}
						return region;
					}

					public String getHyperlinkText() {
						return "hyperlink text for " + editorModel.getLanguageDescriptor().getId();
					}

					public String getTypeLabel() {
						return "label";
					}

					public void open() {

					}
				} };
		}
		return null;
	}
}
