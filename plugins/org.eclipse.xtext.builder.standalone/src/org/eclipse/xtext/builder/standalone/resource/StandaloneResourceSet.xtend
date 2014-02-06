/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.resource

import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class StandaloneResourceSet extends XtextResourceSet {

	override getResource(URI uri, boolean loadOnDemand) {
		try {
			val superResource = super.getResource(uri, loadOnDemand)
			if (superResource != null) {
				superResource
			} else {
				uri.resourceByLastSegment
			}
		} catch (RuntimeException e) {
			uri.resourceByLastSegment
		}
	}

	def getResourceByLastSegment(URI uri) {
		val lastSegment = uri?.lastSegment
		if (lastSegment != null) {
			for (resource : resources) {
				if (lastSegment == resource.URI?.lastSegment) {
					return resource
				}
			}
		}
		throw new RuntimeException("Cannot create a resource for '" + uri + "'; a registered resource factory is needed")
	}

}
