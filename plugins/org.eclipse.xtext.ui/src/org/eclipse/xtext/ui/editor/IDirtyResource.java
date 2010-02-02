/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * Representation of a resource that is currently edited. The accessible 
 * values may represent a cached, intermediate state of the resource. The 
 * are not necessarily a live view on the underlying resource. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IDirtyResource {

	/**
	 * @return the content of the resource as text, never <code>null</code>.
	 */
	String getContents();
	
	/**
	 * @return the description of the resource, never <code>null</code>.
	 */
	IResourceDescription getDescription();
	
	/**
	 * @return the URI of the resource, never <code>null</code>.
	 */
	URI getURI();
	
}
