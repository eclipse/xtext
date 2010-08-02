/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * 
 * This class is intended to be used from an MWE workflow.
 * 
 * It instantiates and registers the Ecore support for Xtext, which allows for referencing ecore models from any Xtext
 * language.
 * 
 * Usage:  
 * 
 * <pre>
 *    component = org.eclipse.xtext.ecore.EcoreSupport{}
 * </pre>
 * 
 * If you want to provide a different guice guiceModule than the default one ({@link EcoreRuntimeModule}) in order to
 * change any implementation classes, you can make use of the property guiceModule. E.g. :
 * 
 * <pre>
 *    component = org.eclipse.xtext.ecore.EcoreSupport{
 *       guiceModule = my.special.CustomizedEcoreRuntimeModule {}
 *    }
 * </pre>
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreSupport implements IWorkflowComponent {

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	private String fileExtension;

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IResourceServiceProvider.Registry registry;

	public void preInvoke() {
		Injector injector = Guice.createInjector(getGuiceModule());
		injector.injectMembers(this);
		registerInRegistry();
	}

	private EcoreRuntimeModule guiceModule = new EcoreRuntimeModule();

	public void setGuiceModule(EcoreRuntimeModule module) {
		this.guiceModule = module;
	}

	protected EcoreRuntimeModule getGuiceModule() {
		return guiceModule;
	}

	protected void registerInRegistry() {
		registry.getExtensionToFactoryMap().put(fileExtension, resourceServiceProvider);
	}

	public void invoke(IWorkflowContext ctx) {
	}

	public void postInvoke() {
	}

}
