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
 */
class StandaloneResourceSet extends XtextResourceSet {

	static val LOG = Logger.getLogger(StandaloneResourceSet)

	override getResource(URI uri, boolean loadOnDemand) {
		val superResource = super.getResource(uri, loadOnDemand)
		if (superResource != null) {
			superResource
		} else {
			LOG.warn('''Failed to resolve a resource by URI: '«uri»'; trying to load it by the URI's last segment: '«uri?.lastSegment»'.''');
			uri.resourceByLastSegment
		}
	}

	def getResourceByLastSegment(URI uri) {
		val lastSegment = uri?.lastSegment
		if (lastSegment == null) {
			return null
		}
		val resources = resources.filter[lastSegment == URI?.lastSegment]
		if (resources.empty) {
			return null
		}
		if (resources.size > 1) {
			LOG.error('''Failed to resolve a resource by the URI's last segment: '«uri?.lastSegment»'. Several resources are matched: «FOR resourceURI : resources.map[URI] SEPARATOR ','»'«resourceURI»'«ENDFOR».''');
			return null
		}
		return resources.head
	}

}
