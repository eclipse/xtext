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
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider
import org.eclipse.xtext.workspace.WorkspaceConfigUtil

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {

	@Inject IWorkspaceConfigProvider workspaceConfigProvider

	override createResourceStorageLoadable(InputStream in) {
		return new BatchLinkableResourceStorageLoadable(in, isStoreNodeModel)
	}

	override createResourceStorageWritable(OutputStream out) {
		return new BatchLinkableResourceStorageWritable(out, isStoreNodeModel)
	}

	override protected getSourceContainerURI(StorageAwareResource resource) {
		val workspaceConfig = workspaceConfigProvider.getWorkspaceConfig(resource.resourceSet)
		val sourceFolder = WorkspaceConfigUtil.getSourceFolderContaining(workspaceConfig, resource.URI)
		if (sourceFolder != null) {
			return sourceFolder.path
		}
		return super.getSourceContainerURI(resource)
	}

} 