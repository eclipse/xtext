/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractConfigurationKey<T> implements IConfigurationKey<T> {

	private final T defaultValue;
	private final String name;

	public AbstractConfigurationKey(String name, T defaultValue) {
		super();
		this.name = name;
		this.defaultValue = defaultValue;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		return obj != null && obj.getClass() == getClass() && ((AbstractConfigurationKey) obj).name.equals(name);
	}

	public T getDefaultValue() {
		return defaultValue;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
