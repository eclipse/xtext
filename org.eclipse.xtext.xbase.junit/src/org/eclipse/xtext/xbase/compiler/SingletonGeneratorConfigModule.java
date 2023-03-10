/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 * @deprecated Use org.eclipse.xtext.xbase.testing.SingletonGeneratorConfigModule instead
 */
@Deprecated(forRemoval = true)
public class SingletonGeneratorConfigModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IGeneratorConfigProvider.class).to(GeneratorConfigProvider.class);
	}
	
	@Singleton
	private static class GeneratorConfigProvider implements IGeneratorConfigProvider {

		private final GeneratorConfig sharedGeneratorConfig = new GeneratorConfig();
		
		@Override
		public GeneratorConfig get(EObject context) {
			return sharedGeneratorConfig;
		}
		
	}

}
