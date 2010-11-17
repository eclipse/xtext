/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

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
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.IRenameElementRefactoringProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameElementHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

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
				URI targetElementURI = editor.getDocument().readOnly(new IUnitOfWork<URI, XtextResource>() {
					public URI exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						if (element != null) {
							ITextRegion region = locationInFileProvider.getSignificantTextRegion(element);
							editor.selectAndReveal(region.getOffset(), region.getLength());
							final URI eObjectURI = EcoreUtil.getURI(element);
							return eObjectURI;
						}
						return null;
					}
				});
				if (targetElementURI != null) {
					RenameRefactoring renameRefactoring = refactoringProvider.getRenameRefactoring(targetElementURI);
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
