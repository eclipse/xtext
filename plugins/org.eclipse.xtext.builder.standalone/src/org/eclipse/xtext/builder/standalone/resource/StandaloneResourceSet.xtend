/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.resource

import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @author Sven Efftinge
 */
class StandaloneResourceSet extends XtextResourceSet {

	static val LOG = Logger.getLogger(StandaloneResourceSet)

	override getResource(URI uri, boolean loadOnDemand) {
		if (loadOnDemand) {
			// try to find existing
			val resource = super.getResource(uri, false);
			if (resource != null) {
				if (!resource.loaded) {
					demandLoadHelper(resource);
				}
				return resource;
			}
			// try find with same simple name
			val resourceWithSameLastSegment = getResourceByLastSegment(uri)
			if (resourceWithSameLastSegment != null) {
				if (!resourceWithSameLastSegment.loaded) {
					demandLoadHelper(resourceWithSameLastSegment);
				}
				LOG.warn('''Failed to resolve a resource by URI: '«uri»'; Using similar URI instead: '«resourceWithSameLastSegment.URI»'.''');
				return resourceWithSameLastSegment;
			}
			return super.getResource(uri, true);
		} else {
			val superResource = super.getResource(uri, false)
			if (superResource != null) {
				return superResource
			} else {
				val resourceWithSameLastSegment = getResourceByLastSegment(uri)
				if (resourceWithSameLastSegment != null) {
					LOG.warn('''Failed to resolve a resource by URI: '«uri»'; Using similar URI instead: '«resourceWithSameLastSegment.URI»'.''');
				}
				return resourceWithSameLastSegment
			}
		}
	}

	def getResourceByLastSegment(URI uri) {
		val lastSegment = uri?.lastSegment
		if (lastSegment == null) {
			return null
		}
		val resources = resources.filter[lastSegment == URI?.lastSegment].toList
		if (resources.empty) {
			return null
		}
		if (resources.size > 1) {
			throw new IllegalArgumentException('''Failed to resolve a resource by the URI's last segment: '«uri?.lastSegment»'. Several resources are matched: «FOR resourceURI : resources.map[URI] SEPARATOR ','»'«resourceURI»'«ENDFOR».''');
		}
		return resources.head
	}

}
