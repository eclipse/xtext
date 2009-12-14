/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

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
