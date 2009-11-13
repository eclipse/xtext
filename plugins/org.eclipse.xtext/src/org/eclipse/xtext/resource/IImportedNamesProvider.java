/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultImportedNamesProvider;
import org.eclipse.xtext.resource.impl.ImportedNamesProviderRegistry;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultImportedNamesProvider.class)
public interface IImportedNamesProvider {
	
	/**
	 * returns the list of names this {@link IImportedNamesProvider}
	 * depends on. 
	 */
	Iterable<String> getImportedNames(Resource resource);
	
	@ImplementedBy(ImportedNamesProviderRegistry.class)
	interface Registry {
			
		IImportedNamesProvider getImportedNamesProvider(Resource resource);
		
	}
}
