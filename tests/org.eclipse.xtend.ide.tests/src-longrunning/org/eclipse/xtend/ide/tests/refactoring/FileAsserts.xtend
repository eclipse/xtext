package org.eclipse.xtend.ide.tests.refactoring

import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import javax.inject.Inject
import static org.junit.Assert.*
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource

class FileAsserts {
	
	@Inject extension WorkbenchTestHelper
	
	def assertFileExists(String fileName) throws Exception {
		val file = project.findMember(fileName)
		assertTrue(file instanceof IFile)
		assertTrue(file.exists())
		return file as IFile;
	}

	def assertFileContains(IFile file, String contents) throws Exception {
		file.refreshLocal(IResource::DEPTH_ZERO, null);
		val fileContents = getContents(file);
		assertTrue(fileContents, fileContents.contains(contents));
	}
}