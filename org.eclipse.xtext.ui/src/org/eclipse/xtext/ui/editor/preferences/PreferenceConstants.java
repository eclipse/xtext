/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;


/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class PreferenceConstants {

	public static final char SEPARATOR = '.';
	public static final String EDITOR_NODE_NAME = "editor";
	
	/**
	 * copied from org.eclipse.jdt.ui.PreferenceConstants
	 * 
	 * A named preference that controls whether the 'sub-word navigation' feature is
	 * enabled.
	 * <p>
	 * Value is of type <code>Boolean</code>.
	 * </p>
	 * @since 2.4
	 */
	public final static String EDITOR_SUB_WORD_NAVIGATION= "subWordNavigation"; //$NON-NLS-1$
}
