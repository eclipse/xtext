/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * An <code>IHighlightingConfigurationAcceptor</code> is used to collect default settings for the various highlighting
 * configurations.
 * 
 * This interface is implemented by components of the framework that need to collect all default configurations.
 * It is not intended to be implemented by clients, although it is easily possible.
 * 
 * @see IHighlightingConfiguration#configure(IHighlightingConfigurationAcceptor)
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IHighlightingConfigurationAcceptor {

	/**
	 * Call this method to announce a specific default style.
	 * Implementors may throw an <code>IllegalStateException</code> when an id is used twice.
	 * 
	 * @param id the unique id that should be associated with the given style.
	 * @param name the human readable name of the style.
	 * @param style the default style with the given id and name.
	 * @throws IllegalStateException when an id has been used twice.
	 * @see IHighlightingConfiguration#configure(IHighlightingConfigurationAcceptor)
	 */
	void acceptDefaultHighlighting(String id, String name, TextStyle style);
	
}
