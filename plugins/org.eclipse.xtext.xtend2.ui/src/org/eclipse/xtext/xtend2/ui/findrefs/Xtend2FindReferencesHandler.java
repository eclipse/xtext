/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.findrefs;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.Messages;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2FindReferencesHandler extends FindReferencesHandler {

	private static final Logger LOG = Logger.getLogger(Xtend2FindReferencesHandler.class);

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				QueryData queryData = editor.getDocument().readOnly(new IUnitOfWork<QueryData, XtextResource>() {
					public QueryData exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						return createQueryData(element);
					}
				});
				if (queryData != null) {
					QueryExecutor queryExecutor = globalServiceProvider.findService(queryData.getTargetElementURIs().get(0),
							QueryExecutor.class);
					if (queryExecutor != null) {
						queryExecutor.execute(queryData.getTargetElementURIs(), localContextProvider,
								createFilter(queryData));
					}
				}
			}
		} catch (Exception e) {
			LOG.error(Messages.FindReferencesHandler_3, e);
		}
		return null;
	}

	public Xtend2ReferenceFilter createFilter(QueryData queryData) {
		return new Xtend2ReferenceFilter(queryData.getExcludedSourceURI());
	}

	public QueryData createQueryData(EObject element) {
		if (element != null) {
			if (element instanceof XtendClass)
				return new QueryData(element, xtend2jvmAssociations.getInferredType((XtendClass) element), xtend2jvmAssociations.getInferredConstructor((XtendClass) element));
			else if (element instanceof XtendFunction)
				return new QueryData(element, xtend2jvmAssociations.getDirectlyInferredOperation((XtendFunction) element));
			else
				return new QueryData(null, element);
		}
		return null;
	}

	public static class QueryData {
		protected List<URI> targetElementURIs = null;
		protected URI excludedSourceURI;

		public QueryData(EObject excludedSourceElement, EObject... targetElements) {
			this.targetElementURIs = newArrayList();
			for (EObject element : targetElements)
				targetElementURIs.add(EcoreUtil.getURI(element));
			this.excludedSourceURI = EcoreUtil.getURI(excludedSourceElement);
		}

		public List<URI> getTargetElementURIs() {
			return targetElementURIs;
		}

		public URI getExcludedSourceURI() {
			return excludedSourceURI;
		}
	}

}
