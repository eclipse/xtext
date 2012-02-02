/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.junit.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractJvmModelTest extends AbstractXbaseTestCase {

	static Injector injector = new XbaseStandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.xbase.XbaseRuntimeModule() {
				
				@Override
				public void configure(com.google.inject.Binder binder) {
					super.configure(binder);
					binder.bind(IJvmModelInferrer.class).to(SimpleJvmModelInferrer.class);
				}
				
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXbaseTestCase.class.getClassLoader();
				}
			});
		}
	}.createInjectorAndDoEMFRegistration();
	
	@Override
	public Injector getInjector() {
		return injector;
	}
}
