/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks;

import java.util.HashMap;
import java.util.Map;

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
		// Do this in one single setAttributes() call, as each set of an attribute is a workspace operation
		Map<String, Object> attributes = new HashMap<>(8);
		attributes.put(IMarker.LOCATION, "line " + task.getLineNumber());
		attributes.put(IMarker.PRIORITY, getPriority(task.getTag().getPriority()));
		attributes.put(IMarker.MESSAGE, task.getFullText());
		attributes.put(IMarker.LINE_NUMBER, task.getLineNumber());
		attributes.put(IMarker.CHAR_START, task.getOffset());
		attributes.put(IMarker.CHAR_END, task.getOffset() + task.getTotalLength());
		attributes.put(IMarker.USER_EDITABLE, false);
		marker.setAttributes(attributes);
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
