/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.xbase.testlanguages.ui.internal.TestlanguagesActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ContentAssistFragmentTestLangExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(TestlanguagesActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		TestlanguagesActivator activator = TestlanguagesActivator.getInstance();
		return activator != null ? activator.getInjector(TestlanguagesActivator.ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_CONTENTASSISTFRAGMENTTESTLANG) : null;
	}

}
