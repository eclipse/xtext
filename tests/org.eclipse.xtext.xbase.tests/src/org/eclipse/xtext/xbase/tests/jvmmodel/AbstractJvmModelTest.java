/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Inject;
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
	
	@Inject
	private ReflectExtensions reflectExtensions; 
	
	private Map<String, List<IJvmModelInferrer>> map;
	
	@Before
	public void copyInferrerRegistry() throws Exception {
		Map<String, List<IJvmModelInferrer>> map = reflectExtensions.get(JvmModelInferrerRegistry.INSTANCE, "map");
		if (map != null) {
			Map<String, List<IJvmModelInferrer>> copy = Maps.newHashMap();
			for(Map.Entry<String, List<IJvmModelInferrer>> entry: map.entrySet()) {
				copy.put(entry.getKey(), Lists.newArrayList(entry.getValue()));
			}
			assertEquals(copy, map);
			this.map = copy;
		}
	}
	
	@After
	public void restoreInferrerRegistry() throws Exception {
		if (map != null) {
			reflectExtensions.set(JvmModelInferrerRegistry.INSTANCE, "map", map);
		}
		map = null;
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
