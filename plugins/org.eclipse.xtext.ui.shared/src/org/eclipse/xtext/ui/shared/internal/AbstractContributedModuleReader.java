/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.ProvisionException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContributedModuleReader {

	private static final Logger logger = Logger.getLogger(AbstractContributedModuleReader.class);
	
	@Inject
	private IExtensionRegistry extensionRegistry;

	private Injector injector;
	
	protected AbstractContributedModuleReader(Injector parentInjector) {
		this.injector = parentInjector;
	}
	
	protected void readModuleContributions(IAcceptor<? super Module> acceptor) {
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(getExtensionPointID());
		IExtension[] extensions = extensionPoint.getExtensions();
		for(IExtension extension: extensions) {
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			for(IConfigurationElement configurationElement: configurationElements) {
				try {
					final Module childModule = (Module) configurationElement.createExecutableExtension("class");
					acceptor.accept(childModule);
				} catch(CoreException e) {
					logger.error(e.getMessage(), e);
				} catch(ProvisionException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	protected abstract String getExtensionPointID();

	protected Injector createInjectorWithoutJITBindings(final Module childModule) {
		Injector childInjector = injector.createChildInjector(new Module() {
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
			}
		}).createChildInjector(getWrappedModule(childModule));
		return childInjector;
	}
	
	protected Module getWrappedModule(Module childModule) {
		return childModule;
	}
	
}
