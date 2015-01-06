/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;

import com.google.inject.Inject;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
public class EclipseGeneratorConfigProvider implements IGeneratorConfigProvider {
	
	@Inject
	XbaseBuilderPreferenceAccess xbaseBuilderPreferenceAccess;

	@Override
	public GeneratorConfig get(EObject context) {
		GeneratorConfig result = new GeneratorConfig();
		IProject project = null;
		if (context.eResource() != null) {
			IFile file = ResourceUtil.getFile(context.eResource());
			if (file != null) {
				project = file.getProject();
			}
		}
		result.setTargetVersion(xbaseBuilderPreferenceAccess.getJavaVersion(project));
		return result;
	}

}
