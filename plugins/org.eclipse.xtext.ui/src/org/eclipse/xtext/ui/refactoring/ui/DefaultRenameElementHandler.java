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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class DefaultRenameElementHandler extends AbstractHandler implements IRenameElementHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected RenameRefactoringController renameRefactoringController;

	protected static final Logger LOG = Logger.getLogger(DefaultRenameElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				IRenameElementContext renameElementContext = editor.getDocument().readOnly(
						new IUnitOfWork<IRenameElementContext, XtextResource>() {
							public IRenameElementContext exec(XtextResource resource) throws Exception {
								EObject targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
										selection.getOffset());
								if (targetElement != null) {
									return createRenameElementContext(targetElement, editor, selection, resource);
								}
								return null;
							}
						});
				if (renameElementContext != null) {
					startRenameElement(renameElementContext);
				}
			}
		} catch (Exception exc) {
			LOG.error("Error initializing refactoring", exc);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error initializing refactoring",
					exc.getMessage());
		}
		return null;
	}

	public IRenameElementContext createRenameElementContext(EObject targetElement, final XtextEditor editor,
			final ITextSelection selection, XtextResource resource) {
		final URI targetElementURI = EcoreUtil2.getNormalizedURI(targetElement);
		IRenameElementContext.Impl renameElementContext = new IRenameElementContext.Impl(targetElementURI,
				targetElement.eClass(), editor, selection, resource.getURI());
		return renameElementContext;
	}

	protected void startRenameElement(IRenameElementContext renameElementContext) throws InterruptedException {
		renameRefactoringController.initialize(renameElementContext);
		renameRefactoringController.startRefactoring(RefactoringType.LINKED_EDITING);
	}

}
