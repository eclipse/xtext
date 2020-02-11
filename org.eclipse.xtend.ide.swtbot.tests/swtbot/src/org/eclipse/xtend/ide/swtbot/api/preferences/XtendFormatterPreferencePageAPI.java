/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.api.preferences;

import org.eclipse.xtend.ide.swtbot.lowlevel.XtextSWTBot;

/**
 * API to access functionality from the xtend formatter preference page through SWTBot.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtendFormatterPreferencePageAPI {

	private XtextSWTBot bot;

	XtendFormatterPreferencePageAPI(XtextSWTBot bot) {
		this.bot = bot;
	}

	public XtendFormatterPreferenceEditDialogAPI openEditDialog() {
		bot.button("Edit...").click();
		return new XtendFormatterPreferenceEditDialogAPI(bot.shellWithRegex("Profile.*"));
	}

}
