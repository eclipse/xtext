/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.util.Strings;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractEObjectDescription implements IEObjectDescription {
	
	protected AbstractEObjectDescription() {
	}
	
	@Override
	public String toString() {
		return getName().toString();
	}
	
	@Override
	public String getUserData(String name) {
		return null;
	}
	
	@Override
	public String[] getUserDataKeys() {
		return Strings.EMPTY_ARRAY;
	}
	
}
