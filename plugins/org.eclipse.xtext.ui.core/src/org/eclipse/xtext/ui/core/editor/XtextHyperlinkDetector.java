/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * Represents an implementation of interface {@link IHyperlinkDetector} to find
 * and convert {@link CrossReference elements}, at a given location, to
 * <code>IHyperlink</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector
 * @see org.eclipse.jface.text.hyperlink.IHyperlink
 */
public class XtextHyperlinkDetector implements IHyperlinkDetector {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion, boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, boolean canShowMultipleHyperlinks) {

		return ((IXtextDocument)textViewer.getDocument()).readOnly(new UnitOfWork<IHyperlink[]>() {
			public IHyperlink[] exec(XtextResource resource) throws Exception {
				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				final LeafNode currentNode = 
					(LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(), region.getOffset());

				if (currentNode.getGrammarElement() instanceof CrossReference) {
					 return new IHyperlink[] { new IHyperlink() {

						public IRegion getHyperlinkRegion() {
							return new Region(currentNode.getTotalOffset(), currentNode.getTotalLength());
						}

						public String getHyperlinkText() {
							return currentNode.getText();
						}

						public String getTypeLabel() {
							return null;
						}

						public void open() {
							new OpenDeclarationAction(currentNode).run();
						}
					} };
				}

				return null;
			}
		});
	}

}
