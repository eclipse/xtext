/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.testing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 */
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
