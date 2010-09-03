/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextOutlinePage extends OutlinePage {

	@Inject
	private FilterParserRulesAction filterParserRulesAction;
	
	@Override
	protected void configureActions() {
		super.configureActions();
		IToolBarManager toolBarManager = getSite().getActionBars().getToolBarManager();
		toolBarManager.add(filterParserRulesAction);
		filterParserRulesAction.activate(this);
	}
}
