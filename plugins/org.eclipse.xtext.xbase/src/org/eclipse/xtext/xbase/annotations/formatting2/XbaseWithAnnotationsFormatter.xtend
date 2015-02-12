/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
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
