/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.api;

import org.eclipse.xtend.ide.swtbot.api.preferences.PreferencesDialogAPI;
import org.eclipse.xtend.ide.swtbot.lowlevel.XtextSWTWorkbenchBot;

/**
 * Main menu of eclipse. Can be used to start all kind of actions, e.g. open the preferences.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class MainMenuAPI {

	private final XtextSWTWorkbenchBot bot;

	public MainMenuAPI(XtextSWTWorkbenchBot bot) {
		this.bot = bot;
	}

	public PreferencesDialogAPI openPreferences() {
		bot.menu("Window").menu("Preferences").click();
		return new PreferencesDialogAPI(bot.shell("Preferences"));
	}

}
