/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.tasks.TaskAssert.*
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.tests.LineDelimiters

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class DefaultTaskFinderTest extends AbstractXtextTests {

	ITaskFinder finder

	@Before
	def void setup() {
		with(NoJdtTestLanguageStandaloneSetup)
		finder = get(DefaultTaskFinder)
	}
	
	@Test
	def void testNonXtextResource() {
		new ResourceImpl().assertContainsTasks(#[])
	}

	@Test
	def void test() {
		getResourceFromString(
			LineDelimiters.toUnix(
			'''
				//TODO foo
				/*
				 * FIXME bar
				 * Fixme no match
				 * FOO also no match
				 */
				Hello notATODO!
			''')
		)
		.assertContainsTasks(#[
			new Task => [
				tag = new TaskTag => [
					name = "TODO"
					priority = Priority.NORMAL
				]
				description = " foo"
				offset = 2
				lineNumber = 1
			],
			new Task => [
				tag = new TaskTag => [
					name = "FIXME"
					priority = Priority.HIGH
				]
				description = " bar"
				offset = 17
				lineNumber = 3
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
}
