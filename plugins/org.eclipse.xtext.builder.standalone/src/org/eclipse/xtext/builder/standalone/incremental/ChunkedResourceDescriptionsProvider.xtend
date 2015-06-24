/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
class ChunkedResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	override getResourceDescriptions(ResourceSet resourceSet) {
		val contextual = ContextualChunkedResourceDescriptions.findInEmfObject(resourceSet)
		if (contextual != null) {
			return contextual
		}
		throw new IllegalArgumentException("The given resourceSet doesn't contain ChunkedResourceDescriptions.") 
	}
		
}
