/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.xbase

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2

class XtypeGeneratorFragment2 extends AbstractGeneratorFragment2 {

	@Inject extension XbaseUsageDetector
	
	override generate() {
		if (language.grammar.inheritsXtype && projectConfig.eclipsePluginManifest !== null)
			projectConfig.eclipsePluginManifest.requiredBundles += 'org.eclipse.xtext.xbase.ui'
	}
	
}
