/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.formatting2.IAutowrapFormatter
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion

/**
 * @author meysholdt - Initial contribution and API
 */
@FinalFieldsConstructor class IndentOnceAutowrapFormatter implements IAutowrapFormatter {
	val IHiddenRegion last
	var hasWrapped = false

	override format(IHiddenRegionFormatter wrapped, extension IFormattableDocument document) {
		if (!hasWrapped) {
			wrapped.increaseIndentation
			last.set[decreaseIndentation]
			hasWrapped = true
		}
	}
}
