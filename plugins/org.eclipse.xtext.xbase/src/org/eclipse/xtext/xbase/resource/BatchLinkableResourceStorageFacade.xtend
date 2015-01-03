/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.inject.Inject
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
	
	@Inject AbstractFileSystemSupport fileSystemSupport
	@Inject extension FileLocations fileLocations
	
	override createResourceStorageLoadable(InputStream in) {
		return new BatchLinkableResourceStorageLoadable(in)
	}
	
	override createResourceStorageWritable(OutputStream out) {
		return new BatchLinkableResourceStorageWritable(out)
	}
	
	override protected getSourceContainerURI(StorageAwareResource resource) {
		val path = fileSystemSupport.getPath(resource)
		val sourceFolder = path.sourceFolder
		if (sourceFolder != null) {
			return resource.URI.trimSegments(sourceFolder.relativize(path).segments.size).appendSegment("")
		}
		return super.getSourceContainerURI(resource)
	}
	
} 