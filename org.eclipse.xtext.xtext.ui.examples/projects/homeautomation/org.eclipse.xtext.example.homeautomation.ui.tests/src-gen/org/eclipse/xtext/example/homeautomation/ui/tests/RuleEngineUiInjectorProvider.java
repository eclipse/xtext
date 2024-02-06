/*******************************************************************************
 * Copyright (c) 2015, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.example.homeautomation.ui.internal.HomeautomationActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class RuleEngineUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return HomeautomationActivator.getInstance().getInjector("org.eclipse.xtext.example.homeautomation.RuleEngine");
	}

}
