package org.eclipse.xtext.idea.sdomain.idea.tests.psi

import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import java.util.List
import org.eclipse.xtext.psi.ResourceDescriptionEventSource
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescription.Event

class PsiTreeChangeToDeltaConverterTest extends LightCodeInsightFixtureTestCase implements IResourceDescription.Event.Listener {

	List<Event> events

	override protected setUp() throws Exception {
		super.setUp()
		events = newArrayList
		ResourceDescriptionEventSource.getInstance(project).addListener(this)
	}

	override protected tearDown() throws Exception {
		ResourceDescriptionEventSource.getInstance(project).removeListener(this)
		events = null
		super.tearDown()
	}

	override descriptionsChanged(Event event) {
		events += event
	}

	def void testAddEntity() {
		val file = myFixture.addFileToProject('Foo.sdomain', '')
		myFixture.openFileInEditor(file.virtualFile)

		events.clear
		writeAndCommit[|
			myFixture.type('entity Foo {}')
		]
		events.assertEvents('Foo')
	}

	def void testRenameEntity() {
		val file = myFixture.addFileToProject('Foo.sdomain', 'entity Foo {}')
		myFixture.openFileInEditor(file.virtualFile)

		events.clear
		writeAndCommit[|
			myFixture.editor.caretModel.moveToOffset("entity Foo".length)
			myFixture.type("\b\b\bBar")
		]
		events.assertEvents('Foo', 'Bar')
	}

	def void testRemoveEntity() {
		val file = myFixture.addFileToProject('Foo.sdomain', 'entity Foo {}')
		myFixture.openFileInEditor(file.virtualFile)

		events.clear
		writeAndCommit[|
			myFixture.editor.caretModel.moveToOffset("entity Foo".length)
			myFixture.type("\b\b\b")
		]
		events.assertEvents('Foo')
	}

	protected def void assertEvents(Iterable<Event> events, String ... expectedExportedNames) {
		events.map [
			deltas
		].flatten.assertDeltas(expectedExportedNames)
	}

	protected def void assertDeltas(Iterable<Delta> deltas, String ... expectedExportedNames) {
		assertFalse("There are not deltas", deltas.empty)
		if (expectedExportedNames.size != 0) {
			val exportedNames = deltas.exportedNames
			assertContainsElements(exportedNames, expectedExportedNames)
			exportedNames.removeAll(expectedExportedNames)
			assertTrue('''Unexpected exported names: «exportedNames»''', exportedNames.empty)
		}
	}

	protected def getExportedNames(Iterable<Delta> deltas) {
		deltas.map [
			val names = newHashSet
			getNew?.exportedObjects?.forEach[names += toString]
			old?.exportedObjects?.forEach[names += toString]
			names
		].flatten.toSet
	}

	protected def writeAndCommit(()=>void action) {
		ApplicationManager.application.runWriteAction [|
			action.apply
			PsiDocumentManager.getInstance(project).commitAllDocuments()
		]
	}

}