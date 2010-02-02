/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

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
		try {
			initializeGuiceInjector();
		} catch(Exception e) {
			log.error("Exception when initializing " + getClass().getName(), e);
			throw e;
		}
	}
	
	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (log.isDebugEnabled())
			log.debug("Stopping Xtext UI bundle.");

		setDefault(null);
		dirtyStateManager = null;
		stateChangeEventBroker = null;
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
	
	private IStateChangeEventBroker stateChangeEventBroker;
	
	private IDirtyStateManager dirtyStateManager;
	
	private IAllContainersState javaProjectsState;
	
	private IAllContainersState workspaceProjectsState;
	
	private void initializeGuiceInjector() {
		try {
			injector = Guice.createInjector(createGuiceModule());
			stateChangeEventBroker = injector.getInstance(IStateChangeEventBroker.class);
			dirtyStateManager = injector.getInstance(IDirtyStateManager.class);
		} catch (Exception e) {
			log.error("Couldn't initialize XtextBuilder", e);
		}
	}

	protected Module createGuiceModule() {
		return new Module();
	}

	public Injector getInjector() {
		return injector;
	}

	public IStateChangeEventBroker getStateChangeEventBroker() {
		return stateChangeEventBroker;
	}
	
	public IDirtyStateManager getDirtyStateManager() {
		return dirtyStateManager;
	}

	public IAllContainersState getJavaProjectsState() {
		if (javaProjectsState == null)
			javaProjectsState = injector.getInstance(JavaProjectsState.class);
		return javaProjectsState;
	}
	
	public IAllContainersState getWorkspaceProjectsState() {
		if (workspaceProjectsState == null)
			workspaceProjectsState = injector.getInstance(WorkspaceProjectsState.class);
		return workspaceProjectsState;
	}
	
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
