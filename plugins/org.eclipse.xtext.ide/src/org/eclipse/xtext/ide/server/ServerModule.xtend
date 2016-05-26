/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.AbstractModule
import io.typefox.lsapi.LanguageServer
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.ResourceServiceProviderServiceLoader

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerModule extends AbstractModule {
    
    override protected configure() {
    	bind(LanguageServer).to(LanguageServerImpl)
        bind(IResourceServiceProvider.Registry).toProvider(ResourceServiceProviderServiceLoader)
    }
    
}