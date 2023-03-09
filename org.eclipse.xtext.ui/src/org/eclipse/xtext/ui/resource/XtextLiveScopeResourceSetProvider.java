/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 */
public class XtextLiveScopeResourceSetProvider extends XtextResourceSetProvider {

	@Inject
	private LiveScopeResourceSetInitializer liveScopeResourceSetInitializer;

	@Override
	public ResourceSet get(IProject project) {
		ResourceSet resourceSet = super.get(project);
		liveScopeResourceSetInitializer.initialize(resourceSet);
		return resourceSet;
	}

}
