/*******************************************************************************
 * Copyright (c) 2011, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.purexbase.ui.internal.PurexbaseActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class PureXbaseExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(PurexbaseActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		PurexbaseActivator activator = PurexbaseActivator.getInstance();
		return activator != null ? activator.getInjector(PurexbaseActivator.ORG_ECLIPSE_XTEXT_PUREXBASE_PUREXBASE) : null;
	}

}
