/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	private TemplatesLanguageConfiguration configuration;

	private LanguageRegistry languageRegistry = createLanguageRegistry();

	@Override
	public void stop(BundleContext context) throws Exception {
		configuration = null;
		super.stop(context);
	}

	protected TemplatesLanguageConfiguration getTemplatesLanguageConfigurationInstance() {
		if (configuration == null) {
			Injector singleTemplateInjector = getInjector("org.eclipse.xtext.ui.codetemplates.SingleCodetemplate");
			configuration = singleTemplateInjector.getInstance(TemplatesLanguageConfiguration.class);
		}
		return configuration;
	}

	public static Provider<TemplatesLanguageConfiguration> getTemplatesLanguageConfigurationProvider() {
		return new Provider<TemplatesLanguageConfiguration>() {
			@Override
			public TemplatesLanguageConfiguration get() {
				return ((AccessibleCodetemplatesActivator) getInstance()).getTemplatesLanguageConfigurationInstance();
			}
		};
	}

	protected LanguageRegistry createLanguageRegistry() {
		return new LanguageRegistry();
	}

	public static Provider<LanguageRegistry> getLanguageRegistry() {
		return new Provider<LanguageRegistry>() {
			@Override
			public LanguageRegistry get() {
				return ((AccessibleCodetemplatesActivator) getInstance()).languageRegistry;
			}
		};
	}

}
