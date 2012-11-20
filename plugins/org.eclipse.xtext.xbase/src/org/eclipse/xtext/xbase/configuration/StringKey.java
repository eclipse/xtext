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
public class StringKey extends SingleValueConfigurationKey<String> {

	public StringKey(String name, String defaultValue) {
		super(name, defaultValue);
	}

	@Override
	protected String load(String storedValue) {
		return storedValue;
	}

	@Override
	protected String store(String value) {
		return value;
	}

}
