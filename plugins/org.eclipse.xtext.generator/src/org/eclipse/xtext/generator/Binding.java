/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class Binding {
	
	private BindKey key;
	private BindValue val;
	
	public Binding(BindKey key, BindValue val) {
		super();
		this.key = key;
		this.val = val;
	}
	
	public BindKey getKey() {
		return key;
	}
	
	public BindValue getValue() {
		return val;
	}
}
