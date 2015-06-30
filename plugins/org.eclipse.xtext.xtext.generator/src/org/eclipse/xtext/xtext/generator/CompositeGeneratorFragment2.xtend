/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List

/**
 * A composite generator fragment delegates to its contained fragments.
 */
class CompositeGeneratorFragment2 implements IGeneratorFragment2 {
	
	@Inject Injector injector
	
	val List<IGeneratorFragment2> fragments = newArrayList
	
	def void addFragment(IGeneratorFragment2 fragment) {
		this.fragments.add(fragment)
	}
	
	override generate() {
		for (fragment : fragments) {
			injector.injectMembers(fragment)
			fragment.generate()
		}
	}
	
}