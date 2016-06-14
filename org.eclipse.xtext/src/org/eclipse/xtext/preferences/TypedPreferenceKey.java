/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class TypedPreferenceKey<T> extends PreferenceKey {

	public TypedPreferenceKey(String id, String defaultValue) {
		super(id, defaultValue);
	}

	public abstract String toString(T value);

	public abstract T toValue(String string);

}
