/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * This class must neither be renamed nor moved.
 *  
 * @author Jan Köhnlein - Initial contribution and API
 * @author Peter Friese
 */
public class FindReferencesHandler extends AbstractHandler {

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected IGlobalServiceProvider globalServiceProvider;
	
	@Inject
	protected FindReferenceQueryDataFactory queryDataFactory;

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				IQueryData context = editor.getDocument().readOnly(new IUnitOfWork<IQueryData, XtextResource>() {
					public IQueryData exec(XtextResource localResource) throws Exception {
						return createQueryData(localResource, selection);
					}
				});
				if (context != null) {
					QueryExecutor queryExecutor = globalServiceProvider.findService(context.getLeadElementURI()
							.trimFragment(), QueryExecutor.class);
					if (queryExecutor != null) {
						queryExecutor.execute(context);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(Messages.FindReferencesHandler_3, e);
		}
		return null;
	}

	protected IQueryData createQueryData(XtextResource localResource, ITextSelection selection) {
		EObject element = eObjectAtOffsetHelper.resolveElementAt(localResource, selection.getOffset());
		if (element != null) {
			URI localResourceURI = localResource.getURI();
			IQueryData queryData = queryDataFactory.createQueryData(element, localResourceURI);
			return queryData;
		}
		return null;
	}

	public static class QueryExecutor {
		@Inject
		private Provider<ReferenceQuery> queryProvider;

		public void execute(final IQueryData queryData) {
			if (!queryData.getTargetURIs().isEmpty()) {
				ReferenceQuery referenceQuery = queryProvider.get();
				referenceQuery.init(queryData);
				NewSearchUI.activateSearchResultView();
				NewSearchUI.runQueryInBackground(referenceQuery);
			}
		}
	}
}
