package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.ui.texteditor.MarkerUtilities
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.core.resources.IFile
import org.junit.Ignore
import org.junit.Rule
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.util.internal.Stopwatches

class RebuildAffectedResourcesTest extends AbstractXtendUITestCase {

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Rule public static StopwatchRule rule = new StopwatchRule(true)
	
	@Test def void testRemoveReferencedType() {
		val type1 = workbenchTestHelper.createFile('Type1.xtend', '''
			class Type1 {
			}
		''')
		val type2 = workbenchTestHelper.createFile('Type2.xtend', '''
			class Type2 {
				Type1 myRef
			}
		''')
		waitForAutoBuild()
		assertNoErrorsInWorkspace
		type1.setContents(new StringInputStream('''
			class Type3 {
			}
		'''),true,true, null)
		waitForAutoBuild()
		type2.assertHasErrors("Type1")
	}
	
	@Test def void testAddReferencedType() {
		val type1 = workbenchTestHelper.createFile('Type1.xtend', '''
			class Type3 {
			}
		''')
		val type2 = workbenchTestHelper.createFile('Type2.xtend', '''
			class Type2 {
				Type1 myRef
			}
		''')
		waitForAutoBuild
		type2.assertHasErrors("Type1")
		type1.setContents(new StringInputStream('''
			class Type1 {
			}
		'''),true,true, null)
		waitForAutoBuild()
		assertNoErrorsInWorkspace
	}
	
	@Ignore
	@Test def void testAddMethod() {
		val type3 = workbenchTestHelper.createFile('Type3.xtend', '''
			class Type3 {
			}
		''')
		workbenchTestHelper.createFile('Type1.xtend', '''
			class Type1 {
				def Type3 foo() { return new Type3()}
			}
		''')
		val type2 = workbenchTestHelper.createFile('Type2.xtend', '''
			class Type2 {
				def void doStuff() {
					new Type1().foo().bar()
				}
			}
		''')
		waitForAutoBuild()
		type2.assertHasErrors("bar")
		type3.setContents(new StringInputStream('''
			class Type3 {
				def void bar() {}
			}
		'''),true,true, null)
		waitForAutoBuild()
		assertNoErrorsInWorkspace
	}
	
	
	def void assertNoErrorsInWorkspace() {
		val findMarkers = ResourcesPlugin::workspace.root.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities::getMessage(iMarker), MarkerUtilities::getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
	
	def void assertNumberOfBuilds(int numberOfBuild) {
		waitForAutoBuild()
		val builderEntry = Stopwatches::allNumbers.entrySet.filter[key == 'XtextBuilder.build'].head
		if (builderEntry == null) {
			assertEquals(numberOfBuild, 0)
		} else {
			val actualMeasurements = builderEntry.value.numberOfMeasurements
			assertEquals(numberOfBuild, actualMeasurements)
		}
	}
	
	def void assertHasErrors(IFile file, String msgPart) {
		val findMarkers = file.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			if (MarkerUtilities::getSeverity(iMarker) == IMarker::SEVERITY_ERROR && MarkerUtilities::getMessage(iMarker).contains(msgPart)) {
				return;
			}
		}
		fail("Exected an error marker containing '"+msgPart+"' on "+file.fullPath)
	}
	
}