/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

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
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Peter Friese
 */
public class FindReferencesHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	@Inject
	private IReferenceFinder.ILocalContextProvider localContextProvider;

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				URI targetURI = editor.getDocument().readOnly(new IUnitOfWork<URI, XtextResource>() {
					public URI exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						if (element != null) {
							return EcoreUtil.getURI(element);
						}
						return null;
					}
				});
				if (targetURI != null) {
					IResourceServiceProvider resourceServiceProvider = serviceProviderRegistry
							.getResourceServiceProvider(targetURI.trimFragment());
					QueryExecutor queryExecutor = resourceServiceProvider.get(QueryExecutor.class);
					if(queryExecutor != null) {
						queryExecutor.execute(targetURI, localContextProvider);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(Messages.FindReferencesHandler_3, e);
		}
		return null;
	}

	public static class QueryExecutor {
		@Inject
		private IStorage2UriMapper storage2UriMapper;

		@Inject
		private Provider<ReferenceQuery> queryProvider;

		@Inject
		private IQualifiedNameProvider qualifiedNameProvider;
		
		@Inject
		private IQualifiedNameConverter qualifiedNameConverter;
		
		public void execute(URI targetElementURI, IReferenceFinder.ILocalContextProvider localContextProvider) {
			ReferenceQuery referenceQuery = queryProvider.get();
			String qualifiedName = localContextProvider.readOnly(targetElementURI, new IUnitOfWork<String, EObject>() {
				public String exec(EObject target) throws Exception {
					return qualifiedNameConverter.toString(qualifiedNameProvider.getFullyQualifiedName(target));
				}
			});
			String label = Messages.FindReferencesHandler_labelPrefix + qualifiedName;
			Iterator<IStorage> storages = storage2UriMapper.getStorages(targetElementURI).iterator();
			if (storages.hasNext()) {
				label += Messages.FindReferencesHandler_1 + storages.next().getFullPath().toString()
						+ Messages.FindReferencesHandler_2;
			}
			referenceQuery.init(targetElementURI, localContextProvider, label);
			NewSearchUI.activateSearchResultView();
			NewSearchUI.runQueryInBackground(referenceQuery);
		}
	}
}
