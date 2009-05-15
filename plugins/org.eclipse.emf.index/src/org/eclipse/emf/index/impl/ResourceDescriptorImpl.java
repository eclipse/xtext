/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDescriptorImpl implements ResourceDescriptor, Serializable {

	private static final long serialVersionUID = 4559062618979870492L;

	protected long indexingDate;
	protected String uri;
	protected Map<String, Serializable> userData;

	public ResourceDescriptorImpl(String uri, long indexingDate, Map<String, Serializable> userData) {
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

	public Map<String, Serializable> getUserData() {
		return userData;
	}

	public Serializable getUserData(String key) {
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

	public boolean copyDetails(ResourceDescriptor resourceDesc) {
		boolean hasChanged = false;
		Map<String, Serializable> newUserData = resourceDesc.getUserData();
		if (newUserData != null) {
			if (!newUserData.equals(userData)) {
				userData = Collections.unmodifiableMap(new HashMap<String, Serializable>(newUserData));
				hasChanged = true;
			}
		}
		else if (userData != null) {
			userData = null;
			hasChanged = true;
		}
		if(resourceDesc.getIndexingDate() != indexingDate) {
			indexingDate = resourceDesc.getIndexingDate();
			hasChanged = true;
		}
		return hasChanged;
	}

}
