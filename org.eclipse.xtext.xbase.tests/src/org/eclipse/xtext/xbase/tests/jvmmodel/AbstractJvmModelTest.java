/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@InjectWith(AbstractJvmModelTest.SimpleJvmModelTestInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractJvmModelTest extends AbstractXbaseTestCase {

	@Override
	public final Injector getInjector() {
		throw new IllegalStateException();
	}
	
	public static class SimpleJvmModelTestInjectorProvider extends XbaseInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new SimpleJvmModelTestStandaloneSetup().createInjectorAndDoEMFRegistration();
		}

		public static class SimpleJvmModelTestStandaloneSetup extends XbaseStandaloneSetup {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XbaseWithLogicalContainerInjectorProvider.XbaseWithLogicalContainerRuntimeModule() {
					@Override
					public void configure(com.google.inject.Binder binder) {
						super.configure(binder);
						binder.bind(IJvmModelInferrer.class).to(SimpleJvmModelInferrer.class);
					}
				});
			}
		}
		
	}
	
}
