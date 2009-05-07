/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ui.dialog.FindEClassbyName;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class FindEClassByNameHandler extends AbstractHandler {

	private IndexStore index;

	@Inject
	public FindEClassByNameHandler(IndexStore index) {
		this.index = index;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		FindEClassbyName findEClassbyName = new FindEClassbyName(window.getShell(), index);
		findEClassbyName.setBlockOnOpen(true);
		findEClassbyName.open();
		return null;
	}
}
