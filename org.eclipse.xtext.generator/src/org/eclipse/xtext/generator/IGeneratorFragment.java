/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtext.generator;

import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * primary hook, allowing configuration and contribution to {@link Generator}
 *
 */
@Deprecated
public interface IGeneratorFragment {
    /**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
     *
	 * @param issues
     *            implementors should report configuration issues to this.
     */
    public void checkConfiguration(Issues issues);

	/**
	 * can be used to generate whatever necessary
	 *
	 * @param grammar
	 * @param ctx - the execution context to use
	 */
	void generate(Grammar grammar, XpandExecutionContext ctx);

	/**
	 * Used to add code to the generated 'public void register(Injector injector)'-method
	 *
	 * @param grammar
	 * @param ctx - the execution context to use (the file is already opened, content goes into the register method)
	 */
	void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx);

	/**
	 * Used to add code to the plugin.xml of the runtime bundle. The surrounding <plugin> tags are added automatically
	 *
	 * @param grammar
	 * @param ctx - the execution context to use (the plugin.xml file is already opened)
	 */
	void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx);

	/**
	 * Used to add code to the plugin.xml of the ui bundle. The surrounding <plugin> tags are added automatically
	 *
	 * @param grammar
	 * @param ctx - the execution context to use (the plugin.xml file is already opened)
	 */
	void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx);

	/**
	 * return a map containing the contributed guice bindings created in this generator fragment
	 *
	 * @param grammar
	 */
	Set<Binding> getGuiceBindingsRt(Grammar grammar);

	/**
	 * return a map containing the contributed guice bindings for the ui part created in this generator fragment
	 *
	 * @param grammar
	 */
	Set<Binding> getGuiceBindingsUi(Grammar grammar);

	/**
	 * return the bundles this fragment requires at runtime
	 *
	 * @param grammar
	 */
	String[] getRequiredBundlesRt(Grammar grammar);

	/**
	 * return the exported packages for the runtime bundle
	 *
	 * @param grammar
	 */
	String[] getExportedPackagesRt(Grammar grammar);

	/**
	 * return the imported packages for the runtime bundle
	 *
	 * @param grammar
	 */
	String[] getImportedPackagesRt(Grammar grammar);

	/**
	 * return the bundles this fragment requires in ui
	 *
	 * @param grammar
	 */
	String[] getRequiredBundlesUi(Grammar grammar);

	/**
	 *  return the exported packages for the ui bundle
	 *
	 * @param grammar
	 */
	String[] getExportedPackagesUi(Grammar grammar);

	/**
	 * return the imported packages for the ui bundle
	 *
	 * @param grammar
	 */
	String[] getImportedPackagesUi(Grammar grammar);
}
