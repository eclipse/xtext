/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractEObjectDescription implements IEObjectDescription {
	
	private boolean ignoreCase;

	public AbstractEObjectDescription(boolean isIgnoreCase) {
		this.ignoreCase =isIgnoreCase;
	}
	
	@Override
	public String toString() {
		return getName().toString();
	}
	
	public String getUserData(String name) {
		return null;
	}
	
	public String[] getUserDataKeys() {
		return new String[0];
	}
	
	public Object getKey() {
		return ignoreCase? getIgnoreCaseName() :getName();
	}

	protected QualifiedName getIgnoreCaseName() {
		return getName().toLowerCase();
	}
}
