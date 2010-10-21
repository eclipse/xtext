/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui;

import org.eclipse.xtext.ui.codetemplates.ui.internal.CodetemplatesActivator;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AccessibleCodetemplatesActivator extends CodetemplatesActivator {

	private Provider<TemplatesLanguageConfiguration> configurationProvider;
	private Provider<LanguageRegistry> languageRegistry;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		Injector templatesInjector = getInjector("org.eclipse.xtext.ui.codetemplates.Codetemplates");
		languageRegistry = templatesInjector.getProvider(LanguageRegistry.class);
		Injector singleTemplateInjector = getInjector("org.eclipse.xtext.ui.codetemplates.SingleCodetemplate");
		configurationProvider = singleTemplateInjector.getProvider(TemplatesLanguageConfiguration.class);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		configurationProvider = null;
		super.stop(context);
	}
	
	public static Provider<TemplatesLanguageConfiguration> getTemplatesLanguageConfigurationProvider() {
		AccessibleCodetemplatesActivator instance = (AccessibleCodetemplatesActivator) getInstance();
		return instance.configurationProvider;
	}
	
	public static Provider<LanguageRegistry> getLanguageRegistry() {
		AccessibleCodetemplatesActivator instance = (AccessibleCodetemplatesActivator) getInstance();
		return instance.languageRegistry;
	}
	
}
