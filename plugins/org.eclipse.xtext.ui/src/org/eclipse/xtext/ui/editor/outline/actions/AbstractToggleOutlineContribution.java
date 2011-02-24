/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.editor.actions.AbstractToggleActionContributor;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractToggleOutlineContribution extends AbstractToggleActionContributor implements IOutlineContribution {

	public void register(OutlinePage outlinePage) {
		IToolBarManager toolBarManager = outlinePage.getSite().getActionBars().getToolBarManager();
		toolBarManager.add(getAction());
		addPropertyChangeListener();
	}

	public void deregister(OutlinePage outlinePage) {
		removePropertyChangeListener();
	}

}