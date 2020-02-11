/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Type;

import org.junit.Assert;

public class TestModule extends AbstractGenericModule {
	public Class<? extends CharSequence> bindString() {
		return String.class;
	}

	public Class<? extends Type> bindType() {
		return Class.class;
	}

	public Class<? extends Assert> bindTestCase() {
		return GenericModuleTest.class;
	}
	
}