/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class Activator extends org.eclipse.xtext.xtext.ui.internal.Activator {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.xtext.ui";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);
		// make sure classpath entries are being resolved
		initJavaCore(context);
	}

	protected void initJavaCore(BundleContext context) throws Exception {
		String javaCorePlugin = JavaCore.PLUGIN_ID;
		for (Bundle bundle : context.getBundles()) {
			if (javaCorePlugin.equals(bundle.getSymbolicName())) {
				JavaCore.initializeAfterLoad(new NullProgressMonitor());
				return;
			}
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
