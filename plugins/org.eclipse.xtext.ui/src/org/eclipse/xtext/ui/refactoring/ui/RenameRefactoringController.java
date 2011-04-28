/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author koehnlein - Initial contribution and API
 */
@Singleton
public class RenameRefactoringController {

	private static final Logger LOG = Logger.getLogger(RenameRefactoringController.class);

	@Inject
	private Provider<RenameLinkedMode> renameLinkedModeProvider;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private IRenameProcessorAdapter.Factory renameProcessorAdapterFactory;

	private RenameLinkedMode activeLinkedMode;

	private IRenameElementContext renameElementContext;
	private ProcessorBasedRefactoring renameRefactoring;
	private IRenameProcessorAdapter renameProcessorAdapter;
	private IUndoableOperation startingUndoOperation;

	/**
	 * Factory for components from the language holding the declaration of the renamed element.
	 * 
	 * @since 2.0
	 */
	protected static class DeclaringLanguageComponentFactory {
		@Inject
		private Provider<RenameRefactoringExecuter> renameRefactoringExecuterProvider;

		public RenameRefactoringExecuter createRenameRefactoringExecuter() {
			return renameRefactoringExecuterProvider.get();
		}

		@Inject
		private IRenameRefactoringProvider renameRefactoringProvider;

		public ProcessorBasedRefactoring createRenameRefactoring(IRenameElementContext renameElementContext) {
			return renameRefactoringProvider.getRenameRefactoring(renameElementContext);
		}
	}

	private DeclaringLanguageComponentFactory declaringLanguage;

	public void startLinkedEditing(IRenameElementContext renameElementContext) {
		if (activeLinkedMode != null) {
			if (renameElementContext.getTriggeringEditor() == getXtextEditor() && activeLinkedMode.isCaretInLinkedPosition()) {
				startRefactoring(RefactoringType.REFACTORING_DIALOG);
				return;
			} else {
				activeLinkedMode.cancel();
			}
		}
		try {
			declaringLanguage = globalServiceProvider.findService(renameElementContext.getTargetElementURI(),
					DeclaringLanguageComponentFactory.class);
		} catch (Throwable t) {
			LOG.error("Error getting refactoring components from declaring language", t);
			return;
		}
		this.renameElementContext = renameElementContext;
		renameRefactoring = declaringLanguage.createRenameRefactoring(renameElementContext);
		renameProcessorAdapter = renameProcessorAdapterFactory.create(renameRefactoring);
		ISourceViewer viewer = getXtextEditor().getInternalSourceViewer();
		if (viewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension) {
				IUndoManagerExtension undoManagerExtension = (IUndoManagerExtension) undoManager;
				IUndoContext undoContext = undoManagerExtension.getUndoContext();
				IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
				startingUndoOperation = operationHistory.getUndoOperation(undoContext);
			}
		}
		activeLinkedMode = renameLinkedModeProvider.get();
		// refactorings should not be reused, so the linked mode uses an extra one 
		activeLinkedMode.start(renameElementContext, declaringLanguage.createRenameRefactoring(renameElementContext));
	}

	public void startRefactoring(RefactoringType refactoringType) {
		ViewFreezer freezer = new ViewFreezer(getXtextEditor().getInternalSourceViewer());
		try {
			freezer.freeze();
			// Cancel undoable right now because the freezer would show the old
			// state and not the new one
			if(activeLinkedMode != null) 
				activeLinkedMode.cancel();
			undoDocumentChanges();
			switch (refactoringType) {
				case REFACTORING_DIRECT:
					startDirectRefactoring();
					break;
				case REFACTORING_DIALOG:
					startRefactoringWithDialog(false);
					break;
				case REFACTORING_PREVIEW:
					startRefactoringWithDialog(true);
			}
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			freezer.release();
		}

	}

	protected void startDirectRefactoring() {
		if (renameProcessorAdapter.getNewName() == null) {
			restoreOriginalSelection();
		} else {
			RenameRefactoringExecuter renameRefactoringExecuter = declaringLanguage.createRenameRefactoringExecuter();
			try {
				renameRefactoringExecuter.configure(renameRefactoring);
				renameRefactoringExecuter.perform(getXtextEditor().getSite());
			} catch (CoreException e) {
				LOG.error(e.getMessage(), e);
				restoreOriginalSelection();
			} catch (InterruptedException e) {
				// User canceled operation
				LOG.error(e.getMessage(), e);
				restoreOriginalSelection();
			}
		}
	}

	protected void startRefactoringWithDialog(final boolean previewOnly) {
		try {
			RenameElementWizard renameElementWizard = new RenameElementWizard(renameRefactoring) {
				@Override
				protected void addUserInputPages() {
					if (!previewOnly) {
						super.addUserInputPages();
					}
				}
			};
			if (previewOnly) {
				renameElementWizard.setForcePreviewReview(true);
			}
			RefactoringWizardOpenOperation openOperation = new RefactoringWizardOpenOperation(renameElementWizard);
			openOperation.run(renameElementContext.getTriggeringEditor().getSite().getShell(), "Rename Element");
		} catch (InterruptedException e) {
			// canceling by the user is ok
			restoreOriginalSelection();
		}

	}

	protected void restoreOriginalSelection() {
		ISelection originalSelection = renameElementContext.getTriggeringEditorSelection();
		if (originalSelection instanceof ITextSelection) {
			getXtextEditor().getInternalSourceViewer().setSelectedRange(((ITextSelection) originalSelection).getOffset(),
					((ITextSelection) originalSelection).getLength());
		}
	}

	public boolean updateNewName(String newName) {
		if (isInValid(newName))
			return false;
		renameProcessorAdapter.setNewName(newName);
		return true;
	}

	protected boolean isInValid(String newName) {
		if (newName != null && newName.length() > 0) {
			RefactoringStatus result = renameProcessorAdapter.validateNewName(newName);
			return result.hasWarning();
		} else {
			return false;
		}
	}

	protected void undoDocumentChanges() throws CoreException {
		final ISourceViewer viewer = getXtextEditor().getInternalSourceViewer();
		try {
			getXtextEditor().getSite().getWorkbenchWindow().run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					if (viewer instanceof ITextViewerExtension6) {
						IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
						if (undoManager instanceof IUndoManagerExtension) {
							IUndoManagerExtension undoManagerExtension = (IUndoManagerExtension) undoManager;
							IUndoContext undoContext = undoManagerExtension.getUndoContext();
							IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
							while (undoManager.undoable()) {
								if (startingUndoOperation != null
										&& startingUndoOperation.equals(operationHistory.getUndoOperation(undoContext)))
									return;
								undoManager.undo();
							}
						}
					}
				}
			});

		} catch (InvocationTargetException e) {
			LOG.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	protected XtextEditor getXtextEditor() {
		IEditorPart part = renameElementContext.getTriggeringEditor();
		if (part instanceof XtextEditor) {
			return (XtextEditor) part;
		}
		return null;
	}
}
