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
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BlankLineKey extends IntegerKey implements Procedure1<IHiddenRegionFormatter> {
	public BlankLineKey(String name, Integer defaultValue) {
		super(name, defaultValue);
	}

	@Override
	public void apply(IHiddenRegionFormatter formatter) {
		ITypedPreferenceValues preferences = formatter.getRequest().getPreferences();
		Integer blankline = preferences.getPreference(this);
		Integer preserve = preferences.getPreference(XbaseFormatterPreferenceKeys.preserveBlankLines);
		int min = blankline.intValue() + 1;
		int max = Math.max(preserve.intValue() + 1, min);
		formatter.setNewLines(min, min, max);
	}
}
