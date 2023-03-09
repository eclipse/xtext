/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.internal;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Activator implements BundleActivator {
	
	@Override
	public void start(BundleContext context) throws Exception {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			initializeResourceServiceProviderRegistry(context);
		}
	}

	private void initializeResourceServiceProviderRegistry(BundleContext context) {
		IExtensionRegistry eReg = Platform.getExtensionRegistry();
		String symbolicName = context.getBundle().getSymbolicName();
		new ContentResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
		new ExtensionResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
		new ProtocolResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
