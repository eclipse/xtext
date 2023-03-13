/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.lowlevel;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * Our own implementation of SWTWorkbenchBot to add new methods to standard implementation.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtextSWTWorkbenchBot extends SWTWorkbenchBot {

	@Override
	public XtextSWTBotShell shell(String text) {
		return shell(text, 0);
	}

	@Override
	public XtextSWTBotShell shell(String text, int index) {
		return new XtextSWTBotShell(shells(text).get(index));
	}

}
