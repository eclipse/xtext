/*******************************************************************************
 * Copyright (c) 2019 Sebastian Zarnekow (szarnekow) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.m2e;

import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * Register the bindings for the maven target folde filter.
 */
public class IgnoreMavenTargetModule extends AbstractModule {

	@Override
	protected void configure() {
		try {
			/*
			 * Even though this bundle does not make any sense without m2e being available,
			 * the bundle dependencies are declared optional to simplify the deployment process.
			 * Here we decouple the registration of the target folder filter from the contributing
			 * module extension point to avoid NoClassDefFounds at runtime if maven is not available. 
			 */
			if (Class.forName("org.eclipse.m2e.core.MavenPlugin") != null) {
				install(new Internal());
			}
		} catch (ClassNotFoundException e) {
			// ignore
		}
	}

	private static class Internal extends AbstractModule {
		@Override
		protected void configure() {
			bind(IStorage2UriMapperContribution.class).to(IgnoreMavenTargetFolderContribution.class);
			bind(IToBeBuiltComputerContribution.class).to(IgnoreMavenTargetFolderContribution.class);
			bind(IgnoreMavenTargetFolderContribution.class).in(Scopes.SINGLETON);
		}
	}
	
}
