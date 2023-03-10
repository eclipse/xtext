/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.editor.actions.AbstractToggleActionContributor;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractToggleOutlineContribution extends AbstractToggleActionContributor implements IOutlineContribution {

	@Override
	public void register(OutlinePage outlinePage) {
		IToolBarManager toolBarManager = outlinePage.getSite().getActionBars().getToolBarManager();
		toolBarManager.add(getAction());
		addPropertyChangeListener();
	}

	@Override
	public void deregister(OutlinePage outlinePage) {
		removePropertyChangeListener();
	}

}