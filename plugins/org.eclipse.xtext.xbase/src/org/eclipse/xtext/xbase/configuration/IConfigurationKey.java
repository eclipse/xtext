/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

/**
 * Implementers of this interface represent a key in {@link IConfigurationValues}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConfigurationKey<T> {

	/**
	 * @return the default value which should be returned by {@link IConfigurationValues#get(IConfigurationKey)} in case
	 *         no explicit value us set.
	 */
	T getDefaultValue();

	/**
	 * @return name for this key which is unique among all keys from the same {@link IConfigurationKeys}.
	 */
	String getName();
}