/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslActivator extends org.eclipse.xtext.example.internal.EcoreDslActivator {

	Logger logger = Logger.getLogger(EcoreDslActivator.class);

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.ecoredsl.ui";
	
	private static final String RESOURCE_NAME = PLUGIN_ID + ".messages";


	/** Key to store our templates. */
	private static final String TEMPLATES_KEY = PLUGIN_ID + ".templates";

	public static final String PREFIX = EcoreDslActivator.PLUGIN_ID + ".templates.contextType.";

	public static final String EPACKAGE = PREFIX + "EPackageDecl";
	public static final String ECLASS = PREFIX + "EClassDecl";
	public static final String EDATATYPEDECL = PREFIX + "EDataTypeDecl";
	public static final String EENUMDECL = PREFIX + "EEnumDecl";
	public static final String EATTRIBUTEDECL = PREFIX + "EAttributeDecl";
	
	
	public static final String[] TEMPLATES = new String[] {
		EPACKAGE,ECLASS,EDATATYPEDECL,EENUMDECL,EATTRIBUTEDECL
		
	};
	// The shared instance
	private static EcoreDslActivator plugin;

	private ResourceBundle resourceBundle;
	private ContextTypeRegistry contextTypeRegistry;
	private TemplateStore templateStore;

	/**
	 * The constructor
	 */
	public EcoreDslActivator() {
		try {
			resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
		} catch (MissingResourceException e) {
			resourceBundle = null;
		}

	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
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
		logger.debug("Starting ecoredsl.ui activator: " + this.getClass().getName());
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
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static EcoreDslActivator getDefault() {
		return plugin;
	}

	private static void setDefault(EcoreDslActivator activator) {
		plugin = activator;
	}

	/**
	 * Returns the template context type registry for the Ecore-Dsl editor.
	 * 
	 * @return the template context type registry for the Ecore-Dsl  editor
	 */
	public ContextTypeRegistry getTemplateContextRegistry() {
		if (contextTypeRegistry == null) {
			ContributionContextTypeRegistry registry = new ContributionContextTypeRegistry();
			for (int i = 0; i < TEMPLATES.length; i++) {
				registry.addContextType(TEMPLATES[i]);
			}
			contextTypeRegistry = registry;
		}
		return contextTypeRegistry;
	}

	/**
	 * Returns the template store for the Ecore-Dsl  editor.
	 * 
	 * @return the template store for the Ecore-Dsl  editor
	 */
	public TemplateStore getTemplateStore() {
		if (templateStore == null) {
			templateStore = new ContributionTemplateStore(getTemplateContextRegistry(), getPreferenceStore(),
					TEMPLATES_KEY);
			try {
				templateStore.load();
			}
			catch (IOException e) {
				logger.error(e);
			}
		}
		return templateStore;
	}
	
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	/**
	 * Writes the message to the plug-in's log
	 * 
	 * @param message the text to write to the log
	 */
	public static void log(String message, Throwable exception) {
		IStatus status = createErrorStatus(message, exception);
		getDefault().getLog().log(status);
	}
	
	public static void log(Throwable exception) {
		getDefault().getLog().log(createErrorStatus(
						getResourceString("Plugin.internal_error"), exception));
	}
	/**
	 * Returns a new <code>IStatus</code> for this plug-in
	 */
	public static IStatus createErrorStatus(String message,
											Throwable exception) {
		if (message == null) {
			message= ""; 
		}		
		return new Status(Status.ERROR, PLUGIN_ID, 0, message, exception);
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
	    String bundleString;
		ResourceBundle bundle = getDefault().getResourceBundle();
		if (bundle != null) {
			try {
				bundleString = bundle.getString(key);
			} catch (MissingResourceException e) {
			    log(e);
				bundleString = "!" + key + "!";
			}
		} else {
			bundleString = "!" + key + "!";
		}
		return bundleString;
	}


}






