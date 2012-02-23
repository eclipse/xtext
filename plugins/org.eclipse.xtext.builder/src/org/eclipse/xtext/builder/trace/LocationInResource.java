/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocationInResource implements ILocationInResource {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceRegistry;
	
	private URI resourceURI;
	private IStorage resource;
	private IProject project;

	private LanguageInfo language;

	protected void init(URI resourceURI, IStorage resource, IProject project) {
		this.resourceURI = resourceURI;
		this.resource = resource;
		this.project = project;
	}
	
	public LanguageInfo getLanguage() {
		if (language == null) {
			IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(resourceURI);
			if (serviceProvider != null) {
				this.language = serviceProvider.get(LanguageInfo.class);
			}
		}
		return language;
	}

	public URI getResourceURI() {
		return resourceURI;
	}

	public URI getEObjectURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@NonNull
	public IStorage getStorage() {
		return resource;
	}
	
	@NonNull
	public IProject getProject() {
		return project;
	}

	public ITextRegionWithLineInformation getTextRegion() {
		return null;
	}

}
