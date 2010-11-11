/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.IRenameElementRefactoringProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameElementHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IResourceDescriptions index;

	@Inject
	private IRenameElementRefactoringProvider refactoringProvider;

	@Inject 
	private ILocationInFileProvider locationInFileProvider;
	
	protected static final Logger LOG = Logger.getLogger(RenameElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				IEObjectDescription eObjectDescription = editor.getDocument().readOnly(new IUnitOfWork<IEObjectDescription, XtextResource>() {
					public IEObjectDescription exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						if (element != null) {
							ITextRegion region = locationInFileProvider.getSignificantTextRegion(element);
							editor.selectAndReveal(region.getOffset(), region.getLength());
							final URI eObjectURI = EcoreUtil.getURI(element);
							IResourceDescription resourceDescription = index.getResourceDescription(eObjectURI.trimFragment());
							if (resourceDescription != null) {
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
						}
						return null;
					}
				});
				if (eObjectDescription != null) {
					RenameRefactoring renameRefactoring = refactoringProvider.getRenameRefactoring(eObjectDescription);
					RenameElementWizard renameElementWizard = new RenameElementWizard(renameRefactoring);
					RefactoringWizardOpenOperation openOperation = new RefactoringWizardOpenOperation(
							renameElementWizard);
					openOperation.run(editor.getSite().getShell(), "Rename Element");
				}
			}
		} catch (Exception exc) {
			LOG.error(exc);
		}
		return null;
	}

}
