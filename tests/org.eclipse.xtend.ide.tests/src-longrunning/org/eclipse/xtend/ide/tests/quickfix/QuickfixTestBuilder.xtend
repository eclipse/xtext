package org.eclipse.xtend.ide.tests.quickfix

import com.google.inject.Inject
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.Issue
import static org.junit.Assert.*
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.core.runtime.NullProgressMonitor

class QuickfixTestBuilder {
	
	@Inject extension WorkbenchTestHelper
	
	@Inject extension IssueResolutionProvider

	@Inject extension IResourceValidator
	
	@Inject extension SyncUtil
	
	int caretOffset
	
	IFile file
	
	XtextEditor editor
	
	List<Issue> issues
	
	def create(String fileName, CharSequence model) {
		val file = createFile(fileName, model.toString.replace("|", ""))
		editor = openEditorSafely(file)
		val document = editor.document
		document.readOnly [
			issues = validate(it, CheckMode::NORMAL_AND_FAST, CancelIndicator::NullImpl)
		]
		caretOffset = model.toString.indexOf("|")
		this
	}
	
	def caretOffset(int offset) {
		caretOffset = offset
		this
	}

	def assertIssueCodes(String... issueCodes) {
		assertEqual(issueCodes, issuesAtCaret.map[code])
		this
	}
	
	def assertResolutionLabels(String... resolutionLabels) {
		val resolutions = issuesAtCaret.map[resolutions].flatten
		assertEqual(resolutionLabels, resolutions.map[label])
		this
	}

	def assertResolutionLabelsSubset(String... expectedLabels) {
		val actualLabels = issuesAtCaret.map[resolutions].flatten.map[label].toSet
		expectedLabels.forEach[
			assertTrue('Label \'' + it + '\' missing. Got ' + actualLabels.join(', '), actualLabels.contains(it))
		]
		this
	}

	def assertModelAfterQuickfix(CharSequence expectedModel) {
		val resolutions = issuesAtCaret.map[resolutions].flatten.toList
		val originalModel = editor.document.get
		resolutions.head.apply()
		assertEquals(expectedModel.toString, editor.document.get())
		editor.document.set(originalModel)
		this
	}
	
	def assertModelAfterQuickfix(String label, CharSequence expectedModel) {
		val resolutions = issuesAtCaret.map[resolutions].flatten.toList
		val originalModel = editor.document.get
		resolutions.findFirst[it.label==label].apply()
		assertEquals(expectedModel.toString, editor.document.get())
		editor.document.set(originalModel)
		this
	}
	
	def protected getIssuesAtCaret() {
		issues.filter[offset <= caretOffset && offset+length >= caretOffset]
	}
	
	def protected assertEqual(List<String> expected, Iterable<String> actual) {
		assertEquals(error(expected, actual), expected.size, actual.size)
		actual.forEach[assertTrue(error(expected, actual), expected.contains(it))]
	}
	
	def protected error(Iterable<String> expected, Iterable<String> actual) {
		'''
			Expected 
				'«expected.join(', ')»'  
			but got 
				'«actual.join(', ')»'
		'''.toString
	}
	
	def protected openEditorSafely(IFile file) throws Exception {
		waitForAutoBuild(new NullProgressMonitor)
		yieldToQueuedDisplayJobs(null)
		var editor = openEditor(file)
		waitForReconciler(editor)
		yieldToQueuedDisplayJobs(null)
		editor
	}
	
	def tearDown() {
		if(editor != null)
			editor.close(false)
		if(file != null)
			file.delete(true, null)
		yieldToQueuedDisplayJobs(null)
	}
}