/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerModule extends AbstractModule {
  @Override
  protected void configure() {
    AnnotatedBindingBuilder<IResourceServiceProvider.Registry> _bind = this.<IResourceServiceProvider.Registry>bind(IResourceServiceProvider.Registry.class);
    ResourceServiceProviderRegistryImpl _resourceServiceProviderRegistryImpl = new ResourceServiceProviderRegistryImpl();
    _bind.toInstance(_resourceServiceProviderRegistryImpl);
  }
}
