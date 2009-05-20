/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.impl.PersistableIndexStore;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class BasicMemoryIndexModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IndexStore.class).to(PersistableIndexStore.class).in(Scopes.SINGLETON);
		bind(ResourceDescriptor.DAO.class).to(ResourceDAOImpl.class).in(Scopes.SINGLETON);
		bind(EObjectDescriptor.DAO.class).to(EObjectDAOImpl.class).in(Scopes.SINGLETON);
		bind(EReferenceDescriptor.DAO.class).to(EReferenceDAOImpl.class).in(Scopes.SINGLETON);
		bind(EPackageDescriptor.DAO.class).to(EPackageDAOImpl.class).in(Scopes.SINGLETON);
		bind(EClassDescriptor.DAO.class).to(EClassDAOImpl.class).in(Scopes.SINGLETON);
	}
}