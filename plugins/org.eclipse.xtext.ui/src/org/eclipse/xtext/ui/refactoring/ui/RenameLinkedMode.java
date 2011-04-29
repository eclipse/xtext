/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IEditingSupport;
import org.eclipse.jface.text.IEditingSupportRegistry;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
public class RenameLinkedMode {
	
	private static final Logger LOG = Logger.getLogger(RenameLinkedMode.class);

	@Inject
	private ILinkedPositionGroupCalculator linkedPositionGroupCalculator;

	@Inject
	private RenameRefactoringController controller;

	@Inject 
	private LinkedEditingUndoSupport undoSupport;
	
	private XtextEditor editor;
	private RenameRefactoringPopup popup;
	private FocusEditingSupport focusEditingSupport;
	private boolean showPreview;
	private Point originalSelection;
	private LinkedModeModel linkedModeModel;
	private LinkedPositionGroup linkedPositionGroup;
	private LinkedPosition currentPosition;

	private boolean isActive = false; 

	public void start(IRenameElementContext renameElementContext) {
		if (renameElementContext == null)
			return;
		this.linkedPositionGroup = linkedPositionGroupCalculator.getLinkedPositionGroup(renameElementContext);
		if (linkedPositionGroup == null)
			return;
		this.editor = (XtextEditor) renameElementContext.getTriggeringEditor();
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
			linkedModeModel = new LinkedModeModel();
			linkedModeModel.addGroup(linkedPositionGroup);
			linkedModeModel.forceInstall();
			linkedModeModel.addLinkingListener(new EditorSynchronizer());
			undoSupport.initialize(editor);
			LinkedModeUI ui = new EditorLinkedModeUI(linkedModeModel, viewer);
			ui.setExitPosition(viewer, currentPosition.getOffset(), 0, Integer.MAX_VALUE);
			ui.setExitPolicy(new ExitPolicy(document));
			ui.enter();
			if (viewer instanceof IEditingSupportRegistry) {
				IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
				registry.register(focusEditingSupport);
			}
			openPopup();
			isActive = true;
		} catch (BadLocationException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	protected void openPopup() {
		popup = new RenameRefactoringPopup(editor, this, controller, updateNewName());
		popup.open();
	}

	protected boolean updateNewName() {
		if (currentPosition != null)
			try {
				return controller.updateNewName(currentPosition.getContent());
			} catch (BadLocationException e) {
				LOG.error("Error updating new name", e);
			}
		return false;
	}

	public boolean isSameRenameElementContext(IRenameElementContext renameElementContext) {
		return renameElementContext.getTriggeringEditor() == editor && isCaretInLinkedPosition();
	}
	
	protected boolean isCaretInLinkedPosition() {
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
		if(isActive) {
			if (linkedModeModel != null) {
				linkedModeModel.exit(ILinkedModeListener.NONE);
			}
			linkedModeLeft();
			undoSupport.undoDocumentChanges();
		}
	}
	
	protected void linkedModeLeft() {
		if (popup != null) {
			popup.close();
		}

		ISourceViewer viewer = editor.getInternalSourceViewer();
		if (viewer instanceof IEditingSupportRegistry) {
			IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
			registry.unregister(focusEditingSupport);
		}
	}

	protected class EditorSynchronizer implements ILinkedModeListener {

		public void left(LinkedModeModel model, int flags) {
			boolean isValidNewName = updateNewName();
			linkedModeLeft();
			if ((flags & ILinkedModeListener.UPDATE_CARET) != 0) {
				if (isValidNewName) {
					if (showPreview)
						controller.startRefactoring(RefactoringType.REFACTORING_PREVIEW);
					else
						controller.startRefactoring(RefactoringType.REFACTORING_DIRECT);
				}
			}
		}

		public void suspend(LinkedModeModel model) {
		}

		public void resume(LinkedModeModel model, int flags) {
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

	protected class ExitPolicy implements IExitPolicy {
		private IDocument document;

		public ExitPolicy(IDocument document) {
			this.document = document;
		}

		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {
			showPreview = (event.stateMask & SWT.CTRL) != 0 && (event.character == SWT.CR || event.character == SWT.LF);
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
