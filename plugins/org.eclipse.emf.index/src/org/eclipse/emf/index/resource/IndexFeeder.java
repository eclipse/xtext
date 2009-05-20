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
 * references.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IndexFeeder {

	void deleteResourceDescriptor(URI resourceURI);

	void createResourceDescriptor(Resource resource, Map<String, Serializable> userData);

	void createEObjectDescriptor(EObject object, String name, String displayName, Map<String, Serializable> userData);

	void createEReferenceDescriptor(URI source, String eReferenceName, int index, URI target);

	void commit();
	
}
