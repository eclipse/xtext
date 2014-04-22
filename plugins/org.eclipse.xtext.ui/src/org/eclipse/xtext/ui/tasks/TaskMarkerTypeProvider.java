/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
