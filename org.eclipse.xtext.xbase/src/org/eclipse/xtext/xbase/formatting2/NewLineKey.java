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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NewLineKey extends BooleanKey implements Procedure1<IHiddenRegionFormatter> {
	public NewLineKey(String name, Boolean defaultValue) {
		super(name, defaultValue);
	}

	@Override
	public void apply(IHiddenRegionFormatter formatter) {
		Boolean newLine = formatter.getRequest().getPreferences().getPreference(this);
		if (newLine.booleanValue()) {
			formatter.setNewLines(1);
		} else {
			formatter.oneSpace();
		}
	}
}
