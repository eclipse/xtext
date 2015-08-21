/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.normalization

import java.util.Collections
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Parameter
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@EmfAdaptable
class RuleWithParameterValues {
	val AbstractRule original
	val Set<Parameter> paramValues

	@FinalFieldsConstructor
	new() {}
	
	package new(AbstractRule original) {
		this(original, Collections.<Parameter>emptySet())
	}
	
	def static AbstractRule getOriginalRule(AbstractRule copy) {
		return findInEmfObject(copy).getOriginal()
	}

	def static Set<Parameter> getParamValues(AbstractRule copy) {
		return findInEmfObject(copy).getParamValues()
	}

}
