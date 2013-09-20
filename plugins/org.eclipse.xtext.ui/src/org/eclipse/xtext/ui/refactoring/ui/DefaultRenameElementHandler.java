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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.NoSuchStrategyException;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@SuppressWarnings("deprecation")
public class DefaultRenameElementHandler extends AbstractHandler implements IRenameElementHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	protected RenameRefactoringController renameRefactoringController;

	@Inject
	protected IGlobalServiceProvider globalServiceProvider;
	
	@Inject
	protected RefactoringPreferences preferences;
	
	@Inject
	protected IRenameContextFactory renameContextFactory;
	
	@Inject
	protected SyncUtil syncUtil;
	
	protected static final Logger LOG = Logger.getLogger(DefaultRenameElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				syncUtil.totalSync(preferences.isSaveAllBeforeRefactoring(), renameRefactoringController.getActiveLinkedMode() == null);
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				IRenameElementContext renameElementContext = editor.getDocument().readOnly(
						new IUnitOfWork<IRenameElementContext, XtextResource>() {
							public IRenameElementContext exec(XtextResource resource) throws Exception {
								EObject selectedElement = eObjectAtOffsetHelper.resolveElementAt(resource,
										selection.getOffset());
								if (selectedElement != null) {
									IRenameElementContext renameElementContext = renameContextFactory.createRenameElementContext(
											selectedElement, editor, selection, resource);
									if (isRefactoringEnabled(renameElementContext, resource))
										return renameElementContext;
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
					exc.getMessage() + "\nSee log for details");
		}
		return null;
	}
	
	/** 
	 * To maintain binary compatibility only.
	 */
	public IRenameElementContext createRenameElementContext(EObject targetElement, final XtextEditor triggeringEditor,
			final ITextSelection selection, XtextResource triggeringResource) {
		return renameContextFactory.createRenameElementContext(targetElement, triggeringEditor, selection, triggeringResource);
	}

	protected boolean isRefactoringEnabled(IRenameElementContext renameElementContext, XtextResource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		if (renameElementContext != null && resourceSet != null) {
			EObject targetElement = resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
			if (targetElement != null && !targetElement.eIsProxy()) {
				if(targetElement.eResource() == resource && renameElementContext.getTriggeringEditorSelection() instanceof ITextSelection) {
					ITextSelection textSelection = (ITextSelection) renameElementContext.getTriggeringEditorSelection();
					ITextRegion selectedRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
					INode crossReferenceNode = eObjectAtOffsetHelper.getCrossReferenceNode(resource, selectedRegion);
					if(crossReferenceNode == null) {
						// selection is on the declaration. make sure it's the name
						ITextRegion significantRegion = locationInFileProvider.getSignificantTextRegion(targetElement);
						if(!significantRegion.contains(selectedRegion)) 
							return false;
					}
				}
				IRenameStrategy.Provider renameStrategyProvider = globalServiceProvider.findService(targetElement,
						IRenameStrategy.Provider.class);
				try {
					return renameStrategyProvider.get(targetElement, renameElementContext) != null;
				} catch (NoSuchStrategyException e) {
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Cannot rename element",
							e.getMessage());
				}
			}
		}
		return false;
	}

	protected void startRenameElement(IRenameElementContext renameElementContext) throws InterruptedException {
		renameRefactoringController.startRefactoring(renameElementContext);
	}

}
