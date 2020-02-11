/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@Deprecated
public interface IGeneratorFragmentExtension {

	/**
	 * Used to add code to the plugin.xml of the tests bundle. The surrounding <plugin> tags are added automatically
	 *
	 * @param grammar
	 * @param ctx - the execution context to use (the plugin.xml file is already opened)
	 * @deprecated We do not generate plugin.xml files for test bundles
	 */
	@Deprecated
	void addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx);

	/**
	 * return the bundles this fragment requires in tests
	 *
	 * @param grammar
	 */
	String[] getRequiredBundlesTests(Grammar grammar);

	/**
	 *  return the exported packages for the tests bundle
	 *
	 * @param grammar
	 */
	String[] getExportedPackagesTests(Grammar grammar);

	/**
	 * return the imported packages for the tests bundle
	 *
	 * @param grammar
	 */
	String[] getImportedPackagesTests(Grammar grammar);
}
