/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class TaskTags implements Iterable<TaskTag> {
	private boolean caseSensitive;

	private final List<TaskTag> taskTags = new ArrayList<>();

	private Pattern pattern;

	private Map<String, TaskTag> taskTagsByName;

	@Override
	public Iterator<TaskTag> iterator() {
		return taskTags.iterator();
	}

	public Pattern toPattern() {
		if (pattern == null) {
			int flags = Pattern.MULTILINE;
			if (!caseSensitive) {
				flags = flags | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
			}
			StringBuilder builder = new StringBuilder();
			builder.append("^.*((");
			String tagNames = taskTags.stream().map(it -> Pattern.quote(it.getName())).collect(joining("|"));
			builder.append(tagNames);
			builder.append(")(.*)?)$");
			pattern = Pattern.compile(builder.toString(), flags);
		}
		return pattern;
	}

	public Map<String, TaskTag> getTaskTagsByName() {
		if (taskTagsByName == null) {
			HashMap<String, TaskTag> name2tag = new HashMap<>();
			taskTagsByName = name2tag;
			for (TaskTag tag : taskTags) {
				String name = caseSensitive ? tag.getName() : tag.getName().toLowerCase();
				TaskTag oldTag = taskTagsByName.get(name);
				if (oldTag != null) {
					// prioritize higher priority tags
					if (tag.getPriority().ordinal() < oldTag.getPriority().ordinal()) {
						taskTagsByName.put(name, tag);
					}
				} else {
					taskTagsByName.put(name, tag);
				}
			}
		}
		return taskTagsByName;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public List<TaskTag> getTaskTags() {
		return taskTags;
	}
}
