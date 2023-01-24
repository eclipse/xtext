/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.api;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.xtend.ide.swtbot.api.preferences.PreferencesDialogAPI;
import org.eclipse.xtend.ide.swtbot.lowlevel.XtextSWTWorkbenchBot;

/**
 * Main menu of eclipse. Can be used to start all kind of actions, e.g. open the preferences.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @author Christian Dietrich
 * @author Karsten Thoms
 */
public class MainMenuAPI {

	private final XtextSWTWorkbenchBot bot;

	public MainMenuAPI(XtextSWTWorkbenchBot bot) {
		this.bot = bot;
	}

	/**
	 * Opens the Eclipse Preferences dialog. On MacOS the preferences are in the system menu which is not accessible via SWTBot.
	 * 
	 */
	public PreferencesDialogAPI openPreferences() {
		// see https://www.eclipse.org/forums/index.php/t/854280/
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			// On Mac, the Preferences menu is under the system menu
			// so we must open it programmatically
			UIThreadRunnable.asyncExec(() -> {
				PreferenceDialog dialog = PreferencesUtil
					.createPreferenceDialogOn
						(bot.activeShell().widget, null, null, null);
				dialog.open();
			});
		} else {
			bot.menu("Window").menu("Preferences").click();
		}
		return new PreferencesDialogAPI(bot.shell("Preferences"));
	}

}
