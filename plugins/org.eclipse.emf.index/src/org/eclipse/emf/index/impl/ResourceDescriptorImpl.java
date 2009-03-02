/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDescriptorImpl implements ResourceDescriptor {

	protected long indexingDate;
	protected String uri;

	protected ResourceDescriptorImpl(String uri, long indexingDate) {
		this.uri = uri;
		this.indexingDate= indexingDate;
	}
	
	public long getIndexingDate() {
		return indexingDate;
	}

	public String getURI() {
		return uri;
	}

	@Override
	public String toString() {
		return uri;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ResourceDescriptor) {
			ResourceDescriptor resourceDescriptor = (ResourceDescriptor) obj;
			return hashCode() == resourceDescriptor.hashCode() && uri.equals(resourceDescriptor.getURI());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return uri.hashCode();
	}
	
	public static class Factory implements ResourceDescriptor.Factory {

		public ResourceDescriptor createDescriptor(Resource resource, long indexingDate) {
			return new ResourceDescriptorImpl(resource.getURI().toString(), indexingDate);
		}

		public boolean isFactoryFor(Resource resource) {
			return resource.getURI() != null;
		}
		
	}
	
}
