/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class DefaultTaskParser implements ITaskParser {
	@Override
	public List<Task> parseTasks(String source, TaskTags taskTags) {
		if (isEmpty(taskTags)) {
			return emptyList();
		}
		Map<String, TaskTag> taskTagsByName = getTaskTagsByName(taskTags);
		Matcher matcher = toPattern(taskTags).matcher(source);

		List<Task> tasks = null;
		int prevLine = 1;
		int prevOffset = 0;
		while (matcher.find()) {
			if (tasks == null) {
				tasks = new ArrayList<>();
			}
			Task task = new Task();
			String matchedTag = matcher.group(2);
			TaskTag tag = taskTagsByName.get(taskTags.isCaseSensitive() ? matchedTag : matchedTag.toLowerCase());
			task.setTag(tag);
			task.setDescription(matcher.group(3));
			task.setOffset(matcher.start(2));
			int countLineBreaks = Strings.countLineBreaks(source, prevOffset, task.getOffset());
			task.setLineNumber(countLineBreaks + prevLine);
			prevLine = task.getLineNumber();
			prevOffset = task.getOffset();
			tasks.add(task);
		}

		return tasks != null ? tasks : emptyList();
	}

	protected Map<String, TaskTag> getTaskTagsByName(TaskTags taskTags) {
		return taskTags.getTaskTagsByName();
	}

	protected Pattern toPattern(TaskTags taskTags) {
		return taskTags.toPattern();
	}
}
