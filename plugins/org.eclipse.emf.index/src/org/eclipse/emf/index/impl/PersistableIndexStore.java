/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IPersistableIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.impl.memory.EClassDAOImpl;
import org.eclipse.emf.index.impl.memory.EObjectDAOImpl;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;
import org.eclipse.emf.index.impl.memory.EReferenceDAOImpl;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class PersistableIndexStore extends BasicIndexStore implements IPersistableIndexStore {

	@Inject
	public PersistableIndexStore(EClassDescriptor.DAO eClassDao, ResourceDescriptor.DAO resourceDao,
			EObjectDescriptor.DAO eObjectDao, EReferenceDescriptor.DAO eReferenceDao, EPackageDescriptor.DAO ePackageDao) {
		super(eClassDao, resourceDao, eObjectDao, eReferenceDao, ePackageDao);
		if (!(ePackageDAO instanceof Serializable) || !(eClassDAO instanceof Serializable)
				|| !(resourceDAO instanceof Serializable) || !(eObjectDAO instanceof Serializable)
				|| !(eReferenceDAO instanceof Serializable)) {
			throw new IllegalStateException("All DAOs of a PersistableIndexStore must be persistable");
		}
	}
	
	/**
	 * for convenient use without guice (e.g. in MWE or in unit tests)
	 */
	public PersistableIndexStore() {
		super(new EClassDAOImpl(), new ResourceDAOImpl(), new EObjectDAOImpl(), new EReferenceDAOImpl(), new EPackageDAOImpl());
	}

	public void save(OutputStream outputStream) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(outputStream));
		try {
			objectOutputStream.writeObject(ePackageDAO);
			objectOutputStream.writeObject(eClassDAO);
			objectOutputStream.writeObject(resourceDAO);
			objectOutputStream.writeObject(eObjectDAO);
			objectOutputStream.writeObject(eReferenceDAO);
		}
		finally {
			objectOutputStream.close();
		}
	}

	public void load(InputStream inputStream) throws IOException, ClassNotFoundException, ClassCastException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(inputStream));
		try {
			ePackageDAO = (EPackageDescriptor.DAO) objectInputStream.readObject();
			eClassDAO = (EClassDescriptor.DAO) objectInputStream.readObject();
			resourceDAO = (ResourceDescriptor.DAO) objectInputStream.readObject();
			eObjectDAO = (EObjectDescriptor.DAO) objectInputStream.readObject();
			eReferenceDAO = (EReferenceDescriptor.DAO) objectInputStream.readObject();
		}
		finally {
			objectInputStream.close();
		}
		initializeDAOs();
	}

}
