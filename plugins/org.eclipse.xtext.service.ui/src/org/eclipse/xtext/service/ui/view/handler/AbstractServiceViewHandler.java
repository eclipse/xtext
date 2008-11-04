/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.ui.view.handler;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.service.ui.view.ServiceRegistryView;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractServiceViewHandler extends AbstractHandler {

	protected ServiceRegistryView getView(ExecutionEvent event) {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if (activePart instanceof ServiceRegistryView) {
			return (ServiceRegistryView) activePart;
		}
		return null;
	}

	protected ServiceRegistryView getView(Map<?, ?> parameters) {
		Object site = parameters.get("org.eclipse.ui.part.IWorkbenchPartSite");
		if (site instanceof IWorkbenchPartSite) {
			if (((IWorkbenchPartSite) site).getPart() instanceof ServiceRegistryView) {
				return ((ServiceRegistryView) ((IWorkbenchPartSite) site).getPart());
			}
		}
		return null;
	}

}
