/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.File;

import org.eclipse.emf.common.util.URI;

/**
 * @noreference This class is not intended to be referenced by clients.
 */
public class UriUtil {
	/**
	 * A URI is a prefix of another URI if:
	 * <br/>
	 * <ul>
	 * 	<li>Both have the same scheme</li>
	 * 	<li>The prefix ends with a trailing separator</li>
	 * 	<li>The segments of both URIs match up to the prefix's length</li>
	 * </ul>
	 */
	public static boolean isPrefixOf(URI prefix, URI uri) {
		if (prefix.scheme() == null || !prefix.scheme().equals(uri.scheme()))
			return false;
		String[] prefixSeg = prefix.segments();
		String[] uriSeg = uri.segments();
		if (prefixSeg.length == 0 || uriSeg.length == 0)
			return false;
		if (!prefix.hasTrailingPathSeparator())
			return false;
		if (uriSeg.length < prefixSeg.length - 1)
			return false;
		for (int i = 0; i < prefixSeg.length - 1; i++)
			if (!uriSeg[i].equals(prefixSeg[i]))
				return false;
		return true;
	}

	/**
	 * In contrast to {@link URI#createFileURI(String)}, this appends a trailing path separator. This ensures
	 * the resulting URI can be used with methods like {@link #isPrefixOf(URI, URI)}, {@link URI#resolve(URI)} and
	 * {@link URI#deresolve(URI)}
	 */
	public static URI createFolderURI(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());
		return toFolderURI(uri);
	}
	
	public static URI toFolderURI(URI uri) {
		if (uri.hasTrailingPathSeparator()) {
			return uri;
		} else {
			return uri.appendSegment("");
		}
	}
}
