/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.tasks.dialogfields;

/**
 * Change listener used by <code>ListDialogField</code> and
 * <code>CheckedListDialogField</code>
 */
public interface IListAdapter {

	/**
	 * A button from the button bar has been pressed.
	 */
	void customButtonPressed(ListDialogField field, int index);

	/**
	 * The selection of the list has changed.
	 */
	void selectionChanged(ListDialogField field);

	/**
	 * En entry in the list has been double clicked
	 */
	void doubleClicked(ListDialogField field);

}
