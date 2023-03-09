/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.util;

/**
 * An object-valued option with default value for use in generator fragments.
 */
public class GeneratorOption <T> {
	
	private final T defaultValue;
	
	private T value;
	
	/**
	 * Create an option with no default value.
	 */
	public GeneratorOption() {
		this.defaultValue = null;
	}
	
	/**
	 * Create an option with a default value.
	 */
	public GeneratorOption(T defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public T get() {
		if (value != null) {
			return value;
		} else {
			return defaultValue;
		}
	}
	
	public void set(T value) {
		this.value = value;
	}
	
	public boolean isSet() {
		return value != null;
	}
	
}