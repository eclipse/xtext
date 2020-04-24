/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.xbase;

import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;

import com.google.inject.Inject;

public class XtypeGeneratorFragment2 extends AbstractXtextGeneratorFragment {
	@Inject
	private XbaseUsageDetector xbaseUsageDetector;

	@Override
	public void generate() {
		if (xbaseUsageDetector.inheritsXtype(getLanguage().getGrammar())
				&& getProjectConfig().getEclipsePlugin().getManifest() != null) {
			getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles().add("org.eclipse.xtext.xbase.ui");
		}
	}
}
