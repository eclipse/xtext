/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
@Singleton public class Storage2UriMapperImpl implements IStorage2UriMapper {
	
	private final static Logger log = Logger.getLogger(Storage2UriMapperImpl.class);
	
	@Inject private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
	@Inject private UriValidator uriValidator;
	
	/**
	 * @since 2.4
	 */
	public void setUriValidator(UriValidator uriValidator) {
		this.uriValidator = uriValidator;
	}
	
	/**
	 * @since 2.4
	 */
	public Map<URI, IStorage> getAllEntries(IContainer container) {
		final Map<URI,IStorage> result = newLinkedHashMap();
		try {
			container.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile storage = (IFile) resource;
						URI uri = getUri(storage);
						if (uri != null)
							result.put(uri, storage);
					}
					if (resource instanceof IFolder) {
						return isHandled((IFolder)resource);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	
	/**
	 * Return <code>true</code> if the folder should be traversed. <code>False</code> otherwise.
	 * Defaults to <code>true</code> for all folders.
	 * @return <code>true</code> if the folder should be traversed. <code>False</code> otherwise.
	 * @since 2.4
	 */
	protected boolean isHandled(IFolder folder) {
		return true;
	}

	public Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
		if (!uri.isPlatformResource()) {
			// support storage lookup by absolute file URI as it is possibly resolved by importURI references
			if (uri.isFile()) {
				IPath path = new Path(uri.toFileString());
				if (path.isAbsolute()) {
					IFile file = getWorkspaceRoot().getFileForLocation(path);
					return getStorages(file);
				}
			}
			return emptySet();
		}
		IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		return getStorages(file);
	}

	private Iterable<Pair<IStorage, IProject>> getStorages(IFile file) {
		if (file == null || !file.isAccessible()) {
			return emptySet();
		}
		return singleton(Tuples.<IStorage,IProject>create(file, file.getProject()));
	}

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public final URI getUri(IStorage storage) {
		if (!uriValidator.isPossiblyManaged(storage))
			return null;
		URI uri = internalGetUri(storage);
		if (uri != null && isValidUri(uri,storage))
			return uri;
		return null;
	}

	protected URI internalGetUri(IStorage storage) {
		if (storage instanceof IFile) {
			return URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		} 
		return null;
	}
	

	public boolean isValidUri(URI uri, IStorage storage) {
		boolean valid = uriValidator.isValid(uri, storage);
		return valid;
	}
	
	@Deprecated public void resourceChanged(IResourceChangeEvent event) {
		log.warn("Storage2UriMapperImpl.resourceChanged(IResourceChangeEvent) is deprecated and does nothing.");
	}
	
}
