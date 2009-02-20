/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class FilteringXtextOutlinePage extends XtextContentOutlinePage {

	@Override
	protected void registerToolbarActions(IActionBars actionBars) {
		super.registerToolbarActions(actionBars);
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		if (toolBarManager != null) {
			toolBarManager.add(new FilterParserRulesAction(this));
		}
	}
}
