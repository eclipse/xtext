/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tasks

import java.util.List
import org.eclipse.xtext.tests.LineDelimiters
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.tasks.Priority.*
import static org.junit.Assert.*

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class DefaultTaskParserTest {
	ITaskParser parser
	TaskTags definitions

	val TODO = createTaskTag("TODO", NORMAL)
	val todo = createTaskTag("todo", NORMAL)

	@Pure
	private def static TaskTag createTaskTag(String tag, Priority priority) {
		new TaskTag => [
			it.name = tag
			it.priority = priority
		]
	}

	@Before
	def void setup() {
		parser = new DefaultTaskParser
		definitions = new DefaultTaskTagProvider().getTaskTags(null)
	}

	@Test
	def void testTasksWithDifferentCase() {
		parser = new DefaultTaskParser
		definitions = new TaskTags => [
			caseSensitive = true
			taskTags += #[ TODO, todo ]
		]

		'''
			/*
			 * TODO uppercase match
			 * todo lowercase match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = TODO
					description = " uppercase match"
					lineNumber = 2
					offset = 6
				],
				new Task() => [
					tag = todo
					description = " lowercase match"
					lineNumber = 3
					offset = 30
				]
			]
		)
	}

	@Test
	def void testTasksWithDifferentCaseCaseInsensitive() {
		parser = new DefaultTaskParser
		definitions = new TaskTags => [
			caseSensitive = false
			taskTags += #[ TODO, todo ]
		]

		'''
			/*
			 * TODO uppercase match
			 * todo lowercase match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = TODO
					description = " uppercase match"
					lineNumber = 2
					offset = 6
				],
				new Task() => [
					tag = TODO
					description = " lowercase match"
					lineNumber = 3
					offset = 30
				]
			]
		)
	}

	@Test
	def void testTasksWithDifferentCasePriorityMergeIfHigher() {
		parser = new DefaultTaskParser
		definitions = new TaskTags => [
			caseSensitive = false
			taskTags += #[
				TODO,
				createTaskTag("todo", HIGH)
			]
		]

		'''
			/*
			 * TODO uppercase match
			 * todo lowercase match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = createTaskTag("todo", HIGH)
					description = " uppercase match"
					lineNumber = 2
					offset = 6
				],
				new Task() => [
					tag = createTaskTag("todo", HIGH)
					description = " lowercase match"
					lineNumber = 3
					offset = 30
				]
			]
		)
	}

	@Test
	def void testTasksWithDifferentCasePriorityNoMergeIfLower() {
		parser = new DefaultTaskParser
		definitions = new TaskTags => [
			caseSensitive = false
			taskTags += #[
				TODO,
				createTaskTag("todo", LOW)
			]
		]

		'''
			/*
			 * TODO uppercase match
			 * todo lowercase match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = TODO
					description = " uppercase match"
					lineNumber = 2
					offset = 6
				],
				new Task() => [
					tag = TODO
					description = " lowercase match"
					lineNumber = 3
					offset = 30
				]
			]
		)
	}

	@Test
	def void testTasksWithDifferentCasePriorityNoMergeIfSame() {
		parser = new DefaultTaskParser
		definitions = new TaskTags => [
			caseSensitive = false
			taskTags += #[
				TODO,
				todo
			]
		]

		'''
			/*
			 * TODO uppercase match
			 * todo lowercase match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = TODO
					description = " uppercase match"
					lineNumber = 2
					offset = 6
				],
				new Task() => [
					tag = TODO
					description = " lowercase match"
					lineNumber = 3
					offset = 30
				]
			]
		)
	}

	@Test
	def void testCaseInSensitive() {
		definitions.caseSensitive = false
		'''
			/*
			 * FixMe case insensitive match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = createTaskTag("FIXME", HIGH)
					description = " case insensitive match"
					lineNumber = 2
					offset = 6
				]
			]
		)
	}

	@Test
	def void testCaseSensitive() {
		'''
			/* TODO this is a task
			 * FIXME this cannot work
			 * XXX: god, this is bad
			 * TODO
			 * FixMe this should not match
			 */
		'''.assertContainsTasks(
			#[
				new Task() => [
					tag = TODO
					description = " this is a task"
					lineNumber = 1
					offset = 3
				],
				new Task() => [
					tag = createTaskTag("FIXME", HIGH)
					description = " this cannot work"
					lineNumber = 2
					offset = 26
				],
				new Task() => [
					tag = createTaskTag("XXX", NORMAL)
					description = ": god, this is bad"
					lineNumber = 3
					offset = 52
				],
				new Task() => [
					tag = TODO
					description = ""
					lineNumber = 4
					offset = 77
				]
			])
	}

	@Test
	def void testLongInputManyTasks() {
		val expectation = 100000
		val String source = '''
			/*
			 «FOR i: 1..expectation»
			 	* FIXME this cannot work
			 «ENDFOR»
			 */
		'''
		val parsed = parser.parseTasks(LineDelimiters.toUnix(source), definitions)
		assertEquals(expectation, parsed.size)
		for(i: 0..<expectation) {
			assertEquals(i+2, parsed.get(i).lineNumber)
		}
	}

	private def assertContainsTasks(CharSequence source, List<Task> expectedTasks) {
		val actualTasks = parser.parseTasks(LineDelimiters.toUnix(source.toString), definitions)
		assertEquals(expectedTasks.size, actualTasks.size)
		for (i : 0 ..< expectedTasks.size) {
			assertEquals(expectedTasks.get(i), actualTasks.get(i))
		}
	}
}
