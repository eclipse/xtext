/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.resource.impl.SimpleResourceIndexerRegistryImpl;

import com.google.inject.Scopes;

/**
 * Google Guice module that describes the default configuration of EMF Index.
 *  
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexDefaultModule extends BasicMemoryIndexModule {

	@Override
	protected void configure() {
		super.configure();
		
		// unlikely to be changed
		bind(EcoreIndexFeeder.class).to(EcoreIndexFeederImpl.class).in(Scopes.SINGLETON);
		bind(ResourceIndexer.Registry.class).to(SimpleResourceIndexerRegistryImpl.class).in(Scopes.SINGLETON);

		// non-singletons
		bind(IndexFeeder.class).to(IndexFeederImpl.class); 
	}
	
}
