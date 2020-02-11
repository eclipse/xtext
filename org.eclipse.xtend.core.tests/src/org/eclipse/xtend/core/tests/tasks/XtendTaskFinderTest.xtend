/** 
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.tasks

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.tasks.ITaskFinder
import org.eclipse.xtext.tasks.Priority
import org.eclipse.xtext.tasks.Task
import org.eclipse.xtext.tasks.TaskTag
import org.junit.Test

import static extension org.eclipse.xtext.util.Strings.*

/** 
 * @author Christian Dietrich - Initial contribution and API
 */
class XtendTaskFinderTest extends AbstractXtendTestCase {
	
	@Inject
	ITaskFinder finder
	
	@Test
	def void test() {
		val contents = '''
		package foo
		
		class Foo {
			def foo() {
				«"'''"»
				«"«"»«"«"»«"«"» TODO this is a todo
				TODO this is not a todo
				«"«"»«"«"»«"«"» FIXME this is a fixme
				«"'''"»
			}
		}
		'''.toString.toUnixLineSeparator
		val file = file(contents)
		
		file.eResource.assertContainsTasks(#[
			new Task => [
				tag = new TaskTag => [
					name = "TODO"
					priority = Priority.NORMAL
				]
				description = " this is a todo"
				offset = 50
				lineNumber = 6
			],
			new Task => [
				tag = new TaskTag => [
					name = "FIXME"
					priority = Priority.HIGH
				]
				description = " this is a fixme"
				offset = 102
				lineNumber = 8
			]
		])
		
	}

	private def assertContainsTasks(Resource resource, List<Task> expectedTasks) {
		val actualTasks = finder.findTasks(resource)
		assertEquals(expectedTasks.size, actualTasks.size)
		for (i : 0 ..< expectedTasks.size) {
			assertExactMatch(expectedTasks.get(i), actualTasks.get(i))
		}
	}
	
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
