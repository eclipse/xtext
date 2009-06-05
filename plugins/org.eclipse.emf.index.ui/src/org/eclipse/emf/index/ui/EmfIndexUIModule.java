/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.PersistableIndexStore;
import org.eclipse.emf.index.impl.memory.EClassDAOImpl;
import org.eclipse.emf.index.impl.memory.EObjectDAOImpl;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;
import org.eclipse.emf.index.impl.memory.EReferenceDAOImpl;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.ui.event.impl.ExtensionRegistryBasedIndexChangeListenerRegistry;
import org.eclipse.emf.index.ui.resource.impl.ExtensionRegistryBasedIndexerRegistry;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EmfIndexUIModule extends AbstractModule {

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
		bind(ResourceIndexer.Registry.class).to(ExtensionRegistryBasedIndexerRegistry.class).in(Scopes.SINGLETON);
		bind(ExtensionRegistryBasedIndexChangeListenerRegistry.class);
		
		bind(IExtensionRegistry.class).toInstance(Platform.getExtensionRegistry());
		// non-singletons
		bind(IndexFeeder.class).to(IndexFeederImpl.class); 
	}
}
