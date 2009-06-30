/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.internal;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ui.EmfIndexUIModule;
import org.eclipse.emf.index.ui.builder.IndexStartupInitializer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexUIPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.emf.index.ui";

	private static EmfIndexUIPlugin plugin;

	private volatile Injector injector;

	private IndexStore indexStore;
	
	public IndexStore getIndexStore() {
		return indexStore;
	}

	public EmfIndexUIPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		// TODO: make the module configurable
		injector = Guice.createInjector(new EmfIndexUIModule());
		indexStore = injector.getInstance(IndexStore.class); 
		plugin = this;
		IndexStartupInitializer.buildAll();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static EmfIndexUIPlugin getDefault() {
		return plugin;
	}

	public static void logError(String message, Throwable t) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, t));
	}

	public static File getIndexFile() {
		return new File(getDefault().getStateLocation().toFile(), "emf_index.bin");
	}

	public Injector getInjector() {
		return injector;
	}
}
