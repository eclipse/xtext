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
import org.eclipse.xtext.util.JavaVersion;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * A Guice module for setting a fixed target Java version for compilation.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 * @deprecated Use org.eclipse.xtext.xbase.testing.JavaVersionModule instead
 */
@Deprecated(forRemoval = true)
public class JavaVersionModule implements Module {

	private final JavaVersion targetVersion;
	
	/**
	 * @since 2.9
	 */
	public JavaVersionModule(JavaVersion version) {
		this.targetVersion = version;
	}
	
	@Override
	public void configure(Binder binder) {
		binder.bind(IGeneratorConfigProvider.class).toInstance(new GeneratorConfigProvider());
	}
	
	private class GeneratorConfigProvider implements IGeneratorConfigProvider {
		
		@Override
		public GeneratorConfig get(EObject context) {
			GeneratorConfig config = new GeneratorConfig();
			config.setJavaSourceVersion(targetVersion);
			return config;
		}
		
	}

}
