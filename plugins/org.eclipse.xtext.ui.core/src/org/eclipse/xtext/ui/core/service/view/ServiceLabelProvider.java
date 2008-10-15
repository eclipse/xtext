/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service.view;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry.Entry;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ServiceLabelProvider extends LabelProvider {

	private final ServiceRegistryViewSettings configs;

	public ServiceLabelProvider(ServiceRegistryViewSettings configs) {
		this.configs = configs;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IServiceScope) {
			IServiceScope scope = (IServiceScope) element;
			return scope.toString();
		}
		if (element instanceof Entry) {
			Entry entry = (Entry) element;
			String name = configs.isShowFQNames() ? entry.getServiceInterface().getName() : entry.getServiceInterface()
					.getSimpleName();
			return name + " (Prio: " + entry.getPriority() + ")";
		}
		// if (element instanceof ServiceDependency) {
		// ServiceDependency serviceDependency = (ServiceDependency) element;
		// return serviceDependency.getName() + " Type: " +
		// serviceDependency.getServiceType().getName()
		// + " (optional:" + serviceDependency.isOptional() + ")";
		// }
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof IServiceScope) {
			return XtextPluginImages.get(XtextPluginImages.OBJ_DESC_LANGUAGE);
		}
		if (element instanceof Entry) {
			// Entry entry = (Entry) element;
			return XtextPluginImages.get(XtextPluginImages.OBJ_DESC_SERVICE_LOADED);
			// if (entry.isLoaded()) {
			// return
			// XtextPluginImages.get(XtextPluginImages.OBJ_DESC_SERVICE_LOADED);
			// }
			// else {
			// return
			// XtextPluginImages.get(XtextPluginImages.OBJ_DESC_SERVICE_NOT_LOADED);
			//
			// }
		}

		return super.getImage(element);
	}
}
