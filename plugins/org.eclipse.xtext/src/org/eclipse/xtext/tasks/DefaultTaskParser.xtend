/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import com.google.common.collect.Maps
import java.util.regex.Pattern
import org.eclipse.xtext.util.Strings

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class DefaultTaskParser implements ITaskParser {

	override parseTasks(String source, TaskTags taskTags) {
		if (taskTags.empty) return #[]
		val taskTagsByName = Maps.uniqueIndex(taskTags)[name.toLowerCase]
		val matcher = taskTags.toPattern.matcher(source)
		val tasks = newArrayList
		while (matcher.find) {
			tasks += new Task => [
				tag = taskTagsByName.get(matcher.group(2).toLowerCase)
				description = matcher.group(3)
				offset = matcher.start(2)
				lineNumber = Strings.countLineBreaks(source.substring(0, offset)) + 1
			]
		}
		tasks
	}
	
	protected def toPattern(TaskTags taskTags) {
		//this takes roughly 1µs per call, so we think its not worth caching patterns here
		var flags = Pattern.MULTILINE
		if (!taskTags.caseSensitive) {
			flags = flags.bitwiseOr(Pattern.CASE_INSENSITIVE).bitwiseOr(Pattern.UNICODE_CASE)
		}
		Pattern.compile('''^.*((«taskTags.map[name].join("|")»)(.*)?)$''', flags)
	}
}
