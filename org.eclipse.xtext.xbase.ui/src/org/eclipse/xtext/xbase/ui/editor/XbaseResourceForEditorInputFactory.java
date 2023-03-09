/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.resource.UriValidator;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
@SuppressWarnings("restriction")
public class XbaseResourceForEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {
	
	@Inject
	private UriValidator uriValidator;

	@Inject
	private ITraceForTypeRootProvider typeForTypeRootProvider;

	protected URI getClassFileSourceURI(IClassFile classFile) {
		ITrace traceToSource = typeForTypeRootProvider.getTraceToSource(classFile);
		if (traceToSource != null) {
			for (ILocationInResource loc : traceToSource.getAllAssociatedLocations())
				return loc.getAbsoluteResourceURI().getURI();
		}
		return null;
	}

	@Override
	public Resource createResource(IEditorInput editorInput) {
		if (editorInput instanceof IClassFileEditorInput) {
			Resource resource = createResource(((IClassFileEditorInput) editorInput).getClassFile());
			if (resource != null)
				return resource;
		}
		return super.createResource(editorInput);
	}

	@Override
	protected boolean isValidationDisabled(URI uri, IStorage storage) {
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			IJavaProject javaProject = JavaCore.create(file.getProject());
			if (javaProject == null || !javaProject.exists() || !javaProject.isOpen()) {
				return true;
			}
			if (!canBuild(uri, storage)) {
				return true;
			}
		}
		return super.isValidationDisabled(uri, storage);
	}

	private boolean canBuild(URI uri, IStorage storage) {
		if (uri == null) {
			return uriValidator.canBuild(getStorageToUriMapper().getUri(storage), storage);
		}
		return uriValidator.canBuild(uri, storage);
	}

	@Override
	protected boolean isValidationDisabled(IStorage storage) {
		return isValidationDisabled(null, storage);
	}

	protected Resource createResource(IClassFile classFile) {
		URI uri = getClassFileSourceURI(classFile);
		IProject project = classFile.getJavaProject().getProject();
		ResourceSet resourceSet = getResourceSetProvider().get(project);
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		resourceSet.getResources().add(resource);
		resource.setValidationDisabled(true);
		return resource;

	}
}
