/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import java.util.List
import org.eclipse.emf.mwe.core.issues.Issues

/**
 * A composite generator fragment delegates to its contained fragments.
 */
class CompositeGeneratorFragment2 implements IGeneratorFragment2 {
	
	val List<IGeneratorFragment2> fragments = newArrayList
	
	def void addFragment(IGeneratorFragment2 fragment) {
		if (fragment === this)
			throw new IllegalArgumentException
		this.fragments.add(fragment)
	}
	
	override checkConfiguration(XtextGenerator generator, Issues issues) {
		for (fragment : fragments) {
			fragment.checkConfiguration(generator, issues)
		}
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		for (fragment : fragments) {
			fragment.initialize(injector)
		}
	}
	
	override generate(LanguageConfig2 language) {
		for (fragment : fragments) {
			fragment.generate(language)
		}
	}
	
}