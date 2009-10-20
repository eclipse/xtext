/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.ReadonlyStorage;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlink extends AbstractHyperlink {

	private static final Logger logger = Logger.getLogger(XtextHyperlink.class);
	
	private URI uri;
	
	@Inject
	private ILocationInFileProvider locationProvider;

	public void setLocationProvider(ILocationInFileProvider locationProvider) {
		this.locationProvider = locationProvider;
	}

	public ILocationInFileProvider getLocationProvider() {
		return locationProvider;
	}

	public void setURI(URI uri) {
		this.uri = uri;
	}

	public URI getURI() {
		return uri;
	}
	
	public void open() {
		IFile file = getContainingResourceSetFile(uri);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart openEditor = null;
		try {
			if (file != null) {
				openEditor = IDE.openEditor(page, file);
			} else {
				IEditorInput input = new XtextReadonlyEditorInput(new ReadonlyStorage(uri));
				openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry()
						.getDefaultEditor(uri.lastSegment()).getId());
			}
		} catch (WrappedException e) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'",
					e.getCause());
		} catch (PartInitException partInitException) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'",
					partInitException);
		}
		if (openEditor != null && openEditor instanceof XtextEditor) {
			final XtextEditor edit = (XtextEditor) openEditor;
			if (uri.fragment()!=null) {
				edit.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>(){
				@Override
				public void process(XtextResource resource) throws Exception {
					EObject object = resource.getEObject(uri.fragment());
					Region region = locationProvider.getLocation(object);
					edit.selectAndReveal(region.getOffset(),region.getLength());
				}});
			}
		}
	}

	private IFile getContainingResourceSetFile(URI uri) {
		String path = null;
		if (uri.isPlatformResource()) {
			path = uri.toPlatformString(true);
		} else if (uri.isPlatformPlugin()) {
			path = uri.toPlatformString(true);
		} else if (uri.isFile()) {
			path = uri.toFileString();
		} else if (uri.isArchive()) {
			URI archiveUri = URI.createURI(uri.authority());
			String archive = null;
			if (archiveUri.isFile()) {
				archive = archiveUri.toFileString();
			} else if (archiveUri.isPlatformResource()) {
				archive = archiveUri.toPlatformString(true);
			} else {
				archive = archiveUri.toString();
			}
			path = uri.scheme() + ":" + archive + uri.path();
		} else {
			path = uri.toString();
		}
		IFile result = null;
		if (uri.isPlatformResource()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		} else {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
			if (result == null) {
				IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
				if (res != null && (res instanceof IFile))
					result = (IFile) res;
			}
		}
		return result;
	}

}