/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;

public class JavaSourceLanguageSetup implements ISetup {
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = createInjector();
		register(injector, "java");
		return injector;
	}

	public Injector createInjector() {
		return Guice.createInjector(new JavaSourceLanguageRuntimeModule());
	}

	public void register(Injector injector, String fileExtension) {
		Resource.Factory resourceFactory = injector.<Resource.Factory>getInstance(Resource.Factory.class);
		IResourceServiceProvider serviceProvider = injector
				.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, resourceFactory);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, serviceProvider);
	}
}
