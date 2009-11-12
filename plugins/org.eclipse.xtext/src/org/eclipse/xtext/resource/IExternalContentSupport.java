/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ExternalContentSupport.class)
public interface IExternalContentSupport {

	public interface IExternalContentProvider {
		String getContent(URI uri);
		boolean hasContent(URI uri);
	}
	
	void configureResourceSet(ResourceSet resourceSet, IExternalContentProvider contentProvider);
	
}
