/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.api;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
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
			final IWorkbench workbench = PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(() -> {
				IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
				if (window != null) {
					Menu appMenu = workbench.getDisplay().getSystemMenu();
					Optional<MenuItem> item = Arrays.stream(appMenu.getItems())
							.filter(i -> i.getText().startsWith("Preferences") || i.getText().startsWith("Einstellungen")).findFirst();
					if (item.isPresent()) {
						MenuItem menuItem = item.get();
						Event event = new Event();
						event.time = (int) System.currentTimeMillis();
						event.widget = menuItem;
						event.display = workbench.getDisplay();
						menuItem.setSelection(true);
						menuItem.notifyListeners(SWT.Selection, event);
					}
				}
			});
		} else {
			bot.menu("Window").menu("Preferences").click();
		}
		return new PreferencesDialogAPI(bot.shell("Preferences"));
	}

}
