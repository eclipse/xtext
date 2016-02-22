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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow - original coding
 * @author Peter Friese
 */
public class LanguageSpecificURIEditorOpener implements IURIEditorOpener {

	private static final Logger logger = Logger.getLogger(LanguageSpecificURIEditorOpener.class);

	@Inject
	private ILocationInFileProvider locationProvider;

	@Inject
	private IStorage2UriMapper mapper;

	@Inject
	private XtextEditorInfo editorInfo;

	@Inject(optional = true)
	private IWorkbench workbench;

	public void setLocationProvider(ILocationInFileProvider locationProvider) {
		this.locationProvider = locationProvider;
	}

	public ILocationInFileProvider getLocationProvider() {
		return locationProvider;
	}

	@Override
	public IEditorPart open(URI uri, boolean select) {
		return open(uri, null, -1, select);
	}

	@Override
	public IEditorPart open(final URI uri, final EReference crossReference, final int indexInList, final boolean select) {
		Iterator<Pair<IStorage, IProject>> storages = mapper.getStorages(uri.trimFragment()).iterator();
		if (storages != null && storages.hasNext()) {
			try {
				IStorage storage = storages.next().getFirst();
				IEditorInput editorInput = EditorUtils.createEditorInput(storage);
				IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow().getActivePage();
				final IEditorPart editor = IDE.openEditor(activePage, editorInput, getEditorId());
				
				Job selectAndRevealJob = new Job("Select and reveal referenced object") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						selectAndReveal(editor, uri, crossReference, indexInList, select);
						return Status.OK_STATUS;
					}
				};
				selectAndRevealJob.setSystem(true);
				selectAndRevealJob.setPriority(Job.SHORT);
				selectAndRevealJob.schedule();
				
				return EditorUtils.getXtextEditor(editor);
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.getCause());
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException);
			}
		}
		return null;
	}

	/**
	 * @since 2.8
	 */
	protected String getEditorId() {
		return editorInfo.getEditorId();
	}

	protected void selectAndReveal(IEditorPart openEditor, final URI uri, final EReference crossReference,
			final int indexInList, final boolean select) {
		final XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null && select) {
			boolean success = false;
			int tries = 0;
			while (!success || tries >= 5) {
				try {
					xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource resource) throws Exception {
							if (resource != null) {
								EObject object = findEObjectByURI(uri, resource);
								if (object != null) {
									final ITextRegion location = (crossReference != null) ? locationProvider
											.getSignificantTextRegion(object, crossReference, indexInList)
											: locationProvider.getSignificantTextRegion(object);
									workbench.getDisplay().asyncExec(new Runnable() {
										@Override
										public void run() {
											xtextEditor.selectAndReveal(location.getOffset(), location.getLength());
										}
									});
								}
							}
						}
					});
					success = true;
				} catch (OperationCanceledException e) {
				} catch (OperationCanceledError e) {
				} finally {
					tries++;
				}
			}
		}
	}

	
	/**
	 * @since 2.2
	 */
	protected EObject findEObjectByURI(final URI uri, XtextResource resource) {
		if (uri.fragment() != null){
			try {
				EObject result = resource.getEObject(uri.fragment());
				return result;
			} catch (IllegalArgumentException e) {
				// thrown if the fragment is outdated, which could possibly happen if a modification has happened in the meantime.
				logger.warn("Couldn't resolve EObject with URI '"+uri+"'. - " + e.getMessage());
			} catch (WrappedException e){
				logger.error("Error while resolving EObject with URI '" + uri + "'" , e.getCause());
			}
		}
		return null;
	}
}
