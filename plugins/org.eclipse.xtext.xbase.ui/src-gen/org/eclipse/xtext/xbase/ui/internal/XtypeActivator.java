/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.internal;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.XbaseRuntimeModule;
import org.eclipse.xtext.xbase.XtypeRuntimeModule;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsRuntimeModule;
import org.eclipse.xtext.xbase.annotations.ui.XbaseWithAnnotationsUiModule;
import org.eclipse.xtext.xbase.ui.XbaseUiModule;
import org.eclipse.xtext.xbase.ui.XtypeUiModule;
import org.osgi.framework.BundleContext;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XtypeActivator extends AbstractUIPlugin {

	public static final String ORG_ECLIPSE_XTEXT_XBASE_XTYPE = "org.eclipse.xtext.xbase.Xtype";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_XBASE = "org.eclipse.xtext.xbase.Xbase";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_ANNOTATIONS_XBASEWITHANNOTATIONS = "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations";
	
	private static final Logger logger = Logger.getLogger(XtypeActivator.class);
	
	private static XtypeActivator INSTANCE;
	
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
	
	public static XtypeActivator getInstance() {
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
			Module runtimeModule = getRuntimeModule(language);
			Module sharedStateModule = getSharedStateModule();
			Module uiModule = getUiModule(language);
			Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}
	
	protected Module getRuntimeModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_XBASE_XTYPE.equals(grammar)) {
			return new XtypeRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_XBASE.equals(grammar)) {
			return new XbaseRuntimeModule();
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_ANNOTATIONS_XBASEWITHANNOTATIONS.equals(grammar)) {
			return new XbaseWithAnnotationsRuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_XBASE_XTYPE.equals(grammar)) {
			return new XtypeUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_XBASE.equals(grammar)) {
			return new XbaseUiModule(this);
		}
		if (ORG_ECLIPSE_XTEXT_XBASE_ANNOTATIONS_XBASEWITHANNOTATIONS.equals(grammar)) {
			return new XbaseWithAnnotationsUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
}
