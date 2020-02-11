/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.Grammar;


/**
 * @since 2.8
 */
@Deprecated
public interface IGeneratorFragmentExtension3 {
	
	/**
	 * return the bundles this fragment requires for ide services
	 *
	 * @param grammar
	 */
	String[] getRequiredBundlesIde(Grammar grammar);

	/**
	 * return the exported packages for the ide bundle
	 *
	 * @param grammar
	 */
	String[] getExportedPackagesIde(Grammar grammar);

	/**
	 * return the imported packages for the ide bundle
	 *
	 * @param grammar
	 */
	String[] getImportedPackagesIde(Grammar grammar);
}
