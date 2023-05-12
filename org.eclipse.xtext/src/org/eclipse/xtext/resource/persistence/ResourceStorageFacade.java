/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceStorageFacade implements IResourceStorageFacade {
	private static final Logger LOG = Logger.getLogger(ResourceStorageFacade.class);

	@Inject
	private IContextualOutputConfigurationProvider outputConfigurationProvider;

	@Inject
	private Provider<AbstractFileSystemAccess2> fileSystemAccessProvider;

	private boolean storeNodeModel = false;

	@Override
	public boolean shouldLoadFromStorage(StorageAwareResource resource) {
		SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findInstalledAdapter(resource.getResourceSet());
		if (adapter == null || adapter.getSourceLevelURIs().contains(resource.getURI()))
			return false;
		return doesStorageExist(resource);
	}

	@Override
	public ResourceStorageLoadable getOrCreateResourceStorageLoadable(StorageAwareResource resource) {
		try {
			ResourceSet resourceSet = resource.getResourceSet();
			ResourceStorageProviderAdapter stateProvider = getResourceStorageProviderAdapter(resourceSet);
			if (stateProvider != null) {
				ResourceStorageLoadable loadable = stateProvider.getResourceStorageLoadable(resource);
				if (loadable != null)
					return loadable;
			}
			URIConverter converter = resourceSet.getURIConverter();
			URI storageURI = getBinaryStorageURI(resource.getURI());
			if (converter.exists(storageURI, Collections.emptyMap())) {
				return createResourceStorageLoadable(converter.createInputStream(storageURI));
			}
			return createResourceStorageLoadable(
					getFileSystemAccess(resource).readBinaryFile(computeOutputPath(resource)));
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	protected boolean doesStorageExist(StorageAwareResource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		ResourceStorageProviderAdapter stateProvider = getResourceStorageProviderAdapter(resourceSet);
		if (stateProvider != null && stateProvider.getResourceStorageLoadable(resource) != null)
			return true;
		// check for next to original location, i.e. jars
		URIConverter converter = resourceSet.getURIConverter();
		if (converter.exists(getBinaryStorageURI(resource.getURI()), Collections.emptyMap()))
			return true;
		// if it's an archive URI, we don't need to look up the source folder-output folder scheme
		if (resource.getURI().isArchive())
			return false;
		URI uri = getFileSystemAccess(resource).getURI(computeOutputPath(resource));
		return uri != null && converter.exists(uri, null);
	}

	@Override
	public void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		MyByteArrayOutputStream bout = new MyByteArrayOutputStream();
		try {
			createResourceStorageWritable(bout).writeResource(resource);
		} catch (IOException e) {
			// something went wrong when writing the resource - stream's content is bogus and not written to disk
			LOG.warn("Cannot write storage for " + resource.getURI(), e);
			return;
		}
		fsa.generateFile(computeOutputPath(resource), new ByteArrayInputStream(bout.toByteArray(), 0, bout.length()));
	}

	@Override
	public ResourceStorageLoadable createResourceStorageLoadable(InputStream in) {
		return new ResourceStorageLoadable(in, isStoreNodeModel());
	}

	@Override
	public ResourceStorageWritable createResourceStorageWritable(OutputStream out) {
		return new ResourceStorageWritable(out, isStoreNodeModel());
	}

	protected ResourceStorageProviderAdapter getResourceStorageProviderAdapter(ResourceSet resourceSet) {
		return (ResourceStorageProviderAdapter) EcoreUtil.getExistingAdapter(
				resourceSet, ResourceStorageProviderAdapter.class);
	}

	protected AbstractFileSystemAccess2 getFileSystemAccess(StorageAwareResource resource) {
		AbstractFileSystemAccess2 fsa = fileSystemAccessProvider.get();
		fsa.setContext(resource);
		fsa.setOutputConfigurations(
				toMap(outputConfigurationProvider.getOutputConfigurations(resource), it -> it.getName()));
		return fsa;
	}

	protected String computeOutputPath(StorageAwareResource resource) {
		return getBinaryStorageURI(resource.getURI()).deresolve(getSourceContainerURI(resource), false, false, true)
				.path();
	}

	protected URI getSourceContainerURI(StorageAwareResource resource) {
		return resource.getURI().trimSegments(1).appendSegment("");
	}

	@Override
	public boolean hasStorageFor(URI uri) {
		return new ExtensibleURIConverterImpl().exists(getBinaryStorageURI(uri), Collections.emptyMap());
	}

	protected URI getBinaryStorageURI(URI sourceURI) {
		return sourceURI.trimSegments(1).appendSegment("." + sourceURI.lastSegment() + "bin");
	}

	public boolean isStoreNodeModel() {
		return storeNodeModel;
	}

	public void setStoreNodeModel(boolean storeNodeModel) {
		this.storeNodeModel = storeNodeModel;
	}

	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		@Override
		public synchronized byte[] toByteArray() {
			return buf;
		}

		public int length() {
			return count;
		}
	}

}
