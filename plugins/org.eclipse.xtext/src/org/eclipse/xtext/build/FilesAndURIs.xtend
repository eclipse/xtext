/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import java.io.File
import org.eclipse.emf.common.util.URI

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class FilesAndURIs {

	static def asFile(URI uri) {
		if(uri.isFile) 
			new File(uri.toFileString).canonicalFile
		else
			throw new IllegalArgumentException('Cannot convert non-file URI ' + uri + ' to file')
	}
	
	static def asURI(String uri) {
		URI.createURI(uri)
	}

	static def asFileURI(String path) {
		URI.createFileURI(new File(path).canonicalPath)
	}
	
	static def findRelativeURI(URI uri, Iterable<URI> baseURIs) {
		val relativeURIs = baseURIs
			.map[getRelativeURI(uri)]
			.filterNull
		if(relativeURIs.empty) 
			return null
		else 
			return relativeURIs.min[
				$0.segmentCount - $1.segmentCount
			]
	}
	
	private static def getRelativeURI(URI prefix, URI uri) {
		if(uri.scheme != prefix.scheme || uri.segmentCount < prefix.segmentCount || prefix.lastSegment != '') 
			return null			
		for(i: 0..<prefix.segmentCount - 1) {
			if(prefix.segment(i) != uri.segment(i))
				return null
		}
		URI.createURI(uri.segments.subList(prefix.segmentCount -1, uri.segmentCount).join('/'))
	}
}
