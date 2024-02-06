/*******************************************************************************
 * Copyright (c) 2015, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.internal;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.codetemplates.CodetemplatesRuntimeModule;
import org.eclipse.xtext.ui.codetemplates.SingleCodetemplateRuntimeModule;
import org.eclipse.xtext.ui.codetemplates.ui.CodetemplatesUiModule;
import org.eclipse.xtext.ui.codetemplates.ui.SingleCodetemplateUiModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CodetemplatesActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.xtext.ui.codetemplates.ui";
	public static final String ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_CODETEMPLATES = "org.eclipse.xtext.ui.codetemplates.Codetemplates";
	public static final String ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_SINGLECODETEMPLATE = "org.eclipse.xtext.ui.codetemplates.SingleCodetemplate";
	
	private static final Logger logger = Logger.getLogger(CodetemplatesActivator.class);
	
	private static CodetemplatesActivator INSTANCE;
	
	private Map<String, Injector> injectors = Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}
	
	public static CodetemplatesActivator getInstance() {
		return INSTANCE;
	}
	
	public Injector getInjector(String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) {
				injectors.put(language, injector = createInjector(language));
			}
			return injector;
		}
	}
	
	protected Injector createInjector(String language) {
		try {
			com.google.inject.Module runtimeModule = getRuntimeModule(language);
			com.google.inject.Module sharedStateModule = getSharedStateModule();
			com.google.inject.Module uiModule = getUiModule(language);
			com.google.inject.Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}
	
	protected com.google.inject.Module getRuntimeModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_CODETEMPLATES.equals(grammar)) {
			return new CodetemplatesRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_SINGLECODETEMPLATE.equals(grammar)) {
			return new SingleCodetemplateRuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_CODETEMPLATES.equals(grammar)) {
			return new CodetemplatesUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_SINGLECODETEMPLATE.equals(grammar)) {
			return new SingleCodetemplateUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
