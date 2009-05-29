/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultGeneratorFragment implements IGeneratorFragment {
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {	}
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {	}
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {	}
	public String[] getExportedPackagesRt(Grammar grammar) {		return null;	}
	public String[] getExportedPackagesUi(Grammar grammar) {		return null;	}
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {		return null;	}
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {		return null;	}
	public String[] getRequiredBundlesRt(Grammar grammar) {		return null;	}
	public String[] getRequiredBundlesUi(Grammar grammar) {		return null;	}
	public void checkConfiguration(Issues issues) {	}
	public void generate(Grammar grammar, XpandExecutionContext ctx) {	}
}
