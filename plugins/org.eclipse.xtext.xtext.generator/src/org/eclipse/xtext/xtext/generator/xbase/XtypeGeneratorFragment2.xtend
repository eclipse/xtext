/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.xbase

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.LanguageConfig2

class XtypeGeneratorFragment2 extends AbstractGeneratorFragment2 {

	static def boolean inheritsXtype(Grammar grammar) {
		GrammarUtil.inherits(grammar, 'org.eclipse.xtext.xbase.Xtype')
	}
	
	@Inject IXtextProjectConfig projectConfig
	
	override generate(LanguageConfig2 language) {
		if (language.grammar.inheritsXtype && projectConfig.eclipsePluginManifest !== null)
			projectConfig.eclipsePluginManifest.requiredBundles += 'org.eclipse.xtext.xbase.ui'
	}
	
}
