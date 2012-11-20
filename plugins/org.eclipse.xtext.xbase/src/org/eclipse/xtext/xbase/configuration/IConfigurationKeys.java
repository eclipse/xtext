/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import java.util.Collection;

/**
 * Implementers of this interface provide access to a set of {@link IConfigurationKey}s.
 * 
 * To guarantee type safety, implements of this interface should provide access to the {@link IConfigurationKey}s via
 * getters or public fields. This interface purpose is solely to allow enumerating all keys.
 * 
 * @see IConfigurationKey
 * @see IConfigurationValues
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConfigurationKeys {

	/**
	 * @return the key for which {@link IConfigurationKey#getName()} equals keyName.
	 */
	IConfigurationKey<?> getKey(String keyName);

	/**
	 * @return all keys that this type is responsible for.
	 */
	Collection<IConfigurationKey<?>> getKeys();
}
