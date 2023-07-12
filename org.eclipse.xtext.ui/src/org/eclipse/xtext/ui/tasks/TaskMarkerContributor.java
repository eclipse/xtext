/**
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tasks;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.ui.markers.IMarkerContributor;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * 
 * @since 2.6
 */
public class TaskMarkerContributor implements IMarkerContributor {

	private static final Logger LOG = Logger.getLogger(TaskMarkerContributor.class);

	@Inject
	private TaskMarkerCreator markerCreator;

	@Inject
	private ITaskFinder taskFinder;

	@Inject
	private TaskMarkerTypeProvider typeProvider;

	@Override
	public void updateMarkers(IFile file, Resource resource, IProgressMonitor monitor) {
		try {
			List<Task> tasks = taskFinder.findTasks(resource);
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			deleteMarkers(file, monitor);
			createTaskMarkers(file, tasks, monitor);
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	protected void createTaskMarkers(IFile file, List<Task> tasks, IProgressMonitor monitor) throws CoreException {
		for (Task task : tasks) {
			markerCreator.createMarker(task, file, typeProvider.getMarkerType(task));
		}
	}

	@Override
	public void deleteMarkers(IFile file, IProgressMonitor monitor) {
		try {
			file.deleteMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
