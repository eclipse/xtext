/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.emf.index.runtime.impl;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.PersistableIndexStore;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;
import org.eclipse.emf.index.runtime.impl.IndexAwareResourceSet.IndexEntry;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class IndexAwareResourceSetTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
	}
	
	public void testSimple() throws Exception {
		IndexAwareResourceSet set = new IndexAwareResourceSet();
		PersistableIndexStore indexStore = new PersistableIndexStore();
		new EcoreIndexFeederImpl(indexStore).index(EcorePackage.eINSTANCE, true);
		set.setIndexStore(indexStore);
		set.addIndexer(new IndexEntry("ecore", new ResourceIndexerImpl()));
		
		set.getResource(URI.createFileURI("src/"+getClass().getName().replace('.', '/')+".ecore"), true);
		
		set.getStore().beginRead();
		Iterable<EObjectDescriptor> result = set.getStore().eObjectDAO().createQuery().executeListResult();
		set.getStore().endRead();
		Iterator<EObjectDescriptor> iterator = result.iterator();
		
		// four elements are expected to be indexed
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertFalse(iterator.hasNext());
	}
}
