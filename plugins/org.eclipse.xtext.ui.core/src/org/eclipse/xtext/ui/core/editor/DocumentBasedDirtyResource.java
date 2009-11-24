/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentBasedDirtyResource implements IDirtyResource {
	
	private IXtextDocument document;
	private URI uri;
	
	public void connect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document == document)
			return;
		if (this.document != null)
			throw new IllegalStateException("Dirty resource was already connected to another document");
		this.uri = document.readOnly(new IUnitOfWork<URI, XtextResource>() {
			public URI exec(XtextResource resource) throws Exception {
				return resource.getURI();
			}
		});
		this.document = document;
	}
	
	public void disconnect(IXtextDocument document) {
		if (document == null)
			throw new IllegalArgumentException("document may not be null");
		if (this.document != document)
			throw new IllegalStateException("Cannot disconnect document that is not connected");
		this.document = null;
		this.uri = null;
	}
	
	public IXtextDocument getUnderlyingDocument() {
		return document;
	}
	
	public URI getURI() {
		if (document == null)
			throw new IllegalStateException("Cannot use getURI if this dirty resource is not connected to a document");
		return uri;
	}

	public Iterable<String> getImportedNames() {
		if (document == null)
			throw new IllegalStateException("Cannot use getImportedNames if this dirty resource is not connected to a document");
		return document.readOnly(new IUnitOfWork<Iterable<String>, XtextResource>(){
			public Iterable<String> exec(XtextResource resource) throws Exception {
				IResourceDescription.Provider provider = resource.getResourceDescriptionProvider();
				if (provider == null)
					return Collections.emptyList();
				IResourceDescription description = provider.getResourceDescription(resource);
				if (description == null)
					return Collections.emptyList();
				return description.getImportedNames();
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		if (document == null)
			throw new IllegalStateException("Cannot use getExportedObjects if this dirty resource is not connected to a document");
		return document.readOnly(new IUnitOfWork<Iterable<IEObjectDescription>, XtextResource>(){
			public Iterable<IEObjectDescription> exec(XtextResource resource) throws Exception {
				IResourceDescription.Provider provider = resource.getResourceDescriptionProvider();
				if (provider == null)
					return Collections.emptyList();
				IResourceDescription description = provider.getResourceDescription(resource);
				if (description == null)
					return Collections.emptyList();
				return description.getExportedObjects();
			}
		});
	}

	public String getContents() {
		if (document == null)
			throw new IllegalStateException("Cannot use getContents if this dirty resource is not connected to a document");
		return document.get();
	}
	
}