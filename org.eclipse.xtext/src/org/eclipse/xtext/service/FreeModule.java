/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;

import com.google.inject.Binder;

public class FreeModule extends MethodBasedModule {

	public FreeModule(Method method, Object owner) {
		super(method, owner);
	}

	@Override
	public void configure(Binder binder) {
		invokeMethod(binder);
	}
	
}