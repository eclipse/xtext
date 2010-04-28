/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullJdtTypeProvider implements IJdtTypeProvider {

	private ResourceSet resourceSet;
	private TypeURIHelper typeURIHelper;

	public NullJdtTypeProvider(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(URIHelperConstants.PROTOCOL, this);
		typeURIHelper = new TypeURIHelper();
	}
	
	public JvmType findTypeByName(String name) throws TypeNotFoundException {
		throw new TypeNotFoundException("Type: '" + name + "' is not available.");
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public TypeURIHelper getTypeUriHelper() {
		return typeURIHelper;
	}

	public IJavaProject getJavaProject() {
		return null;
	}

}
