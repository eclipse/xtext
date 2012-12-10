/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
public interface IPreferenceKey<ValueType> {

	/**
	 * @return the default value.
	 */
	ValueType getDefaultValue();
	
	/**
	 * @return the string representation of a given value
	 */
	String valueToString(ValueType value);
	
	/**
	 * @return the value for a given string
	 * @throws IllegalArgumentException if the given string cannot be converted to a value.
	 */
	ValueType stringToValue(String value);

	/**
	 * @return name for this key which is unique among all keys.
	 */
	String getId();
	
	/**
	 * @return the key to use for determining the default value.
	 */
	IPreferenceKey<ValueType> getDelegationKey();
	
	public static abstract class AbstractKey<T> implements IPreferenceKey<T> {
		
		private final String name;
		private IPreferenceKey<T> delegatonKey;
		
		public AbstractKey(String name) {
			this(name, null);
		}
		
		public AbstractKey(String name, IPreferenceKey<T> delegationKey) {
			this.name = name;
			this.delegatonKey = delegationKey;
		}
		
		public String getId() {
			return this.name;
		}
		
		@Override
		public String toString() {
			return "Configration key '"+name+"'.";
		}
		
		public IPreferenceKey<T> getDelegationKey() {
			return delegatonKey;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			AbstractKey<?> other = (AbstractKey<?>) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
	}
}