/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Test

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*
import static extension org.eclipse.xtext.ui.XtextProjectHelper.*
import org.junit.After

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XtendNatureAddingEditorCallbackTest extends AbstractXtendUITestCase {

	@Inject
	WorkbenchTestHelper workbenchTestHelper

	@After
	override tearDown() throws Exception {
		cleanWorkspace
	}

	@Test
	def void testOpenXtendFileFromBuildPath() {
		val project = 'testProject'.createJavaProject.project
		assertFalse(project.hasNature)
		workbenchTestHelper.openEditor('testProject/src/Foo.xtend'.createFile('class Foo {}'))
		assertTrue(project.hasNature)
	}

	@Test
	def void testOpenXtendFileFromFilteredBuildPath() {
		val project = ('testProject'.createJavaProject => [
			addSourceFolder('filtered-src', null, #["**.xtend"])
		]).project
		assertFalse(project.hasNature)
		workbenchTestHelper.openEditor('testProject/filtered-src/Foo.xtend'.createFile('class Foo {}'))
		assertFalse(project.hasNature)
	}

	@Test
	def void testOpenXtendFileFromOutOfBuildPath() {
		val project = 'testProject'.createJavaProject.project
		assertFalse(project.hasNature)
		workbenchTestHelper.openEditor('testProject/doc/Foo.xtend'.createFile('class Foo {}'))
		assertFalse(project.hasNature)
	}

}
