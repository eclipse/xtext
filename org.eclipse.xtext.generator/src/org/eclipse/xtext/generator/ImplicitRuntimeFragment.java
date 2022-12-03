/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtext.generator;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

@Deprecated(forRemoval = true)
public class ImplicitRuntimeFragment extends DefaultGeneratorFragment {

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{"org.eclipse.xtext", "org.eclipse.xtext.util"};
	}

	@Override
	public String[] getImportedPackagesRt(Grammar grammar) {
		return new String[] {"org.apache.log4j"};
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		super.addToPluginXmlRt(grammar, ctx);
	}
}
