/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullJdtTypeProvider implements IJdtTypeProvider, Resource.Factory {

	private static final Logger log = Logger.getLogger(NullJdtTypeProvider.class);
	
	private ResourceSet resourceSet;
	private TypeURIHelper typeURIHelper;

	public NullJdtTypeProvider(ResourceSet resourceSet) {
		doLogMessage("Creating NullJdtTypeProvider");
		this.resourceSet = resourceSet;
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(URIHelperConstants.PROTOCOL, this);
		typeURIHelper = new TypeURIHelper();
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		return null;
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		return null;
	}

	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public TypeURIHelper getTypeUriHelper() {
		return typeURIHelper;
	}

	@Override
	public IJavaProject getJavaProject() {
		return null;
	}

	@Override
	public Resource createResource(URI uri) {
		doLogMessage("Creating empty resource instead of type resource:" + uri);
		return new ResourceImpl(uri) {
			@Override
			protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
				// ignore
			}
		};
	}

	protected void doLogMessage(String message) {
		if (log.isDebugEnabled()) {
			log.debug(message, new RuntimeException());
		} else if (log.isInfoEnabled()) {
			log.info(message);
		}
	}

}
