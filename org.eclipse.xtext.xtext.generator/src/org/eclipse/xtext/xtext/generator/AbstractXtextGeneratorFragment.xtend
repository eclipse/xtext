/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig

/**
 * Convenience class for implementing generator fragments. Provides access to the
 * {@link IXtextProjectConfig project configuration} and the {@link IXtextGeneratorLanguage language configuration}.
 */
abstract class AbstractXtextGeneratorFragment implements IXtextGeneratorFragment {
	
	@Accessors(PROTECTED_GETTER)
	@Inject IXtextProjectConfig projectConfig
	
	@Accessors(PROTECTED_GETTER)
	@Inject IXtextGeneratorLanguage language
	
	@Accessors(PROTECTED_GETTER)
	@Inject Grammar grammar
	
	override checkConfiguration(Issues issues) {
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
	}
	
}
