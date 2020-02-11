/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.workspace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.UriUtil;

/**
 * Describes directories that contain source files of a project.
 */
public interface ISourceFolder {

	/**
	 * The logical name of the source folder, like "src/main/java"
	 */
	String getName();

	/**
	 * The (platform dependent) physical location of the source folder. The path will always end in a trailing
	 * separator. It will never be null.
	 */
	URI getPath();

	/**
	 * @param uri
	 *            to check
	 * @return true iff the given {@link URI} is a sub element of the {@link URI} of this {@link ISourceFolder}.
	 */
	default boolean contains(URI uri) {
		URI path = getPath();
		return UriUtil.isPrefixOf(path, uri);
	}

	/** @return a list of all URIs that are passed to the acceptor of {@link IFileSystemScanner#scan(URI, IAcceptor)} */
	default List<URI> getAllResources(IFileSystemScanner scanner) {
		List<URI> uris = new ArrayList<>();
		scanner.scan(getPath(), uri -> uris.add(uri));

		return uris;
	}

}
