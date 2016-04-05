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
		for (expectation : expectedContents) {
			if (!fileContents.contains(expectation)) {
				assertEquals(expectation, fileContents)
			}
		}
	}
}