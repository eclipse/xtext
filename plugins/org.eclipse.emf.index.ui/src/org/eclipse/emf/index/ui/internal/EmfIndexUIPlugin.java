/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.internal;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EPackageRegistryIndexFeeder;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexUIPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.emf.index.ui";

	private static EmfIndexUIPlugin plugin;
	
	public EmfIndexUIPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		EPackageRegistryIndexFeeder.feedEPackagesFromRegistry(IIndexStore.eINSTANCE);
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static EmfIndexUIPlugin getDefault() {
		return plugin;
	}

}
