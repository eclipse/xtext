/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExportedEObjectProviderRegistry implements IExportedEObjectsProvider.Registry {

	public IExportedEObjectsProvider getExportedEObjectsProvider(Resource resource) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getExportedEObjectsProvider();
		}
		return null;
	}
	
}
