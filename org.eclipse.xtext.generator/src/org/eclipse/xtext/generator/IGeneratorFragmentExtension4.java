/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.Grammar;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.8
 */
@Deprecated
public interface IGeneratorFragmentExtension4 {

	/**
	 * @return the qualified name of the default module the generated runtime one should inherit from, or <code>null</code> if the default one should be used.
	 */
	public String getDefaultRuntimeModuleClassName(Grammar grammar);
	
	/**
	 * @return the qualified name of the default module the generated ui one should inherit from, or <code>null</code> if the default one should be used.
	 */
	public String getDefaultUiModuleClassName(Grammar grammar);
}
