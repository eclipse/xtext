/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class ActionTestLanguage3StandaloneSetup extends ActionTestLanguage3StandaloneSetupGenerated {

	public static void doSetup() {
		new ActionTestLanguage3StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
