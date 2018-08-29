/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import java.util.regex.Pattern

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@EqualsHashCode
class TaskTag {
	String name
	Priority priority

	def length() {
		name.length
	}
}

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
class TaskTags implements Iterable<TaskTag> {

	boolean caseSensitive
	val List<TaskTag> taskTags = newArrayList
	
	@Accessors(NONE)
	var Pattern pattern

	override iterator() {
		taskTags.iterator
	}
	
	def Pattern toPattern() {
		if (pattern === null) {
			// for projects with a lot of comments around 5-10% of full build is spend to compile pattern
			// hence we cache it
			var flags = Pattern.MULTILINE
			if (!caseSensitive) {
				flags = flags.bitwiseOr(Pattern.CASE_INSENSITIVE).bitwiseOr(Pattern.UNICODE_CASE)
			}
			pattern = Pattern.compile('''^.*((«taskTags.map[Pattern.quote(name)].join("|")»)(.*)?)$''', flags)
		}
		return pattern
	}

}
