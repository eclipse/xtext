/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractConfigurationValues<K extends IConfigurationKeys> implements IConfigurationValues<K> {

	private final K keys;

	public AbstractConfigurationValues(K keys) {
		super();
		this.keys = keys;
	}

	public K getKeys() {
		return keys;
	}

}
