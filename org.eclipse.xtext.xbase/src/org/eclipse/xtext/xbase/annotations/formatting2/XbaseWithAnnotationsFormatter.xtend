/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		ann.regionFor.keyword("@").append[noSpace]
		ann.regionFor.keyword("(").surround[noSpace]
		if (ann.value !== null) {
			ann.value.format
			ann.regionFor.keyword(")").prepend[noSpace]
		} else if (!ann.elementValuePairs.empty) {
			for (pair : ann.elementValuePairs) {
				pair.regionFor.keyword("=").surround[noSpace]
				pair.value.format
				pair.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			ann.regionFor.keyword(")").prepend[noSpace]
		}
	}

}
