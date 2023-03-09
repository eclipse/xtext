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
 * Change listener used by <code>DialogField</code>
 */
public interface IDialogFieldListener {

	/**
	 * The dialog field has changed.
	 * 
	 * @param field
	 *            the dialog field that changed
	 */
	void dialogFieldChanged(DialogField field);

}
