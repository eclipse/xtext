package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper

import static org.junit.Assert.*

class FileAsserts {
	
	@Inject extension WorkbenchTestHelper
	
	def assertFileExists(String fileName) throws Exception {
		val file = project.findMember(fileName)
		assertTrue(file instanceof IFile)
		assertTrue(file.exists())
		file as IFile
	}

	def assertFileContains(IFile file, String expectedContents) throws Exception {
		file.refreshLocal(IResource::DEPTH_ZERO, null);
		val fileContents = getContents(file);
		assertTrue('''Substring '«expectedContents»' not found in '«fileContents»' ''', 
			fileContents.contains(expectedContents)
		)
	}
}