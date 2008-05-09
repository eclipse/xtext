/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.tests;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class Invocation {
	
	public final String method;
	public final String feature;
	public final Object param;
	Invocation(String method, String feature, Object param) {
		super();
		this.feature = feature;
		this.method = method;
		this.param = param;
	}
	
	@Override
	public String toString() {
		return method+"("+feature+(param!=null?","+param:"")+")";
	}
	
}	
