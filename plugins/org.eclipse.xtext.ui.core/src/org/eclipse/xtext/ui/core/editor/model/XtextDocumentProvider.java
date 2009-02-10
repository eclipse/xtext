/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextDocumentProvider extends FileDocumentProvider implements IDocumentProvider {

	private static final Logger log = Logger.getLogger(XtextDocumentProvider.class);
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 *
	 * updates referenced EMF Resources on IResourceChangeEvent 
	 */
	private final class ReferencedResourcesUpdater implements IResourceChangeListener {
		private final XtextDocument document;

		private ReferencedResourcesUpdater(XtextDocument document) {
			this.document = document;
		}
		
		public void resourceChanged(final IResourceChangeEvent event) {
			
			final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor(document);
			try {
				event.getDelta().accept(visitor);
			} catch (CoreException e1) {
				log.error(e1.getMessage(), e1);
			}
			if (!visitor.deltas.isEmpty()) {
			new Job("updating resourceset"){
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					document.modify(new UnitOfWork<Object>() {
						
						public Object exec(XtextResource arg) throws Exception {
							for (IResourceDelta delta : visitor.deltas) {
								IResource res = delta.getResource();
								String string = res.getFullPath().lastSegment();
								for (final Resource emfResource : arg.getResourceSet().getResources()) {
									if (emfResource.getURI().lastSegment().equals(string)) {
										switch (delta.getKind()) {
										case IResourceDelta.REMOVED:
											// UNLOAD
											document.modify(new UnitOfWork<Object>() {
												
												public Object exec(XtextResource arg) throws Exception {
													emfResource.unload();
													return null;
												}
											});
											break;
										case IResourceDelta.CHANGED:
											// RELOAD
											document.modify(new UnitOfWork<Object>() {
												public Object exec(XtextResource arg) throws Exception {
													emfResource.unload();
													try {
														emfResource.load(null);
													} catch (IOException e) {
														log.error(e.getMessage(), e);
													}
													return null;
												}
											});
											break;
										}
									}
								}
							}
							arg.reparse(document.get());
							return null;
						}
					});
					return Status.OK_STATUS;
				}}.schedule();
			}

		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * collects all interesting IResourceDeltas (those which are referenced by the managed EMF Resource)
	 */
	private final class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		private final XtextDocument document;

		private ResourceDeltaVisitor(XtextDocument document) {
			this.document = document;
		}
		
		public final List<IResourceDelta> deltas = new ArrayList<IResourceDelta>();

		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();
			int kind = delta.getKind();
			int flags = delta.getFlags();
			if ((kind == IResourceDelta.REMOVED ||  
					(kind == IResourceDelta.CHANGED && ((IResourceDelta.CONTENT & flags) != 0))) 
					&& document.isReferenced(res)) {
				deltas.add(delta);
			}
			return true;
		}
	}

	private IResourceChangeListener resourceChangeListener = null;

	@Override
	protected IDocument createEmptyDocument() {
		return new XtextDocument();
	}

	@Override
	public IDocument getDocument(Object element) {
		final XtextDocument document = (XtextDocument) super.getDocument(element);
		if (!(element instanceof IFileEditorInput))
			throw new IllegalArgumentException("Can only handle instances of " + IFileEditorInput.class.getSimpleName()
					+ " as input.");
		document.setInput((IFileEditorInput) element);

		resourceChangeListener = new ReferencedResourcesUpdater(document);

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
				IResourceChangeEvent.POST_CHANGE);
		return document;
	}

	@Override
	protected void disconnected() {
		super.disconnected();
		if (resourceChangeListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
			resourceChangeListener = null;
		}
	}

}
