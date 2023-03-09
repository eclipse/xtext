/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.debug;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.console.actions.CloseConsoleAction;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * @author Christian Dietrich - Initial contribution and API
 * 
 * {@link IConsolePageParticipant} that adds a close action to Xtext Build Console
 * 
 * @since 2.12
 */
public class XtextBuildConsolePageParticipant implements IConsolePageParticipant {
	
	private CloseConsoleAction fCloseAction;

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public void init(IPageBookViewPage page, IConsole console) {
		fCloseAction = new CloseConsoleAction(console);
		
		IToolBarManager manager = page.getSite().getActionBars().getToolBarManager();
		manager.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fCloseAction);
	}

	@Override
	public void dispose() {
		deactivated();
	}

	@Override
	public void activated() {
	}

	@Override
	public void deactivated() {
	}

}
