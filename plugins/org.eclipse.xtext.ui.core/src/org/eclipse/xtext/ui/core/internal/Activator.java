/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.core.guice.IGuiceAwareActivator;
import org.eclipse.xtext.ui.core.index.IndexAccess;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IGuiceAwareActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.ui";

	private static Logger log = Logger.getLogger(Activator.class);

	// TODO extract DEBUG handling to separate class!
	public static final boolean DEBUGING = Platform.inDebugMode();
	public static final boolean DEBUG_FOLDING = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/folding"));
	public static final boolean DEBUG_PROPOSALS_PROVIDER = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/proposalProvider"));
	public static final boolean DEBUG_PARSING = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/parser"));
	public static final boolean DEBUG_FORMATTER = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/formatter"));
	public static final boolean DEBUG_MARKERCREATOR = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/marker_creator"));
	public static final boolean DEBUG_SYNTAX_COLORING = DEBUGING
			&& "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.xtext.ui/debug/services/syntaxColoring"));

	// The shared instance
	private static Activator plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);

		if (log.isDebugEnabled())
			log.debug("Starting Xtext UI Core bundle.");
		// make sure classpath entries are being resolved
		JavaCore.initializeAfterLoad(new NullProgressMonitor());

		initializeGuiceInjector();
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (log.isDebugEnabled())
			log.debug("Stopping Xtext UI bundle.");

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

	/**
	 * Returns the active workbench page or <code>null</code> if none.
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getActivePage();
		}
		return null;
	}

	/**
	 * Returns the active workbench window or <code>null</code> if none
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}

	private Injector injector;

	private void initializeGuiceInjector() {
		try {
			injector = Guice.createInjector(new Module());
			IndexAccess.setIndex(injector.getInstance(UpdateableIndex.class));
		}
		catch (Exception e) {
			log.error("Couldn't initialize XtextBuilder", e);
		}
	}
	
	public Injector getInjector(String injectorName) {
		return injector;
	}
	
}
