/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import org.eclipse.emf.ecore.resource.ResourceSet

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.9 
 */
class ResourceSetClearer {
	/**
     * Clears the content of the resource set without sending notifications.
     * This avoids unnecessary, explicit unloads.
     */
	def void clearResourceSet(ResourceSet resourceSet) {
		val wasDeliver = resourceSet.eDeliver();
		try {
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
		} finally {
			resourceSet.eSetDeliver(wasDeliver);
		}
	}
}