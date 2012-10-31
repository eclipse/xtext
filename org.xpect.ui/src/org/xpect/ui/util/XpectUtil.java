/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;
import org.xpect.XpectFile;
import org.xpect.ui.internal.XpectActivator;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectUtil {
	public static XpectFile load(IFile file) {
		Injector injector = XpectActivator.getInstance().getInjector(XpectActivator.ORG_XPECT_XPECT);
		XtextResourceSet rs = new XtextResourceSet();
		IJavaProject javaProject = JavaCore.create(file.getProject());
		if (javaProject != null && javaProject.exists()) {
			rs.setClasspathURIContext(javaProject);
			rs.setClasspathUriResolver(new JdtClasspathUriResolver());
		}
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = injector.getInstance(XtextResourceFactory.class).createResource(uri);
		rs.getResources().add(resource);
		try {
			resource.load(Collections.emptyMap());
			for (EObject obj : resource.getContents())
				if (obj instanceof XpectFile)
					return (XpectFile) obj;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
