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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class GlobalURIEditorOpener implements IURIEditorOpener {

	private static final Logger logger = Logger.getLogger(GlobalURIEditorOpener.class);
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject
	private IStorage2UriMapper mapper;
	
	@Inject(optional=true) 
	/* @Nullable */
	private IWorkbench workbench;
	
	/**
	 * @since 2.2
	 */
	public IEditorPart open(URI uri, Object context, boolean select) {
		return open(uri, select);
	}
	
	public IEditorPart open(URI uri, boolean select) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(uri.trimFragment());
		if(resourceServiceProvider instanceof IResourceUIServiceProvider) {
			return ((IResourceUIServiceProvider) resourceServiceProvider).getURIEditorOpener().open(uri, select);
		}
		return openDefaultEditor(uri, null, -1, select);
	}

	public IEditorPart open(URI referenceOwnerURI, EReference reference, int indexInList, boolean select) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(referenceOwnerURI.trimFragment());
		if(resourceServiceProvider instanceof IResourceUIServiceProvider) {
			return ((IResourceUIServiceProvider) resourceServiceProvider).getURIEditorOpener().open(referenceOwnerURI, reference, indexInList, select);
		}
		return openDefaultEditor(referenceOwnerURI, reference, indexInList, select);
	}
	
	protected IEditorPart openDefaultEditor(URI uri, EReference crossReference, int indexInList, boolean select) {
		Iterator<Pair<IStorage, IProject>> storages = mapper.getStorages(uri.trimFragment()).iterator();
		if (storages != null && storages.hasNext()) {
			try {
				IStorage storage = storages.next().getFirst();
				IEditorPart editor = null;
				if (storage instanceof IFile) {
					editor = openDefaultEditor((IFile) storage);
				} else {
					editor = openDefaultEditor(storage, uri);
				}
				selectAndReveal(editor, uri, crossReference, indexInList, select);
				return editor;
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.getCause());
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException);
			}
		}
		return null;
	}

	protected void selectAndReveal(IEditorPart openEditor, final URI uri, final EReference crossReference,
			final int indexInList, final boolean select) {
		final XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null) {
			if (uri.fragment() != null) {
				xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource != null) {
							EObject object = resource.getEObject(uri.fragment());
							ILocationInFileProvider locationProvider = resource.getResourceServiceProvider().get(ILocationInFileProvider.class);
							ITextRegion location = (crossReference != null) ? locationProvider.getSignificantTextRegion(object,
									crossReference, indexInList) : locationProvider.getSignificantTextRegion(object);
							if (select) {
								xtextEditor.selectAndReveal(location.getOffset(), location.getLength());
							} else {
								xtextEditor.reveal(location.getOffset(), location.getLength());								
							}
						}
					}
				});
			}
		}
	}

	protected IEditorPart openDefaultEditor(IFile file) throws PartInitException {
		IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, file);
	}


	protected IEditorPart openDefaultEditor(IStorage storage, URI uri) throws PartInitException {
		XtextReadonlyEditorInput editorInput = new XtextReadonlyEditorInput(storage);
		IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return IDE.openEditor(page, editorInput, PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
				uri.lastSegment()).getId());
	}
	
	protected IWorkbench getWorkbench() {
		if (workbench==null)
			throw new IllegalStateException("No workbench");
		return workbench;
	}
}
