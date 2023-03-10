/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.swt.widgets.Shell;

/**
 * A utility class to ask a user questions, through a dialog, and remember his decision.<br>
 * The settings are stored in {@link IDialogSettings} of your language UIPlugin.
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.8
 */
public class DontAskAgainDialogs extends DontAskAgainPreferences {
	/**
	 * A section id that holds the "don't ask me again" dialog settings.
	 * <p>
	 * Value is of type <code>String</code> and is one of
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#ALWAYS},
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#NEVER} or (default)
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#PROMPT}.
	 * </p>
	 * 
	 * @since 2.8
	 */
	public static final String DONT_ASK_AGAIN_DIALOG_PREFIX = "dont_ask_again_dialog";

	@Override
	protected String getPrefix() {
		return DONT_ASK_AGAIN_DIALOG_PREFIX;
	}
	
	/**
	 * Opens a {@link MessageDialogWithToggle} and stores the answer, if user activated the corresponding checkbox.
	 *
	 * @param question
	 *            The question to ask.
	 * @param dialogTitle
	 *            Title
	 * @param storeKey
	 *            The key used to store the decision in {@link IDialogSettings}, also used to read the
	 *            {@link #getUserDecision(String)}
	 * @param shell
	 *            the parent {@link Shell} of the dialog
	 * @return User answer, one of {@link IDialogConstants#YES_ID}, {@link IDialogConstants#NO_ID} or
	 *         {@link IDialogConstants#CANCEL_ID}
	 */
	public int askUser(String question, String dialogTitle, String storeKey, Shell shell) {
		MessageDialogWithToggle dialogWithToggle = MessageDialogWithToggle.openYesNoCancelQuestion(shell, dialogTitle,
				question, null, false, null, null);
		boolean rememberDecision = dialogWithToggle.getToggleState();
		int userAnswer = dialogWithToggle.getReturnCode();
		if (rememberDecision) {
			if (userAnswer == IDialogConstants.NO_ID) {
				neverAskAgain(storeKey);
			} else if (userAnswer == IDialogConstants.YES_ID) {
				storeUserDecision(storeKey, MessageDialogWithToggle.ALWAYS);
			}
		}
		return userAnswer;
	}
}
