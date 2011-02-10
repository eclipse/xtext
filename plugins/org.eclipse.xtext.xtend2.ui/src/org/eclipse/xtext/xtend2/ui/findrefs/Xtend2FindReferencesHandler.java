/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.findrefs;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.Messages;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtend2.linking.XtendSourceAssociator;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2FindReferencesHandler extends FindReferencesHandler {

	private static final Logger LOG = Logger.getLogger(Xtend2FindReferencesHandler.class);
	
	@Inject
	private XtendSourceAssociator xtendSourceAssociator;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				Pair<URI, Predicate<IReferenceDescription>> queryData = editor.getDocument().readOnly(new IUnitOfWork<Pair<URI, Predicate<IReferenceDescription>>, XtextResource>() {
					public Pair<URI, Predicate<IReferenceDescription>> exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						if (element != null) {
							EObject xtendSource = xtendSourceAssociator.getXtendSource(element);
							Predicate<IReferenceDescription> filter = null;
							if(xtendSource != null) {
								final URI xtendSourceURI = EcoreUtil.getURI(xtendSource);
								filter = new Predicate<IReferenceDescription>() {
									public boolean apply(IReferenceDescription input) {
										return !xtendSourceURI.equals(input.getSourceEObjectUri());
									}
								};
							}
							return Tuples.create(EcoreUtil.getURI(element), filter);
						}
						return null;
					}
				});
				if (queryData != null) {
					QueryExecutor queryExecutor = globalServiceProvider.findService(queryData.getFirst().trimFragment(),
							QueryExecutor.class);
					if (queryExecutor != null) {
						queryExecutor.execute(queryData.getFirst(), localContextProvider, queryData.getSecond());
					}
				}
			}
		} catch (Exception e) {
			LOG.error(Messages.FindReferencesHandler_3, e);
		}
		return null;
	}

}
