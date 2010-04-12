/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseResourceDescriptionManager extends DefaultResourceDescriptionManager {

	@Override
	protected void addExportedNames(Set<String> names, IResourceDescription resourceDescriptor) {
		if (resourceDescriptor==null)
			return;
		Iterable<IEObjectDescription> iterable = resourceDescriptor.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : iterable) {
			names.add(ieObjectDescription.getName().toLowerCase());
		}
	}
	
	@Override
	protected Collection<String> getImportedNames(IResourceDescription candidate) {
		Collection<String> result = Sets.newHashSet();
		for(String s: candidate.getImportedNames()) {
			result.add(s.toLowerCase());
		}
		return result;
	}
	
}
