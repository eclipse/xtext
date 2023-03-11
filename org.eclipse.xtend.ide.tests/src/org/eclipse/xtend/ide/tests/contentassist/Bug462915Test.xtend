/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Test

import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.findJavaProject
import static extension org.eclipse.xtext.util.Strings.*

/**
 * Tests for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=462915">Bug 462915</a>
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
class Bug462915Test extends AbstractXtendContentAssistBugTest {
	
	static val NO_GUICE_PROJECT_NAME = "Bug462915"
	IProject noGuiceProject

	@After
	override tearDown() throws Exception {
		if (noGuiceProject !== null) {
			deleteProject(noGuiceProject)
		}
		super.tearDown()
		
	}

	/**
	 * make sure additional proposal infos can be calculated
	 */
	@Test
	def void testAdditionalProposalInfoWorks() {
		val model = '''
		class A {
			test
		}'''
		val proposals = newBuilder
		.append(model)
		.computeCompletionProposals(model.indexOf("test") + 4)
		assertEquals("More than one proposal found", 1, proposals.size)
		val proposal = proposals.head
		assertEquals("test - JUnit test method", proposal.displayString)
		assertEquals('''
		@Test
		def void testName() {
			
		}'''.toUnixLineSeparator.toString, proposal.additionalProposalInfo)
	}

	/**
	 * make sure inject is not proposed
	 */
	@Test
	def void testTestPreConditionsWork() {
		
		val model = '''
		class A {
			inject
		}'''
		val proposals = newBuilder
		.append(model)
		.computeCompletionProposals(model.indexOf("inject") + 6)
		assertEquals("Did not expect to find any proposal", 0, proposals.size)
	}

	override IJavaProject getJavaProject(ResourceSet resourceSet) {
		var IJavaProject javaProject = findJavaProject(NO_GUICE_PROJECT_NAME);
		if (javaProject === null || !javaProject.exists()) {
			try {
				noGuiceProject = WorkbenchTestHelper.createPluginProject(NO_GUICE_PROJECT_NAME, getTestProjectRequiredBundles());
				javaProject = findJavaProject(NO_GUICE_PROJECT_NAME);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	def protected getTestProjectRequiredBundles() {
		// no com.google.inject here
		#["org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit"]
	}

}