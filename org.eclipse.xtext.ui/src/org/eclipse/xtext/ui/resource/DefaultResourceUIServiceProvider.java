/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultResourceUIServiceProvider implements IResourceServiceProviderExtension, IResourceUIServiceProvider, IResourceUIServiceProviderExtension {

	private IResourceServiceProvider delegate;
	
	@Inject
	private IJdtHelper jdtHelper;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject(optional=true)
	private IWorkspace workspace;

	@Inject
	public DefaultResourceUIServiceProvider(IResourceServiceProvider delegate) {
		this.delegate = delegate;
	}

	@Override
	public Manager getContainerManager() {
		return delegate.getContainerManager();
	}

	@Override
	public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
		return delegate.getResourceDescriptionManager();
	}

	@Override
	public IResourceValidator getResourceValidator() {
		return delegate.getResourceValidator();
	}

	@Inject
	@ResourceServiceDescriptionLabelProvider
	private ILabelProvider descriptionLabelProvider;

	@Override
	public ILabelProvider getLabelProvider() {
		return descriptionLabelProvider;
	}
	
	public void setDescriptionLabelProvider(ILabelProvider descriptionLabelProvider) {
		this.descriptionLabelProvider = descriptionLabelProvider;
	}

	@Override
	public boolean canHandle(URI uri) {
		boolean result = delegate.canHandle(uri);
		return result;
	}

	/**
	 * Compute whether the given storage is interesting in the context of Xtext.
	 * By default, it will delegate to {@link #canHandle(URI)} and perform a subsequent
	 * check to filter storages from Java target folders.
	 * @return <code>true</code> if the <code>uri / storage</code> pair should be processed.
	 */
	@Override
	public boolean canHandle(URI uri, IStorage storage) {
		if (delegate.canHandle(uri)) {
			if (isJavaCoreAvailable()) {
				return !isJavaTargetFolder(storage);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public boolean canBuild(URI uri, IStorage storage) {
		return canHandle(uri, storage);
	}

	/**
	 * @since 2.1
	 */
	protected boolean isJavaCoreAvailable() {
		return jdtHelper.isJavaCoreAvailable();
	}

	/**
	 * @since 2.1
	 */
	protected boolean isJavaTargetFolder(IStorage storage) {
		if (storage instanceof IResource) {
			return jdtHelper.isFromOutputPath((IResource) storage);
		}
		return false;
	}

	@Inject 
	private IEncodingProvider encodingProvider;
	
	@Override
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	@Inject(optional=true)
	@LanguageSpecific
	private IURIEditorOpener uriEditorOpener;

	@Override
	public IURIEditorOpener getURIEditorOpener() {
		return uriEditorOpener;
	}
	
	/**
	 * @deprecated use <code>get(IReferenceUpdater.class)</code> instead
	 */
	@Override
	@Deprecated
	public IReferenceUpdater getReferenceUpdater() {
		return get(IReferenceUpdater.class);
	}
	
	@Override
	public <T> T get(Class<T> t) {
		return delegate.get(t);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isSource(URI uri) {
		if (delegate instanceof IResourceServiceProviderExtension) {
			if (!((IResourceServiceProviderExtension) delegate).isSource(uri))
				return false;
		}
		if (workspace != null) {
			if (uri.isPlatformResource()) {
				String projectName = URI.decode(uri.segment(1));
				IProject project = workspace.getRoot().getProject(projectName);
				return project.isAccessible();
			}
			if (uri.isPlatformPlugin()) {
				return false;
			}
		}
		Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(uri);
		for (Pair<IStorage, IProject> pair : storages) {
			IStorage storage = pair.getFirst();
			if (storage instanceof IFile) {
				return ((IFile)storage).isAccessible();
			} else {
				return false;
			}
		}
		return true;
	}
}
