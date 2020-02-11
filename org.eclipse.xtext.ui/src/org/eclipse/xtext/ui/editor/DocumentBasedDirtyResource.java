/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentBasedDirtyResource implements IDirtyResource.NormalizedURISupportExtension,
		IDirtyResource.ICurrentStateProvidingExtension, Provider<IResourceDescription>,
		IDirtyResource.InitializationAware {
	
	private IXtextDocument document;
	private IResourceDescription description;
	private String content;
	private URI normalizedUri;
	private Provider<ResourceStorageLoadable> storageAwareResourceInputStreamProvider;
	
	public synchronized void connect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document == document)
			return;
		if (this.document != null)
			throw new IllegalStateException("Dirty resource was already connected to another document");
		this.document = document;
		document.tryReadOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) {
				DocumentBasedDirtyResource.this.normalizedUri = EcoreUtil2.getNormalizedURI(resource);
				initiallyProcessResource(resource);
			}
		});
	}
	
	protected void initiallyProcessResource(XtextResource resource) {
		IResourceServiceProvider serviceProvider = resource.getResourceServiceProvider();
		if (serviceProvider != null) {
			IResourceDescription.Manager descriptionManager = serviceProvider.getResourceDescriptionManager();
			if (descriptionManager != null) {
				final IResourceDescription description = descriptionManager.getResourceDescription(resource);
				if (description != null)
					copyState(description);							
			}
		}
	}
	
	public synchronized void disconnect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document != document)
			throw new IllegalStateException("Cannot disconnect document that is not connected");
		this.document = null;
		description = null;
		content = null;
	}
	
	/**
	 * Callback method for the copied resource description. Is triggered as soon as somebody is 
	 * interested in the reference descriptions which shall be up to date all the time.
	 * This allows for lazy resolution of proxies instead of eager copying.
	 * @return the current resource description of the associated document. May be <code>null</code>.
	 */
	@Override
	public IResourceDescription get() {
		IResourceDescription result = document.tryReadOnly(new IUnitOfWork<IResourceDescription, XtextResource>() {
			@Override
			public IResourceDescription exec(XtextResource resource) {
				IResourceServiceProvider serviceProvider = resource.getResourceServiceProvider();
				if (serviceProvider != null) {
					IResourceDescription.Manager manager = serviceProvider.getResourceDescriptionManager();
					if (manager != null) {
						return manager.getResourceDescription(resource);
					}
				}
				return null;
			}
		});
		return result;
	}
	
	public void copyState(IResourceDescription original) {
		StatefulResourceDescription copy = new StatefulResourceDescription(original, this);
		synchronized(this) {
			description = copy;
			content = getUnderlyingDocument().get();
		}
	}
	
	public IXtextDocument getUnderlyingDocument() {
		return document;
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public IResourceDescription getDescriptionIfInitialized() {
		return description;
	}
	
	@Override
	public boolean isInitialized() {
		return description != null;
	}
	
	@Override
	public URI getURI() {
		if (document == null)
			throw new IllegalStateException("Cannot use getURI if this dirty resource is not connected to a document");
		IResourceDescription description = this.description;
		if (description == null)
			throw new IllegalStateException("Cannot use getURI if this dirty resource is currently not initialized");
		return description.getURI();
	}
	
	@Override
	public synchronized IResourceDescription getDescription() {
		if (document == null)
			throw new IllegalStateException("Cannot use getDescription if this dirty resource is not connected to a document");
		IResourceDescription description = this.description;
		if (description == null)
			throw new IllegalStateException("Cannot use getDescription if this dirty resource is currently not initialized");
		return description;
	}

	@Override
	public synchronized String getContents() {
		if (document == null)
			throw new IllegalStateException("Cannot use getContents if this dirty resource is not connected to a document");
		String content = this.content;
		if (content == null)
			throw new IllegalStateException("Cannot use getContents if this dirty resource is currently not mementoed");
		return content;
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public String getContentsIfInitialized() {
		return content;
	}
	
	@Override
	public String getActualContents() {
		IXtextDocument document = this.document;
		if (document == null)
			throw new IllegalStateException("Cannot use getActualContents if this dirty resource is not connected to a document");
		return document.get();
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public String getActualContentsIfInitialized() {
		IXtextDocument document = this.document;
		if (document == null)
			return null;
		return document.get();
	}

	/**
	 * @since 2.4
	 */
	@Override
	public URI getNormalizedURI() {
		return normalizedUri;
	}
	
	/**
	 * @since 2.8
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public ResourceStorageLoadable getResourceStorageLoadable() {
		Provider<ResourceStorageLoadable> provider = this.storageAwareResourceInputStreamProvider;
		if (provider == null)
			return null;
		return provider.get();
	}

	/**
	 * @since 2.8
	 */
	public void setResourceStorageLoadableProvider(Provider<ResourceStorageLoadable> provider) {
		this.storageAwareResourceInputStreamProvider = provider;
	}
}