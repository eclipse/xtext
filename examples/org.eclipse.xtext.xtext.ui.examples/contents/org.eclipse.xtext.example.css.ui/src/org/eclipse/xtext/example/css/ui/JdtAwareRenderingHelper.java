/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.example.css.rendering.XcssRendererHelper;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class JdtAwareRenderingHelper extends XcssRendererHelper {

	@Inject(optional=true)
	private IWorkspace workspace;
	
	public StyleSheet getStyleSheet(URI uri) {
		XtextResourceSet resourceSet = createResourceSet();
		if (uri.isPlatformResource() && workspace != null) {
			String platformString = uri.toPlatformString(true);
			IResource resource = workspace.getRoot().findMember(platformString);
			IProject project = resource.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) {
				resourceSet.setClasspathURIContext(javaProject);
			}
		}
		Resource result = resourceSet.getResource(uri, true);
		return getValidStyleSheet(result);
	}
}
