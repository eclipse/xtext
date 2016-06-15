/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.swt.widgets.Shell;

import com.google.inject.Inject;

/**
 * A utility class to ask use questions and remember his decision.<br>
 * The settings a stored in {@link IDialogSettings} of your language UIPlugin.
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.8
 */
public class DontAskAgainDialogs {
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

	private @Inject IDialogSettings dialogSettings;

	/**
	 * Returns the stored user answer to the question identified with the passed key.
	 * 
	 * @param key
	 *            unique identifier . Represents the key to use when storing or reading the setting.
	 * 
	 * @return User decision for the corresponding question. Value is one of type <code>String</code> and is one of
	 *         {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#ALWAYS},
	 *         {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#NEVER} or (default)
	 *         {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#PROMPT}. Never <code>null</code>
	 */
	public String getUserDecision(String key) {
		String userDecision = getDontAskAgainDialogSettings().get(key);
		if (userDecision == null) {
			userDecision = MessageDialogWithToggle.PROMPT;
		}
		return userDecision;
	}

	/**
	 * Opens a {@link MessageDialogWithToggle} and stores the answer, if use activate the corresponding checkbox.
	 *
	 * @param question
	 *            The question to ask.
	 * @param dialogTitle
	 *            Title
	 * @param storeKey
	 *            the key used to store the decision in {@link IDialogSettings}, also used to read them
	 *            {@link #getUserDecision(String)}
	 * @param shell
	 *            the parent {@link Shell} of the dialog
	 * @return User answer one of {@link IDialogConstants#YES_ID}, {@link IDialogConstants#NO_ID} or
	 *         {@link IDialogConstants#CANCEL_ID}
	 */
	public int askUser(String question, String dialogTitle, String storeKey, Shell shell) {
		MessageDialogWithToggle dialogWithToggle = MessageDialogWithToggle.openYesNoCancelQuestion(shell, dialogTitle,
				question, null, false, null, null);
		boolean rememberDecision = dialogWithToggle.getToggleState();
		int userAnswer = dialogWithToggle.getReturnCode();
		if (rememberDecision) {
			if (userAnswer == IDialogConstants.NO_ID) {
				storeUserDecision(storeKey, MessageDialogWithToggle.NEVER);
			} else if (userAnswer == IDialogConstants.YES_ID) {
				storeUserDecision(storeKey, MessageDialogWithToggle.ALWAYS);
			}
		}
		return userAnswer;
	}

	/**
	 * Rewrites the {@link #DONT_ASK_AGAIN_DIALOG_PREFIX} section in {@link IDialogSettings} for the current language.<br>
	 * All the user decisions will be reseted.
	 */
	public void forgetAllUserDecisions() {
		dialogSettings.addNewSection(DONT_ASK_AGAIN_DIALOG_PREFIX);
	}

	private IDialogSettings getDontAskAgainDialogSettings() {
		IDialogSettings section = dialogSettings.getSection(DONT_ASK_AGAIN_DIALOG_PREFIX);
		if (section == null) {
			return dialogSettings.addNewSection(DONT_ASK_AGAIN_DIALOG_PREFIX);
		}
		return section;
	}

	private void storeUserDecision(String key, String value) {
		getDontAskAgainDialogSettings().put(key, value);
	}
}
