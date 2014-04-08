/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import java.util.List

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class TaskTag {
	@Property String name
	@Property Priority priority

	def length() {
		name.length
	}
}

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class TaskTags implements Iterable<TaskTag> {

	@Property boolean caseSensitive
	val List<TaskTag> taskTags = newArrayList

	override iterator() {
		taskTags.iterator
	}

	def getTaskTags() {
		taskTags
	}

}
