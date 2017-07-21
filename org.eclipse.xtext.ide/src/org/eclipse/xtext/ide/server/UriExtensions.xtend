/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Singleton
import java.nio.file.FileSystemNotFoundException
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class UriExtensions {

	def URI toUri(String pathWithScheme) {
		// URI is used to get path of the uri without scheme
		var path = URI.createURI(pathWithScheme).path
		return URI.createURI(path.toPath)
	}

	def String toPath(URI uri) {
		return uri.toString
	}

	def String toPath(java.net.URI uri) {
		return uri.path.toPath
	}

	/**
	 * We need to check if current path represents directory in file system
	 * and need to add trailing slash if path represents directory.
	 */
	private def toPath(String uri) {
		try {
			val path = Paths.get(uri)
			// On Linux Paths.get returns encoded URI (e.x. cyrillic)
			return URLDecoder.decode(path.toUri.toString, StandardCharsets.UTF_8.name);
		} catch (FileSystemNotFoundException e) {
			return uri
		}
	}
}

