/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess
import org.junit.After
import org.junit.Test

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*
import static org.eclipse.xtext.generator.IFileSystemAccess.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class KeepLocalHistoryTest extends AbstractXtendUITestCase {

	val static FILE_NAME = 'foo/Foo.xtend'

	val static GENERATE_FILE_NAME = '../xtend-gen/foo/Foo.java'

	val static GENERATE_TRACK_FILE_NAME = '../xtend-gen/foo/.Foo.java._trace'
	
	val static CONTENT_WITHOUT_BODY = 'package foo class Foo {}'
	
	val static CONTENT_WITH_BODY = 'package foo class Foo { def foo() {} }'

	@Inject
	extension WorkbenchTestHelper workbenchTestHelper

	@Inject
	extension IPreferenceStoreAccess

	override setUp() throws Exception {
		super.setUp()
		override = true
		cleanDirectory = false
		cleanupDerived = true
	}

	@After
	override tearDown() throws Exception {
		workbenchTestHelper.tearDown
	}

	@Test
	def void testTurnOffLocalHistoryKeeping() {
		keepLocalHistory = false

		assertCreateFile(0) => [
			assertChangeContentByAnotherContent(0)
			assertChangeContentByTheSameContent(0)
			cleanupDerived = false
			override = false
			assertChangeContentByAnotherContent(0)
			assertChangeContentByTheSameContent(0)
			override = true
			cleanupDerived = true
			assertDelete(0)
		]

		assertCreateFile(0) => [
			cleanupDerived = true
			assertCleanBuild(0)
			cleanDirectory = true
			assertCleanBuild(0)
		]
	}

	@Test
	def void testTurnOnLocalHistoryKeeping() {
		keepLocalHistory = true

		assertCreateFile(0) => [
			assertChangeContentByAnotherContent(1)
			assertChangeContentByTheSameContent(1)
			cleanupDerived = false
			override = false
			assertChangeContentByAnotherContent(1)
			assertChangeContentByTheSameContent(1)
			override = true
			cleanupDerived = true
			assertDelete(2)
		]

		assertCreateFile(2) => [
			cleanupDerived = true
			assertCleanBuild(3)
			cleanDirectory = true
			assertCleanBuild(4)
		]
	}

	def assertCreateFile(int expectedLocalHistorySize) {
		FILE_NAME.createFile(CONTENT_WITHOUT_BODY) => [
			assertGeneratedFiles(expectedLocalHistorySize)
		]
	}

	def assertChangeContentByAnotherContent(IFile it, int expectedLocalHistorySize) {
		openEditor => [
			val currentContent = document.get
			if (currentContent.equals(CONTENT_WITHOUT_BODY)) {
				document.set(CONTENT_WITH_BODY)
			} else {
				document.set(CONTENT_WITHOUT_BODY)
			}
			saveEditor(false)
		]
		assertGeneratedFiles(expectedLocalHistorySize)
	}

	def assertChangeContentByTheSameContent(IFile it, int expectedLocalHistorySize) {
		openEditor => [
			document.set(document.get)
			saveEditor(false)
		]
		assertGeneratedFiles(expectedLocalHistorySize)
	}

	def assertDelete(IFile it, int expectedLocalHistorySize) {
		delete(true, null)
		fullBuild
		GENERATE_FILE_NAME.assertFileLocalHistory(expectedLocalHistorySize)
		GENERATE_TRACK_FILE_NAME.assertFileLocalHistoryEmpty
	}

	def assertCleanBuild(int expectedLocalHistorySize) {
		cleanBuild
		assertGeneratedFiles(expectedLocalHistorySize)
	}

	def assertGeneratedFiles(int expectedLocalHistorySize) {
		fullBuild
		GENERATE_FILE_NAME.assertExist.assertFileLocalHistory(expectedLocalHistorySize)
		GENERATE_TRACK_FILE_NAME.assertExist.assertFileLocalHistoryEmpty
	}

	def assertFileLocalHistoryEmpty(String it) {
		assertFileLocalHistory(0)
	}

	def assertExist(String it) {
		assertTrue(file.exists)
		it
	}

	def assertFileLocalHistory(String it, int expectedLocalHistorySize) {
		assertEquals(expectedLocalHistorySize, file.getHistory(null).size)
	}

	def setKeepLocalHistory(boolean keepLocalHistory) {
		setValue(OUTPUT_KEEP_LOCAL_HISTORY, keepLocalHistory)
	}

	def setOverride(boolean ^override) {
		setValue(OUTPUT_OVERRIDE, override)
	}

	def setCleanupDerived(boolean cleanupDerived) {
		setValue(OUTPUT_CLEANUP_DERIVED, cleanupDerived)
	}

	def setCleanDirectory(boolean cleanDirectory) {
		setValue(OUTPUT_CLEAN_DIRECTORY, cleanDirectory)
	}

	def setValue(String preferenceName, boolean value) {
		project.writablePreferenceStore.setValue(preferenceName.key, value)
	}

	def String getKey(String preferenceName) '''«OUTPUT_PREFERENCE_TAG»«^SEPARATOR»«DEFAULT_OUTPUT»«^SEPARATOR»«preferenceName»'''

}
