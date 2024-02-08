/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.ui.internal;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.backtracking.ui.BeeLangTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.backtracking.ui.ExBeeLangTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.backtracking.ui.SimpleBeeLangTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.fileAware.ui.FileAwareTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.nestedRefs.NestedRefsTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.nestedRefs.ui.NestedRefsTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.noJdt.ui.NoJdtTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.xtextgrammar.XtextGrammarTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.xtextgrammar.ui.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TestlanguagesActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.xtext.testlanguages.ui";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_BEELANGTESTLANGUAGE = "org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_SIMPLEBEELANGTESTLANGUAGE = "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_EXBEELANGTESTLANGUAGE = "org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NOJDT_NOJDTTESTLANGUAGE = "org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_XTEXTGRAMMAR_XTEXTGRAMMARTESTLANGUAGE = "org.eclipse.xtext.testlanguages.xtextgrammar.XtextGrammarTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_FILEAWARE_FILEAWARETESTLANGUAGE = "org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguage";
	public static final String ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NESTEDREFS_NESTEDREFSTESTLANGUAGE = "org.eclipse.xtext.testlanguages.nestedRefs.NestedRefsTestLanguage";
	
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
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_BEELANGTESTLANGUAGE.equals(grammar)) {
			return new BeeLangTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_SIMPLEBEELANGTESTLANGUAGE.equals(grammar)) {
			return new SimpleBeeLangTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_EXBEELANGTESTLANGUAGE.equals(grammar)) {
			return new ExBeeLangTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NOJDT_NOJDTTESTLANGUAGE.equals(grammar)) {
			return new NoJdtTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_XTEXTGRAMMAR_XTEXTGRAMMARTESTLANGUAGE.equals(grammar)) {
			return new XtextGrammarTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_FILEAWARE_FILEAWARETESTLANGUAGE.equals(grammar)) {
			return new FileAwareTestLanguageRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NESTEDREFS_NESTEDREFSTESTLANGUAGE.equals(grammar)) {
			return new NestedRefsTestLanguageRuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_BEELANGTESTLANGUAGE.equals(grammar)) {
			return new BeeLangTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_SIMPLEBEELANGTESTLANGUAGE.equals(grammar)) {
			return new SimpleBeeLangTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_BACKTRACKING_EXBEELANGTESTLANGUAGE.equals(grammar)) {
			return new ExBeeLangTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NOJDT_NOJDTTESTLANGUAGE.equals(grammar)) {
			return new NoJdtTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_XTEXTGRAMMAR_XTEXTGRAMMARTESTLANGUAGE.equals(grammar)) {
			return new XtextGrammarTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_FILEAWARE_FILEAWARETESTLANGUAGE.equals(grammar)) {
			return new FileAwareTestLanguageUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_TESTLANGUAGES_NESTEDREFS_NESTEDREFSTESTLANGUAGE.equals(grammar)) {
			return new NestedRefsTestLanguageUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
