/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.ui.texteditor.IReadOnlyDependent;

/**
 * Action for shifting code to the right or left by one indentation level.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextViewerShiftAction extends TextViewerAction implements IReadOnlyDependent {

	/** The text operation code */
	private int fOperationCode = -1;
	/** The text operation target */
	private ITextOperationTarget fOperationTarget = null;

	/**
	 * Creates and initializes the action for the given text viewer and operation code. The action configures its visual
	 * representation from the given resource bundle. The action works by asking the text viewer at the time for its
	 * text operation target adapter {@link ITextViewer#getTextOperationTarget()}. The action runs that operation with
	 * the given opcode.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text editor
	 * @param operationCode
	 *            the operation code
	 * @see TextViewerAction#TextViewerAction(ResourceBundle, String, ITextViewer)
	 */
	public TextViewerShiftAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int operationCode) {
		super(bundle, prefix);
		setViewer(viewer);
		fOperationCode = operationCode;
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

		if (!canModifyViewer())
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

	@Override
	public void update() {
		super.update();
		if (!isEnabled())
			return;

		if (!canModifyViewer()) {
			setEnabled(false);
			return;
		}

		ITextViewer viewer = getTextViewer();
		if (fOperationTarget == null && viewer != null && fOperationCode != -1)
			fOperationTarget = viewer.getTextOperationTarget();

	}

	/**
	 * Enablement when tab key is pressed - the current selection has to be cover multiple lines.
	 * 
	 * @since 3.0
	 */
	protected void updateForTab() {
		super.update();

		if (isEnabled()) {
			if (!canModifyViewer()) {
				setEnabled(false);
				return;
			}

			ITextViewer viewer = getTextViewer();
			if (fOperationTarget == null && viewer != null && fOperationCode != -1)
				fOperationTarget = viewer.getTextOperationTarget();

			boolean isEnabled = (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
			setEnabled(isEnabled);
		}

	}

	@Override
	public void setViewer(ITextViewer viewer) {
		super.setViewer(viewer);
		fOperationTarget = null;
	}

	@Override
	public boolean isEnabled(boolean isWritable) {

		if (!isWritable)
			return false;

		/*
		 * Note that this implementation still honors the result returned by canDoOperation.
		 * I.e. if the viewer is set to read-only, this method still returns false.
		 * It covers the case in which the viewer is also writable.
		 *
		 */
		ITextViewer viewer = getTextViewer();
		if (fOperationTarget == null && viewer != null && fOperationCode != -1)
			fOperationTarget = viewer.getTextOperationTarget();

		return (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
	}
}
