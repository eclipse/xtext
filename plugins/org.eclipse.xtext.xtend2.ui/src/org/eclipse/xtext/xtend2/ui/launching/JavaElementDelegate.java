/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.launching;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.resource.FileExtensionProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementDelegate implements IAdaptable {

	private static final Logger log = Logger.getLogger(JavaElementDelegate.class);
	
	private IFileEditorInput editorInput;
	private IResource resource;
	
	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;
	
	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public void initializeWith(IFileEditorInput editorInput) {
		this.editorInput = editorInput;
	}
	
	public void initializeWith(IResource resource) {
		this.resource = resource;
	}
	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (IJavaElement.class.equals(adapter)) {
			if (editorInput != null) {
				IFile file = editorInput.getFile();
				if (fileExtensionProvider.isValid(file.getFileExtension())) {
					return getJavaElementForResource(file);
				} 
			} else if (resource != null) {
				if (fileExtensionProvider.isValid(resource.getFileExtension())) {
					return getJavaElementForResource(resource);
				}
			}
		}
		return null;
	}
	
	protected IJavaElement getJavaElementForResource(IResource resource) {
		try {
			final String getSourcePath = URI.createPlatformResourceURI(resource.getFullPath().toString(), true).toString();
			List<IFile> resources = derivedResourceMarkers.findDerivedResources(resource.getProject(), getSourcePath);
			if (resources.size() >= 1)
				return JavaCore.create(resources.get(0));
		} catch (CoreException e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
		return null;
	}

}
