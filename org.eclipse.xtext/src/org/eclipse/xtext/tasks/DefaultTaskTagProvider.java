/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class DefaultTaskTagProvider implements ITaskTagProvider {
	@Override
	public TaskTags getTaskTags(Resource resource) {
		TaskTags taskTags = new TaskTags();
		taskTags.setCaseSensitive(true);
		taskTags.getTaskTags().add(toTaskTag("TODO", Priority.NORMAL));
		taskTags.getTaskTags().add(toTaskTag("FIXME", Priority.HIGH));
		taskTags.getTaskTags().add(toTaskTag("XXX", Priority.NORMAL));
		return taskTags;
	}

	private TaskTag toTaskTag(String name, Priority priority) {
		TaskTag tag = new TaskTag();
		tag.setName(name);
		tag.setPriority(priority);
		return tag;
	}
}
