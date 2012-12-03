/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
@Singleton
public class Storage2UriMapperJavaImpl extends Storage2UriMapperImpl implements IStorage2UriMapperJdtExtensions {
	
	private static final Logger log = Logger.getLogger(Storage2UriMapperJavaImpl.class);
	
	static class PackageFragmentRootData {
		public URI uriPrefix;
		public final Object modificationStamp;
		public final IPackageFragmentRoot root;
		public PackageFragmentRootData(IPackageFragmentRoot root, Object modificationStamp) {
			this.modificationStamp = modificationStamp;
			this.root = root;
		}
		public Map<URI, IStorage> uri2Storage = newLinkedHashMap();
	}
	
	
	@Inject private JarEntryLocator locator;
	@Inject private UriValidator uriValidator;
	@Inject private IJdtHelper jdtHelper;
	
	/**
	 * @since 2.4
	 */
	@Override public void setUriValidator(UriValidator uriValidator) {
		super.setUriValidator(uriValidator);
		this.uriValidator = uriValidator;
	}
	
	/**
	 * @since 2.4
	 */
	public void setJdtHelper(IJdtHelper jdtHelper) {
		this.jdtHelper = jdtHelper;
	}
	
	public void setLocator(JarEntryLocator locator) {
		this.locator = locator;
	}
	
	private Map<String, PackageFragmentRootData> cachedPackageFragmentRootData = newLinkedHashMap();
	
	/**
	 * Ignores Java output folders when traversing a project.
	 * @return <code>false</code> if the folder is a java output folder. Otherwise <code>true</code>.
	 */
	@Override
	protected boolean isHandled(IFolder folder) {
		return super.isHandled(folder) && jdtHelper != null && !jdtHelper.isFromOutputPath(folder);
	}
	
	/**
	 * @since 2.4
	 */
	public Pair<URI, URI> getURIMapping(IPackageFragmentRoot root) throws JavaModelException {
		PackageFragmentRootData data = getData(root);
		if (data.uriPrefix == null)
			return null;
		IPath path = root.isExternal() ? root.getPath() : root.getUnderlyingResource().getLocation();
		URI physical = URI.createFileURI(path.toFile().getPath());
		return Tuples.create(data.uriPrefix, physical);
	}
	
	/**
	 * @since 2.4
	 */
	public Map<URI, IStorage> getAllEntries(IPackageFragmentRoot root) {
		try {
			if (root.getUnderlyingResource() instanceof IFolder) {
				return getAllEntries((IFolder)root.getUnderlyingResource());
			}
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
			return emptyMap();
		}
		PackageFragmentRootData data = getData(root);
		return data.uri2Storage;
	}
	
	private PackageFragmentRootData getData(IPackageFragmentRoot root) {
		final String id = root.getHandleIdentifier();
		final boolean isCachable = root instanceof JarPackageFragmentRoot;
		if (isCachable) {
			synchronized (cachedPackageFragmentRootData) {
				if (cachedPackageFragmentRootData.containsKey(id)) {
					final PackageFragmentRootData data = cachedPackageFragmentRootData.get(id);
					if (isUpToDate(data, root)) {
						return data;
					} else {
						cachedPackageFragmentRootData.remove(id);
					}
				}
			}
		}
		PackageFragmentRootData data = initializeData(root);
		if (isCachable) {
			synchronized (cachedPackageFragmentRootData) {
				if (!cachedPackageFragmentRootData.containsKey(id))
					cachedPackageFragmentRootData.put(id, data);
			}
		}
		return data;
	}
	
	private boolean isUpToDate(PackageFragmentRootData data, IPackageFragmentRoot root) {
		return Objects.equal(data.modificationStamp, computeModificationStamp(root));
	}
	
	private Object computeModificationStamp(IPackageFragmentRoot root) {
		try {
			IResource resource = root.getUnderlyingResource();
			if (resource != null) {
				return resource.getLocation().toFile().lastModified();
			}
			return root.getPath().toFile().lastModified();
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
		}
		return new Object();
	}

	/**
	 * @since 2.4
	 */
	protected PackageFragmentRootData initializeData(final IPackageFragmentRoot root) {
		final PackageFragmentRootData data = new PackageFragmentRootData(root, computeModificationStamp(root));
		try {
			final SourceAttachmentPackageFragmentRootWalker<Void> walker = new SourceAttachmentPackageFragmentRootWalker<Void>() {
				
				@Override
				protected URI getURI(IFile file,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					if (!uriValidator.isPossiblyManaged(file))
						return null;
					return super.getURI(file, state);
				}

				@Override
				protected URI getURI(IJarEntryResource jarEntry,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					if (!uriValidator.isPossiblyManaged(jarEntry))
						return null;
					final URI uri = locator.getURI(root, jarEntry, state);
					if (!uriValidator.isValid(uri, jarEntry))
						return null;
					return uri;
				}

				@Override
				protected Void handle(URI uri, IStorage storage,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					data.uri2Storage.put(uri, storage);
					return null;
				}
				
			};
			walker.traverse(root, false);
			if (walker.getBundleSymbolicName() != null)
				data.uriPrefix = URI.createPlatformResourceURI(walker.getBundleSymbolicName(), true);
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
		}
		return data;
	}
	
	@Override
	public Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
		
		Iterable<Pair<IStorage, IProject>> storages = super.getStorages(uri);
		if (!isEmpty(storages))
			return storages;
		List<Pair<IStorage, IProject>> result = newArrayListWithCapacity(1);
		for (PackageFragmentRootData data : cachedPackageFragmentRootData.values()) {
			// TODO better isPrefix
			if (data.uriPrefix == null || uri.toString().startsWith(data.uriPrefix.toString())) {
				IStorage storage = data.uri2Storage.get(uri);
				if (storage != null) {
					result.add(Tuples.create(storage, data.root.getJavaProject().getProject()));
				}
			}
		}
		return result;
	}
	

	@Override
	protected URI internalGetUri(IStorage storage) {
		if (!uriValidator.isPossiblyManaged(storage))
			return null;
		URI uri = super.internalGetUri(storage);
		if (uri != null)
			return uri;
		if (storage instanceof IJarEntryResource) {
			final IJarEntryResource storage2 = (IJarEntryResource) storage;
			Map<URI, IStorage> data = getAllEntries(storage2.getPackageFragmentRoot());
			for (Map.Entry<URI, IStorage> entry : data.entrySet()) {
				if (entry.getValue().equals(storage2))
					return entry.getKey();
			}
		}
		return null;
	}
	
	protected URI getPathToArchive(URI archiveURI) {
		if (!archiveURI.isArchive())
			throw new IllegalArgumentException("not an archive URI : " + archiveURI);
		String string = archiveURI.toString();
		return URI.createURI(string.substring(archiveURI.scheme().length() + 1, string.indexOf('!')));
	}
	
	@Deprecated public void elementChanged(ElementChangedEvent changeEvent) {
		log.warn("Storage2UriMapperJavaImpl.elementChanged(ElementChangedEvent) is deperecated and does nothing.");
	}


}
