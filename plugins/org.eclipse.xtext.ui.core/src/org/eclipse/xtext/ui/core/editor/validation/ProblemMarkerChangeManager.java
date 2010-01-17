/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.ui.core.XtextUIMessages;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Listens to resource deltas and filters for marker changes of type IMarker.PROBLEM Viewers showing error ticks should
 * register as {@link IProblemMarkerChangedListener} to this type.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Singleton
public class ProblemMarkerChangeManager implements IResourceChangeListener {
	// mostly copied from {@link org.eclipse.jdt.internal.ui.viewsupport.ProblemMarkerManager}
	public static Logger log = Logger.getLogger(ProblemMarkerChangeManager.class);

	@Inject
	private IStorage2UriMapper mapper;
	private ListenerList listenerList = new ListenerList();
	private Set<IResource> resourcesWithMarkerChanges = Sets.newHashSet();
	private UIJob notifierJob;

	/**
	 * Visitors used to look if the element change delta contains a marker change.
	 */
	private class ProblemMarkerResourceDeltaVisitor implements IResourceDeltaVisitor {
		private Set<IResource> changedElements;

		public ProblemMarkerResourceDeltaVisitor(Set<IResource> changedElements) {
			this.changedElements = changedElements;
		}

		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();
			if (res instanceof IProject && delta.getKind() == IResourceDelta.CHANGED) {
				IProject project = (IProject) res;
				if (!project.isAccessible()) {
					return false;
				}
			}
			checkInvalidate(delta, res);
			return true;
		}

		private void checkInvalidate(IResourceDelta delta, IResource resource) {
			if (isHandled(resource) && mapper.getUri((IFile) resource) != null) {
				int kind = delta.getKind();
				if (kind == IResourceDelta.REMOVED || kind == IResourceDelta.ADDED
						|| (kind == IResourceDelta.CHANGED && isErrorDelta(delta))) {
					while (resource.getType() != IResource.ROOT && changedElements.add(resource)) {
						resource = resource.getParent();
					}
				}
			}

		}

		private boolean isErrorDelta(IResourceDelta delta) {
			if ((delta.getFlags() & IResourceDelta.MARKERS) != 0) {
				IMarkerDelta[] markerDeltas = delta.getMarkerDeltas();
				for (int i = 0; i < markerDeltas.length; i++) {
					if (markerDeltas[i].isSubtypeOf(IMarker.PROBLEM)) {
						int kind = markerDeltas[i].getKind();
						if (kind == IResourceDelta.ADDED || kind == IResourceDelta.REMOVED)
							return true;
						int severity = markerDeltas[i].getAttribute(IMarker.SEVERITY, -1);
						int newSeverity = markerDeltas[i].getMarker().getAttribute(IMarker.SEVERITY, -1);
						if (newSeverity != severity)
							return true;
					}
				}
			}
			return false;
		}

		private boolean isHandled(IResource resource) {
			return (resource instanceof IFile) && !((IFile) resource).isDerived();
		}
	}

	/*
	 * @see IResourceChangeListener#resourceChanged
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		Set<IResource> changedElements = Sets.newHashSet();
		try {
			IResourceDelta delta = event.getDelta();
			if (delta != null) {
				delta.accept(new ProblemMarkerResourceDeltaVisitor(changedElements));
			}
		} catch (CoreException e) {
			log.error(e.getStatus());
		}
		if (!changedElements.isEmpty()) {
			boolean hasChanges = false;
			synchronized (this) {
				if (resourcesWithMarkerChanges.isEmpty()) {
					resourcesWithMarkerChanges = changedElements;
					hasChanges = true;
				} else {
					hasChanges = resourcesWithMarkerChanges.addAll(changedElements);
				}
			}
			if (hasChanges) {
				fireChanges();
			}
		}
	}

	/**
	 * Adds a listener for problem marker changes.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	public void addChangeListener(IProblemMarkerChangedListener listener) {
		if (listenerList.isEmpty()) {
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		}
		listenerList.add(listener);
	}

	/**
	 * Removes a <code>IProblemChangedListener</code>.
	 * 
	 * @param listener
	 *            the listener to remove
	 */
	public void removeListener(IProblemMarkerChangedListener listener) {
		listenerList.remove(listener);
		if (listenerList.isEmpty()) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		}
	}

	/**
	 * Notify all IProblemChangedListener. Must be called in the display thread.
	 */
	private void runPendingUpdates() {
		IResource[] markerResources = null;
		synchronized (this) {
			if (!resourcesWithMarkerChanges.isEmpty()) {
				markerResources = resourcesWithMarkerChanges.toArray(new IResource[resourcesWithMarkerChanges.size()]);
				resourcesWithMarkerChanges.clear();
			}
		}
		Object[] listeners = listenerList.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			IProblemMarkerChangedListener changedListener = (IProblemMarkerChangedListener) listeners[i];
			if (markerResources != null) {
				changedListener.problemsChanged(markerResources, true);
			}
		}
	}
	
	private void fireChanges() {
		Display display = Display.getDefault();
		if (display != null && !display.isDisposed()) {
			postAsyncUpdate(display);
		}
	}

	private void postAsyncUpdate(final Display display) {
		if (notifierJob == null) {
			notifierJob = new UIJob(display, XtextUIMessages.ProblemMarkerManager_problem_marker_update_job_description) {
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					runPendingUpdates();
					return Status.OK_STATUS;
				}
			};
			notifierJob.setSystem(true);
		}
		notifierJob.schedule();
	}

}
