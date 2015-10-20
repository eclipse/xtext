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
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.workspace.IProjectConfigProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {

	@Inject IProjectConfigProvider projectConfigProvider

	override createResourceStorageLoadable(InputStream in) {
		return new BatchLinkableResourceStorageLoadable(in, isStoreNodeModel)
	}

	override createResourceStorageWritable(OutputStream out) {
		return new BatchLinkableResourceStorageWritable(out, isStoreNodeModel)
	}

	override protected getSourceContainerURI(StorageAwareResource resource) {
		val project = projectConfigProvider.getProjectConfig(resource.resourceSet)
		val uri = resource.URI
		val sourceFolder = project?.findSourceFolderContaining(uri)
		if (sourceFolder != null) {
			return sourceFolder.path
		}
		return super.getSourceContainerURI(resource)
	}

} 