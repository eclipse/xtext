/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.util.internal.Stopwatches

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class StorageAwareResource extends LazyLinkingResource {
	public static val UNRESOLVABLE_FRAGMENT = "UNRESOLVABLE"
	static val Logger LOG = Logger.getLogger(StorageAwareResource)
	
	@Accessors(PUBLIC_GETTER) @Inject(optional=true) IResourceStorageFacade resourceStorageFacade
	
	@Accessors(PUBLIC_GETTER) @Inject PortableURIs portableURIs
	
	@Accessors boolean isLoadedFromStorage = false;
	
	@Accessors IResourceDescription resourceDescription = null;
	
	override load(Map<?, ?> options) throws IOException {
		if (!isLoaded && !isLoading && resourceStorageFacade !== null && resourceStorageFacade.shouldLoadFromStorage(this)) {
			if (LOG.isDebugEnabled) {
				LOG.debug("Loading "+URI+" from storage.")
			}
			try {
				val in = resourceStorageFacade.getOrCreateResourceStorageLoadable(this);
				loadFromStorage(in)
				return;
			} catch(IOException e) {
				// revert the resource into a clean state
				contents.clear
				eAdapters.clear
				unload
			}
		}
		super.load(options)
	}
	
	def void loadFromStorage(ResourceStorageLoadable storageInputStream) throws IOException {
		if (storageInputStream === null) {
			throw new NullPointerException('storageInputStream')
		}
		val task = Stopwatches.forTask("Loading from storage")
		task.start
		isLoading = true;
		isLoadedFromStorage = true;
		try {
			storageInputStream.loadIntoResource(this);
			isLoaded = true;
		} finally {
			isLoading = false
			task.stop
		}
	}
	
	override protected doUnload() {
		super.doUnload
		isLoadedFromStorage = false;
	}
	
	override protected clearInternalState() {
		isLoadedFromStorage = false;
		super.clearInternalState();
	}
	
	override synchronized getEObject(String uriFragment) {
		if (portableURIs.isPortableURIFragment(uriFragment)) {
			return portableURIs.resolve(this, uriFragment)
		}
		super.getEObject(uriFragment)
	}
	
	override protected getUnresolvableURIFragments() {
		if (isLoadedFromStorage) {
			return #{UNRESOLVABLE_FRAGMENT}
		} else {
			return super.getUnresolvableURIFragments()
		}
	}
	
}
