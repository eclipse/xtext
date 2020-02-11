/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot;

import org.eclipse.xtend.ide.swtbot.api.MainMenuAPI;
import org.eclipse.xtend.ide.swtbot.lowlevel.XtextSWTWorkbenchBot;

/**
 * Starter class for all SWTBot tests. Provides static methods to access all parts of the IDE.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class EclipseAPI {

	private static XtextSWTWorkbenchBot bot = new XtextSWTWorkbenchBot();

	private EclipseAPI() {
	}

	public static MainMenuAPI mainMenu() {
		return new MainMenuAPI(bot);
	}

	public static void closeAllShells() {
		bot.closeAllShells();
	}

}
