/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * Implementers of this interface represent a configuration key.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sven Efftinge
 */
public class PreferenceKey {

	/**
	 * @return the default value.
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

	private final String id;
	private final String defaultValue;

	public PreferenceKey(String id, String defaultValue) {
		this.id = id;
		this.defaultValue = defaultValue;
	}

	@Override
	public String toString() {
		return "Configuration key '" + id + "' default value '" + getDefaultValue() + "'.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
