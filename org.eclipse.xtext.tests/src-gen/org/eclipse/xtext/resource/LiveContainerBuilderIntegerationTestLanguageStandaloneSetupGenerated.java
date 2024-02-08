/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;
import org.eclipse.xtext.resource.liveContainerBuilderIntegerationTestLanguage.LiveContainerBuilderIntegerationTestLanguagePackage;

@SuppressWarnings("all")
public class LiveContainerBuilderIntegerationTestLanguageStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new LiveContainerBuilderIntegerationTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		IResourceServiceProvider serviceProvider = injector.getInstance(IResourceServiceProvider.class);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("livecontainerbuilderintegerationtestlanguage", resourceFactory);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("livecontainerbuilderintegerationtestlanguage", serviceProvider);
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.xtext.org/LiveContainerBuilderIntegerationTestLanguage.xtext")) {
			EPackage.Registry.INSTANCE.put("http://www.xtext.org/LiveContainerBuilderIntegerationTestLanguage.xtext", LiveContainerBuilderIntegerationTestLanguagePackage.eINSTANCE);
		}
	}
}
