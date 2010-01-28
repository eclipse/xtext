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
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
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
			EObject element = EObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
			if (element != null) {
				final URI eObjectURI = EcoreUtil.getURI(element);
				IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
						.trimFragment());
				Iterator<IEObjectDescription> eObjectDescriptions = Iterables.filter(
						resourceDescription.getExportedObjects(), new Predicate<IEObjectDescription>() {
							public boolean apply(IEObjectDescription input) {
								return input.getEObjectURI().equals(eObjectURI);
							}
						}).iterator();
				if (eObjectDescriptions.hasNext()) {
					return eObjectDescriptions.next();
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
				Iterator<IStorage> storages = storage2UriMapper.getStorages(eObjectDescription.getEObjectURI())
						.iterator();
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
