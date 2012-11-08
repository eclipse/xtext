package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import java.lang.reflect.InvocationTargetException
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

class RenameFileTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper testHelper

	@Inject extension FileAsserts
	
	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown()
	}
	
	@Test
	def testRenameClass() {
		try {
			val fooFile = createFile("Foo", '''
				class Foo {}
			''')
			waitForAutoBuild		
			val processor = new RenameResourceProcessor(fooFile)
			val refactoring = new RenameRefactoring(processor)
			processor.setNewResourceName("Bar.xtend")
			val status = refactoring.checkAllConditions(new NullProgressMonitor)
			assertFalse(status.toString, status.hasError)
			val change = refactoring.createChange(new NullProgressMonitor)
			val applyOperation = new ApplyChangeOperation(change)
			applyOperation.run(new NullProgressMonitor)
			val barFile = assertFileExists('src/Bar.xtend')
			assertFileContains(barFile, 'class Bar {}')
		} finally {
			project.getFile('src/Bar.xtend').delete(true, new NullProgressMonitor)
		}
	}
	
	@Test
	def testDontRenameClass() {
		try {
			val fooFile = createFile("Foo", '''
				class FooBar {}
			''')
			waitForAutoBuild		
			val processor = new RenameResourceProcessor(fooFile)
			val refactoring = new RenameRefactoring(processor)
			processor.setNewResourceName("Bar.xtend")
			val status = refactoring.checkAllConditions(new NullProgressMonitor)
			assertFalse(status.toString, status.hasError)
			val change = refactoring.createChange(new NullProgressMonitor)
			val applyOperation = new ApplyChangeOperation(change)
			applyOperation.run(new NullProgressMonitor)
			val barFile = assertFileExists('src/Bar.xtend')
			assertFileContains(barFile, 'class FooBar {}')
		} finally {
			project.getFile('src/Bar.xtend').delete(true, new NullProgressMonitor)
		}
	}
}

class ApplyChangeOperation extends WorkspaceModifyOperation {
	Change change
	Change undoChange
	
	new(Change change) {
		this.change = change
	}

	override protected execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		undoChange = change.perform(monitor);		
	}
	
}