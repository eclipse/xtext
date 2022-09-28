/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
import org.eclipse.emf.common.util.URI;

/**
 * Normalizes file uris without authorities (<code>file:/path...</code>) to contain an empty authority (i.e. starts with three slashes:<code>file:///path...</code>).
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
public class UriExtensions extends org.eclipse.xtext.util.UriExtensions {

	/**
	 * returns the encoded string representation of the given URI (with empty authority, if absent and has file scheme).
	 */
	public String toUriString(URI uri) {
		return withEmptyAuthority(uri).toString();
	}

	/**
	 * converts a java.net.URI into a string representation with empty authority, if absent and has file scheme.
	 */
	public String toUriString(java.net.URI uri) {
		return toUriString(URI.createURI(uri.normalize().toString()));
	}

}
