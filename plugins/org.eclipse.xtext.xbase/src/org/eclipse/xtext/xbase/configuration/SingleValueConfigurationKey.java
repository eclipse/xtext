/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class SingleValueConfigurationKey<T> extends AbstractConfigurationKey<T> implements
		IConfigurationKeyWithStorage<T> {

	public SingleValueConfigurationKey(String name, T defaultValue) {
		super(name, defaultValue);
	}

	public Collection<String> getStorageNames() {
		return Collections.singleton(getName());
	}

	public T load(Function<String, String> storage) {
		return load(storage.apply(getName()));
	}

	protected abstract T load(String storedValue);

	protected abstract String store(T value);

	public void store(T value, IAcceptor<Pair<String, String>> storage) {
		storage.accept(Tuples.create(getName(), store(value)));
	}

}
