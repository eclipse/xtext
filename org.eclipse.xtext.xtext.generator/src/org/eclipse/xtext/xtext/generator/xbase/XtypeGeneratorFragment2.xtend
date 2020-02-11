/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.xbase

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

class XtypeGeneratorFragment2 extends AbstractXtextGeneratorFragment {

	@Inject extension XbaseUsageDetector
	
	override generate() {
		if (language.grammar.inheritsXtype && projectConfig.eclipsePlugin.manifest !== null)
			projectConfig.eclipsePlugin.manifest.requiredBundles += 'org.eclipse.xtext.xbase.ui'
	}
	
}
