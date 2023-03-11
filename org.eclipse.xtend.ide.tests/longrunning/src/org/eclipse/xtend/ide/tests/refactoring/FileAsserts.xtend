/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.junit.Assert.*

class FileAsserts {
	
	@Inject extension WorkbenchTestHelper
	
	def assertFileExists(String fileName) throws Exception {
		val file = project.findMember(fileName)
		assertTrue(fileName + ' is not an IFile', file instanceof IFile)
		assertTrue('File ' + fileName + ' doesn\'t exist', file.exists())
		file as IFile
	}

	def assertFileDoesntExists(String fileName) throws Exception {
		val file = project.findMember(fileName)
		assertNull(file)
	}

	def assertFileContains(IFile file, String... expectedContents) throws Exception {
		file.refreshLocal(IResource::DEPTH_ZERO, null);
		val fileContents = getContentsAsString(file);
		expectedContents.forEach [ expectation |
			if (!fileContents.contains(expectation)) {
				assertEquals(expectation, fileContents)
			}
		]
	}
}