/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.resource;

import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DescriptionFlags {

	public static final String KEY = "Flags";
	
	public static final int DISPATCHER_OPERATION = 1;
	public static final int IS_STATIC = 2;
	
	public boolean isDispatcherOperation(IEObjectDescription eObjectDescription) {
		int flags = getFlags(eObjectDescription);
		return (flags & DISPATCHER_OPERATION) != 0;
	}

	public boolean isStatic(IEObjectDescription eObjectDescription) {
		int flags = getFlags(eObjectDescription);
		return (flags & IS_STATIC) != 0;
	}

	public int setDispatcherOperation(int flags) {
		return flags | DISPATCHER_OPERATION;
	}
	
	public int setStatic(int flags) {
		return flags | IS_STATIC;
	}
	
	protected int getFlags(IEObjectDescription eObjectDescription) {
		String value = eObjectDescription.getUserData(KEY);
		return value == null ? 0 : Integer.parseInt(value);
	}
	
}
