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
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.builder.impl.StorageUtil;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlink extends AbstractHyperlink {

	private static final Logger logger = Logger.getLogger(XtextHyperlink.class);

	private URI uri;

	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private StorageUtil storageUtil;

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
		IStorage storage = storageUtil.getIStorage(uri.trimFragment());
		if (storage != null) {
			try {
				if (storage instanceof IFile) {
					selectAndReveal(openEditor((IFile) storage));
				} else {
					selectAndReveal(openEditor(storage));
				}
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.getCause());
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException);
			}
		}
	}

	protected void selectAndReveal(IEditorPart openEditor) {
		if (openEditor != null && openEditor instanceof XtextEditor) {
			final XtextEditor edit = (XtextEditor) openEditor;
			if (uri.fragment() != null) {
				edit.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						EObject object = resource.getEObject(uri.fragment());
						Region region = locationProvider.getLocation(object);
						edit.selectAndReveal(region.getOffset(), region.getLength());
					}
				});
			}
		}
	}

	protected IEditorPart openEditor(IFile file) throws PartInitException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, file);
	}

	protected IEditorPart openEditor(IStorage storage) throws PartInitException {
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(storage);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, editorInput, PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
				uri.lastSegment()).getId());
	}

}