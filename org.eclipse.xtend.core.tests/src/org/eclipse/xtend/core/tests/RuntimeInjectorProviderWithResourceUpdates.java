/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.linking.Linker;
import org.eclipse.xtext.linking.ILinker;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuntimeInjectorProviderWithResourceUpdates extends RuntimeInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new RuntimeTestSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtendRuntimeTestModule() {
					@Override
					public Class<? extends ILinker> bindILinker() {
						return LinkerWithResourceUpdates.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
	
	public static class LinkerWithResourceUpdates extends Linker {
		@Override
		protected boolean isClearAllReferencesRequired(Resource resource) {
			return true;
		}
	}
	
}
