/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.Objects;

/**
 * Implementers of this interface represent a configuration key.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sven Efftinge
 * 
 * @since 2.26
 */
public class PreferenceKey {
	
	private final String id;
	private final String defaultValue;
	
	public PreferenceKey(String id, String defaultValue) {
		this.id = Objects.requireNonNull(id);
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the default value. May be null.
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * @return id for this key which is unique among all keys.
	 */
	public String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Preference key '" + id + "' with default value '" + getDefaultValue() + "'.";
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreferenceKey other = (PreferenceKey) obj;
		return id.equals(other.id);
	}
}
