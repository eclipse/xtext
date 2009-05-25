/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.eclipse.emf.index";
	
	private static EmfIndexPlugin plugin;
	
	public static EmfIndexPlugin getDefault() {
		return plugin;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static void logError(String message, Throwable t) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, t));
	}

	public static void logError(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message));
	}

}
