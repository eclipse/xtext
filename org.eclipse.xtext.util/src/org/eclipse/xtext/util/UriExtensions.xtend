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
		return netUri.toEmfUri
	}
	
	/**
	 * returns a URI with empty authority, if absent and has file scheme.
	 */
	def URI toEmfUri(java.net.URI netUri) {
		val decoded = netUri.toDecodedString
		val uri = URI.createURI(decoded);
		val result = uri.withEmptyAuthority
		result
	}
	
	/**
	 * converts a java.net.URI to a decoded string
	 */
	def String toDecodedString(java.net.URI uri) {
		val scheme = uri.getScheme();
		val part = uri.getSchemeSpecificPart();
		if (scheme === null) {
			return part
		}
		return scheme + ':' + part;
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