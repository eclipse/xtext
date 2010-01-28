/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.findrefs;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class FindReferencesHandler extends AbstractHandler {

	private class EObjectResolver implements IUnitOfWork<IEObjectDescription, XtextResource> {
		private final ITextSelection selection;

		private EObjectResolver(ITextSelection selection) {
			this.selection = selection;
		}

		public IEObjectDescription exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult != null && parseResult.getRootNode() != null) {
				AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(),
						selection.getOffset());
				while (node != null) {
					if (node.getGrammarElement() instanceof CrossReference) {
						EObject referenceOwner = NodeUtil.getNearestSemanticObject(node);
						EReference eReference = GrammarUtil.getReference((CrossReference) node.getGrammarElement(),
								referenceOwner.eClass());
						try {
							List<EObject> linkedEObjects = linkingService.getLinkedObjects(referenceOwner, eReference,
									node);
							if (!linkedEObjects.isEmpty()) {
								EObject resolved = EcoreUtil.resolve(linkedEObjects.get(0), referenceOwner);
								IScope scope = scopeProvider.getScope(referenceOwner, eReference);
								return scope.getContentByEObject(resolved);
							} else {
								return null;
							}
						} catch (IllegalNodeException ex) {
							return null;
						}
					} else if (node.getElement() != null) {
						IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(state
								.getURI());
						Iterator<IEObjectDescription> eObjectDescriptors = resourceDescription.getExportedObjectsForEObject(node.getElement()).iterator();
						if(eObjectDescriptors.hasNext()) {
							return eObjectDescriptors.next();
						}
					}
					node = node.getParent();
				}
			}
			return null;
		}
	}

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private Provider<ReferenceQuery> queryProvider;

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = (XtextEditor) HandlerUtil.getActiveEditor(event);
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();

			IEObjectDescription eObjectDescription = editor.getDocument().readOnly(new EObjectResolver(selection));
			if (eObjectDescription != null) {
				ReferenceQuery referenceQuery = queryProvider.get();
				String label = "Xtext References to " + eObjectDescription.getQualifiedName();
				Iterator<IStorage> storages = storage2UriMapper.getStorages(eObjectDescription.getEObjectURI()).iterator();
				if (storages.hasNext()) {
					label += " (" + storages.next().getFullPath().toString() + ")";
				}
				referenceQuery.init(eObjectDescription.getEObjectURI(), label);
				NewSearchUI.activateSearchResultView();
				NewSearchUI.runQueryInBackground(referenceQuery);
			} 
		} catch (Exception e) {
			LOG.error("Error finding references", e);
		}
		return null;
	}

}
