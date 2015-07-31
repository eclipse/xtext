/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * Extensible trace implementation that uses {@link IStorageAwareTraceContribution contributions} to resolve trace URIs.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StorageAwareTrace extends AbstractEclipseTrace {

	private IStorage localStorage;

	private String projectName;

	private ImmutableList<? extends IStorageAwareTraceContribution> contributions = ImmutableList.of();

	@Inject
	private void initializeContributions(ISharedStateContributionRegistry registry) {
		contributions = registry.getContributedInstances(IStorageAwareTraceContribution.class);
	}

	@Override
	public IStorage getLocalStorage() {
		return localStorage;
	}

	@Override
	public AbsoluteURI getLocalURI() {
		IStorage localStorage = getLocalStorage();
		return getURIForStorage(localStorage);
	}

	@Override
	public IProject getLocalProject() {
		return findProject(projectName);
	}
	
	/**
	 * Resolve the given path in the context of the known {@link #getLocalStorage() local storage}.
	 * 
	 * Try to resolve it by querying the {@link IStorageAwareTraceContribution contributions}.
	 * 
	 * @see IStorageAwareTraceContribution#tryResolvePath(IStorage, SourceRelativeURI)
	 */
	@Override
	protected AbsoluteURI resolvePath(SourceRelativeURI path) {
		for (int i = 0, size = contributions.size(); i < size; i++) {
			AbsoluteURI result = contributions.get(i).tryResolvePath(localStorage, path);
			if (result != null) {
				return result;
			}
		}
		if (localStorage instanceof IFile) {
			IProject project = ((IFile) localStorage).getProject();
			if (project != null) {
				AbsoluteURI result = resolvePath(project, path);
				if (result != null) {
					return result;
				}
			}
		}
		return super.resolvePath(path);
	}

	protected AbsoluteURI resolvePath(IProject project, SourceRelativeURI path) {
		String decodedPath = URI.decode(path.getURI().toString());
		IResource candidate = project.findMember(decodedPath);
		if (candidate != null && candidate.exists())
			return new AbsoluteURI(URI.createPlatformResourceURI(project.getFullPath() + "/" + decodedPath, true));
		return null;
	}

	protected void setLocalStorage(IStorage derivedResource) {
		this.localStorage = derivedResource;
		if (derivedResource instanceof IResource) {
			this.projectName = ((IResource) derivedResource).getProject().getName();
		}
	}

	@Override
	protected IStorage findStorage(SourceRelativeURI uri, IProject project) {
		AbsoluteURI resolvePath = resolvePath(uri);
		Iterable<Pair<IStorage, IProject>> allStorages = getStorage2uriMapper().getStorages(resolvePath.getURI());
		for (Pair<IStorage, IProject> storage : allStorages) {
			if (project.equals(storage.getSecond())) {
				return storage.getFirst();
			}
		}
		return null;
	}

	@Override
	protected InputStream getContents(SourceRelativeURI uri, IProject project) throws IOException {
		try {
			IStorage storage = findStorage(uri, project);
			if (storage == null)
				return null;
			return storage.getContents();
		} catch(CoreException e) {
			throw new WrappedCoreException(e);
		}
	}

	@Override
	protected void setTraceRegionProvider(ITraceRegionProvider traceRegionProvider) {
		super.setTraceRegionProvider(traceRegionProvider);
	}
	
}
