/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EagerInitializer extends AbstractContributedModuleReader {

	@Inject
	protected EagerInitializer(Injector parentInjector) {
		super(parentInjector);
	}

	private static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".eagerInitializationModule";
	
	@Override
	protected String getExtensionPointID() {
		return EXTENSION_POINT;
	}
	
	void initialize() {
		readModuleContributions(new IAcceptor<Module>() {
			public void accept(Module module) {
				// simply create the injector, all necessary bindings should be eager singletons
				createInjectorWithoutJITBindings(module);
			}
		});
	}

}
