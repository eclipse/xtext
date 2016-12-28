/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ServiceLoader;
import java.util.Set;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class ResourceServiceProviderServiceLoader implements Provider<IResourceServiceProvider.Registry> {
  private ServiceLoader<ISetup> setupLoader = ServiceLoader.<ISetup>load(ISetup.class);
  
  private IResourceServiceProvider.Registry registry = this.loadRegistry();
  
  private IResourceServiceProvider.Registry loadRegistry() {
    final ResourceServiceProviderRegistryImpl registry = new ResourceServiceProviderRegistryImpl();
    for (final ISetup cp : this.setupLoader) {
      {
        final Injector injector = cp.createInjectorAndDoEMFRegistration();
        final IResourceServiceProvider resourceServiceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
        final FileExtensionProvider extensionProvider = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
        Set<String> _fileExtensions = extensionProvider.getFileExtensions();
        for (final String ext : _fileExtensions) {
          boolean _containsKey = registry.getExtensionToFactoryMap().containsKey(ext);
          if (_containsKey) {
            String _primaryFileExtension = extensionProvider.getPrimaryFileExtension();
            boolean _equals = Objects.equal(_primaryFileExtension, ext);
            if (_equals) {
              registry.getExtensionToFactoryMap().put(ext, resourceServiceProvider);
            }
          } else {
            registry.getExtensionToFactoryMap().put(ext, resourceServiceProvider);
          }
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
