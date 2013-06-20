/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultResourceUIServiceProvider implements IResourceUIServiceProvider, IResourceUIServiceProviderExtension {

	private IResourceServiceProvider delegate;
	
	@Inject
	private IJdtHelper jdtHelper;

	@Inject
	public DefaultResourceUIServiceProvider(IResourceServiceProvider delegate) {
		this.delegate = delegate;
	}

	public Manager getContainerManager() {
		return delegate.getContainerManager();
	}

	public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
		return delegate.getResourceDescriptionManager();
	}

	public IResourceValidator getResourceValidator() {
		return delegate.getResourceValidator();
	}

	@Inject
	@ResourceServiceDescriptionLabelProvider
	private ILabelProvider descriptionLabelProvider;

	public ILabelProvider getLabelProvider() {
		return descriptionLabelProvider;
	}
	
	public void setDescriptionLabelProvider(ILabelProvider descriptionLabelProvider) {
		this.descriptionLabelProvider = descriptionLabelProvider;
	}

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
	
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	@Inject(optional=true)
	@LanguageSpecific
	private IURIEditorOpener uriEditorOpener;

	public IURIEditorOpener getURIEditorOpener() {
		return uriEditorOpener;
	}
	
	/**
	 * @deprecated use <code>get(IReferenceUpdater.class)</code> instead
	 */
	@Deprecated
	public IReferenceUpdater getReferenceUpdater() {
		return get(IReferenceUpdater.class);
	}
	
	public <T> T get(Class<T> t) {
		return delegate.get(t);
	}
}
