/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.ImplementedBy
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * Provider for resource set instances.
 */
@ImplementedBy(DefaultImpl)
interface IWebResourceSetProvider {
	
	def ResourceSet get(String resourceId)
	
	/**
	 * The default implementation creates a new resource set for each resource.
	 */
	class DefaultImpl implements IWebResourceSetProvider {
		
		override get(String resourceId) {
			return new XtextResourceSet
		}
		
	}
	
}