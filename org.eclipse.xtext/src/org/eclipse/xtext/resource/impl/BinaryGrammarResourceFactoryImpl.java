/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public class BinaryGrammarResourceFactoryImpl implements Factory {

	@Override
	public Resource createResource(URI uri) {
		XMIResourceImpl resource = new XMIResourceImpl(uri);
		
		// make it a binary resource
		resource.getDefaultLoadOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
		
		// don't do any resolution, since the only external references point to Ecore elements from EPackages in the registry. 
		XMLResource.URIHandler uriHandler = new XMLResource.URIHandler() {

			@Override
			public void setBaseURI(URI uri) {
			}

			@Override
			public URI resolve(URI uri) {
				return uri;
			}

			@Override
			public URI deresolve(URI uri) {
				return uri;
			}
		};
		resource.getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
		return resource;
	}

}
