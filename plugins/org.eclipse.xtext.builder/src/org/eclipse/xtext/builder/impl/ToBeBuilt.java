/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ToBeBuilt {
	Map<URI,IStorage> toBeUpdated = Maps.newHashMap();
	Set<URI> toBeDeleted = Sets.newHashSet();
	
	public Set<URI> getToBeDeleted() {
		return toBeDeleted;
	}
	
	public Map<URI, IStorage> getToBeUpdated() {
		return toBeUpdated;
	}
}