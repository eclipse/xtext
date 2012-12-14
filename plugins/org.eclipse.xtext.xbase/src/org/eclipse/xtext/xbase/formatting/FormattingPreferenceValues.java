/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.IPreferenceValues;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FormattingPreferenceValues {

	private IPreferenceValues values;

	public FormattingPreferenceValues(IPreferenceValues values) {
		super();
		this.values = values;
	}
	
	public int get(IntegerKey key) {
		return Integer.valueOf(values.getPreference(key));
	}
	
	public boolean get(BooleanKey key) {
		return Boolean.valueOf(values.getPreference(key));
	}
	
	public String get(StringKey key) {
		return values.getPreference(key);
	}
	
}
