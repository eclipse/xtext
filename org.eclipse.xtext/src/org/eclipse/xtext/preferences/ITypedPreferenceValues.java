/*******************************************************************************
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * A strongly typed API to access preferences.
 * 
 * @see TypedPreferenceKey
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.26
 */
public interface ITypedPreferenceValues extends IPreferenceValues {

	/**
	 * @return the currently active value for the given preference or its default value, if no current value was
	 *         explicitly defined.
	 *         
	 * @see TypedPreferenceKey#getDefaultValue()
	 */
	<T> T getPreference(TypedPreferenceKey<T> key);

}
