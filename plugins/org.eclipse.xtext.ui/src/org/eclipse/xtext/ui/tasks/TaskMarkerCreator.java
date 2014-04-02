/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class TaskMarkerCreator {

	public void createMarker(Task task, IResource resource, String markerType) throws CoreException {
		IMarker marker = resource.createMarker(markerType);
		setMarkerAttributes(task, resource, marker);
	}

	protected void setMarkerAttributes(Task task, IResource resource, IMarker marker) throws CoreException {
		marker.setAttribute(IMarker.LOCATION, "line " + task.getLineNumber());
		marker.setAttribute(IMarker.PRIORITY, getPriority(task.getTag().getPriority()));
		marker.setAttribute(IMarker.MESSAGE, task.getFullText());
		marker.setAttribute(IMarker.LINE_NUMBER, task.getLineNumber());
		marker.setAttribute(IMarker.CHAR_START, task.getOffset());
		marker.setAttribute(IMarker.CHAR_END, task.getOffset() + task.getTotalLength());
		marker.setAttribute(IMarker.USER_EDITABLE, false);
	}

	private int getPriority(Priority priority) {
		switch(priority) {
			case HIGH:
				return IMarker.PRIORITY_HIGH;
			case NORMAL:
				return IMarker.PRIORITY_NORMAL;
			case LOW:
				return IMarker.PRIORITY_LOW;
			default:
				return IMarker.PRIORITY_NORMAL;
		}
	}
}
