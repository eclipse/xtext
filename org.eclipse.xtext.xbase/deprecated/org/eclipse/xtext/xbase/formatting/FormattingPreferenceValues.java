/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.apache.log4j.Logger;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.TypedPreferenceValues;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @deprecated use {@link TypedPreferenceValues}
 */
@Deprecated
public class FormattingPreferenceValues {
	
	private final static Logger log = Logger.getLogger(FormattingPreferenceValues.class);

	private IPreferenceValues values;

	public FormattingPreferenceValues(IPreferenceValues values) {
		super();
		this.values = values;
	}
	
	public int get(IntegerKey key) {
		final String preference = values.getPreference(key);
		try {
			if (preference != null)
				return Integer.valueOf(preference);
		} catch (NumberFormatException e) {
			log.warn("Couldn't parse value '"+preference+"' of formatting preference '"+key.getId()+"'.");
		}
		return Integer.valueOf(key.getDefaultValue());
	}
	
	public boolean get(BooleanKey key) {
		final String preference = values.getPreference(key);
		if (preference != null)
			return Boolean.valueOf(preference);
		return Boolean.valueOf(key.getDefaultValue());
	}
	
	public String get(StringKey key) {
		final String preference = values.getPreference(key);
		if (preference != null)
			return preference;
		return key.getDefaultValue();
	}
	
}
