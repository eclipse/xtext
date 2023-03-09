/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import java.util.Map;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * This class is intended to be used in an MWE workflow.
 * 
 * It instantiates and registers Xtext support for a non-Xtext based EMF resources, e.g. to reference model elements from
 * any Xtext language.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein 
 */
public abstract class AbstractGenericResourceSupport implements IWorkflowComponent {

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IResourceServiceProvider.Registry registry;

	@Override
	public void preInvoke() {
		registerServices(true);
	}

	/**
	 * Inject members into this instance and register the services afterwards.
	 * @see #getGuiceModule()
	 * @see #registerInRegistry(boolean)
	 * @since 2.1
	 */
	public void registerServices(boolean force) {
		Injector injector = Guice.createInjector(getGuiceModule());
		injector.injectMembers(this);
		registerInRegistry(force);
	}

	private Module guiceModule;

	public void setGuiceModule(Module module) {
		this.guiceModule = module;
	}

	protected Module getGuiceModule() {
		if (guiceModule == null)
			guiceModule = createGuiceModule();
		return guiceModule;
	}

	protected abstract Module createGuiceModule();

	/**
	 * @deprecated use {@link #registerInRegistry(boolean)} instead.
	 */
	@Deprecated
	protected void registerInRegistry() {
		registerInRegistry(true);
	}
	
	/**
	 * @param force <code>true</code> if you want to override existing service providers.
	 * @since 2.1
	 */
	protected void registerInRegistry(boolean force) {
		Map<String, Object> map = registry.getExtensionToFactoryMap();
		for(String fileExtension: fileExtensionProvider.getFileExtensions()) {
			if (force || !map.containsKey(fileExtension))
				map.put(fileExtension, resourceServiceProvider);
		}
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
	}

	@Override
	public void postInvoke() {
	}

}
