/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
