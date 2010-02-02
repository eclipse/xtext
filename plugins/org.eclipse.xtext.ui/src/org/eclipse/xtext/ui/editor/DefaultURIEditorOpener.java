/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.ILocationInFileProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - original coding
 */
public class DefaultURIEditorOpener implements IURIEditorOpener {

	private static final Logger logger = Logger.getLogger(DefaultURIEditorOpener.class);

	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private IStorage2UriMapper mapper;

	public void setLocationProvider(ILocationInFileProvider locationProvider) {
		this.locationProvider = locationProvider;
	}

	public ILocationInFileProvider getLocationProvider() {
		return locationProvider;
	}

	public void open(URI uri) {
		Iterator<IStorage> storages = mapper.getStorages(uri.trimFragment()).iterator();
		if (storages != null && storages.hasNext()) {
			try {
				IStorage storage = storages.next();
				if (storage instanceof IFile) {
					selectAndReveal(openEditor((IFile) storage),uri);
				} else {
					selectAndReveal(openEditor(storage, uri),uri);
				}
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.getCause());
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException);
			}
		}
	}

	protected void selectAndReveal(IEditorPart openEditor, final URI uri) {
		if (openEditor != null && openEditor instanceof XtextEditor) {
			final XtextEditor edit = (XtextEditor) openEditor;
			if (uri.fragment() != null) {
				edit.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource != null) {
							EObject object = resource.getEObject(uri.fragment());
							Region region = locationProvider.getLocation(object);
							edit.selectAndReveal(region.getOffset(), region.getLength());
						}
					}
				});
			}
		}
	}

	protected IEditorPart openEditor(IFile file) throws PartInitException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, file);
	}

	protected IEditorPart openEditor(IStorage storage, URI uri) throws PartInitException {
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(storage);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, editorInput, PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
				uri.lastSegment()).getId());
	}

}
