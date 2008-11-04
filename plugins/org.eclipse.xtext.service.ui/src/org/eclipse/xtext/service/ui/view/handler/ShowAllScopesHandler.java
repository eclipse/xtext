/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.ui.view.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.service.ui.view.ServiceRegistryView;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ShowAllScopesHandler extends AbstractServiceViewHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ServiceRegistryView view = getView(event);
		if(view!=null)
			view.showScopes();
		return this;
	}
}
