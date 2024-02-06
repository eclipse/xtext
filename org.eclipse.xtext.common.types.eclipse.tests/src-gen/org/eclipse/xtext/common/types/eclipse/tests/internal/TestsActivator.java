/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.eclipse.tests.internal;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage1RuntimeModule;
import org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage2RuntimeModule;
import org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguageRuntimeModule;
import org.eclipse.xtext.common.types.xtext.ui.ui.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.common.types.xtext.ui.ui.RefactoringTestLanguage1UiModule;
import org.eclipse.xtext.common.types.xtext.ui.ui.RefactoringTestLanguage2UiModule;
import org.eclipse.xtext.common.types.xtext.ui.ui.RefactoringTestLanguageUiModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TestsActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.xtext.common.types.eclipse.tests";
	public static final String ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_CONTENTASSISTTESTLANGUAGE = "org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE = "org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE1 = "org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage1";
	public static final String ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE2 = "org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage2";
	
	private static final Logger logger = Logger.getLogger(TestsActivator.class);
	
	private static TestsActivator INSTANCE;
	
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
	
	public static TestsActivator getInstance() {
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
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_CONTENTASSISTTESTLANGUAGE.equals(grammar)) {
			return new ContentAssistTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE.equals(grammar)) {
			return new RefactoringTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE1.equals(grammar)) {
			return new RefactoringTestLanguage1RuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE2.equals(grammar)) {
			return new RefactoringTestLanguage2RuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_CONTENTASSISTTESTLANGUAGE.equals(grammar)) {
			return new ContentAssistTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE.equals(grammar)) {
			return new RefactoringTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE1.equals(grammar)) {
			return new RefactoringTestLanguage1UiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_COMMON_TYPES_XTEXT_UI_REFACTORINGTESTLANGUAGE2.equals(grammar)) {
			return new RefactoringTestLanguage2UiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
