/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class RuleEngineStandaloneSetup extends RuleEngineStandaloneSetupGenerated {

	public static void doSetup() {
		new RuleEngineStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
