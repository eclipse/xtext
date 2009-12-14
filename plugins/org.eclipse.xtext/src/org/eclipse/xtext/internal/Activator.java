/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.internal;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Activator extends Plugin {
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		initializeResourceServiceProviderRegistry(context);
	}

	private void initializeResourceServiceProviderRegistry(BundleContext context) {
		IExtensionRegistry eReg = Platform.getExtensionRegistry();
		String symbolicName = context.getBundle().getSymbolicName();
		new ContentResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
		new ExtensionResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
		new ProtocolResourceServiceProviderRegistryReader(eReg, symbolicName).readRegistry();
	}

}
