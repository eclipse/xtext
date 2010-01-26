/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.findrefs;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class FindReferencesHandler extends AbstractHandler {

	@Inject
	private Provider<ReferenceQuery> queryProvider;

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = (XtextEditor) HandlerUtil.getActiveEditor(event);
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();

			URI targetEObjectURI = getSelectedEObjectURI(editor, selection);
			NewSearchUI.activateSearchResultView();
			ReferenceQuery referenceQuery = queryProvider.get();
			referenceQuery.setEObjectTargetURI(targetEObjectURI);
			NewSearchUI.runQueryInBackground(referenceQuery);
		} catch (Exception e) {
			LOG.error("Error finding references", e);
		}
		return null;
	}

	private URI getSelectedEObjectURI(XtextEditor editor, final ITextSelection selection) {
		return editor.getDocument().readOnly(new IUnitOfWork<URI, XtextResource>() {
			public URI exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				if (parseResult != null) {
					CompositeNode rootNode = parseResult.getRootNode();
					if (rootNode != null) {
						AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, selection
								.getOffset());
						if (node != null) {
							EObject selectedElement = NodeUtil.getNearestSemanticObject(node);
							if (selectedElement != null) {
								return EcoreUtil.getURI(selectedElement);
							}
						}
					}
				}
				return null;
			}
		});
	}

}
