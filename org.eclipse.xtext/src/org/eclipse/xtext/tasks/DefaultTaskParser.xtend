/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import java.util.Collections
import java.util.List
import java.util.Map
import org.eclipse.xtext.util.Strings

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class DefaultTaskParser implements ITaskParser {
	
	override parseTasks(String source, TaskTags taskTags) {
		if (taskTags.empty) return Collections.emptyList

		val taskTagsByName = getTaskTagsByName(taskTags)

		val matcher = toPattern(taskTags).matcher(source)
		var List<Task> tasks
		// keep track of the offset and line numbers to avoid unnecessary line counting from start
		var prevLine = 1;
		var prevOffset = 0;
		while (matcher.find) {
			if (tasks === null)
				tasks = newArrayList
			val task = new Task()
			val matchedTag = matcher.group(2)
			task.tag = taskTagsByName.get(if (taskTags.caseSensitive) matchedTag else matchedTag.toLowerCase)
			task.description = matcher.group(3)
			task.offset = matcher.start(2)
			task.lineNumber = Strings.countLineBreaks(source, prevOffset, task.offset) + prevLine
			prevLine = task.lineNumber
			prevOffset = task.offset
			tasks += task
		}
		tasks ?: Collections.emptyList
	}

	protected def Map<String, TaskTag> getTaskTagsByName(TaskTags taskTags) {
		return taskTags.taskTagsByName
	}

	protected def toPattern(TaskTags taskTags) {
		return taskTags.toPattern
	}
}
