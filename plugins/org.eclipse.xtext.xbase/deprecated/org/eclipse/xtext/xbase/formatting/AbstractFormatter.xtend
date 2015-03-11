package org.eclipse.xtext.xbase.formatting

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.formatting2.AbstractFormatter2

/**
 * @deprecated use {@link AbstractFormatter2}
 */
@Deprecated abstract class AbstractFormatter implements IBasicFormatter {

	@Accessors boolean allowIdentityEdits = false
	@Accessors boolean diagnoseConflicts = true
	boolean conflictOccurred = false

	override format(XtextResource res, int offset, int length, FormattingPreferenceValues cfg) {
		val doc = res.parseResult.rootNode.text
		val format = new FormattableDocument(cfg, doc)
		format(res.contents.head, format)
		if (diagnoseConflicts && format.conflictOccurred) {
			val debug = new FormattableDocument(cfg, doc)
			debug.rootTrace = new RuntimeException
			format(res.contents.head, debug)
		}
		conflictOccurred = format.conflictOccurred
		val edits = format.renderToEdits(offset, length)

		if (allowIdentityEdits)
			edits
		else
			edits.filter[doc.substring(it.offset, it.offset + it.length) != text].toList
	}
	
	def isConflictOccurred() {
		conflictOccurred
	}

	def protected dispatch void format(Void expr, FormattableDocument format) {
	}

	def protected dispatch void format(EObject expr, FormattableDocument format) {
	}

}
