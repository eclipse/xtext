package org.eclipse.xtext.xbase.annotations.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

class XbaseWithAnnotationsFormatter extends XbaseFormatter {

	def dispatch void format(XAnnotation ann, extension IFormattableDocument document) {
		ann.regionForKeyword("@").append[noSpace]
		ann.regionForKeyword("(").surround[noSpace]
		if (ann.value != null) {
			ann.value.format(document)
			ann.regionForKeyword(")").prepend[noSpace]
		} else if (!ann.elementValuePairs.empty) {
			for (pair : ann.elementValuePairs) {
				pair.regionForKeyword("=").surround[noSpace]
				pair.value.format(document)
				pair.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			ann.regionForKeyword(")").prepend[noSpace]
		}
	}

}
