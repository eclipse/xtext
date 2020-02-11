/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		val uri = resource.URI
		val mainProject = projectConfigProvider.getProjectConfig(resource.resourceSet)
		if (mainProject !== null) {
			val project = mainProject.workspaceConfig.findProjectContaining(uri)
			val sourceFolder = project?.findSourceFolderContaining(uri)
			if (sourceFolder !== null) {
				return sourceFolder.path
			}
		}
		return super.getSourceContainerURI(resource)
	}

} 
