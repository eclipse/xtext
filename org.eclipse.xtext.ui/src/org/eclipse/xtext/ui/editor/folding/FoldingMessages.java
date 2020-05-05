/*******************************************************************************
 * Copyright (c) 2010, 2020 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class that gives access to the folding messages resource bundle.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class FoldingMessages {

	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.editor.folding.FoldingMessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private FoldingMessages() {
		// no instance
	}

	/**
	 * Returns the resource string associated with the given key in the resource bundle. If there isn't any value under
	 * the given key, the key is returned.
	 * 
	 * @param key
	 *            the resource key
	 * @return the string
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Returns the resource bundle managed by the receiver.
	 * 
	 * @return the resource bundle
	 */
	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}

	/**
	 * Returns the formatted resource string associated with the given key in the resource bundle.
	 * <code>MessageFormat</code> is used to format the message. If there isn't any value under the given key, the key
	 * is returned.
	 * 
	 * @param key
	 *            the resource key
	 * @param arg
	 *            the message argument
	 * @return the string
	 */
	public static String getFormattedString(String key, Object arg) {
		return MessageFormat.format(key, new Object[] { arg });
	}
}
