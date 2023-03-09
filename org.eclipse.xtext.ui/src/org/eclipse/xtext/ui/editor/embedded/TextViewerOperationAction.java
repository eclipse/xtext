/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * An action which gets a text operation target from its text editor.
 * <p>
 * The action is initially associated with a text editor via the constructor, but can subsequently be changed using
 * <code>setEditor</code>.
 * </p>
 * <p>
 * If this class is used as is, it works by asking the text editor for its text operation target adapter (using
 * <code>getAdapter(ITextOperationTarget.class)</code>. The action runs this operation with the pre-configured opcode.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextViewerOperationAction extends TextViewerAction {

	/** The text operation code */
	private int fOperationCode = -1;
	/** The text operation target */
	private ITextOperationTarget fOperationTarget;
	/**
	 * Indicates whether this action can be executed on read only editors
	 */
	private boolean fRunsOnReadOnly = false;

	/**
	 * Flag to prevent running twice trough {@link #update()} when creating this action.
	 */
	private boolean fAllowUpdate = false;

	/**
	 * Creates and initializes the action for the given text editor and operation code. The action configures its visual
	 * representation from the given resource bundle. The action works by asking the text editor at the time for its
	 * text operation target adapter (using <code>getAdapter(ITextOperationTarget.class)</code>. The action runs that
	 * operation with the given opcode.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text viewer
	 * @param operationCode
	 *            the operation code
	 * @see TextViewerAction#TextViewerAction(ResourceBundle, String, ITextViewer)
	 */
	public TextViewerOperationAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int operationCode) {
		this(bundle, prefix, viewer, operationCode, false);
	}

	/**
	 * Creates and initializes the action for the given text editor and operation code. The action configures its visual
	 * representation from the given resource bundle. The action works by asking the text editor at the time for its
	 * text operation target adapter (using <code>getAdapter(ITextOperationTarget.class)</code>. The action runs that
	 * operation with the given opcode.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text viewer
	 * @param operationCode
	 *            the operation code
	 * @param runsOnReadOnly
	 *            <code>true</code> if action can be executed on read-only files
	 * 
	 * @see TextViewerAction#TextViewerAction(ResourceBundle, String, ITextViewer)
	 */
	public TextViewerOperationAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int operationCode,
			boolean runsOnReadOnly) {
		super(bundle, prefix);
		setViewer(viewer);
		fOperationCode = operationCode;
		fRunsOnReadOnly = runsOnReadOnly;
		fAllowUpdate = true;
		update();
	}

	/**
	 * The <code>TextOperationAction</code> implementation of this <code>IAction</code> method runs the operation with
	 * the current operation code.
	 */
	@Override
	public void run() {
		if (fOperationCode == -1 || fOperationTarget == null)
			return;

		ITextViewer viewer = getTextViewer();
		if (viewer == null)
			return;

		if (!fRunsOnReadOnly && !canModifyViewer())
			return;

		Display display = null;

		Shell shell = viewer.getTextWidget().getShell();
		if (shell != null && !shell.isDisposed())
			display = shell.getDisplay();

		BusyIndicator.showWhile(display, new Runnable() {
			@Override
			public void run() {
				fOperationTarget.doOperation(fOperationCode);
			}
		});
	}

	/**
	 * The <code>TextOperationAction</code> implementation of this <code>IUpdate</code> method discovers the operation
	 * through the current editor's <code>ITextOperationTarget</code> adapter, and sets the enabled state accordingly.
	 */
	@Override
	public void update() {
		if (!fAllowUpdate)
			return;

		super.update();

		if (!fRunsOnReadOnly && !canModifyViewer()) {
			setEnabled(false);
			return;
		}

		ITextViewer viewer = getTextViewer();
		if (fOperationTarget == null && viewer != null && fOperationCode != -1)
			fOperationTarget = viewer.getTextOperationTarget();

		boolean isEnabled = (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
		setEnabled(isEnabled);
	}

	@Override
	public void setViewer(ITextViewer viewer) {
		super.setViewer(viewer);
		fOperationTarget = null;
	}
}
