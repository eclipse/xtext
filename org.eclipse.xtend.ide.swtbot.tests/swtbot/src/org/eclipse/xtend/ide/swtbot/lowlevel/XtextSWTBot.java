/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.swtbot.lowlevel;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.*;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.*;

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.WaitForObjectCondition;
import org.hamcrest.Matcher;

/**
 * Our own implementation of SWTBot to add new methods to standard implementation.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtextSWTBot extends SWTBot {

	public XtextSWTBot(Shell widget) {
		super(widget);
	}

	public XtextSWTBotShell shellWithRegex(String regex) {
		return new XtextSWTBotShell(shellsWithRegex(regex).get(0));
	}

	private List<Shell> shellsWithRegex(String regex) {
		Matcher<Shell> withRegex = withRegex(regex);
		WaitForObjectCondition<Shell> waitForShell = waitForShell(withRegex);
		waitUntilWidgetAppears(waitForShell);
		return waitForShell.getAllMatches();
	}
}
