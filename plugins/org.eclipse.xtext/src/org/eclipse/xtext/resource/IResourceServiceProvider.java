/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * a generic way to find a service for a resource.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IResourceServiceProvider.DefaultImpl.class)
public interface IResourceServiceProvider {
	
	/**
	 * @return an instance of <b>clazz</b> responsible for the given resource or null, if no such service exists.
	 */
	<T> T getService(Resource resource, Class<T> clazz);
	
	public static class DefaultImpl implements IResourceServiceProvider {

		public <T> T getService(Resource resource, Class<T> clazz) {
			if (resource instanceof XtextResource) {
				return ((XtextResource)resource).getAdapter(clazz);
			}
			return null;
		}
		
	}
}
