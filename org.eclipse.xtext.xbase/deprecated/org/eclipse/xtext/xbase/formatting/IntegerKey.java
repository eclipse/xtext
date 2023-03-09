/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.preferences.PreferenceKey;

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.IntegerKey}
 */
@Deprecated
public class IntegerKey extends PreferenceKey {
	public IntegerKey(String name, Integer defaultValue) {
		super(name, defaultValue.toString());
	}
}
