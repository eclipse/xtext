/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.findrefs;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class FindReferencesHandler extends AbstractHandler {
	

	private class EObjectResolver implements IUnitOfWork<Void, XtextResource> {
		private final ITextSelection selection;

		private String name;
		
		private URI uri;
				
		private EObjectResolver(ITextSelection selection) {
			this.selection = selection;
		}

		public java.lang.Void exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult != null) {
				CompositeNode rootNode = parseResult.getRootNode();
				if (rootNode != null) {
					AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, selection
							.getOffset());
					if (node != null) {
						EObject selectedElement = NodeUtil.getNearestSemanticObject(node);
						if (selectedElement != null) {
							uri = EcoreUtil.getURI(selectedElement);
							name = qualifiedNameProvider.getQualifiedName(selectedElement);
						}
					}
				}
			}
			return null;
		}
		
		public String getName() {
			return name;
		}
		
		public URI getURI() {
			return uri;
		}
	}

	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private Provider<ReferenceQuery> queryProvider;

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = (XtextEditor) HandlerUtil.getActiveEditor(event);
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();

			EObjectResolver resolver = new EObjectResolver(selection);
			editor.getDocument().readOnly(resolver);
			NewSearchUI.activateSearchResultView();
			ReferenceQuery referenceQuery = queryProvider.get();			
			String label = "Xtext References to " + resolver.getName();
			Iterator<IStorage> storages = storage2UriMapper.getStorages(resolver.getURI()).iterator();
			if(storages.hasNext()) {
				label += " (" + storages.next().getFullPath().toString() + ")";
			}
			referenceQuery.init(resolver.getURI(), label);
			NewSearchUI.runQueryInBackground(referenceQuery);
		} catch (Exception e) {
			LOG.error("Error finding references", e);
		}
		return null;
	}


}
