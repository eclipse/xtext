/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Generator fragment that wraps another fragment and can be toggled via a property
 * 
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.13
 */
class ConditionalXtextGeneratorFragment implements IXtextGeneratorFragment {
	
	@Accessors
	IXtextGeneratorFragment fragment
	
	@Accessors
	boolean enabled = true
	
	override checkConfiguration(Issues issues) {
		if (fragment === null)
			issues.addError('The property \'fragment\' must be set.', this)
		else
			fragment.checkConfiguration(issues)
	}
	
	override generate() {
		if (enabled) {
			fragment.generate()
		}
	}
	
	override initialize(Injector injector) {
		fragment.initialize(injector)
	}
	
}