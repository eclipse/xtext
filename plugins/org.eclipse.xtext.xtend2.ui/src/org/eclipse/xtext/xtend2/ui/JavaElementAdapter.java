/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.builder.DerivedResourceMarkers;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaElementAdapter implements IAdapterFactory {
	
	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;
	
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes")  Class adapterType) {
		try {
			IFile file = null;
			if (adaptableObject instanceof IFileEditorInput) {
				file = ((IFileEditorInput) adaptableObject).getFile();
			} else if (adaptableObject instanceof IFile) {
				file = (IFile) adaptableObject;
			} else {
				return null;
			}
			return getJavaElementForFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected IJavaElement getJavaElementForFile(final IFile file) {
		try {
			final String getSourcePath = URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString();
			List<IFile> resources = derivedResourceMarkers.findDerivedResources(file.getProject(), getSourcePath);
			if (resources.size() >= 1)
				return JavaCore.create(resources.get(0));
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes") 
	public Class[] getAdapterList() {
		return new Class[]{IJavaElement.class};
	}
	
}
