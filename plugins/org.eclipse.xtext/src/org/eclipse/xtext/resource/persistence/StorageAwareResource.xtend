/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.inject.Inject
import java.io.IOException
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.linking.lazy.LazyLinkingResource
import org.eclipse.xtext.resource.IResourceDescription

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class StorageAwareResource extends LazyLinkingResource {
	
	static val Logger LOG = Logger.getLogger(StorageAwareResource)
	
	@Accessors(PUBLIC_GETTER) @Inject ResourceStorageFacade resourceStorageFacade
	
	@Accessors(PUBLIC_GETTER) protected boolean isLoadedFromStorage = false;
	
	@Accessors protected IResourceDescription resourceDescription = null;
	
	override load(Map<?, ?> options) throws IOException {
		if (!isLoaded && !isLoading && resourceStorageFacade.shouldLoadFromStorage(this)) {
			if (LOG.isDebugEnabled) {
				LOG.debug("Loading "+URI+" from storage.")
			}
			val in = resourceStorageFacade.getExistingResourceStorageInputStream(this);
			load(in)
		} else {
			super.load(options)
		}
	}
	
	def void load(ResourceStorageInputStream storageInputStream) {
		if (storageInputStream == null) {
			throw new NullPointerException('storageInputStream')
		}
		isLoading = true;
		isLoadedFromStorage = true;
		try {
			storageInputStream.loadIntoResource(this);
			isLoaded = true;
		} finally {
			isLoading = false
		}
	}
	
	override protected clearInternalState() {
		isLoadedFromStorage = false;
		super.clearInternalState();
	}
	
}