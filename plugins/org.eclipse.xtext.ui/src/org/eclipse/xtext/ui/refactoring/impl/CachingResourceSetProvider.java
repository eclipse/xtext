/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingResourceSetProvider extends RefactoringResourceSetProvider {
	private final Map<IProject, ResourceSet> resourceSets = Maps.newHashMap();
	private final RefactoringResourceSetProvider delegate;

	public CachingResourceSetProvider(RefactoringResourceSetProvider delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public ResourceSet get(IProject project) {
		ResourceSet result = resourceSets.get(project);
		if (result != null) {
			return result;
		}
		result = delegate.get(project);
		resourceSets.put(project, result);
		return result;
	}
}