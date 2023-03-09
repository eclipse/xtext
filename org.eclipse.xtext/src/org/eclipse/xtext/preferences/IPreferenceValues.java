/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @see ITypedPreferenceValues
 * @since 2.26
 */
public interface IPreferenceValues {

	/**
	 * @return the currently active value for the given preference or its default value, if no current value was
	 *         explicitly defined.
	 * 
	 * @see PreferenceKey#getDefaultValue()
	 */
	String getPreference(PreferenceKey key);

}
