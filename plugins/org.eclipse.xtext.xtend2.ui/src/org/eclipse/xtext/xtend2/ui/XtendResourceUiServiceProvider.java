/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendResourceUiServiceProvider extends DefaultResourceUIServiceProvider {

	@Inject
	public XtendResourceUiServiceProvider(IResourceServiceProvider delegate) {
		super(delegate);
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return super.canHandle(uri);
	}
	
	@Override
	public boolean canHandle(URI uri, IStorage storage) {
		final boolean canHandle = super.canHandle(uri, storage);
		if (canHandle && (storage instanceof IResource)) {
			IResource resource = (IResource) storage;
			IProject project = resource.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			return javaProject.isOnClasspath(resource);
		}
		return canHandle;
	}

}
