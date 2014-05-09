/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.ui.resource.JavaProjectResourceSetInitializer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 */
public class JvmTypesAwareResourceSetInitializer extends JavaProjectResourceSetInitializer {
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Override
	public void initialize(ResourceSet resourceSet, IProject project) {
		super.initialize(resourceSet, project);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}
}
