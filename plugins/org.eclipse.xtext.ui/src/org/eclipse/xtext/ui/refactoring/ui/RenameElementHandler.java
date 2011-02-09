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
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.RefactoringType;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class RenameElementHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;	

	protected static final Logger LOG = Logger.getLogger(RenameElementHandler.class);

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
									final URI targetElementURI = EcoreUtil.getURI(targetElement);
									IRenameElementContext.Impl renameElementContext = new IRenameElementContext.Impl(
											targetElementURI, targetElement.eClass(), editor, selection, resource.getURI());
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

	public static class RenameElementOperation {
		@Inject
		protected Provider<RenameLinkedMode> renameLinkedModeProvider;
		
		public void execute(IRenameElementContext renameElementContext) throws InterruptedException {
			
			RenameLinkedMode activeLinkedMode = RenameLinkedMode.getActiveLinkedMode();
			if (activeLinkedMode != null) {
				if (activeLinkedMode.isCaretInLinkedPosition()) {
					activeLinkedMode.startRefactoring(RefactoringType.REFACTORING_DIALOG);
					return;
				} else {
					activeLinkedMode.cancel();
				}
			} 
			activeLinkedMode = renameLinkedModeProvider.get();
			activeLinkedMode.start(renameElementContext);
						
		}
	}
}
