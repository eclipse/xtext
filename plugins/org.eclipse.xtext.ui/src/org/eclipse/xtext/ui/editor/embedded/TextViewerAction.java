/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * Copied from class org.eclipse.ui.texteditor.templates.TemplatePreferencePage.EditTemplateDialog.TextViewerAction from
 * <code>org.eclipse.ui.texteditor.templates</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TextViewerAction extends Action implements IUpdate {

	private int fOperationCode = -1;
	private ITextOperationTarget fOperationTarget;

	/**
	 * Creates a new action.
	 * 
	 * @param viewer
	 *            the viewer
	 * @param operationCode
	 *            the opcode
	 */
	public TextViewerAction(ITextViewer viewer, int operationCode) {
		fOperationCode = operationCode;
		fOperationTarget = viewer.getTextOperationTarget();
		update();
	}

	/**
	 * Updates the enabled state of the action. Fires a property change if the enabled state changes.
	 * 
	 * @see Action#firePropertyChange(String, Object, Object)
	 */
	public void update() {
		// XXX: workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=206111
		//			if (fOperationCode == ITextOperationTarget.REDO || fOperationCode == ITextOperationTarget.UNDO)
		//				return;

		boolean wasEnabled = isEnabled();
		boolean isEnabled = (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
		setEnabled(isEnabled);

		if (wasEnabled != isEnabled) {
			firePropertyChange(ENABLED, wasEnabled ? Boolean.TRUE : Boolean.FALSE, isEnabled ? Boolean.TRUE
					: Boolean.FALSE);
		}
	}

	/**
	 * @see Action#run()
	 */
	@Override
	public void run() {
		if (fOperationCode != -1 && fOperationTarget != null) {
			fOperationTarget.doOperation(fOperationCode);
		}
	}
}