/*******************************************************************************
 * Copyright (c) 2015, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.example.homeautomation.ui.internal.HomeautomationActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class RuleEngineExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(HomeautomationActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		HomeautomationActivator activator = HomeautomationActivator.getInstance();
		return activator != null ? activator.getInjector(HomeautomationActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_HOMEAUTOMATION_RULEENGINE) : null;
	}

}
