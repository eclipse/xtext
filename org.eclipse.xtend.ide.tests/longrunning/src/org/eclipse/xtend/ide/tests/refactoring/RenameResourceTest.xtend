package org.eclipse.xtend.ide.tests.refactoring

import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.junit.Test
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import com.google.inject.Inject
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.Path

class RenameResourceTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper
	
	@Inject IWorkspace workspace
	
	@Inject extension FileAsserts
	
	@Test 
	def void testRenameClassWithSameName() {
		try {			
			createFile('Foo', 'class Foo {}')
				.renameTo('Bar.xtend')
				.assertFileContains('class Bar {}')
		} finally {
			getFile('Bar.xtend').delete(true, null)
		}
	}
	
	@Test 
	def void testDontRenameClassWithDifferenName() {
		try {			
			createFile('Foo', 'class FooBar {}')
				.renameTo('Bar.xtend')
				.assertFileContains('class FooBar {}')
		} finally {
			getFile('Bar.xtend').delete(true, null)
		}
	}
	
	@Test 
	def void testGuardMissingFileExtension() {
		try {			
			createFile('Foo', 'class Foo {}')
				.renameTo('Bar')
				.assertFileContains('class Foo {}')
		} finally {
			getFile('Bar').delete(true, null)
		}
	}
	
	def protected renameTo(IFile file, String newFileName) {
		val renameResourceProcessor = new RenameResourceProcessor(file)
		renameResourceProcessor.setNewResourceName(newFileName)
		val renameRefactoring = new RenameRefactoring(renameResourceProcessor)
		renameRefactoring.checkAllConditions(new NullProgressMonitor)
		val change = renameRefactoring.createChange(new NullProgressMonitor)
		workspace.run([
			change.perform(it)
		], new NullProgressMonitor)
		val newFile = project.findMember(new Path("src/" + newFileName))
		assertTrue(newFile.exists)
		assertTrue(newFile instanceof IFile)
		newFile as IFile
	}
}