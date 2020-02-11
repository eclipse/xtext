/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.lowlevel;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * Our own implementation of SWTBotShell to add new methods to standard implementation.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtextSWTBotShell extends SWTBotShell {

	public XtextSWTBotShell(Shell shell) {
		super(shell);
	}
	
	@Override
	public XtextSWTBot bot() {
		return new XtextSWTBot(widget);
	}

}
