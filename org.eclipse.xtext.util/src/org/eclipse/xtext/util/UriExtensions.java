/**
 * Copyright (c) 2017, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Singleton;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@Singleton
public class UriExtensions {
	/**
	 * Converts the given absolute, encoded stringUri to an EMF URI. If the URI
	 * is a {@link URI#isFile() file URI}, it is guaranteed that its
	 * {@link URI#authority() authority} is not null.
	 */
	public URI toUri(String stringUri) {
		URI result = URI.createURI(stringUri);
		// Short-circuit the good case where the URI doesn't contain any unusual escape sequences
		if (shouldValidateEncodingSequences(result, stringUri)) {
			return cleanupEncodedCharacters(result);
		}
		return withEmptyAuthority(result);
	}

	/**
	 * Return true if the URI has escape sequence that need to be re-validated and can potentially be simplified.
	 * 
	 * @since 2.29
	 */
	protected boolean shouldValidateEncodingSequences(URI rawUri, String uriAsString) {
		return uriAsString.contains("%");
	}

	/**
	 * Process the already encoded URI and eliminate unnecessarily encoded parts of it, e.g. encoded characters that
	 * would be valid in the part of the URI where they occur.
	 * 
	 * The result is supposed to be encoded in a minimal (only the strictly necessary but no optional escape sequences) way.
	 * 
	 * @since 2.29
	 */
	protected URI cleanupEncodedCharacters(URI encoded) {
		// Decompose the URI
		String authority = encoded.authority();
		String[] segments = encoded.segments();
		String device = encoded.device();
		String opaque = encoded.opaquePart();
		String query = encoded.query();
		String fragment = encoded.fragment();
		
		// Path the authority in-place if we are dealing with a file URI
		if (authority == null && encoded.isFile()) {
			authority = "";
		} else if (authority != null && !authority.isEmpty()) {
			authority = URI.encodeAuthority(URI.decode(authority), false);	
		}
		
		// For encoded URIs, the device information might have been encoded as part of the segments
		// so do a little dance if the device is absent and the first segment looks like one
		int segmentIdx = 0;
		if (device == null) {
			if (segments.length > 0) {
				String maybeDevice = URI.encodeSegment(URI.decode(segments[0]), false);
				if (URI.validDevice(maybeDevice)) {
					device = maybeDevice;
					if (segments.length == 2 && segments[1].isEmpty()) {
						segments = Strings.EMPTY_ARRAY;
					} else if (segments.length > 1) {
						segments = Arrays.copyOfRange(segments, 1, segments.length);
					} else {
						segments = null;
					}
				} else {
					segments[0] = maybeDevice;
					segmentIdx++;
				}
			}
		}
		// Handle segments, opaque-part, query, and fragment below
		if (segments != null) {
			for(int i = segmentIdx; i < segments.length; i++) {
				segments[i] = URI.encodeSegment(URI.decode(segments[i]), false);
			}
		}
		if (opaque != null) {
			opaque = URI.encodeOpaquePart(URI.decode(opaque), false);
		}
		if (query != null) {
			query = URI.encodeQuery(URI.decode(query), false);
		}
		if (fragment != null) {
			query = URI.encodeFragment(URI.decode(fragment), false);
		}
		// Depending on the shape of the URI recreate it from the decomposed parts which are now
		// correctly encoded in a minimal (only the strictly necessary but no optional escape sequences) way
		URI result;
		if (opaque != null) {
			result = withEmptyAuthority(URI.createGenericURI(encoded.scheme(), opaque, fragment));
		} else if (segments != null) {
			result = URI.createHierarchicalURI(encoded.scheme(), authority, device, segments, query, fragment);
		} else {
			result = URI.createHierarchicalURI(encoded.scheme(), authority, device, query, fragment);
		}
		return result;
	}

	/**
	 * Returns an URI with empty authority, if authority is absent (null) and
	 * has file scheme.
	 */
	public URI toEmfUri(java.net.URI netUri) {
		return toUri(netUri.toString());
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
	 * Converts the file URIs with an absent (null) authority to one with an
	 * empty ("") authority
	 */
	public URI withEmptyAuthority(URI uri) {
		if (uri.isFile() && uri.authority() == null) {
			String[] segments = uri.segments();
			String device = uri.device();
			String scheme = uri.scheme();
			String emptyAuthority = "";
			String query = uri.query();
			String fragment = uri.fragment();
			if (!uri.hasAbsolutePath()) {
				// must not pass an empty segment array by accident
				return URI.createHierarchicalURI(scheme, emptyAuthority, device, query, fragment);
			}
			return URI.createHierarchicalURI(scheme, emptyAuthority, device, segments, query, fragment);
		}
		return uri;
	}
}
