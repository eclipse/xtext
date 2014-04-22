/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks

import com.google.inject.Inject
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.tasks.ITaskFinder
import org.eclipse.xtext.tasks.Task
import org.eclipse.xtext.ui.markers.IMarkerContributor

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class TaskMarkerContributor implements IMarkerContributor {

	static final val log = Logger.getLogger(TaskMarkerContributor);

	@Inject
	TaskMarkerCreator markerCreator

	@Inject
	ITaskFinder taskFinder

	@Inject
	TaskMarkerTypeProvider typeProvider

	override updateMarkers(IFile file, Resource resource, IProgressMonitor monitor) {
		val subMonitor = SubMonitor.convert(monitor, 1);
		try {
			val tasks = taskFinder.findTasks(resource);
			if (subMonitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			subMonitor.worked(1);
			deleteMarkers(file, subMonitor);
			createTaskMarkers(file, tasks, subMonitor);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected def createTaskMarkers(IFile file, List<Task> tasks, IProgressMonitor monitor) throws CoreException {
		for (task : tasks) {
			markerCreator.createMarker(task, file, typeProvider.getMarkerType(task));
		}
	}

	override deleteMarkers(IFile file, IProgressMonitor monitor) {
		file.deleteMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO)
	}

}
