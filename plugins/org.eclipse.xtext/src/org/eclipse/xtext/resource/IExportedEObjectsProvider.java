/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultExportedEObjectsProvider;
import org.eclipse.xtext.resource.impl.ExportedEObjectProviderRegistry;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultExportedEObjectsProvider.class)
public interface IExportedEObjectsProvider {
	
	/**
	 * @return descriptions of all EObjects provided by the given Resource. The result is expected
	 * 	to return any combination of <code>name</code> and <code>eObjectOrProxy</code> only once
	 *  as an {@link IEObjectDescription}.
	 */
	Iterable<IEObjectDescription> getExportedObjects(Resource resource);
	
	@ImplementedBy(ExportedEObjectProviderRegistry.class)
	interface Registry {
		IExportedEObjectsProvider getExportedEObjectsProvider(Resource resource);
	}
}
