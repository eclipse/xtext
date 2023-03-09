/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;

import com.google.inject.Inject;

/**
 * A utility class to remember a user's decision concerning "Don't ask again" preferences.<br>
 * The settings are stored in {@link IDialogSettings} of your language UIPlugin.
 *
 * @author Titouan Vervack - Initial contribution and API
 * @since 2.14
 */
public class DontAskAgainPreferences {
	/**
	 * A section id that holds the "don't ask me again" settings.
	 * <p>
	 * Value is of type <code>String</code> and is one of
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#ALWAYS},
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#NEVER} or (default)
	 * {@link org.eclipse.jface.dialogs.MessageDialogWithToggle#PROMPT}.
	 * </p>
	 *
	 * @since 2.14
	 */
	public static final String DONT_ASK_AGAIN_PREFERENCE_PREFIX = "dont_ask_again_preference";

	private @Inject IDialogSettings dialogSettings;

	/**
	 * Returns the prefix of this specific preference.
	 * This allows for granular removal of "Don't Ask Again" settings.
	 */
	protected String getPrefix() {
		return DONT_ASK_AGAIN_PREFERENCE_PREFIX;
	}

	/**
	 * Returns whether the "Don't Ask Again" question should be asked again.
	 *
	 * @return Whether to show the question again or not
	 */
	public boolean shouldAskAgain(String key) {
		return !MessageDialogWithToggle.NEVER.equals(getUserDecision(key));
	}

	/**
	 * Saves the user's preference to never ask a certain question again.
	 *
	 * @param key The unique identifier of the question never to ask again.
	 */
	protected void neverAskAgain(String key) {
		storeUserDecision(key, MessageDialogWithToggle.NEVER);
	}

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
	 * Rewrites the {@link #getPrefix()} section in {@link IDialogSettings} for the current language.<br>
	 * All the user decisions will be reset.
	 */
	public void forgetAllUserDecisions() {
		dialogSettings.addNewSection(getPrefix());
	}

	protected IDialogSettings getDontAskAgainDialogSettings() {
		IDialogSettings section = dialogSettings.getSection(getPrefix());
		if (section == null) {
			return dialogSettings.addNewSection(getPrefix());
		}
		return section;
	}

	protected void storeUserDecision(String key, String value) {
		getDontAskAgainDialogSettings().put(key, value);
	}
}
