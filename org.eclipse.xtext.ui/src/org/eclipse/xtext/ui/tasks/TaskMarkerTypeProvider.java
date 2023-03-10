/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks;

import org.eclipse.xtext.tasks.Task;


/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class TaskMarkerTypeProvider {

	public static final String XTEXT_TASK_TYPE = "org.eclipse.xtext.ui.task";

	public String getMarkerType(Task task) {
		return XTEXT_TASK_TYPE;
	}

}
