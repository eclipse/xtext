/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Type;

import junit.framework.TestCase;

public class TestModule extends AbstractGenericModule {
	public Class<? extends CharSequence> bindString() {
		return String.class;
	}

	public Class<? extends Type> bindType() {
		return Class.class;
	}

	public Class<? extends TestCase> bindTestCase() {
		return GenericModuleTest.class;
	}
}