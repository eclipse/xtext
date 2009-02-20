/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IIndexFeeder {
	void registerResourceDescriptorFactory(ResourceDescriptor.Factory factory);

	void registerElementDescriptorFactory(EObjectDescriptor.Factory factory);
	
	void registerCrossReferenceDescriptorFactory(ECrossReferenceDescriptor.Factory factory);

	List<EObjectDescriptor> index(Resource resource, boolean isResolveProxies) throws IndexingException;

	List<EClassDescriptor> index(EPackage ePackage, boolean isRecurseSubpackages) throws IndexingException;

}
