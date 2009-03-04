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

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EObjectDescriptorImpl extends BasicEObjectDescriptorImpl {

	private Map<String, String> userData;

	public EObjectDescriptorImpl(ResourceDescriptor resourceDescriptor, String fragment, String name,
			String displayName, EClassDescriptor typeDescriptor, Map<String, String> userData) {
		super(resourceDescriptor, fragment, name, displayName, typeDescriptor);
		if (userData != null)
			this.userData = Collections.unmodifiableMap(userData);
	}

	public boolean copyDetails(EObjectDescriptor newDesc) {
		boolean hasChanged = super.copyDetails(newDesc);
		Map<String, String> newUserData = newDesc.getUserData();
		if (newUserData != null) {
			if (!newUserData.equals(userData)) {
				userData = Collections.unmodifiableMap(new HashMap<String, String>(newUserData));
				return true;
			}
		}
		else if (userData != null) {
			userData = null;
			return true;
		}
		return hasChanged;
	}

	public String getUserData(String key) {
		if (userData != null)
			return userData.get(key);
		return null;
	}

	public Map<String, String> getUserData() {
		return userData;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
