/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDescriptorImpl implements ResourceDescriptor {

	protected long indexingDate;
	protected String uri;
	protected Map<String, String> userData;

	public ResourceDescriptorImpl(String uri, long indexingDate, Map<String, String> userData) {
		this.uri = uri;
		this.indexingDate = indexingDate;
		if (userData != null)
			this.userData = Collections.unmodifiableMap(userData);
	}

	public long getIndexingDate() {
		return indexingDate;
	}

	public String getURI() {
		return uri;
	}

	public Map<String, String> getUserData() {
		return userData;
	}

	public String getUserData(String key) {
		return (userData == null) ? null : userData.get(key);
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

	public void copyDetails(ResourceDescriptor resourceDesc) {
		if(resourceDesc.getUserData() != null) 
			userData = Collections.unmodifiableMap(new HashMap<String, String>(resourceDesc.getUserData()));
		else
			userData = null;
	}

}
