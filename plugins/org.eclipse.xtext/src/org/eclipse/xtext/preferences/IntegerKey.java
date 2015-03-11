/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import org.apache.log4j.Logger;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IntegerKey extends TypedPreferenceKey<Integer> {

	private final static Logger log = Logger.getLogger(IntegerKey.class);

	public IntegerKey(String id, Integer defaultValue) {
		super(id, defaultValue.toString());
	}

	@Override
	public String toString(Integer value) {
		return value.toString();
	}

	@Override
	public Integer toValue(String string) {
		try {
			if (string != null)
				return Integer.valueOf(string);
		} catch (NumberFormatException e) {
			log.warn("Couldn't parse value '" + string + "' of formatting preference '" + getId() + "'.");
		}
		return Integer.valueOf(getDefaultValue());
	}

}
