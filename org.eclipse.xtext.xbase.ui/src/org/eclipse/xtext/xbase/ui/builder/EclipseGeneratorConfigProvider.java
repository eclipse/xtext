/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
public class EclipseGeneratorConfigProvider implements IGeneratorConfigProvider {
	
	@Inject
	XbaseBuilderPreferenceAccess xbaseBuilderPreferenceAccess;
	
	@Inject
	IStorage2UriMapper storage2UriMapper;

	@Override
	public GeneratorConfig get(EObject context) {
		GeneratorConfig result = new GeneratorConfig();
		IProject project = null;
		if (context.eResource() != null) {
			Pair<IStorage, IProject> pair = Iterables.getFirst(storage2UriMapper.getStorages(context.eResource().getURI()), null);
			if (pair != null) {
				project = pair.getSecond();
			}
		}
		xbaseBuilderPreferenceAccess.loadBuilderPreferences(result, project);
		return result;
	}

}
