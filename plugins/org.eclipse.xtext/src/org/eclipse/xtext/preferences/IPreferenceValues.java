/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import com.google.common.base.Strings;



/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IPreferenceValues {

	/**
	 * @return the currently active value for the given preference
	 */
	<T> T getPreference(IPreferenceKey<T> key);
	
	public abstract static class AbstractPreferenceValues implements IPreferenceValues {
		
		public <T> T getPreference(IPreferenceKey<T> key) {
			final String string = internalGet(key.getId());
			if (Strings.isNullOrEmpty(string)) {
				return getDefault(key);
			}
			return key.stringToValue(string);
		}
		
		protected <T> T getDefault(IPreferenceKey<T> key) {
			if (key.getDelegationKey() != null) {
				return getPreference(key.getDelegationKey());
			}
			return key.getDefaultValue();
		}
		
		abstract protected String internalGet(String id);
	}
}
