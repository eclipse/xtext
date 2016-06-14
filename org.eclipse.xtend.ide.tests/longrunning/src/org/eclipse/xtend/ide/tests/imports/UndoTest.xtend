package org.eclipse.xtend.ide.tests.imports

import com.google.inject.Inject
import org.eclipse.jface.text.ITextViewerExtension6
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler
import org.junit.Test

class UndoTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper
	
	@Inject extension OrganizeImportsHandler
	
	@Test
	def void testUndo() {
		val editor = openEditor('Foo', '''
			class Foo {
				val java.lang.String x
				val java.util.ArrayList<String> y
			}
		''')
		doOrganizeImports(editor.document)
		assertEquals('''
			import java.util.ArrayList
			
			class Foo {
				val String x
				val ArrayList<String> y
			}
		'''.toString, editor.document.get)
		val viewer = editor.internalSourceViewer
		assertTrue(viewer instanceof ITextViewerExtension6)
		val undoManager = (viewer as ITextViewerExtension6).undoManager
		undoManager.undo
		assertEquals('''
			class Foo {
				val java.lang.String x
				val java.util.ArrayList<String> y
			}
		'''.toString, editor.document.get)
	}
}