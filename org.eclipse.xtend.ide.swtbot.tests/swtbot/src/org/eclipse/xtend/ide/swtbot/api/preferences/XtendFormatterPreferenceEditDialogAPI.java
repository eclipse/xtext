/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.api.preferences;

import org.eclipse.xtend.ide.swtbot.lowlevel.XtextSWTBotShell;

/**
 * API to access functionality from the xtend formatter preference edit dialog through SWTBot.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtendFormatterPreferenceEditDialogAPI {

	private final XtextSWTBotShell shell;

	XtendFormatterPreferenceEditDialogAPI(XtextSWTBotShell shell) {
		this.shell = shell;
	}

	public void cancel() {
		shell.bot().button("Cancel").click();
	}

	public void activateBracesSection() {
		shell.bot().tabItem("Braces").activate();
	}

	public void activateWhiteSpaceSection() {
		shell.bot().tabItem("White Space").activate();
	}

	public void activateBlankLinesSection() {
		shell.bot().tabItem("Blank Lines").activate();
	}

	public void activateNewLinesSection() {
		shell.bot().tabItem("New Lines").activate();
	}

	public void activateLineWrappingSection() {
		shell.bot().tabItem("Line Wrapping").activate();
	}

}
