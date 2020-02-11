/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.persistence.StorageAwareResource

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class StorageAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {
	
	override getResourceDescription(Resource resource) {
		switch resource {
			StorageAwareResource case resource.resourceDescription !== null 
				    : resource.resourceDescription
			default :  super.getResourceDescription(resource)
		}
	}
	
}
