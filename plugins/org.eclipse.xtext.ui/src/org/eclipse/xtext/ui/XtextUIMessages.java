/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextUIMessages {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private XtextUIMessages() {
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		try {
			return getResourceBundle().getString(key);
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * @return the rESOURCE_BUNDLE
	 */
	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}

	/**
	 * @param key
	 * @param args
	 * @return Formatted message
	 */
	public static String getFormattedString(String key, Object... args) {
		return MessageFormat.format(RESOURCE_BUNDLE.getString(key), args);
	}

}
