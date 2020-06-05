/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.NewLineKey}
 */
@Deprecated
public class NewLineKey extends BooleanKey {
	public NewLineKey(String name, Boolean defaultValue) {
		super(name, (defaultValue).booleanValue());
	}
}
