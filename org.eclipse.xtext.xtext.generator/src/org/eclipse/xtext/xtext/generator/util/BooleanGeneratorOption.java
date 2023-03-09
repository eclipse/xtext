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
 * A Boolean-valued option with default value for use in generator fragments.
 */
public class BooleanGeneratorOption {
	
	private final boolean defaultValue;
	
	private Boolean value;
	
	public BooleanGeneratorOption() {
		this(false);
	}
	
	public BooleanGeneratorOption(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public boolean get() {
		if (value != null) {
			return value;
		} else {
			return defaultValue;
		}
	}
	
	public void set(boolean value) {
		this.value = value;
	}
	
	public boolean isSet() {
		return value != null;
	}
	
}