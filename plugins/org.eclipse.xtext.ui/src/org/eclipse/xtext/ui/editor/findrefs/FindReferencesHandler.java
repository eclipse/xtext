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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

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

	private static final Logger LOG = Logger.getLogger(FindReferencesHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				ReferenceQueryExecutor queryExecutor = editor.getDocument().readOnly(new IUnitOfWork<ReferenceQueryExecutor, XtextResource>() {
					public ReferenceQueryExecutor exec(XtextResource state) throws Exception {
						EObject target = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						URI targetURI = EcoreUtil2.getNormalizedURI(target);
						if(targetURI != null) {
							ReferenceQueryExecutor queryExecutor = globalServiceProvider.findService(targetURI.trimFragment(), ReferenceQueryExecutor.class);
							if (queryExecutor != null) {
								queryExecutor.init(target);
								return queryExecutor;
							}
						}
						return null;
					}
				});
				if(queryExecutor != null) 
					queryExecutor.execute();
			}
		} catch (Exception e) {
			LOG.error(Messages.FindReferencesHandler_3, e);
		}
		return null;
	}

}
