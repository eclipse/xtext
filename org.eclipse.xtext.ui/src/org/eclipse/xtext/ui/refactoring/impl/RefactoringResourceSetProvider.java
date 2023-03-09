/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;

/**
 * Provides the correctly configured {@link ResourceSet} that is used during refactoring.
 * 
 * It's based on the dirty state, i.e. the content of unsaved editors can be accessed. Furthermore changed resources
 * inside the resource set shadow existing ones.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringResourceSetProvider extends XtextLiveScopeResourceSetProvider {

	@Override
	public ResourceSet get(IProject project) {
		ResourceSet resourceSet = super.get(project);
		configure(resourceSet);
		return resourceSet;
	}

	protected void configure(ResourceSet resourceSet) {
	}
}
