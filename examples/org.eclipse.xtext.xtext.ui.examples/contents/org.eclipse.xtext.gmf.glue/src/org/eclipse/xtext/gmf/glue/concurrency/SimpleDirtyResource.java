/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.concurrency;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.ui.editor.IDirtyResource;

/**
 * An implementation of {@link IDirtyResource} for resources without an underlying document.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class SimpleDirtyResource implements IDirtyResource {

	private XtextResource resource;

	private Manager resourceDescriptionManager;

	public SimpleDirtyResource(XtextResource resource, IResourceServiceProvider resourceServiceProvider) {
		this.resource = resource;
		this.resourceDescriptionManager = resourceServiceProvider.getResourceDescriptionManager();
	}

	public String getContents() {
		return resource.getSerializer().serialize(resource.getContents().get(0));
	}

	public IResourceDescription getDescription() {
		return resourceDescriptionManager.getResourceDescription(resource);
	}

	public URI getURI() {
		return resource.getURI();
	}

	public Resource getResource() {
		return resource;
	}

}
