package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.ui.ide.ResourceUtil
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.ui.editor.XbaseEditorInputRedirector
import org.junit.After
import org.junit.Test

class XbaseEditorInputRedirectorTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper helper 
	
	@Inject XbaseEditorInputRedirector redirector
	
	@After override void tearDown() {
		helper.tearDown
	}
	
	@Test def void testOpenDerivedFileFromBin() {
		val fileInSrc = (WorkbenchTestHelper::TESTPROJECT_NAME + "/src/mypack/HelloXtend.xtend").createFileImpl('''
			package mypack
			class HelloXtend {
				def void doStuff() {
				}
			}
		''');
		val fileInBin = (WorkbenchTestHelper::TESTPROJECT_NAME + "/bin/mypack/HelloXtend.xtend").createFileImpl('''
			package mypack
			class HelloXtend {
				def void doStuff() {
				}
			}
		''');
		
		val result = redirector.findOriginalSource(new FileEditorInput(fileInBin))
		assertEquals(fileInSrc, ResourceUtil::getFile(result))
		
		val result2 = redirector.findOriginalSource(new FileEditorInput(fileInSrc))
		assertEquals(fileInSrc, ResourceUtil::getFile(result2))
	}
}