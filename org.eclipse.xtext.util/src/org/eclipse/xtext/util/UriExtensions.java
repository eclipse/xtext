/**
 * Copyright (c) 2017, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
public class UriExtensions {
	/**
	 * Returns an URI with empty authority, if authority is absent (null) and has file scheme.
	 */
	public URI toUri(String stringUri) {
		try {
			java.net.URI netUri = new java.net.URI(stringUri);
			return toEmfUri(netUri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns an URI with empty authority, if authority is absent (null) and has file scheme.
	 */
	public URI toEmfUri(java.net.URI netUri) {
		String decoded = toDecodedString(netUri);
		URI uri = URI.createURI(decoded, false);
		URI result = withEmptyAuthority(uri);
		return result;
	}

	/**
	 * Converts a java.net.URI to a decoded string
	 */
	public String toDecodedString(java.net.URI uri) {
		String scheme = uri.getScheme();
		String part = uri.getSchemeSpecificPart();
		if (scheme == null) {
			return part;
		}
		return scheme + ":" + part;
	}

	/**
	 * Converts the file URIs with an absent (null) authority to one with an empty ("") authority
	 */
	public URI withEmptyAuthority(URI uri) {
		if (uri.isFile() && uri.authority() == null) {
			return URI.createHierarchicalURI(uri.scheme(), "", uri.device(), uri.segments(), uri.query(),
					uri.fragment());
		}
		return uri;
	}
}
