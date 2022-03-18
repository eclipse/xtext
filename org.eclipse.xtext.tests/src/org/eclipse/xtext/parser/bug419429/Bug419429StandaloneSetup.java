/*******************************************************************************
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.bug419429;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug419429StandaloneSetup extends Bug419429StandaloneSetupGenerated{

	public static void doSetup() {
		new Bug419429StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

