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
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RenameElementHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	protected static final Logger LOG = Logger.getLogger(RenameElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				IRenameElementContext renameElementContext = editor.getDocument().readOnly(new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource resource) throws Exception {
						EObject targetElement = eObjectAtOffsetHelper.resolveElementAt(resource, selection.getOffset());
						if (targetElement != null) {
							final URI targetElementURI = EcoreUtil.getURI(targetElement);
							IRenameElementContext.Impl renameElementContext = new IRenameElementContext.Impl(targetElementURI, targetElement.eClass(), editor, selection);
							selectElementInEditor(targetElement, targetElementURI, editor, resource);
							return renameElementContext;
						}
						return null;
					}
				});
				if (renameElementContext != null) {
					// refactoring target could be from another language
					RenameElementOperation renameElementOperation = globalServiceProvider.findService(
							renameElementContext.getTargetElementURI().trimFragment(), RenameElementOperation.class);
					if (renameElementOperation != null)
						renameElementOperation.execute(renameElementContext);
				}
			}
		} catch (Exception exc) {
			LOG.error(exc);
		}
		return null;
	}

	protected void selectElementInEditor(EObject targetElement, final URI targetElementURI, final XtextEditor editor,
			XtextResource editorResource) {
		if (targetElementURI != null && targetElementURI.trimFragment().equals(editorResource.getURI())) {
			ITextRegion region = locationInFileProvider.getSignificantTextRegion(targetElement);
			editor.selectAndReveal(region.getOffset(), region.getLength());
		}
	}

	public static class RenameElementOperation {
		@Inject
		private IRenameRefactoringProvider refactoringProvider;

		public void execute(IRenameElementContext renameElementContext) throws InterruptedException {
			RenameRefactoring renameRefactoring = refactoringProvider.getRenameRefactoring(renameElementContext);
			RenameElementWizard renameElementWizard = new RenameElementWizard(renameRefactoring);
			RefactoringWizardOpenOperation openOperation = new RefactoringWizardOpenOperation(renameElementWizard);
			openOperation.run(renameElementContext.getTriggeringEditor().getSite().getShell(), "Rename Element");
		}
	}
}
