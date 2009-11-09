/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceAwareXtextDocumentProvider extends XtextDocumentProvider {
	
	private static final Logger log = Logger.getLogger(ResourceAwareXtextDocumentProvider.class);
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 *
	 * updates referenced EMF Resources on IResourceChangeEvent
	 */
	protected static class ReferencedResourcesUpdater implements IResourceChangeListener {
		private final XtextDocument document;

		private ReferencedResourcesUpdater(XtextDocument document) {
			this.document = document;
		}

		public void resourceChanged(final IResourceChangeEvent event) {

			final ResourceDeltaVisitor visitor = createDeltaVisitor();
			try {
				event.getDelta().accept(visitor);
			} catch (CoreException e) {
				log.error(e.getMessage(), e);
			}
			if (!visitor.deltas.isEmpty()) {
			new Job("updating resourceset"){
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					document.modify(new IUnitOfWork.Void<XtextResource>() {

						@Override
						public void process(XtextResource arg) throws Exception {
							for (IResourceDelta delta : visitor.deltas) {
								IResource res = delta.getResource();
								String resourcesLastSegment = getLastSegment(res);
								ResourceSet set = arg.getResourceSet();
								for(int i = 0; i < set.getResources().size(); ) {
									final Resource emfResource = set.getResources().get(i);
									if (emfResource != null) {
										String otherLastSegment = getLastSegment(emfResource);
										if (resourcesLastSegment.equals(otherLastSegment)) {
											switch (delta.getKind()) {
											case IResourceDelta.REMOVED:
												// UNLOAD
												emfResource.unload();
												if (emfResource.getResourceSet() != null)
													set.getResources().remove(emfResource);
												break;
											case IResourceDelta.CHANGED:
												// RELOAD
												emfResource.unload();
												emfResource.load(null);
												break;
											}
										}
									}
									if (set.getResources().size() > i && set.getResources().get(i) == emfResource)
										i++;
								}
							}
							arg.reparse(document.get());
						}
					});
					return Status.OK_STATUS;
				}}.schedule(); // do we need to lock the workspace?
			}
		}

		protected ResourceDeltaVisitor createDeltaVisitor() {
			return new ResourceDeltaVisitor(document);
		}

	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * collects all interesting IResourceDeltas (those which are referenced by the managed EMF Resource)
	 */
	protected static class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		private final XtextDocument document;

		private ResourceDeltaVisitor(XtextDocument document) {
			this.document = document;
		}

		public final List<IResourceDelta> deltas = new ArrayList<IResourceDelta>();

		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();
			int kind = delta.getKind();
			int flags = delta.getFlags();
			if ((kind == IResourceDelta.REMOVED || (kind == IResourceDelta.CHANGED && ((IResourceDelta.CONTENT & flags) != 0)))
				&& isReferenced(res)) { 
				deltas.add(delta);
			}
			return true;
		}
		
		public boolean isReferenced(final IResource anIResource) {
			if (!(anIResource instanceof IFile))
				return false;
			Boolean result = document.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
				public Boolean exec(XtextResource resource) throws Exception {
					if (resource == null || resource.getResourceSet() == null)
						return false;
					List<Resource> resources = resource.getResourceSet().getResources();
					String resourcesLastSegment = getLastSegment(anIResource);
					for (Resource res : resources) {
						if (res != resource) {
							String otherLastSegment = getLastSegment(res);
							if (otherLastSegment.equals(resourcesLastSegment))
								return true;
						}
					}
					return false;
				}
			});
			return result.booleanValue();
		}
	}
	
	protected static String getLastSegment(IResource resource) {
		String result = resource.getFullPath().lastSegment();
		result = URI.encodeSegment(result, true);
		return result;
	}

	protected static String getLastSegment(final Resource resource) {
		String result = resource.getURI().lastSegment();
		result = URI.encodeSegment(result, true);
		return result;
	}

	private final List<IResourceChangeListener> resourceChangeListener = new ArrayList<IResourceChangeListener>();

	@Override
	protected XtextDocument createEmptyDocument() {
		XtextDocument result = super.createEmptyDocument();
		ReferencedResourcesUpdater listener = createReferencedResourceUpdater(result);
		resourceChangeListener.add(listener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener,
				IResourceChangeEvent.POST_CHANGE);

		return result;
	}

	private ReferencedResourcesUpdater createReferencedResourceUpdater(XtextDocument result) {
		return new ReferencedResourcesUpdater(result);
	}

	@Override
	protected void setupDocument(Object element, IDocument document) {
		((XtextDocument) document).setInput((IEditorInput) element);
	}

	@Override
	protected void disconnected() {
		super.disconnected();
		for (IResourceChangeListener listener : resourceChangeListener) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);
		}
		resourceChangeListener.clear();
	}
}
