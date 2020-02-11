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
 * API to access functionality from the preference dialog through SWTBot.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class PreferencesDialogAPI {

	private final XtextSWTBotShell shell;

	public PreferencesDialogAPI(XtextSWTBotShell shell) {
		this.shell = shell;
	}

	public void cancel() {
		shell.bot().button("Cancel").click();
	}

	public XtendFormatterPreferencePageAPI activateXtendFormatterPage() {
		shell.bot().tree().expandNode("Xtend").select("Formatter");
		return new XtendFormatterPreferencePageAPI(shell.bot());
	}

}
