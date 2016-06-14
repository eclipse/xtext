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

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
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

	override iterator() {
		taskTags.iterator
	}

}
