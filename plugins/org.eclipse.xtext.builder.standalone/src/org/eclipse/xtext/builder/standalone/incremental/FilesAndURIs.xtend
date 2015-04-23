/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.io.File
import org.eclipse.emf.common.util.URI
import java.net.URLClassLoader
import java.net.URL

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class FilesAndURIs {
	
	/**
	 * Unfortunately, {@link File#toURI} does not append '/' to directiories, making it useless for the {@link URLClassLoader}.
	 */
	static def asURI(File file) {
		val uri = URI.createFileURI(file.absolutePath)
		if(file.isDirectory)
			uri.appendSegment('')
		else 
			uri
	}
	
	static def asFile(URI uri) {
		new File(asPath(uri))
	}
	
	static def asPath(URI uri) {
		if(uri.isFile) 
			uri.toFileString
		else
			throw new IllegalArgumentException('Cannot convert non-file URI ' + uri + ' to file')
	}
	
	static def asURI(String uri) {
		URI.createURI(uri)
	}

	static def asFileURI(String path) {
		URI.createFileURI(path)
	}
	
	static def asPath(URL url) {
		url.toString.asURI.asPath
	}
	
	static def findSourceRootRelativeURI(URI uri, BuildRequest request) {
		for(sourceRootURI: request.sourceRoots) {
			val relativeURI = uri.deresolve(sourceRootURI)
			if(relativeURI != uri) 
				return relativeURI
		}
		return null
	}
	
}