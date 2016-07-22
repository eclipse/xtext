/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Singleton
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class UriExtensions {

	def URI toUri(String path) {
		return URI.createURI(java.net.URI.create(path).toPath)
	}

	def String toPath(URI uri) {
		return java.net.URI.create(uri.toString).toPath
	}

	def String toPath(java.net.URI uri) {
		val path = Paths.get(uri)
		return path.toUri.toString
	}

}
