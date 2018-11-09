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
 */
@SuppressWarnings("deprecation")
public class DefaultGeneratorFragment implements IGeneratorFragment,IGeneratorFragmentExtension, IGeneratorFragmentExtension2, IGeneratorFragmentExtension3 {
	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public void addToPluginXmlRt(LanguageConfig config, XpandExecutionContext ctx) {
		addToPluginXmlRt(config.getGrammar(), ctx);
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public void addToPluginXmlUi(LanguageConfig config, XpandExecutionContext ctx) {
		addToPluginXmlUi(config.getGrammar(), ctx);
	}

	
	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public void addToStandaloneSetup(LanguageConfig config, XpandExecutionContext ctx) {
		addToStandaloneSetup(config.getGrammar(), ctx);
	}
	
	/**
	 * @since 2.6
	 * @deprecated
	 */
	@Override
	@Deprecated
	public void addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx) {}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public String[] getExportedPackagesIde(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return null;
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return null;
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getImportedPackagesRt(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public String[] getImportedPackagesIde(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getImportedPackagesUi(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.8
	 */
	@Override
	public String[] getRequiredBundlesIde(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public String[] getExportedPackagesTests(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public String[] getImportedPackagesTests(Grammar grammar) {
		return null;
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public String[] getRequiredBundlesTests(Grammar grammar) {
		return null;
	}

	@Override
	public void checkConfiguration(Issues issues) {
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	/**
	 * @since 2.6
	 */
	@Override
	public void generate(LanguageConfig config, XpandExecutionContext ctx) {
		generate(config.getGrammar(), ctx);
	}
}
