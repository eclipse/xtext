/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NewLineOrPreserveKey extends BooleanKey implements Procedure1<IHiddenRegionFormatter> {
	public NewLineOrPreserveKey(String name, Boolean defaultValue) {
		super(name, defaultValue);
	}

	@Override
	public void apply(IHiddenRegionFormatter formatter) {
		ITypedPreferenceValues preferences = formatter.getRequest().getPreferences();
		Boolean newLine = preferences.getPreference(this);
		Boolean preserve = preferences.getPreference(XbaseFormatterPreferenceKeys.preserveNewLines);
		int min = 0;
		if (newLine.booleanValue()) {
			min = 1;
		}
		int max = 0;
		if (preserve.booleanValue() || newLine.booleanValue()) {
			max = 1;
		}
		formatter.setNewLines(min, min, max);
		formatter.setSpace(" ");
	}
}
