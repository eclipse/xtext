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
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IEditingSupport;
import org.eclipse.jface.text.IEditingSupportRegistry;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ILinkedModelCalculator;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.RefactoringType;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.RenameRefactoringExecuter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class RenameLinkedMode {
	@Inject
	private ILinkedModelCalculator linkedModelCalculator;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	/**
	 * Components from the language holding the declaration of the refactored element. 
	 * @since 2.0
	 */
	protected static class DeclaringLanguageComponents {
		@Inject
		private Provider<RenameRefactoringExecuter> renameRefactoringExecuterProvider;

		@Inject
		private IRenameRefactoringProvider refactoringProvider;		
		
		public IRenameRefactoringProvider getRefactoringProvider() {
			return refactoringProvider;
		}
		
		public Provider<RenameRefactoringExecuter> getRenameRefactoringExecuterProvider() {
			return renameRefactoringExecuterProvider;
		}
	}

	private DeclaringLanguageComponents declaringLanguage;

	private IUndoableOperation startingUndoOperation;
	private RenameRefactoringPopup popup;
	private FocusEditingSupport focusEditingSupport;
	private boolean showPreview;
	private Point originalSelection;
	private LinkedModeModel linkedModeModel;
	private static RenameLinkedMode INSTANCE;
	private XtextEditor editor;
	private LinkedPositionGroup linkedPositionGroup;
	private LinkedPosition currentPosition;
	private Logger log = Logger.getLogger(RenameLinkedMode.class);
	private IRenameElementContext renameElementContext;
	private ProcessorBasedRefactoring renameRefactoring;
	private AbstractRenameProcessor renameProcessor;
	
	public static RenameLinkedMode getActiveLinkedMode() {
		if (INSTANCE != null) {
			ISourceViewer viewer = INSTANCE.editor.getInternalSourceViewer();
			if (viewer != null) {
				StyledText textWidget = viewer.getTextWidget();
				if (textWidget != null && !textWidget.isDisposed()) {
					return INSTANCE;
				}
			}
		}
		// make sure we don't hold onto the active linked mode if anything
		// went wrong with canceling:
		INSTANCE = null;
		return null;
	}

	public void start(IRenameElementContext renameElementContext) {
		try {
			declaringLanguage = globalServiceProvider.findService(renameElementContext.getTargetElementURI(), DeclaringLanguageComponents.class);
		} catch(Throwable t) {
			log.error("Error getting refactoring components from declaring language", t);
			return;
		}
		this.renameRefactoring = declaringLanguage.getRefactoringProvider().getRenameRefactoring(renameElementContext);
		if(renameRefactoring == null) 
			return;
		this.renameProcessor = (AbstractRenameProcessor) renameRefactoring.getProcessor();
		this.renameElementContext = renameElementContext;
		linkedModelCalculator.init(renameElementContext);
		this.linkedPositionGroup = linkedModelCalculator.getLinkedPositionGroup();
		if (linkedPositionGroup == null)
			return;
		this.editor = getXtextEditor(renameElementContext);
		this.focusEditingSupport = new FocusEditingSupport();
		ISourceViewer viewer = editor.getInternalSourceViewer();
		IDocument document = viewer.getDocument();
		originalSelection = viewer.getSelectedRange();
		for (LinkedPosition linkedPosition : linkedPositionGroup.getPositions()) {
			if (linkedPosition.includes(originalSelection.x + originalSelection.y)) {
				currentPosition = linkedPosition;
				viewer.setSelectedRange(currentPosition.offset, currentPosition.length);
			}
		}
		if (currentPosition == null) {
			return;
		}

		try {
			if (viewer instanceof ITextViewerExtension6) {
				IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
				if (undoManager instanceof IUndoManagerExtension) {
					IUndoManagerExtension undoManagerExtension = (IUndoManagerExtension) undoManager;
					IUndoContext undoContext = undoManagerExtension.getUndoContext();
					IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
					startingUndoOperation = operationHistory.getUndoOperation(undoContext);
				}
			}
			linkedModeModel = new LinkedModeModel();
			linkedModeModel.addGroup(linkedPositionGroup);
			linkedModeModel.forceInstall();
			linkedModeModel.addLinkingListener(new EditorSynchronizer());

			LinkedModeUI ui = new EditorLinkedModeUI(linkedModeModel, viewer);
			ui.setExitPosition(viewer, currentPosition.getOffset(), 0, Integer.MAX_VALUE);
			ui.setExitPolicy(new ExitPolicy(document));
			ui.enter();

			if (viewer instanceof IEditingSupportRegistry) {
				IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
				registry.register(focusEditingSupport);
			}
			openPopup();
			INSTANCE = this;
		} catch (BadLocationException e) {
			log.error(e.getMessage(), e);
		}
	}

	private XtextEditor getXtextEditor(IRenameElementContext renameElementContext) {
		IEditorPart part = renameElementContext.getTriggeringEditor();
		if (part instanceof XtextEditor) {
			return (XtextEditor) part;
		}
		return null;
	}

	protected void openPopup() {
		popup = new RenameRefactoringPopup(editor, this);
		popup.open();
	}

	public boolean isCaretInLinkedPosition() {
		return getCurrentLinkedPosition() != null;
	}

	public LinkedPosition getCurrentLinkedPosition() {
		Point selection = editor.getInternalSourceViewer().getSelectedRange();
		int start = selection.x;
		int end = start + selection.y;
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for (int i = 0; i < positions.length; i++) {
			LinkedPosition position = positions[i];
			if (position.includes(start) && position.includes(end))
				return position;
		}
		return null;
	}

	public void cancel() {
		if (linkedModeModel != null) {
			linkedModeModel.exit(ILinkedModeListener.NONE);
		}
		linkedModeLeft();

	}

	protected void linkedModeLeft() {
		INSTANCE = null;
		if (popup != null) {
			popup.close();
		}

		ISourceViewer viewer = editor.getInternalSourceViewer();
		if (viewer instanceof IEditingSupportRegistry) {
			IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
			registry.unregister(focusEditingSupport);
		}
	}

	public class EditorSynchronizer implements ILinkedModeListener {

		public void left(LinkedModeModel model, int flags) {
			linkedModeLeft();
			if ((flags & ILinkedModeListener.UPDATE_CARET) != 0) {
				if (showPreview)
					startRefactoring(RefactoringType.REFACTORING_PREVIEW);
				else
					startRefactoring(RefactoringType.REFACTORING_DIRECT);
			}
		}

		public void suspend(LinkedModeModel model) {
		}

		public void resume(LinkedModeModel model, int flags) {
		}

	}

	protected void undoDocumentChanges() throws CoreException {
		final ISourceViewer viewer = editor.getInternalSourceViewer();
		try {

			editor.getSite().getWorkbenchWindow().run(false, true, new IRunnableWithProgress() {
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
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
	}

	public boolean isValid(){
		try{
		if(currentPosition != null){
		String newName = currentPosition.getContent();
		return !isInValid(newName);
		} else
			return false;
		} catch (BadLocationException e){
			log.error(e.getMessage(),e);
			return false;
		}
	}
	
	protected boolean isInValid(String newName) {
		if (newName != null && newName.length() > 0) {
			RefactoringStatus result = renameProcessor.getRenameElementStrategy().validateNewName(newName);
			return result.hasWarning() || result.hasError() || result.hasFatalError();
		} else {
			return false;
		}
	}

	public void startRefactoring(RefactoringType refactoringType) {
		ViewFreezer freezer = new ViewFreezer(editor.getInternalSourceViewer());
		try {
			freezer.freeze();
			updateRefactoringProcessor();
			// Cancel undoable right now because the freezer would show the old
			// state and not the new one
			cancel();
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
		} catch (BadLocationException e) {
			log.error(e.getMessage(), e);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		} finally {
			freezer.release();
		}

	}

	protected void startDirectRefactoring() {
		if(renameProcessor.getNewName() == null) {
			restoreOriginalSelection();
		} else {
			RenameRefactoringExecuter renameRefactoringExecuter = declaringLanguage.getRenameRefactoringExecuterProvider().get();
			try {
				renameRefactoringExecuter.configure(renameRefactoring);
				renameRefactoringExecuter.perform(editor.getSite());
			} catch (CoreException e) {
				log.error(e.getMessage(), e);
				restoreOriginalSelection();
			} catch (InterruptedException e) {
				// User canceled operation
				log.error(e.getMessage(), e);
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
		editor.getInternalSourceViewer().setSelectedRange(originalSelection.x, originalSelection.y);
	}

	protected void updateRefactoringProcessor() throws BadLocationException {
		if (currentPosition != null) {
			String newName = currentPosition.getContent();
			if (isInValid(newName))
				return;
			renameProcessor.setNewName(newName);
		}
	}

	protected class FocusEditingSupport implements IEditingSupport {
		public boolean ownsFocusShell() {
			if (popup == null)
				return false;
			if (popup.ownsFocusShell()) {
				return true;
			}

			Shell editorShell = editor.getSite().getShell();
			Shell activeShell = editorShell.getDisplay().getActiveShell();
			if (editorShell == activeShell)
				return true;
			return false;
		}

		public boolean isOriginator(DocumentEvent event, IRegion subjectRegion) {
			return false; // leave on external modification outside positions
		}
	}

	protected class ExitPolicy extends DeleteBlockingExitPolicy {
		public ExitPolicy(IDocument document) {
			super(document);
		}

		@Override
		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {
			showPreview = (event.stateMask & SWT.CTRL) != 0 && (event.character == SWT.CR || event.character == SWT.LF);
			return super.doExit(model, event, offset, length);
		}
	}

	public static class DeleteBlockingExitPolicy implements IExitPolicy {
		private IDocument document;

		public DeleteBlockingExitPolicy(IDocument document) {
			this.document = document;
		}

		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {
			if (length == 0 && (event.character == SWT.BS || event.character == SWT.DEL)) {
				LinkedPosition position = model.findPosition(new LinkedPosition(document, offset, 0,
						LinkedPositionGroup.NO_STOP));
				if (position != null) {
					if (event.character == SWT.BS) {
						if (offset - 1 < position.getOffset()) {
							// skip backspace at beginning of linked position
							event.doit = false;
						}
					} else /* event.character == SWT.DEL */{
						if (offset + 1 > position.getOffset() + position.getLength()) {
							// skip delete at end of linked position
							event.doit = false;
						}
					}
				}
			}

			return null; // don't change behavior
		}
	}
}
