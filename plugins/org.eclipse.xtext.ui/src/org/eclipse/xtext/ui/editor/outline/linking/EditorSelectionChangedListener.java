/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * This listener listens to selections in the text editor and will update the
 * outline selection accordingly.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public final class EditorSelectionChangedListener extends AbstractSelectionChangedListener {

	public EditorSelectionChangedListener(XtextContentOutlinePage outlinePage) {
		super(outlinePage);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (outlinePage.isLinkingEnabled() && !selection.isEmpty() && selection instanceof ITextSelection) {

			final ITextSelection textSel = (ITextSelection) selection;

			getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource resource) throws Exception {
					IParseResult parseResult = resource.getParseResult();
					Assert.isNotNull(parseResult);
					CompositeNode rootNode = parseResult.getRootNode();

					// Get the current element from the offset
					int offset = textSel.getOffset();
					AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, offset);

					// Synchronize the outline page
					outlinePage.synchronizeOutlinePage(node);
				}
			});

		}
	}

}
