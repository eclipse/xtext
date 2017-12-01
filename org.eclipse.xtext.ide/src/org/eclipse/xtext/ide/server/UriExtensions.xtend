/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Singleton
import org.eclipse.emf.common.util.URI

/**
 * Normalizes file uris without authorities (<code>file:/path...</code>) to contain an empty authority (i.e. starts with three slashes:<code>file:///path...</code>).
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class UriExtensions extends org.eclipse.xtext.util.UriExtensions {
	
	/**
	 * returns the string representation of the given URI (with empty authority, if absent and has file scheme).
	 */
	def String toUriString(URI uri) {
		return uri.withEmptyAuthority.toString
	}

	/**
	 * converts a java.net.URI into a string representation with empty authority, if absent and has file scheme.
	 */
	def String toUriString(java.net.URI uri) {
		return toUriString(URI.createURI(uri.normalize.toString))
	}
	
	/**
	 * @deprecated use #toUriString(URI)
	 */
	@Deprecated()
	def String toPath(URI uri) {
		return toUriString(uri)
	}

	/**
	 * @deprecated use toUriString(URI)
	 */
	@Deprecated() 
	def String toPath(java.net.URI uri) {
		return toUriString(uri)
	}
	
	
	
}
