/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import static org.junit.Assert.*

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class TaskAssert {
	def static void assertExactMatch(Task expected, Task actual) {
		assertExactMatch(expected.tag, actual.tag)
		assertEquals(expected.description, actual.description)
		assertEquals(expected.lineNumber, actual.lineNumber)
		assertEquals(expected.offset, actual.offset)
	}
	
	def static void assertExactMatch(TaskTag expected, TaskTag actual) {
		assertEquals(expected.name, actual.name)
		assertEquals(expected.priority, actual.priority)	
	}
}
