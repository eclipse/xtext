/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
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

	private XtextEditor editor;
	private RenameRefactoringPopup popup;
	private FocusEditingSupport focusEditingSupport;
	private boolean showPreview;
	private Point originalSelection;
	private String originalName;
	private LinkedModeModel linkedModeModel;
	private LinkedPositionGroup linkedPositionGroup;
	private LinkedPosition currentPosition;

	public boolean start(IRenameElementContext renameElementContext, IProgressMonitor monitor) {
		if (renameElementContext == null)
			throw new IllegalArgumentException("RenameElementContext is null");
		this.linkedPositionGroup = linkedPositionGroupCalculator.getLinkedPositionGroup(renameElementContext, monitor);
		if (linkedPositionGroup == null || linkedPositionGroup.isEmpty())
			return false;
		this.editor = (XtextEditor) renameElementContext.getTriggeringEditor();
		this.focusEditingSupport = new FocusEditingSupport();
		ISourceViewer viewer = editor.getInternalSourceViewer();
		IDocument document = viewer.getDocument();
		originalSelection = viewer.getSelectedRange();
		currentPosition = linkedPositionGroup.getPositions()[0];
		originalName = getCurrentName();
		try {
			linkedModeModel = new LinkedModeModel();
			linkedModeModel.addGroup(linkedPositionGroup);
			linkedModeModel.forceInstall();
			linkedModeModel.addLinkingListener(new EditorSynchronizer());
			LinkedModeUI ui = new EditorLinkedModeUI(linkedModeModel, viewer);
			ui.setExitPolicy(new ExitPolicy(document));
			if (currentPosition.includes(originalSelection.x))
				ui.setExitPosition(viewer, originalSelection.x, 0, Integer.MAX_VALUE);
			ui.enter();
			if (currentPosition.includes(originalSelection.x)
					&& currentPosition.includes(originalSelection.x + originalSelection.y))
				viewer.setSelectedRange(originalSelection.x, originalSelection.y);
			if (viewer instanceof IEditingSupportRegistry) {
				IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
				registry.register(focusEditingSupport);
			}
			openPopup();
			return true;
		} catch (BadLocationException e) {
			throw new WrappedException(e);
		}
	}

	protected void openPopup() {
		popup = new RenameRefactoringPopup(editor, controller, this);
		popup.open();
	}

	public boolean isCurrentNameValid() {
		String currentName = getCurrentName();
		return !isEmpty(currentName) && !equal(originalName, currentName);
	}

	public String getCurrentName() {
		if (currentPosition != null)
			try {
				return currentPosition.getContent();
			} catch (BadLocationException e) {
				LOG.error("Error updating new name", e);
			}
		return null;
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

	/**
	 * PopUp gets closed and the focus goes back to the editor. Linked mode stays active and can be reenabled, i.e. by
	 * putting the caret back into a linked editing position.
	 */
	public void linkedModeLeft() {
		if (linkedModeModel != null) {
			linkedModeModel.exit(ILinkedModeListener.NONE);
		}
		if (popup != null) {
			popup.close();
		}

		if (editor != null) {
			ISourceViewer viewer = editor.getInternalSourceViewer();
			if (viewer instanceof IEditingSupportRegistry) {
				IEditingSupportRegistry registry = (IEditingSupportRegistry) viewer;
				registry.unregister(focusEditingSupport);
			}
		}
	}

	protected class EditorSynchronizer implements ILinkedModeListener {
		public void left(LinkedModeModel model, int flags) {
			//boolean isValidNewName = updateNewName();
			if ((flags & ILinkedModeListener.UPDATE_CARET) != 0) {// && isValidNewName) {
				if (showPreview)
					controller.startRefactoring(RefactoringType.REFACTORING_PREVIEW);
				else
					controller.startRefactoring(RefactoringType.REFACTORING_DIRECT);
			} else {
				controller.cancelLinkedMode();
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
