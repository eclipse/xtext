package org.eclipse.xtext.xbase.formatting

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.configuration.IConfigurationValues

abstract class AbstractFormatter implements IFormatter {

	@Property boolean allowIdentityEdits = false
	@Property boolean diagnoseConflicts = true

	override format(XtextResource res, int offset, int length, IConfigurationValues cfg) {
		val doc = res.parseResult.rootNode.text
		val format = new FormattableDocument(cfg, doc)
		format(res.contents.head, format)
		if (diagnoseConflicts && format.conflictOccurred) {
			val debug = new FormattableDocument(cfg, doc)
			debug.rootTrace = new RuntimeException
			format(res.contents.head, debug)
		}
		val edits = format.renderToEdits(offset, length)

		if (allowIdentityEdits)
			edits
		else
			edits.filter[doc.substring(it.offset, it.offset + it.length) != text].toList
	}

	def protected dispatch void format(Void expr, FormattableDocument format) {
	}

	def protected dispatch void format(EObject expr, FormattableDocument format) {
	}

}
