/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.PersistableIndexStore;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;
import org.eclipse.emf.index.tracking.EmfResourceChangeListener;
import org.eclipse.emf.index.tracking.impl.EmfResourceChangeListenerRegistryImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * Google Guice module that describes the default configuration of EMF Index.
 *  
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexDefaultModule extends AbstractModule {

	@Override
	protected void configure() {
		// Storage backend providers should override these
		bind(IndexStore.class).to(PersistableIndexStore.class).in(Scopes.SINGLETON);
		bind(ResourceDescriptor.DAO.class).to(ResourceDAOImpl.class).in(Scopes.SINGLETON);
		bind(EObjectDescriptor.DAO.class).to(EObjectDAOImpl.class).in(Scopes.SINGLETON);
		bind(EReferenceDescriptor.DAO.class).to(EReferenceDAOImpl.class).in(Scopes.SINGLETON);
		bind(EPackageDescriptor.DAO.class).to(EPackageDAOImpl.class).in(Scopes.SINGLETON);
		bind(EClassDescriptor.DAO.class).to(EClassDAOImpl.class).in(Scopes.SINGLETON);
		
		// unlikely to be changed
		bind(EcoreIndexFeeder.class).to(EcoreIndexFeederImpl.class).in(Scopes.SINGLETON);
		bind(EmfResourceChangeListener.Registry.class).to(EmfResourceChangeListenerRegistryImpl.class).in(Scopes.SINGLETON);

		// non-singletons
		bind(ResourceIndexer.class).to(ResourceIndexerImpl.class);
		bind(IndexFeeder.class).to(IndexFeederImpl.class); 
	}
	
}
