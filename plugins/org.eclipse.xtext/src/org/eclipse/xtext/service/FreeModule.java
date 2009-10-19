/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;

import com.google.inject.Binder;

public class FreeModule extends MethodBasedModule {

	public FreeModule(Method method, Object owner) {
		super(method, owner);
	}

	public void configure(Binder binder) {
		invokeMethod(binder);
	}
	
}