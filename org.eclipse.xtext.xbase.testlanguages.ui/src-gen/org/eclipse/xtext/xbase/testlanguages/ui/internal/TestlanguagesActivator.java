/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.ui.internal;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangRuntimeModule;
import org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLangRuntimeModule;
import org.eclipse.xtext.xbase.testlanguages.XImportSectionTestLangRuntimeModule;
import org.eclipse.xtext.xbase.testlanguages.bug462047.Bug462047LangRuntimeModule;
import org.eclipse.xtext.xbase.testlanguages.bug462047.ui.Bug462047LangUiModule;
import org.eclipse.xtext.xbase.testlanguages.ui.ContentAssistFragmentTestLangUiModule;
import org.eclipse.xtext.xbase.testlanguages.ui.JvmGenericTypeValidatorTestLangUiModule;
import org.eclipse.xtext.xbase.testlanguages.ui.XImportSectionTestLangUiModule;
import org.osgi.framework.BundleContext;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TestlanguagesActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.xtext.xbase.testlanguages.ui";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_XIMPORTSECTIONTESTLANG = "org.eclipse.xtext.xbase.testlanguages.XImportSectionTestLang";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_CONTENTASSISTFRAGMENTTESTLANG = "org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLang";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_BUG462047_BUG462047LANG = "org.eclipse.xtext.xbase.testlanguages.bug462047.Bug462047Lang";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_JVMGENERICTYPEVALIDATORTESTLANG = "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang";
	
	private static final Logger logger = Logger.getLogger(TestlanguagesActivator.class);
	
	private static TestlanguagesActivator INSTANCE;
	
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
	
	public static TestlanguagesActivator getInstance() {
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
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_XIMPORTSECTIONTESTLANG.equals(grammar)) {
			return new XImportSectionTestLangRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_CONTENTASSISTFRAGMENTTESTLANG.equals(grammar)) {
			return new ContentAssistFragmentTestLangRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_BUG462047_BUG462047LANG.equals(grammar)) {
			return new Bug462047LangRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_JVMGENERICTYPEVALIDATORTESTLANG.equals(grammar)) {
			return new JvmGenericTypeValidatorTestLangRuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_XIMPORTSECTIONTESTLANG.equals(grammar)) {
			return new XImportSectionTestLangUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_CONTENTASSISTFRAGMENTTESTLANG.equals(grammar)) {
			return new ContentAssistFragmentTestLangUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_BUG462047_BUG462047LANG.equals(grammar)) {
			return new Bug462047LangUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_TESTLANGUAGES_JVMGENERICTYPEVALIDATORTESTLANG.equals(grammar)) {
			return new JvmGenericTypeValidatorTestLangUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
