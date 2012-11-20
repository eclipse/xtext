/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

/**
 * ConfigurationsValues represent a type-safe key-value mapping.
 * 
 * As the name suggests, this is intended to be used to store configuration values. The keys, which have to implement
 * {@link IConfigurationKey}, define the value's type via IConfigurationKey's type parameter.
 * 
 * ConfigurationValues can be persisted in IPreferenceStores, Maps or Properties. A single value inside
 * ConfigurationValues can be represented as multiple values inside a Map or PreferencesStore.
 * 
 * @see IConfigurationKey
 * @see IConfigurationKeys
 * 
 * @see MapBasedConfigurationValues
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConfigurationValues {

	/**
	 * @return returns the values represented by this key.
	 */
	<T> T get(IConfigurationKey<T> key);

	/**
	 * @return the {@link IConfigurationKeys} for which this instance can hold values.
	 */
	IConfigurationKeys getKeys();
}
