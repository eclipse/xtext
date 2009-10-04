/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.ReadonlyArchiveStorage;
import org.eclipse.xtext.ui.core.editor.ReadonlyFileStorage;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlink implements IHyperlink {

	private static final Logger logger = Logger.getLogger(XtextHyperlink.class);
	
	private String hyperlinkText;
	
	private String typeLabel;
	
	private Region hyperlinkRegion;
	
	private URI uri;
	
	@Inject
	private ILocationInFileProvider locationProvider;

	public String getHyperlinkText() {
		return hyperlinkText;
	}

	public void setHyperlinkText(String hyperlinkText) {
		this.hyperlinkText = hyperlinkText;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	public Region getHyperlinkRegion() {
		return hyperlinkRegion;
	}

	public void setHyperlinkRegion(Region hyperlinkRegion) {
		this.hyperlinkRegion = hyperlinkRegion;
	}

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
			} else if (uri.isArchive()) {
				// TODO don't fall back to java.io
				IEditorInput input = new XtextReadonlyEditorInput(new ReadonlyArchiveStorage(uri));
				openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry()
						.getDefaultEditor(uri.lastSegment()).getId());
			} else {
				// fall back: URI is bundle resource uri and has to converted, or http uri
				URL url = FileLocator.toFileURL(new URL(uri.scheme()+ ":" +uri.devicePath()));
				URI urlAsUri = URI.createURI(url.toString());
				String path = urlAsUri.toFileString();
				if (path != null) {
					File ioFile = new File(path);
					// TODO don't fall back to java.io
					IEditorInput input = new XtextReadonlyEditorInput(new ReadonlyFileStorage(ioFile, uri));
					openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry()
							.getDefaultEditor(uri.lastSegment()).getId());
				}
			}
		} catch (PartInitException partInitException) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'",
					partInitException);
		} catch (IOException e) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'", e);
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
//		else if (openEditor instanceof EcoreEditor) {
//			EcoreEditor ecoreEditor = (EcoreEditor)openEditor;
//			// set selection
//		    EditingDomain editingDomain = ecoreEditor.getEditingDomain();
//		    EObject editObject = editingDomain.getResourceSet().getEObject(uri, true);
//		    if (editObject != null) {
//		        ecoreEditor.setSelectionToViewer(Collections.singleton(editObject));
//		    }
//		}
		else if (openEditor instanceof ISelectionProvider) {
			//TODO: use ISelectionProvider instead of ITextEditor
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