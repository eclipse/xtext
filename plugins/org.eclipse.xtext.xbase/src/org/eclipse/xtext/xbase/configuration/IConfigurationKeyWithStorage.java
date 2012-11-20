/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import java.util.Collection;

import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;

/**
 * {@link IConfigurationKey}s which additionally implement this interface can be persisted as key-value-mapping, whereas
 * both keys and values are strings. This is used to persist {@link IConfigurationValues} as Map<String, String> or
 * IPreferenceStore.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConfigurationKeyWithStorage<T> extends IConfigurationKey<T> {

	/**
	 * @return all qualified names that values of this key will store a value for. All returned names are expected to be
	 *         prefixed with {@link #getName()}.
	 */
	Collection<String> getStorageNames();

	/**
	 * @return create a value by gathering all data from the provided function. The function is expected to be called
	 *         for names from {@link #getStorageNames()}. This method should be symmetric to
	 *         {@link #store(Object, IAcceptor)}.
	 */
	T load(Function<String, String> storage);

	/**
	 * Store a value by pushing key-value-pairs into the acceptor. Valid keys are the ones from
	 * {@link #getStorageNames()}. This method should be symmetric to {@link #load(Function)}.
	 */
	void store(T value, IAcceptor<Pair<String, String>> storage);
}