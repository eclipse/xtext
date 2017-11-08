/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util

import org.eclipse.emf.common.util.URI

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
class UriExtensions {
	
	/**
	 * returns a URI with empty authority, if absent and has file scheme.
	 */
	def URI toUri(String stringUri) {
		val netUri = new java.net.URI(stringUri)
		val decoded = '''«netUri.scheme»:«netUri.schemeSpecificPart»'''.toString
		val uri = URI.createURI(decoded);
		val result = uri.withEmptyAuthority
		result
	}
	
	/**
	 * converts the file URIs with an absent authority to one with an empty 
	 */
	def URI withEmptyAuthority(URI uri) {
		if (uri.isFile && uri.authority === null) {		
			URI.createHierarchicalURI(uri.scheme, "", uri.device, uri.segments, uri.query, uri.fragment)
		} else {
			uri
		}
	}
	
}