/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * The write interface to the index. Creates descriptors and keeps the index consistent, e.g. free of dangling
 * references. Write operations take the form of transactions. Each transaction starts with a call to {@link #begin()}
 * followed by several calls to the <code>createXDescriptor</code> methods. The transaction is finished by calling
 * {@link #commit()}.
 * 
 * The indexFeeder implementation is currently NOT thread safe.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IndexFeeder {

	void begin();
	
	void deleteResourceDescriptor(URI resourceURI);

	void createResourceDescriptor(Resource resource, Map<String, Serializable> userData);

	void createEObjectDescriptor(EObject object, String name, String displayName, Map<String, Serializable> userData);

	void createEReferenceDescriptor(URI source, String eReferenceName, int index, URI target);

	void commit();
	
	void rollback();

}
