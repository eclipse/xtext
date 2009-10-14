/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuildState {
	private Map<IResource,Resource> updated = new LinkedHashMap<IResource,Resource>();
	private Set<URI> deleted = new LinkedHashSet<URI>();
	
	public void updated(IResource iRes, Resource res) {
		this.updated.put(iRes, res);
	}
	
	public void deleted(URI uri) {
		this.deleted.add(uri);
	}
	
	public Set<URI> getDeleted() {
		return deleted;
	}
	
	public Map<IResource,Resource> getUpdated() {
		return updated;
	}
	
	public void clear() {
		updated.clear();
		deleted.clear();
	}
}
