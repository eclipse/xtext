package org.eclipse.xtext.xbase.ui.tests.quickfix

import com.google.inject.Inject
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.Test
import org.eclipse.xtext.resource.XtextResourceSet

class Bug390595Test extends AbstractXbaseQuickfixTest {

	@Inject
	IResourceValidator resourceValidator
	@Inject
	DefaultQuickfixProvider quickfixProvider
	@Inject
	TestIssueModificationContext modificationContext
	@Inject
	XtextDocument document

	@Test
	def void testNoExceptionDuringResolutionCreation() {
		val String code = '''{
			val n = newHashSet ( )
			val m = newHashSet ( )
			if ( n < m ) { }
			}
		'''
		val resource = getResourceFor(new StringInputStream(code))
		modificationContext.setDocument(getDocument(resource, code))

		val issue = resourceValidator.validate(resource, CheckMode::ALL, CancelIndicator::NullImpl).head
		quickfixProvider.getResolutionsForLinkingIssue(issue).head
	}

	def getDocument(XtextResource xtextResource, String code) {
		document.setInput(xtextResource)
		document.set(code)
		(xtextResource.resourceSet as XtextResourceSet).markSynced
		document
	}

}
