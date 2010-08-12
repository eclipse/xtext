/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentBasedDirtyResource implements IDirtyResource {
	
	private IXtextDocument document;
	private IResourceDescription description;
	private String content;
	
	public void connect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document == document)
			return;
		if (this.document != null)
			throw new IllegalStateException("Dirty resource was already connected to another document");
		this.document = document;
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) {
				if (resource != null) {
					initiallyProcessResource(resource);
				}
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
	
	public void disconnect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document != document)
			throw new IllegalStateException("Cannot disconnect document that is not connected");
		this.document = null;
		description = null;
		content = null;
	}
	
	public synchronized void copyState(IResourceDescription original) {
		description = new StatefulResourceDescription(original);
		content = getUnderlyingDocument().get();
	}
	
	public IXtextDocument getUnderlyingDocument() {
		return document;
	}
	
	public boolean isInitialized() {
		return description != null;
	}
	
	public URI getURI() {
		if (document == null)
			throw new IllegalStateException("Cannot use getURI if this dirty resource is not connected to a document");
		if (description == null)
			throw new IllegalStateException("Cannot use getURI if this dirty resource is currently not initialized");
		return description.getURI();
	}
	
	public synchronized IResourceDescription getDescription() {
		if (document == null)
			throw new IllegalStateException("Cannot use getDescription if this dirty resource is not connected to a document");
		if (description == null)
			throw new IllegalStateException("Cannot use getDescription if this dirty resource is currently not initialized");
		return description;
	}

	public synchronized String getContents() {
		if (document == null)
			throw new IllegalStateException("Cannot use getContents if this dirty resource is not connected to a document");
		if (content == null)
			throw new IllegalStateException("Cannot use getContents if this dirty resource is currently not mementoed");
		return content;
	}

}