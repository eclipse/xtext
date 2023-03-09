/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import java.util.ServiceLoader;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Singleton
public class ResourceServiceProviderServiceLoader implements Provider<Registry> {
	
	private final ServiceLoader<ISetup> setupLoader = ServiceLoader.load(ISetup.class);

	private final Registry registry = loadRegistry();

	private Registry loadRegistry() {
		ResourceServiceProviderRegistryImpl registry = new ResourceServiceProviderRegistryImpl();
		for (ISetup cp : setupLoader) {
			Injector injector = cp.createInjectorAndDoEMFRegistration();
			IResourceServiceProvider resourceServiceProvider = injector.getInstance(IResourceServiceProvider.class);
			FileExtensionProvider extensionProvider = injector.getInstance(FileExtensionProvider.class);
			String primaryFileExtension = extensionProvider.getPrimaryFileExtension();
			for (String ext : extensionProvider.getFileExtensions()) {
				if (registry.getExtensionToFactoryMap().containsKey(ext)) {
					if (primaryFileExtension.equals(ext))
						registry.getExtensionToFactoryMap().put(ext, resourceServiceProvider);
				} else {
					registry.getExtensionToFactoryMap().put(ext, resourceServiceProvider);
				}
			}
		}
		return registry;
	}

	@Override
	public IResourceServiceProvider.Registry get() {
		return this.registry;
	}
}
