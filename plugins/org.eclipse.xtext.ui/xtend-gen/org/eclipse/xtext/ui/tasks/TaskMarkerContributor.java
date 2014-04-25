/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tasks;

import com.google.inject.Inject;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class TaskMarkerContributor implements IMarkerContributor {
  private final static Logger log = Logger.getLogger(TaskMarkerContributor.class);
  
  @Inject
  private TaskMarkerCreator markerCreator;
  
  @Inject
  private ITaskFinder taskFinder;
  
  @Inject
  private TaskMarkerTypeProvider typeProvider;
  
  public void updateMarkers(final IFile file, final Resource resource, final IProgressMonitor monitor) {
    final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
    try {
      final List<Task> tasks = this.taskFinder.findTasks(resource);
      boolean _isCanceled = subMonitor.isCanceled();
      if (_isCanceled) {
        throw new OperationCanceledException();
      }
      subMonitor.worked(1);
      this.deleteMarkers(file, subMonitor);
      this.createTaskMarkers(file, tasks, subMonitor);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        String _message = e.getMessage();
        TaskMarkerContributor.log.error(_message, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void createTaskMarkers(final IFile file, final List<Task> tasks, final IProgressMonitor monitor) throws CoreException {
    for (final Task task : tasks) {
      String _markerType = this.typeProvider.getMarkerType(task);
      this.markerCreator.createMarker(task, file, _markerType);
    }
  }
  
  public void deleteMarkers(final IFile file, final IProgressMonitor monitor) {
    try {
      file.deleteMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
