/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CodetemplatesStandaloneSetup extends CodetemplatesStandaloneSetupGenerated{

	public static void doSetup() {
		new CodetemplatesStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

