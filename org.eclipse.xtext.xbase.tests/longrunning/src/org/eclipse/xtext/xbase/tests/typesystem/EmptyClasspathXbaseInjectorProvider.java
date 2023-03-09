/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;

import com.google.inject.Injector;

public class EmptyClasspathXbaseInjectorProvider extends XbaseInjectorProvider {
	@Override
	public Injector internalCreateInjector() {
		return new EmptyClasspathXbaseTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
