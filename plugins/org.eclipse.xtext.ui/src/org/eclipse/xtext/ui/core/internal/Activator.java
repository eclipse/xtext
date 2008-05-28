/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.core.editor.utils.CustomResourceLibrary;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.ui";

	// The shared instance
	private static Activator plugin;

	private CustomResourceLibrary resourceLibrary;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		if (resourceLibrary != null) {
			resourceLibrary.dispose();
			resourceLibrary = null;
		}
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

	public CustomResourceLibrary getResourceLibrary() {
		if (resourceLibrary == null) {
			Display displ = null;
			if (Display.getCurrent() != null) {
				displ = Display.getCurrent();
			}
			if (PlatformUI.isWorkbenchRunning()) {
				displ = PlatformUI.getWorkbench().getDisplay();
			}
			resourceLibrary = new CustomResourceLibrary(displ);
		}
		return resourceLibrary;
	}

}
