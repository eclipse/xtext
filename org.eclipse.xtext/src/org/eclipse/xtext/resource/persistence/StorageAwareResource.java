/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.internal.Stopwatches;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class StorageAwareResource extends LazyLinkingResource {
	public static final String UNRESOLVABLE_FRAGMENT = "UNRESOLVABLE";

	private static final Logger LOG = Logger.getLogger(StorageAwareResource.class);

	@Inject(optional = true)
	private IResourceStorageFacade resourceStorageFacade;

	@Inject
	private PortableURIs portableURIs;

	private boolean isLoadedFromStorage = false;

	private IResourceDescription resourceDescription = null;

	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (!isLoaded && !isLoading && resourceStorageFacade != null
				&& resourceStorageFacade.shouldLoadFromStorage(this)) {
			LOG.debug("Loading " + getURI() + " from storage.");
			try {
				ResourceStorageLoadable in = resourceStorageFacade.getOrCreateResourceStorageLoadable(this);
				loadFromStorage(in);
				return;
			} catch (IOException e) {
				if (contents != null) {
					contents.clear();
				}
				if (eAdapters != null) {
					eAdapters.clear();
				}
				unload();
			}
		}
		super.load(options);
	}

	public void loadFromStorage(ResourceStorageLoadable storageInputStream) throws IOException {
		// check the argument for null before the internal state is modified
		Preconditions.checkNotNull(storageInputStream, "storageInputStream");
		Stopwatches.StoppedTask task = Stopwatches.forTask("Loading from storage");
		task.start();
		isLoading = true;
		isLoadedFromStorage = true;
		try {
			storageInputStream.loadIntoResource(this);
			isLoaded = true;
		} finally {
			isLoading = false;
			task.stop();
		}
	}

	@Override
	protected void doUnload() {
		super.doUnload();
		isLoadedFromStorage = false;
	}

	@Override
	protected void clearInternalState() {
		isLoadedFromStorage = false;
		super.clearInternalState();
	}

	@Override
	public synchronized EObject getEObject(String uriFragment) {
		if (portableURIs.isPortableURIFragment(uriFragment)) {
			return portableURIs.resolve(this, uriFragment);
		}
		return super.getEObject(uriFragment);
	}

	@Override
	protected Set<String> getUnresolvableURIFragments() {
		if (isLoadedFromStorage) {
			return Collections.singleton(StorageAwareResource.UNRESOLVABLE_FRAGMENT);
		}
		return super.getUnresolvableURIFragments();
	}

	public IResourceStorageFacade getResourceStorageFacade() {
		return resourceStorageFacade;
	}

	public PortableURIs getPortableURIs() {
		return portableURIs;
	}

	public boolean isLoadedFromStorage() {
		return isLoadedFromStorage;
	}

	public void setIsLoadedFromStorage(boolean isLoadedFromStorage) {
		this.isLoadedFromStorage = isLoadedFromStorage;
	}

	public IResourceDescription getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(IResourceDescription resourceDescription) {
		this.resourceDescription = resourceDescription;
	}
}
