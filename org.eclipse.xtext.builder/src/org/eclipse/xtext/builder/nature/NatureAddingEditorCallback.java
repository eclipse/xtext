/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.nature;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.util.DontAskAgainDialogs;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class NatureAddingEditorCallback extends IXtextEditorCallback.NullImpl {
	private static final String ADD_XTEXT_NATURE = "add_xtext_nature";
	@Inject
	private ToggleXtextNatureCommand toggleNature;

	private @Inject DontAskAgainDialogs dialogs;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		IResource resource = editor.getResource();
		if (resource != null && !toggleNature.hasNature(resource.getProject()) && resource.getProject().isAccessible()
				&& !resource.getProject().isHidden()) {
			String title = Messages.NatureAddingEditorCallback_MessageDialog_Title;
			String message = Messages.NatureAddingEditorCallback_MessageDialog_Msg0 + resource.getProject().getName()
					+ Messages.NatureAddingEditorCallback_MessageDialog_Msg1;
			boolean addNature = false;
			if (MessageDialogWithToggle.PROMPT.equals(dialogs.getUserDecision(ADD_XTEXT_NATURE))) {
				int userAnswer = dialogs.askUser(message, title, ADD_XTEXT_NATURE, editor.getEditorSite().getShell());
				if (userAnswer == IDialogConstants.YES_ID) {
					addNature = true;
				} else if (userAnswer == IDialogConstants.CANCEL_ID) {
					return;
				}
			} else if (MessageDialogWithToggle.ALWAYS.equals(dialogs.getUserDecision(ADD_XTEXT_NATURE))) {
				addNature = true;
			}
			if (addNature) {
				toggleNature.toggleNature(resource.getProject());
			}
		}
	}
}