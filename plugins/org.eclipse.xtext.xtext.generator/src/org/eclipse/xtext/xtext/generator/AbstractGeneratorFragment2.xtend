/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.xtext.generator.IGeneratorFragment2
import com.google.inject.Injector
import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractGeneratorFragment2 implements IGeneratorFragment2 {
	
	@Accessors(PROTECTED_GETTER) @Inject LanguageConfig2 language
	@Accessors(PROTECTED_GETTER) @Inject Grammar grammar
	
	override checkConfiguration(Issues issues) {
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
	}
	
}