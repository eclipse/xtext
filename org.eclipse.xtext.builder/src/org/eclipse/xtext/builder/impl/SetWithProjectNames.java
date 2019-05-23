/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ForwardingSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SetWithProjectNames extends ForwardingSet<URI> {

	private final Set<URI> delegate;
	private final Set<String> removedProjects;
	private final String projectName;

	public SetWithProjectNames(Set<URI> delegate, String projectName, Set<String> removedProjects) {
		this.delegate = delegate;
		this.projectName = projectName;
		this.removedProjects = removedProjects;
		
	}
	
	@Override
	protected Set<URI> delegate() {
		return delegate;
	}
	
	/**
	 * @see BuildData#getRemovedProjects()
	 */
	public Set<String> getRemovedProjects() {
		return removedProjects;
	}
	
	/**
	 * @see BuildData#getProjectName()
	 */
	public String getProjectName() {
		return projectName;
	}

}
