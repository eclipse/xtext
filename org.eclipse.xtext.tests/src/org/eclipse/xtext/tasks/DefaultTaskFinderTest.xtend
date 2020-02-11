/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tasks

import com.google.inject.Binder
import com.google.inject.Guice
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageRuntimeModule
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.tests.LineDelimiters
import org.junit.Before
import org.junit.Test

import com.google.inject.name.Names
import org.eclipse.xtext.documentation.impl.AbstractMultiLineCommentProvider

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
				/* TODO Get rid of this */
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
			],
			new Task => [
				tag = new TaskTag => [
					name = "TODO"
					priority = Priority.NORMAL
				]
				description = " Get rid of this "
				offset = 73
				lineNumber = 7
			]
		])
		
	}
	
	@Test
	def void testSpecialEndTag() {
		with(NoJdtTestLanguageStandaloneSetupCustom)
		finder = get(DefaultTaskFinder)
		getResourceFromString(
			LineDelimiters.toUnix(
			'''
				/* TODO Get rid of this ***/
				Hello notATODO!
			''')
		)
		.assertContainsTasks(#[
			new Task => [
				tag = new TaskTag => [
					name = "TODO"
					priority = Priority.NORMAL
				]
				description = " Get rid of this "
				offset = 3
				lineNumber = 1
			]
		])
	}
	
	static class NoJdtTestLanguageStandaloneSetupCustom extends NoJdtTestLanguageStandaloneSetup {
		
		override createInjector() {
			return Guice.createInjector(new NoJdtTestLanguageRuntimeModule() {
				def configureEndTag(Binder binder) {
					binder.bind(String).annotatedWith(
						Names.named(AbstractMultiLineCommentProvider.END_TAG)
					).toInstance("\\*\\*\\*/")
				}
			});
		}
		
	}

	private def assertContainsTasks(Resource resource, List<Task> expectedTasks) {
		val actualTasks = finder.findTasks(resource)
		assertEquals(expectedTasks.size, actualTasks.size)
		for (i : 0 ..< expectedTasks.size) {
			assertEquals(expectedTasks.get(i), actualTasks.get(i))
		}
	}
}
